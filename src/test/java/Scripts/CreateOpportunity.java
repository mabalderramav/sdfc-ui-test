package Scripts;

import Framework.BrowserManager;
import Pages.LoginPage;
import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Opportunities.OpportunityProfile;
import Pages.TopBar.TabBar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Ivan Vasquez on 6/29/2015.
 */
public class CreateOpportunity {

    //region Objects
    TabBar              tapBar;
    OpportunitiesHome   opportunitiesHome;
    NewOpportunityForm  newOpportunityForm;
    OpportunityProfile  opportunityProfile;
    //endregion

    //region values
    private String opportunityName          = "Opp_name1";
    private String accountName              = "test account_1";
    private String type                     = "Existing Customer - Replacement";
    private String leadSource               = "Partner Referral";
    private String amount                   = "100";
    private String nextStep                 = "Conquer the world";
    private String stage                    = "Needs Analysis";
    private String primaryCampaignSource    = "Campaign_001";
    private String orderNumber              = "00001";
    private String deliveryInstallStatus    = "Yet to begin";
    //endregion

    @BeforeTest
    public void BeforeTest()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("vasquez.vn@gmail.com")
                .setPasswordField("123Control")
                .clickLogInToSalesforceButton();
    }

    @Test
    public void CreateOpportunity()
    {
        opportunitiesHome = tapBar
                .clickOpportunityTab();

        newOpportunityForm = opportunitiesHome
                .clickNewButton();

        opportunityProfile = newOpportunityForm
                .checkPrivateFlag(true)
                .setOpportunityName(opportunityName)
                .setAccountName(accountName)   // TODO: lookup
                .chooseTypeDdl(type)
                .chooseLeadSourceDdl(leadSource)
                .setAmount(amount)
                .setCurrentCloseDate()
                .setNextStep(nextStep)
                .chooseStageDdl(stage)
                .setPrimaryCampaignSource(primaryCampaignSource)   // TODO: lookup
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
        opportunityProfile.pressDeleteBtn();
    }
}
