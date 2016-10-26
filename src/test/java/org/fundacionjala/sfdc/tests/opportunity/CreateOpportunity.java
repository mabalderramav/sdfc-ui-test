package org.fundacionjala.sfdc.tests.opportunity;

import java.util.Map;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountAbstractPage;
import org.fundacionjala.sfdc.pages.accounts.AccountProfile;
import org.fundacionjala.sfdc.pages.accounts.NewAccountPage;
import org.fundacionjala.sfdc.pages.opportunities.Opportunity;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class is a test to create a opportunity
 */
public class CreateOpportunity {

    static final String OPPORTUNITY_DATA_PATH = "opportunity/CreateOpportunityData.json";
    private TabBar tabBar;
    private OpportunityDetail opportunityDetail;
    private AccountAbstractPage accountsHome;
    private AccountProfile accountProfile;
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
        NewAccountPage newAccountForm = accountsHome.clickNewButton();
        accountProfile = newAccountForm
                .setAccountName(valuesMapJson.get("accountName"))
                .pressSaveBtn();
    }

    /**
     * This a test to create a opportunities.
     */
    @Test
    public void createOpportunity() {
        OpportunityHome opportunityHome = tabBar.clickOnOpportunitiesHome();
        opportunityHome.clickNewButton();
        // Option 1
        //        opportunityDetail = opportunityHome.clickSaveButton()
        //                .setOpportunityName("Test")
        //                .setOrderNumber("")
        //                .clickSaveBtn();

        // Option 2
        //        opportunityForm.fillTheForm(valuesMapJson);
        //        opportunityDetail = opportunityForm.clickSaveBtn();

        // Option 3
        //        Builder.
        Opportunity opportunity = new Opportunity.OpportunityBuilder(valuesMapJson.get("opportunityName"),
                valuesMapJson.get("currentCloseDate"), valuesMapJson.get("stage"))
                .setType(valuesMapJson.get("type"))
                .setAccountName(valuesMapJson.get("accountName"))
                .build();
        opportunityDetail = opportunity.createOpportunity();

        AssertOpportunity.assertDetailValues(opportunityDetail, opportunity.getValuesMap());
    }

    /**
     * This a post conditions a opportunities.
     */
    @AfterTest
    public void afterTest() {
        MainApp mainApp = opportunityDetail.clickDeleteButton();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapJson.get("accountName"));
        accountProfile.deleteAccount();
    }
}
