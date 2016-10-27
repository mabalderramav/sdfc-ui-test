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
 * Class that verify the edit option for an account.
 */
public class EditAccount {
    /**
     * This test is to edit  an account.
     */
    private AccountHome accountHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private AccountDetail accountDetail;
    private AccountForm accountForm;

    public static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    public static final String ACCOUNT_DATA_EDIT_PATH = "account/EditAccountData.json";
    private Map<String, String> valuesMapJson;
    private Map<String, String> valuesMapEditJson;

    /**
     * Before method.
     */
    @BeforeMethod
    public void login() {
        valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickOnAccountsHome();
        accountForm = accountHome.clickNewButton();
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(accountDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }

    /**
     * Test to verify the edit of account.
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
     * Method to delete the created account.
     */
    @AfterMethod
    public void afterTest() {
        accountDetail.clickDeleteButton();
        mainApp.clickUserButton().clickLogout();
    }
}
