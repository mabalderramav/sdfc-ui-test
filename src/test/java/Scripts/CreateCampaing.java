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


public class CreateCampaing {

    TabBar tapBar;
    CampaignsHome campaignsHome;
    NewCampaignForm newCampaignForm;
    LookUpWindow lookUpWindow;
    CampaignProfile campaignProfile;

    @Test
    public void CreateCampaing()
    {
        campaignsHome = tapBar
                .clickCampaigns();

        newCampaignForm = campaignsHome
                .clickNewButton();

        lookUpWindow = newCampaignForm
                .setCampaingNameField("Test100")
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .setStartDateField("6/24/2015")
                .clickLookUpIcon();

        newCampaignForm = lookUpWindow
                .switchSearchFrame()
                .selectSearchWithinDropdown("My Campaigns")
                .setSearchWithinField("Test01")
                .clickGoButton()
                .switchResultsFrame()
                .clickResult("Test01");

        campaignProfile = newCampaignForm
                .clickSaveButton();

        String campaingName = campaignProfile.getCampaingNameLabel();

        Assert.assertEquals(campaingName, "Test100");
    }

    @BeforeTest
    public void BeforeTest()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("giselitamt6@gmail.com")
                .setPasswordField("Control123")
                .clickLogInToSalesforceButton();
    }

    @AfterTest
    public void afterTest()
    {

    }
}
