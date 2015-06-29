package Scripts;

import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Opportunities.OpportunityProfile;
import Pages.TopBar.TabBar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Framework.BrowserManager;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by ivan on 28-06-15.
 */
public class CreateOpportunity {

    //region Objects
    TabBar              tapBar;
    OpportunitiesHome   opportunitiesHome;
    NewOpportunityForm  newOpportunityForm;
    OpportunityProfile  opportunityProfile;
    Calendar            c = new GregorianCalendar();
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

        Assert.assertEquals(opportunityName, opportunityProfile.getOpportunityName());
        Assert.assertEquals(accountName, opportunityProfile.getAccountName());
        Assert.assertEquals(getCurrentDate(), opportunityProfile.getCloseDate());
        Assert.assertEquals(stage, opportunityProfile.getStage());
        Assert.assertEquals(orderNumber, opportunityProfile.getOrderNumber());
        Assert.assertEquals(deliveryInstallStatus, opportunityProfile.getDeliveryInstallation());

    }

    @AfterTest
    public void afterTest()
    {
        opportunityProfile.pressDeleteBtn();
    }

    private String getCurrentDate() {

        return String.format("%s/%s/%s",
                Integer.toString(c.get(Calendar.MONTH) + 1),
                Integer.toString(c.get(Calendar.DATE)),
                Integer.toString(c.get(Calendar.YEAR)));
    }
}
