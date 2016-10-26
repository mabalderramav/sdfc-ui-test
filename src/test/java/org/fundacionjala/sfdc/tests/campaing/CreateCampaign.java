package org.fundacionjala.sfdc.tests.campaing;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;


public class CreateCampaign {

    TabBar tapBar;
    CampaignsHome campaignsHome;
    CampaignForm campaignForm;
    CampaignLookup lookUpWindow;
    CampaignDetail campaignDetail;
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

        campaignForm = campaignsHome
                .clickNewButton();

        campaignDetail = campaignForm
                .setCampaingNameField(campaignParent)
                .checkActiveCheckbox()
                .clickSaveButton();

        campaingParantUrl = campaignDetail.getUrl();
    }

    @Test(groups = {"smoke", "acceptance"})
    public void CreateCampaing() {
        campaignsHome = mainApp.goToTabBar().clickCampaigns();
        campaignForm = campaignsHome
                .clickNewButton();

        lookUpWindow = campaignForm
                .setCampaingNameField("Test00100")
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .setStartDateField("6/24/2015")
                .clickLookUpIcon();

        campaignForm = lookUpWindow.selectCampaignWithNameByScope(campaignParent, CampaignLookup.ALL_CAMPAIGN);


        campaignDetail = campaignForm.clickSaveButton();

        String campaingName = campaignDetail.getCampaingNameLabel();

        assertEquals(campaingName, "Test00100");
    }

    @AfterTest(groups = {"smoke", "acceptance"})
    public void afterTest() {
        //campaignsHome = campaignDetail
        //       .clickDeleteButton();
/*
        campaignDetail = campaignsHome
                .goCampaingProfile(campaingParantUrl);

        campaignsHome = campaignDetail
                .clickDeleteButton();
                */
    }
}
