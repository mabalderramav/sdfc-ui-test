package org.fundacionjala.sfdc.unittest.contract;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;

/**
 * This class is a test to edit and delete of a opportunity.
 */
public class DeleteEditContract {

    private TabBar tabBar;
    private LoginPage loginPage;
    private OpportunityHome opportunityHomeHome;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private AccountHome accountsHome;
    private AccountForm newAccountForm;
    private AccountDetail accountProfile;
    private MainApp mainApp;
    public static final String OPPORTUNITY_DATA_EDIT_PATH = "src/test/resources/json/opportunity/CreateOpportunityData.json";
    private Map<String, String> valuesMapJson;
    private Map<String, String> valuesMapEditJson;

    /**
     * This method is a preconditions to edit and delete a opportunity.
     */
    @BeforeMethod
    public void BeforeTest() {
        valuesMapJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();

        accountsHome = tabBar.clickOnAccountsHome();
        newAccountForm = accountsHome.clickNewButton();
        accountProfile = newAccountForm
                .setAccountName(valuesMapJson.get("accountName"))
                .clickSaveButton();
        opportunityHomeHome = tabBar.clickOnOpportunitiesHome();
        opportunityForm = opportunityHomeHome.clickNewButton();

        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.clickSaveButton();

    }

    /**
     * This a test to delete a opportunities
     */
    @Test
    public void DeleteOpportunity() {
        opportunityDetail.clickDeleteButton();
        Assert.assertFalse(opportunityDetail.isOpportunityDisplayed(valuesMapJson.get("opportunityName")));
    }

    /**
     * This is a test to edit a opportunities
     */
    @Test
    public void EditOpportunity() {
        opportunityForm = opportunityDetail.clickEditButton();
        valuesMapEditJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        opportunityForm.fillTheForm(valuesMapEditJson);
        opportunityDetail = opportunityForm.clickSaveButton();
        AssertContract.assertDetailValues(opportunityDetail, valuesMapEditJson);
    }

    /**
     * This is a post conditions a opportunities.
     */
    @AfterMethod
    public void afterTest() {
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapJson.get("accountName"));
        mainApp = accountProfile.clickDeleteButton();
        mainApp.clickUserButton().clickLogout();
    }

}
