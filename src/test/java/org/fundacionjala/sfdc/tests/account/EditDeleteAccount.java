package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.fundacionjala.sfdc.tests.Asserts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;

import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_NAME;
import static org.testng.Assert.assertFalse;

/**
 * Class that verify the edit and delete options for an account.
 */
public class EditDeleteAccount {
    private AccountDetail accountDetail;
    private AccountForm accountForm;
    private AccountHome accountHome;
    private static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    private static final String ACCOUNT_DATA_EDIT_PATH = "account/EditAccountData.json";
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to edit and delete an account.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickOnAccountsHome();
        accountForm = accountHome.clickNewButton();
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
    }

    /**
     * Test to verify the successful deleting of an account.
     */
    @Test
    public void deleteAccount() {
        accountDetail.clickDeleteButton();
        assertFalse(accountHome.isAccountDisplayed(valuesMapJson.get(ACCOUNT_NAME.toString())));
    }

    /**
     * Test to verify the correct edition of an account.
     */
    @Test
    public void editAccount() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(ACCOUNT_DATA_EDIT_PATH);
        accountForm = accountDetail.clickEditButton();
        accountForm.fillTheForm(valuesMapEditJson);
        accountDetail = accountForm.clickSaveButton();
        Asserts.assertDetailValues(accountDetail, valuesMapEditJson);
    }

    /**
     * This method delete the created  Account.
     */
    @AfterClass
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
