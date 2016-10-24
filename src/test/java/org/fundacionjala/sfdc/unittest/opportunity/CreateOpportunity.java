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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * This class is a test to create a opportunity
 */
public class CreateOpportunity {

    private TabBar tabBar;
    private LoginPage loginPage;
    private OpportunityHome opportunityHomeHome;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private AccountAbstractPage accountsHome;
    private NewAccountPage newAccountForm;
    private AccountProfile accountProfile;
    private MainApp mainApp;
    public static final String OPPORTUNITY_DATA_PATH = "src/test/resources/json/opportunity/CreateOpportunityData.json";
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to create a opportunities.
     */
    @BeforeTest
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
    }

    /**
     * This a test to create a opportunities.
     */
    @Test
    public void createOpportunity() {
        opportunityForm = opportunityHomeHome.clickNewButton();
        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.pressSaveBtn();
        new AssertOpportunity().assertDetailValues(opportunityDetail, valuesMapJson);
    }


    /**
     * This a post conditions a opportunities.
     */
    @AfterTest
    public void afterTest() {
        mainApp = opportunityDetail.clickDeteleBtn();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapJson.get("accountName"));
        mainApp = accountProfile.deleteAccount();
        mainApp.clickUserButton().clickLogout();
    }
}
