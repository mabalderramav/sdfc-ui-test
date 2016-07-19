package Pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;


public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    
    public AbstractBasePage() {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
}
