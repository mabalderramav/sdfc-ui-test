package org.fundacionjala.sfdc.unittest.campaign;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Created by Lion on 10/23/2016.
 */
public class DeleteCampaign {


    public static final String CAMPAIGN_NAME = "Test For Delete";
    private CampaignsHome campaigns;
    private CampaignForm campaignForm;
    private CampaignDetail campaignDetail;
    private MainApp mainApp;
    private String homeUrl;
    private LoginPage loginPage;


    @BeforeTest(groups = {"smoke", "acceptance"})
    public void BeforeTest() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        homeUrl = mainApp.getUrl();
        campaigns = mainApp.goToTabBar().clickCampaigns();
        campaignForm = campaigns
                .clickNewButton();
        campaignForm
                .setCampaingNameField(CAMPAIGN_NAME)
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .clickOnStartDate();
        campaignDetail = campaignForm.clickSaveButton();
        assertEquals(campaignDetail.getCampaingNameLabel(), CAMPAIGN_NAME);
    }

    @Test(groups = {"smoke", "acceptance"})
    public void deleteCampaign() {
        campaigns = campaignDetail.clickDeleteButton();
        assertFalse(campaigns.existCampaign(CAMPAIGN_NAME));
    }

    @AfterTest(groups = {"smoke", "acceptance"})
    public void afterTest() {
        mainApp = campaigns
                .goToHomePage(homeUrl);
    }

}
