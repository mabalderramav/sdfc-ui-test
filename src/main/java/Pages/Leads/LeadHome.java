package Pages.Leads;

import Framework.BrowserManager;
import Pages.Leads.*;
import Framework.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LeadHome {
    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewLeadFormButtton;
    //endregion

    public LeadHome(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public NewLeadForm clickNewButton() {
        CommonActions.click(NewLeadFormButtton);
        return new NewLeadForm(Driver);
    }
}