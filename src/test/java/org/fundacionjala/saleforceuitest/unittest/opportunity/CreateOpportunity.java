package org.fundacionjala.saleforceuitest.unittest.opportunity;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.saleforceuitest.pages.accounts.AccountAbstractPage;
import org.fundacionjala.saleforceuitest.pages.accounts.AccountProfile;
import org.fundacionjala.saleforceuitest.pages.accounts.NewAccountPage;
import org.fundacionjala.saleforceuitest.pages.campaigns.CampaignProfile;
import org.fundacionjala.saleforceuitest.pages.campaigns.CampaignsHome;
import org.fundacionjala.saleforceuitest.pages.campaigns.NewCampaignForm;
import org.fundacionjala.saleforceuitest.pages.LoginPage;
import org.fundacionjala.saleforceuitest.pages.lookup.LookUpWindow;
import org.fundacionjala.saleforceuitest.pages.MainApp;
import org.fundacionjala.saleforceuitest.pages.opportunities.NewOpportunityForm;
import org.fundacionjala.saleforceuitest.pages.opportunities.OpportunitiesAbstractPage;
import org.fundacionjala.saleforceuitest.pages.opportunities.OpportunityProfile;
import org.fundacionjala.saleforceuitest.pages.TabBar;


/**
 * Created by Ruber Cuellar
 */
public class CreateOpportunity {

    //region Objects
    private TabBar          tabBar;
    private LookUpWindow    lookUpWindow;
    private LoginPage loginPage;

    private OpportunitiesAbstractPage opportunitiesHome;
    private NewOpportunityForm  newOpportunityForm;
    private OpportunityProfile  opportunityProfile;

    private CampaignsHome   campaignsHome;
    private NewCampaignForm newCampaignForm;
    private CampaignProfile campaignProfile;

    private AccountAbstractPage accountsHome;
    private NewAccountPage newAccountForm;
    private AccountProfile  accountProfile;
    private MainApp mainApp;
    //endregion

    //region values
    private String campaignName;
    private String campaingUrl;

    private String accountUrl;

    private String opportunityName          = "Opp_name1";
    private String type                     = "Existing Customer - Replacement";
    private String leadSource               = "Partner Referral";
    private String amount                   = "100";
    private String nextStep                 = "Conquer the world";
    private String stage                    = "Needs Analysis";
    private String orderNumber              = "00001";
    private String deliveryInstallStatus    = "Yet to begin";
    private String accountName = "RuberAccount";

    //endregion

    @BeforeTest
    public void BeforeTest()
    {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();

        //newOpportunityForm = opportunitiesHome.clickElement

        accountsHome = tabBar.clickOnAccountsHome();

        newAccountForm = accountsHome.clickNewButton();

        accountProfile = newAccountForm
                .setAccountName(accountName)
                .pressSaveBtn();

        accountUrl = accountProfile.getUrl();

        opportunitiesHome = tabBar.clickOnOpportunitiesHome();
    }

    @Test
    public void CreateOpportunity()
    {
        newOpportunityForm = opportunitiesHome.clickNewButton();
        opportunityProfile = newOpportunityForm
                .checkPrivateFlag(true)
                .setOpportunityName(opportunityName)
                .setAccountName(accountName)
                .chooseTypeDdl(type)
                .chooseLeadSourceDdl(leadSource)
                .setAmount(amount)
                .setCurrentCloseDate()
                .setNextStep(nextStep)
                .chooseStageDdl(stage)
                .setPrimaryCampaignSource(campaignName)
                .setOrderNumber(orderNumber)
                .chooseDeliveryInstallationStatusDdl(deliveryInstallStatus)
                .pressSaveBtn();


        Assert.assertEquals(opportunityProfile.getOpportunityName(), opportunityName);
        Assert.assertEquals(opportunityProfile.getAccountName(), accountName);
        Assert.assertEquals(opportunityProfile.getStage(), stage);
        Assert.assertEquals(opportunityProfile.getOrderNumber(), orderNumber);
        Assert.assertEquals(opportunityProfile.getDeliveryInstallation(), deliveryInstallStatus);

    }

    @AfterTest
    public void afterTest()
    {
        mainApp = opportunityProfile.clickDeteleBtn();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(accountName);
        mainApp = accountProfile.deleteAccount();
        mainApp.clickUserButton().clickLogout();

    }
}
