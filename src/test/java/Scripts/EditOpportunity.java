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
public class EditOpportunity {

    TabBar tapBar;
    OpportunitiesHome opportunitiesHome;
    NewOpportunityForm newOpportunityForm;
    OpportunityProfile opportunityProfile;

    //region values
    private boolean isPrivate               = true;
    private String opportunityName          = "Opp_name1";
    private String opportunityNameUpdate    = "Opp_name2";
    private String accountName              = "test account_1";
    private String accountNameUpdate        = "test account_2";
    private String stage                    = "Needs Analysis";
    private String stageUpdate              = "Perception Analysis";
    //endregion

    @BeforeTest
    public void BeforeTest()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("vasquez.vn@gmail.com")
                .setPasswordField("123Control")
                .clickLogInToSalesforceButton();
        createOpportunity();
    }

    private void createOpportunity() {
        opportunitiesHome = tapBar
                .clickOpportunityTab();

        newOpportunityForm = opportunitiesHome
                .clickNewButton();

        opportunityProfile = newOpportunityForm
                .checkPrivateFlag(isPrivate)
                .setOpportunityName(opportunityName)
                .setAccountName(accountName)   // TODO: lookup
                .setCurrentCloseDate()
                .chooseStageDdl(stage)
                .pressSaveBtn();
    }

    @Test
    public void EditOpportunity()
    {
        newOpportunityForm = opportunityProfile
                .pressEditBtn();

        opportunityProfile = newOpportunityForm
                .uncheckPrivateFlag(isPrivate)
                .setOpportunityName(opportunityNameUpdate)
                .setAccountName(accountNameUpdate)   // TODO: lookup
                .chooseStageDdl(stageUpdate)
                .pressSaveBtn();

        Assert.assertEquals(opportunityProfile.isPrivateFlag(), false);
        Assert.assertEquals(opportunityProfile.getOpportunityName(), opportunityNameUpdate);
        Assert.assertEquals(opportunityProfile.getAccountName(), accountNameUpdate);
        Assert.assertEquals(opportunityProfile.getStage(), stageUpdate);
    }

    @AfterTest
    public void afterTest()
    {
        opportunityProfile.pressDeleteBtn();
    }
}
