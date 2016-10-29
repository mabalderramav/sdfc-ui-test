package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;

/**
 * Class that verify the creation of the account.
 */
public class CreateAccount {
    private AccountHome accountHome;
    private AccountDetail accountDetail;
    private static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to create an account.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickOnAccountsHome();
    }

    /**
     * Method that verify the creation of the account.
     */
    @Test
    public void createAccount() {
        AccountForm accountForm = accountHome.clickNewButton();
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(accountDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }

    /**
     * Delete the created account.
     */
    @AfterMethod
    public void afterTest() {
        accountDetail.clickDeleteButton();
    }
}
