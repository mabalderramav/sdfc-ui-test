package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;

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
    private Map<String, String> valuesMapEditJson;

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
     * Test to verify the delete of an account.
     */
    @Test
    public void deleteAccount() {
        accountDetail.clickDeleteButton();
        assertFalse(accountHome.isAccountDisplayed(valuesMapJson.get("accountName")));
    }

    /**
     * Test to verify the edit of an account.
     */
    @Test
    public void editAccount() {
        accountForm = accountDetail.clickEditButton();
        valuesMapEditJson = JsonMapper.getMapJson(ACCOUNT_DATA_EDIT_PATH);
        accountForm.fillTheForm(valuesMapEditJson);
        accountDetail = accountForm.clickSaveButton();
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(accountDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapEditJson.get(value)));
    }

    /**
     * This method delete the created AccountFields.
     */
    @AfterClass
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
