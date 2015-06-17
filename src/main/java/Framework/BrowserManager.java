package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BrowserManager {
    private static BrowserManager instance;
    public WebDriver Browser;
    public WebDriverWait Waiter;
    private BrowserManager() {
        openBrowser("Firefox");
        configureBrowser();

    }

    public static BrowserManager getInstance() {
        if (instance == null) {
            instance = new BrowserManager();
        }
        return instance;
    }

    private void openBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("Firefox")) {
                Browser = new FirefoxDriver();
            }
            else if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/Framework/Browser/Drivers/chromedriver.exe");
                Browser = new ChromeDriver();
            }
            else if (browserName.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "src/Framework/Browser/Drivers/IEDriverServer.exe");
                Browser = new InternetExplorerDriver();
            } else {
                System.out.println("Incorrect Browser");
            }
        }
        catch (WebDriverException wde){
            System.out.println(wde.getMessage());
        }
    }

    private void configureBrowser() {
        // Maximize Browser Window
        Browser.manage().window().maximize();

        // Set Implicit Waits
        Browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Browser.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Browser.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);

        // Delete Cookies
        Browser.manage().deleteAllCookies();
    }


    private void startWait()
    {
        Waiter = new WebDriverWait(Browser, 15);
    }

    public void goStartPage(String url)
    {
        Browser.get(url);
    }
}
