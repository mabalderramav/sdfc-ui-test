package org.fundacionjala.sfdc.tests.lead;


import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadHome;

import static org.fundacionjala.sfdc.pages.leads.LeadFields.CAMPAIGN;
import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * This class verify the Creation of LeadHome.
 */
public class CreateLead {

    private static final String CAMPAIGN_NAME = "AT-CampaignTest-01";
    private static final String LEAD_DATA_PATH = "lead/CreateLeadData.json";

    private LeadHome leadHomePage;
    private CampaignsHome campaignsHome;
    private CampaignDetail campaignDetail;
    private LeadDetails leadDetails;

    private Map<String, String> valuesMapJson;


    /**
     * This method execute the preconditions to make the validation for creation of lead,
     * in this method a campaign is created and the LINKS tab is selected.
     */
    @BeforeMethod
    public void setUp() {
        TabBar tabBar = new MainApp().goToTabBar();
        campaignsHome = tabBar.clickCampaigns();
        CampaignForm campaignForm = campaignsHome.clickNewButton();
        Campaigns campaigns = new Campaigns.CampaignBuilder(CAMPAIGN_NAME)
                .setActive("checked")
                .build();
        campaignDetail = campaigns.createCampaign();
        valuesMapJson = JsonMapper.getMapJson(LEAD_DATA_PATH);
        valuesMapJson.put(CAMPAIGN.toString(), CAMPAIGN_NAME);
        leadHomePage = tabBar.clickLead();
    }

    /**
     * This method create a new LeadFields and make the corresponding assertions.
     */
    @Test
    public void createLeadTest() {
        LeadForm leadForm = leadHomePage.clickNewButton();
        leadForm.fillTheForm(valuesMapJson);
        leadDetails = leadForm.clickSaveButton();
        assertDetailValues(leadDetails, leadForm.formatJson(valuesMapJson));

    }

    /**
     * This method delete the created Lead and also delete the created campaign.
     */
    @AfterMethod
    public void tearDown() {
        leadDetails.clickDeleteButton();
        campaignsHome = new TabBar().clickCampaigns();
        campaignDetail = campaignsHome.selectCampaign(CAMPAIGN_NAME);
        campaignDetail.clickDeleteButton();
    }
}


