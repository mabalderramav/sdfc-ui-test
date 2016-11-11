package org.fundacionjala.sfdc.tests.campaign;

import java.util.Map;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.framework.utils.Navigator;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.fundacionjala.sfdc.tests.Asserts;

/**
 * Create a campaign using a builder and Json File.
 */
public class CreateCampaign {

    public static final int BOUND = 9999;
    private CampaignsHome campaignsHome;
    private CampaignForm campaignForm;
    private LookUpWindow lookUpWindow;
    private CampaignDetail campaignDetail;
    private TabBar tabBar;
    private String campaignParent;
    private static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";
    private Map<String, String> valuesMapJson;

    /**
     * Setup the Test crating a Parent campaign for a test.
     */
    @BeforeMethod()
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        campaignParent = "Parent" + new Random().nextInt(BOUND);
        campaignsHome = Navigator.goToCampaign();
        campaignForm = campaignsHome
                .clickNewButton();
        campaignDetail = campaignForm
                .setCampaingNameField(campaignParent)
                .checkActiveCheckbox()
                .clickSaveButton();
        tabBar = campaignDetail.toTabBar();
        campaignsHome = tabBar.clickCampaigns();
    }

    /**
     * Create a campaign using  a Json file.
     */
    @Test()
    public void createCampaignWithJson() {
        campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        lookUpWindow = campaignForm.clickLookUpIcon();
        lookUpWindow.selectCampaignWithNameByScope(campaignParent, LookUpWindow.ALL_CAMPAIGN);
        campaignDetail = campaignForm.clickSaveButton();
        Asserts.assertDetailValues(campaignDetail, valuesMapJson);
    }

    /**
     * create a campaign using the Builder pattern.
     */
    @Test()
    public void createCampaign() {
        campaignsHome.clickNewButton();
        Campaigns campaigns = new Campaigns.CampaignBuilder("builderTest")
                .setTypeDropDown("Email")
                .setStatusDropDown("In Progress")
                .setStartDate("10/25/2015")
                .setEndDate("10/27/2015")
                .setRevenue("1,000")
                .build();
        campaignDetail = campaigns.createCampaign();
        Asserts.assertDetailValues(campaignDetail, campaigns.getValuesMap());
    }

    /**
     * Eliminate the campaign created.
     */
    @AfterMethod()
    public void tearDown() {
        campaignsHome = campaignDetail.clickDeleteButton();


    }
}
