package Scripts;

import Framework.BrowserManager;
import Pages.Campaigns.CampaignProfile;
import Pages.Campaigns.CampaignsHome;
import Pages.Campaigns.NewCampaignForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.TopBar.TabBar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;


public class CreateCampaing {

    TabBar tapBar;
    CampaignsHome campaignsHome;
    NewCampaignForm newCampaignForm;
    LookUpWindow lookUpWindow;
    CampaignProfile campaignProfile;

    String campaongParent;
    String campaingParantUrl;

    @Test
    public void CreateCampaing()
    {
        campaignsHome = tapBar
                .clickCampaigns();

        newCampaignForm = campaignsHome
                .clickNewButton();

        lookUpWindow = newCampaignForm
                .setCampaingNameField("Test00100")
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .setStartDateField("6/24/2015")
                .clickLookUpIcon();

        newCampaignForm = lookUpWindow
                .switchSearchFrame()
                .setSearchWithinField(campaongParent)
                .clickGoButton()
                .switchResultsFrame()
                .clickResult(campaongParent);

        campaignProfile = newCampaignForm
                .clickSaveButton();

        String campaingName = campaignProfile.getCampaingNameLabel();

        Assert.assertEquals(campaingName, "Test00100");
    }

    @BeforeTest
    public void BeforeTest()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("vasquez.vn@gmail.com")
                .setPasswordField("123Control")
                .clickLogInToSalesforceButton();

        campaongParent = "Parent" + new Random().nextInt(9999);
        campaignsHome = tapBar
                .clickCampaigns();

        newCampaignForm = campaignsHome
                .clickNewButton();

        campaignProfile = newCampaignForm
                .setCampaingNameField(campaongParent)
                .checkActiveCheckbox()
                .clickSaveButton();

        campaingParantUrl = campaignProfile.getUrl();
    }

    @AfterTest
    public void afterTest()
    {
        campaignsHome = campaignProfile
                .clickDeleteButton();

        campaignProfile = campaignsHome
                .goCampaingProfile(campaingParantUrl);

        campaignsHome = campaignProfile
                .clickDeleteButton();

    }
}
