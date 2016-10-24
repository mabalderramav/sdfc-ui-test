package org.fundacionjala.sfdc.unittest.opportunity;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountAbstractPage;
import org.fundacionjala.sfdc.pages.accounts.AccountProfile;
import org.fundacionjala.sfdc.pages.accounts.NewAccountPage;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.utils.Common;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.fundacionjala.sfdc.unittest.opportunity.CreateOpportunity.OPPORTUNITY_DATA_PATH;


/**
 * This class is a test to create a opportunity
 */
public class DeleteEditOpportunity {

    private TabBar tabBar;
    private LoginPage loginPage;
    private OpportunityHome opportunityHomeHome;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private AccountAbstractPage accountsHome;
    private NewAccountPage newAccountForm;
    private AccountProfile accountProfile;
    private MainApp mainApp;
    public static final String OPPORTUNITY_DATA_EDIT_PATH = "src/test/resources/json/opportunity/CreateOpportunityData.json";
    private Map<String, String> valuesMapJson;
    private Map<String, String> valuesMapEditJson;

    /**
     * This method is a preconditions to create a opportunities
     */
    @BeforeMethod
    public void BeforeTest() {
        valuesMapJson = Common.getMapJson(OPPORTUNITY_DATA_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();

        accountsHome = tabBar.clickOnAccountsHome();
        newAccountForm = accountsHome.clickNewButton();
        accountProfile = newAccountForm
                .setAccountName(valuesMapJson.get("accountName"))
                .pressSaveBtn();
        opportunityHomeHome = tabBar.clickOnOpportunitiesHome();
        opportunityForm = opportunityHomeHome.clickNewButton();

        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.pressSaveBtn();

    }

    /**
     * This a test to delete a opportunities
     */
    @Test
    public void DeleteOpportunity() {
        opportunityDetail.clickDeteleBtn();
        Assert.assertFalse(opportunityDetail.isOpportunityDisplayed(valuesMapJson.get("opportunityName")));
    }

    /**
     * This is a test to delete a opportunities
     */
    @Test
    public void EditOpportunity() {
        opportunityForm = opportunityDetail.clickEditBtn();
        valuesMapEditJson = Common.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        opportunityForm.fillTheForm(valuesMapEditJson);
        opportunityDetail = opportunityForm.pressSaveBtn();
        new AssertOpportunity().assertDetailValues(opportunityDetail, valuesMapEditJson);
    }

    /**
     * This is a post conditions a opportunities.
     */
    @AfterMethod
    public void afterTest() {
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapJson.get("accountName"));
        mainApp = accountProfile.deleteAccount();
        mainApp.clickUserButton().clickLogout();
    }

}