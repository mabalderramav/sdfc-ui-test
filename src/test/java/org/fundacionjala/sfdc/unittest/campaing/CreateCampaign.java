package org.fundacionjala.sfdc.unittest.campaing;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignProfile;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.campaigns.NewCampaignForm;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;


public class CreateCampaign {

    TabBar tapBar;
    CampaignsHome campaignsHome;
    NewCampaignForm newCampaignForm;
    CampaignLookup lookUpWindow;
    CampaignProfile campaignProfile;
    MainApp mainApp;
    String campaignParent;
    String campaingParantUrl;
    private TabBar tabBar;
    private LoginPage loginPage;

    @BeforeTest(groups = {"smoke", "acceptance"})
    public void BeforeTest() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();

        campaignParent = "Parent" + new Random().nextInt(9999);
        campaignsHome = mainApp.goToTabBar().clickCampaigns();

        newCampaignForm = campaignsHome
                .clickNewButton();

        campaignProfile = newCampaignForm
                .setCampaingNameField(campaignParent)
                .checkActiveCheckbox()
                .clickSaveButton();

        campaingParantUrl = campaignProfile.getUrl();
    }

    @Test(groups = {"smoke", "acceptance"})
    public void CreateCampaing() {
        campaignsHome = mainApp.goToTabBar().clickCampaigns();
        newCampaignForm = campaignsHome
                .clickNewButton();

        lookUpWindow = newCampaignForm
                .setCampaingNameField("Test00100")
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .setStartDateField("6/24/2015")
                .clickLookUpIcon();

        newCampaignForm = lookUpWindow.selectCampaignWithNameByScope(campaignParent, CampaignLookup.ALL_CAMPAIGN);


        campaignProfile = newCampaignForm.clickSaveButton();

        String campaingName = campaignProfile.getCampaingNameLabel();

        assertEquals(campaingName, "Test00100");
    }

    @AfterTest(groups = {"smoke", "acceptance"})
    public void afterTest() {
        //campaignsHome = campaignProfile
        //       .clickDeleteButton();
/*
        campaignProfile = campaignsHome
                .goCampaingProfile(campaingParantUrl);

        campaignsHome = campaignProfile
                .clickDeleteButton();
                */
    }
}
