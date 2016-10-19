package org.fundacionjala.sfdc.unittest.campaing;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.campaigns.CampaignProfile;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.campaigns.NewCampaignForm;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;


public class CreateCampaing {

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

    @Test
    public void CreateCampaing()
    {
        campaignsHome = mainApp.goToTabBar().clickCampaigns();
        newCampaignForm = campaignsHome
                .clickNewButton();

        lookUpWindow = newCampaignForm
                .setCampaingNameField("Test00100")
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .setStartDateField("6/24/2015")
                .clickLookUpIcon();

        newCampaignForm = lookUpWindow.selectCampaignWithNameByScope(campaignParent,CampaignLookup.ALL_CAMPAIGN);


        campaignProfile = newCampaignForm
                .clickSaveButton();

        String campaingName = campaignProfile.getCampaingNameLabel();

        Assert.assertEquals(campaingName, "Test00100");
    }

    @BeforeTest
    public void BeforeTest()
    {
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

    @AfterTest
    public void afterTest()
    {
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
