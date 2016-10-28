package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.fundacionjala.sfdc.tests.Asserts;
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
    private static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    private static final String NAME_TEST = "nameTest";
    private static final String SITE_TEST = "site test";
    private AccountDetail accountDetail;
    private AccountForm accountForm;
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to create an account.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        AccountHome accountHome = tabBar.clickOnAccountsHome();
        accountForm = accountHome.clickNewButton();
    }

    /**
     * Method that verify the creation of the account with json file.
     */
    @Test
    public void createAccountWithJson() {
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
        Asserts.assertDetailValues(accountDetail, valuesMapJson);
    }

    /**
     * Method that verify the creation of the account.
     */
    @Test
    public void createAccount() {
        accountForm = new AccountForm.AccountBuilder(NAME_TEST)
                .setSite(SITE_TEST)
                .build();
        accountDetail = accountForm.saveAccount();
        Asserts.assertDetailValues(accountDetail, accountForm.getValuesMap());
    }

    /**
     * Delete the created account after the  tests.
     */
    @AfterMethod
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
