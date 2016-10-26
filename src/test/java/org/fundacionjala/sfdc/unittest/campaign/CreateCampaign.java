package org.fundacionjala.sfdc.unittest.campaign;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
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

import java.util.Map;
import java.util.Random;


public class CreateCampaign {

    private CampaignsHome campaignsHome;

    private CampaignForm campaignForm;
    private CampaignLookup lookUpWindow;
    private CampaignDetail campaignDetail;
    private String campaignParent;
    private JsonMapper jsonMapper;
    public static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";


    private Map<String, String> valuesMapJson;
    private LoginPage loginPage;

    @BeforeTest()
    public void setup() {
        valuesMapJson = jsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        final MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        campaignParent = "Parent" + new Random().nextInt(9999);
        campaignsHome = tabBar.clickCampaigns();
        campaignForm = campaignsHome
                .clickNewButton();
       campaignDetail = campaignForm
                .setCampaingNameField(campaignParent)
                .checkActiveCheckbox()
                .clickSaveButton();
        tabBar = campaignDetail.toTabBar();
        campaignsHome= tabBar.clickCampaigns();
    }

    @Test()
    public void createCampaingWhithJason() {
        CampaignForm campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        lookUpWindow = campaignForm.clickLookUpIcon();
        campaignForm = lookUpWindow.selectCampaignWithNameByScope(campaignParent, CampaignLookup.ALL_CAMPAIGN);
        campaignDetail=campaignForm.clickSaveButton();
        AssertCampaign.assertDetailValues(campaignDetail, valuesMapJson);

    }

//    @Test
//    public void createCampaign() {
//        campaignsHome.clickNewButton();
//        Campaigns campaigns = new Campaigns.ProductBuilder("builderTest")
//                .setRevenue("1000")
//                .build();
//        campaignDetail = campaigns.createCampaign();
//       // AssertProduct.assertDetailValues(productDetail, product.getValuesMap());
//    }

    @AfterTest()
    public void tearDown() {
        campaignsHome = campaignDetail.clickDeleteButton();

    }
}
