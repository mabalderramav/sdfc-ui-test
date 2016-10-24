package org.fundacionjala.sfdc.unittest.campaing;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.fundacionjala.sfdc.utils.Common;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Random;

import static org.testng.Assert.assertEquals;


public class CreateCampaign {


    private Campaigns campaigns;
    private CampaignForm campaignForm;
    private CampaignLookup lookUpWindow;
    private CampaignDetail campaignDetail;
    private MainApp mainApp;
    private String campaignParent;
    private String campaingParantUrl;
    public static final String CAMPAIGN_DATA_PATH = "src/test/resources/json/campaign/CreateCampaignData.json";
    private Map<String, String> valuesMapJson;
    private LoginPage loginPage;

    @BeforeTest(groups = {"smoke", "acceptance"})
    public void beforeTest() {
        valuesMapJson = Common.getMapJson(CAMPAIGN_DATA_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        campaignParent = "Parent" + new Random().nextInt(9999);
        campaigns = mainApp.goToTabBar().clickCampaigns();

        campaignForm = campaigns
                .clickNewButton();

        campaignDetail = campaignForm
                .setCampaingNameField(campaignParent)
                .checkActiveCheckbox()
                .clickSaveButton();
        campaingParantUrl = campaignDetail.getUrl();
    }

    @Test(groups = {"smoke", "acceptance"})
    public void createCampaing() {
        campaigns = mainApp.goToTabBar().clickCampaigns();
        campaignForm = campaigns
                .clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        lookUpWindow = campaignForm.setDate(10, 24, 2016).checkActiveCheckbox().clickLookUpIcon();
        campaignForm = lookUpWindow.selectCampaignWithNameByScope(campaignParent, CampaignLookup.ALL_CAMPAIGN);
        campaignDetail = campaignForm.clickSaveButton();
        String campaingName = campaignDetail.getCampaingNameLabel();
        assertEquals(campaingName, "Test105");
    }

    @AfterTest(groups = {"smoke", "acceptance"})
    public void afterTest() {
        campaigns = campaignDetail
                .clickDeleteButton();

        campaignDetail = campaigns
                .goCampaingProfile(campaingParantUrl);

        campaigns = campaignDetail
                .clickDeleteButton();
    }
}
