package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;

/**
 * Class to verify the delete option for an account.
 */
public class DeleteAccount {
    /**
     * This test is to edit and delete an account.
     */
    public static final String COLON = ", ";
    private AccountHome accountHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private AccountDetail accountDetail;
    private AccountForm accountForm;

    public static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    private Map<String, String> valuesMapJson;

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
     * Test to verify the delete option.
     */
    @Test
    public void deleteAccount() {
        accountDetail.clickDeleteButton();
        Assert.assertFalse(accountDetail.isAccountDisplayed(valuesMapJson.get("accountName")
                .concat(COLON).concat(valuesMapJson.get("accountName"))));
    }

}
