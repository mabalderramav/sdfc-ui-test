package Pages.Opportunities;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Campaigns.CampaignProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 26-06-15.
 */
public class OpportunitiesHome {
    private WebDriver       driver;
    private WebDriverWait   wait;

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;

    public OpportunitiesHome(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public NewOpportunityForm clickNewButton() {
        CommonActions.click(NewButtton);

        return new NewOpportunityForm(driver);
    }

    public OpportunityProfile goOpportunityProfile(String url) {
        driver.navigate().to(url);

        return new OpportunityProfile(driver);
    }

}
