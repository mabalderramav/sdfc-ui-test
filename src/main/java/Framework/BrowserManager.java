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
    private WebDriver driver;
    private WebDriverWait wait;
    private String browser;
    private final String baseURL = "https://na24.salesforce.com/";
    private static final int TIMEOUT_NORMAL = 30;

    private BrowserManager() {
        browser = Environment.getInstance().getBrowser();
        openBrowser(browser);
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
                driver = new FirefoxDriver();
            }
            else if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if (browserName.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
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
        driver.manage().window().maximize();

        // Set Implicit Waits
        driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);

        // Delete Cookies
        driver.manage().deleteAllCookies();
    }


    private void startWait()
    {
        wait = new WebDriverWait(driver, TIMEOUT_NORMAL);
    }

    public void goStartPage(String url)
    {
        driver.get(url);
    }
    
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }	
}
