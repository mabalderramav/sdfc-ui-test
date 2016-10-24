package org.fundacionjala.sfdc.unittest.campaing;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Lion on 10/23/2016.
 */
public class UpdateCampaign {

    public static final String PARA_BORRAR = "campaign to be updated";
    private Campaigns campaigns;
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
                .setCampaingNameField(PARA_BORRAR)
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .clickOnStartDate();
        campaignDetail = campaignForm.clickSaveButton();

        assertEquals(campaignDetail.getCampaingNameLabel(), PARA_BORRAR);
    }

    @Test(groups = {"smoke", "acceptance"})
    public void deleteCampaign() {
        campaignForm = campaignDetail.clickEditButton();
        campaignForm.setCampaingNameField("Campaign Updated");
        campaignDetail = campaignForm.clickSaveButton();
        assertEquals(campaignDetail.getCampaingNameLabel(), "Campaign Updated");
    }

    @AfterTest(groups = {"smoke", "acceptance"})
    public void afterTest() {
        campaigns = campaignDetail
                .clickDeleteButton();

        mainApp = campaigns
                .goToHomePage(homeUrl);
    }

}
