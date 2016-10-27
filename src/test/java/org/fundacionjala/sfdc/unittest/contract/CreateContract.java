package org.fundacionjala.sfdc.unittest.contract;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;

/**
 * This class is a test to create a contract.
 */
public class CreateContract {

    private TabBar tabBar;
    private LoginPage loginPage;
    private OpportunityHome opportunityHomeHome;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private AccountHome accountsHome;
    private AccountForm newAccountForm;
    private AccountDetail accountProfile;
    private MainApp mainApp;
    public static final String OPPORTUNITY_DATA_PATH = "src/test/resources/json/opportunity/CreateOpportunityData.json";
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to create a contract.
     */
    @BeforeTest
    public void beforeTest() {
        valuesMapJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        newAccountForm = accountsHome.clickNewButton();
        accountProfile = newAccountForm
                .setNameTextField(valuesMapJson.get("accountName"))
                .clickSaveButton();
        opportunityHomeHome = tabBar.clickOnOpportunitiesHome();
    }

    /**
     * This a test to create a opportunities.
     */
    @Test
    public void createOpportunity() {
        opportunityForm = opportunityHomeHome.clickNewButton();
        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.clickSaveButton();
        //new AssertContract().assertDetailValues(opportunityDetail, valuesMapJson);
    }


    /**
     * This a post conditions a opportunities.
     */
    @AfterTest
    public void afterTest() {
        mainApp = opportunityDetail.clickDeleteButton();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapJson.get("accountName"));
        mainApp = accountProfile.clickDeleteButton();
        mainApp.clickUserButton().clickLogout();
    }
}
