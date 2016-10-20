package org.fundacionjala.sfdc.unittest.opportunity;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountAbstractPage;
import org.fundacionjala.sfdc.pages.accounts.AccountProfile;
import org.fundacionjala.sfdc.pages.accounts.NewAccountPage;
import org.fundacionjala.sfdc.pages.opportunities.Opportunity;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.unittest.opportunity.CreateOpportunity.valuesListAssert;
import static org.fundacionjala.sfdc.unittest.opportunity.CreateOpportunity.valuesMapCreate;

/**
 * This class is a test to create a opportunity
 */
public class DeleteEditOpportunity {

    private TabBar tabBar;
    private LoginPage loginPage;
    private Opportunity opportunityHome;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private AccountAbstractPage accountsHome;
    private NewAccountPage newAccountForm;
    private AccountProfile accountProfile;
    private MainApp mainApp;

    /**
     * This method is a preconditions to create a opportunities
     */
    @BeforeTest
    public void BeforeTest() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();

        accountsHome = tabBar.clickOnAccountsHome();
        newAccountForm = accountsHome.clickNewButton();
        accountProfile = newAccountForm
                .setAccountName(valuesMapCreate.get("accountName"))
                .pressSaveBtn();
        opportunityHome = tabBar.clickOnOpportunitiesHome();
        opportunityForm = opportunityHome.clickNewButton();

        valuesMapCreate.keySet()
                .forEach(step -> opportunityForm.getStrategyStepMap(valuesMapCreate).get(step).executeStep());
        opportunityDetail = opportunityForm.pressSaveBtn();
    }

    /**
     * This a test to delete a opportunities
     */
    @Test
    public void DeleteOpportunity() {
        opportunityDetail.clickDeteleBtn();
        Assert.assertFalse(opportunityDetail.isOpportunityDisplayed(valuesMapCreate.get("accountName")), "Product Deleted");
    }

    /**
     * This a test to delete a opportunities
     */
    @Test
    public void EditOpportunity() {
        opportunityForm = opportunityDetail.clickEditBtn();

        valuesMapCreate.keySet()
                .forEach(step -> opportunityForm.getStrategyStepMap(valuesMapCreate).get(step).executeStep());

        opportunityDetail = opportunityForm.pressSaveBtn();

        valuesListAssert
                .forEach(value -> Assert.assertEquals(opportunityDetail.getStrategyAssertMap().get(value).executeStep()
                        , valuesMapCreate.get(value)));

    }

    /**
     * This a post conditions a opportunities.
     */
    @AfterTest
    public void afterTest() {
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapCreate.get("accountName"));
        mainApp = accountProfile.deleteAccount();
        mainApp.clickUserButton().clickLogout();
    }

}
