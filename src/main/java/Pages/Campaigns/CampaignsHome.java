package Pages.Campaigns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractBasePage;


public class CampaignsHome extends AbstractBasePage {

    //region Locators

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;
    //endregion

    public NewCampaignForm clickNewButton() {
        CommonActions.click(NewButtton);
        return new NewCampaignForm();
    }

    public CampaignProfile goCampaingProfile(String url) {
        driver.navigate().to(url);
        return new CampaignProfile();
    }
}
