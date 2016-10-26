package org.fundacionjala.sfdc.tests.opportunity;

import java.util.Map;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;

import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.*;


/**
 * This class is a test to create a opportunity
 */
public class CreateOpportunity {

    static final String OPPORTUNITY_DATA_PATH = "opportunity/CreateOpportunityData.json";
    private TabBar tabBar;
    private OpportunityDetail opportunityDetail;
    private AccountHome accountsHome;
    private AccountDetail accountProfile;
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to create a opportunities.
     */
    @BeforeTest
    public void BeforeTest() {
        valuesMapJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_PATH);
        final MainApp mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        AccountForm newAccountForm = accountsHome.clickNewButton();
        accountProfile = newAccountForm
                .setAccountName(valuesMapJson.get(ACCOUNT_NAME.value))
                .clickSaveButton();
    }

    /**
     * This a test to create a opportunities.
     */
    @Test
    public void createOpportunity() {
        OpportunityHome opportunityHome = tabBar.clickOnOpportunitiesHome();
        OpportunityForm opportunityForm = opportunityHome.clickNewButton();

        opportunityForm = new OpportunityForm.OpportunityBuilder(
                valuesMapJson.get(OPPORTUNITY_NAME.value),
                valuesMapJson.get(CURRENT_CLOSE_DATE.value),
                valuesMapJson.get(STAGE.value))
                .setType(valuesMapJson.get(TYPE.value))
                .setAccountName(valuesMapJson.get(ACCOUNT_NAME.value))
                .build();
        opportunityDetail = opportunityForm.saveOpportunity();
        AssertOpportunity.assertDetailValues(opportunityDetail, opportunityForm.getValuesMap());
    }

    /**
     * This a post conditions a opportunities.
     */
    @AfterTest
    public void afterTest() {
        MainApp mainApp = opportunityDetail.clickDeleteButton();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapJson.get(ACCOUNT_NAME.value));
        accountProfile.clickDeleteButton();
    }
}
