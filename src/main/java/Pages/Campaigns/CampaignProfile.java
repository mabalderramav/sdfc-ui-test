package Pages.Campaigns;


import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class CampaignProfile {

    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

    @FindBy(className = "pageDescription")
    @CacheLookup
    WebElement CampaingNameLabel;

    //endregion

    public CampaignProfile(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public String getCampaingNameLabel() {
        return CampaingNameLabel.getText();
    }

}
