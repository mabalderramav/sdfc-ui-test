package org.fundacionjala.sfdc.tests.contract;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.contracts.ContractForm;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;
import org.fundacionjala.sfdc.tests.Asserts;

import static org.fundacionjala.sfdc.pages.contracts.ContractFields.ACCOUNT_NAME;
import static org.testng.Assert.assertFalse;

/**
 * This class handle edit and deleted a contract.
 */
public class DeleteEditContract {

    private static final String CONTRACT_DATA_EDIT_PATH = "contract/EditContractData.json";
    private String contractNumber;
    private TabBar tabBar;
    private ContractForm contractForm;
    private ContractDetail contractDetail;
    private AccountHome accountsHome;
    private AccountDetail accountDetail;
    private MainApp mainApp;
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to edit and delete a contract.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(CreateContract.CONTRACT_DATA_PATH);
        mainApp = new MainApp();

        tabBar = mainApp.goToTabBar();

        accountsHome = tabBar.clickOnAccountsHome();
        AccountForm accountForm = accountsHome.clickNewButton();
        accountDetail = accountForm
                .setNameTextField(valuesMapJson.get(ACCOUNT_NAME.toString()))
                .clickSaveButton();

        ContractHome contractHome = tabBar.clickOnContractHome();
        contractForm = contractHome.clickNewButton();

        contractForm.fillTheForm(valuesMapJson);
        contractDetail = contractForm.clickSaveButton();
        contractNumber = contractDetail.getContractNumber();
    }

    /**
     * This a test to delete a contract.
     */
    @Test
    public void deleteContract() {
        contractDetail.clickDeleteButton();
        assertFalse(contractDetail.isContractDisplayed(contractNumber), "The contract shouldn't be displayed");
    }

    /**
     * This is a test to edit a contract.
     */
    @Test
    public void editContract() {
        contractForm = contractDetail.clickEditButton();
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(CONTRACT_DATA_EDIT_PATH);
        contractForm.fillTheForm(valuesMapEditJson);
        contractDetail = contractForm.clickSaveButton();
        Asserts.assertDetailValues(contractDetail, valuesMapEditJson);
    }

    /**
     * This is a post conditions for contract test.
     */
    @AfterMethod
    public void tearDown() {
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountDetail = accountsHome.clickOnAccount(valuesMapJson.get(ACCOUNT_NAME.toString()));
        mainApp = accountDetail.clickDeleteButton();

    }
}
