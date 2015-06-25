package Pages.Campaigns;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CampaignsHome {
    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;
    //endregion

    public CampaignsHome(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public NewCampaignForm clickNewButton() {
        CommonActions.click(NewButtton);
        return new NewCampaignForm(Driver);
    }
}
