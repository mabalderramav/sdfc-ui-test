package org.fundacionjala.sfdc.unittest.opportunity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/**
 * This class is a test to create a opportunity
 */
public class CreateOpportunity {

    private TabBar tabBar;
    private LoginPage loginPage;
    private Opportunity opportunityHome;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private AccountAbstractPage accountsHome;
    private NewAccountPage newAccountForm;
    private AccountProfile accountProfile;
    private MainApp mainApp;

    public static final Map<String, String> valuesMapCreate = new HashMap();
    static {
        valuesMapCreate.put("opportunityName", "Opp_name1");
        valuesMapCreate.put("type", "Existing Customer - Replacement");
        valuesMapCreate.put("CurrentCloseDate", "");
        valuesMapCreate.put("leadSource", "Partner Referral");
        valuesMapCreate.put("amount", "100");
        valuesMapCreate.put("nextStep", "Conquer the world");
        valuesMapCreate.put("stage", "Needs Analysis");
        valuesMapCreate.put("orderNumber", "00001");
        valuesMapCreate.put("deliveryInstallStatus", "Yet to begin");
        valuesMapCreate.put("accountName", "RuberAccount");
    }

    public static final List<String> valuesListAssert = new ArrayList();
    static {
        valuesListAssert.add("opportunityName");
        valuesListAssert.add("stage");
        valuesListAssert.add("orderNumber");
        valuesListAssert.add("deliveryInstallStatus");
        valuesListAssert.add("accountName");
    }

    /**
     * This method is a preconditions to create a opportunities.
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
    }

    /**
     * This a test to create a opportunities.
     */
    @Test
    public void CreateOpportunity() {
        opportunityForm = opportunityHome.clickNewButton();

        valuesMapCreate.keySet()
                .forEach(step -> opportunityForm.getStrategyStepMap(valuesMapCreate).get(step).executeStep());

        opportunityDetail = opportunityForm.pressSaveBtn();

        valuesListAssert
                .forEach(value ->  Assert.assertEquals(opportunityDetail.getStrategyAssertMap().get(value).getText()
                        , valuesMapCreate.get(value)) );
    }

    /**
     * This a post conditions a opportunities.
     */
    @AfterTest
    public void afterTest() {
        mainApp = opportunityDetail.clickDeteleBtn();
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(valuesMapCreate.get("accountName"));
        mainApp = accountProfile.deleteAccount();
        mainApp.clickUserButton().clickLogout();
    }
}
