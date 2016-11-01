package org.fundacionjala.sfdc.tests.opportunity;

import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.tests.Asserts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.CURRENT_CLOSE_DATE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.OPPORTUNITY_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.STAGE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.TYPE;


/**
 * This class is a test to create a opportunity.
 */
public class CreateOpportunity {

    static final String OPPORTUNITY_DATA_PATH = "opportunity/CreateOpportunityData.json";
    private TabBar tabBar;
    private OpportunityDetail opportunityDetail;
    private AccountDetail accountDetail;
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to create a opportunities.
     */
    @BeforeMethod
    public void beforeTest() {
        valuesMapJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_PATH);
        MainApp mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        AccountHome accountsHome = tabBar.clickOnAccountsHome();
        AccountForm newAccountForm = accountsHome.clickNewButton();
        accountDetail = newAccountForm
                .setNameTextField(valuesMapJson.get(ACCOUNT_NAME.getValue()))
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
                valuesMapJson.get(OPPORTUNITY_NAME.getValue()),
                valuesMapJson.get(CURRENT_CLOSE_DATE.getValue()),
                valuesMapJson.get(STAGE.getValue()))
                .setType(valuesMapJson.get(TYPE.getValue()))
                .setAccountName(valuesMapJson.get(ACCOUNT_NAME.getValue()))
                .build();
        opportunityDetail = opportunityForm.saveOpportunity();
        Asserts.assertDetailValues(opportunityDetail, opportunityForm.getValuesMap());
    }

    /**
     * This a post conditions a opportunities.
     */
    @AfterMethod
    public void afterTest() {
        // Deleting account, it is deleted the opportunity too.
        accountDetail = opportunityDetail.clickAccountName(valuesMapJson.get(ACCOUNT_NAME.getValue()));
        accountDetail.clickDeleteButton();
    }
}
