package org.fundacionjala.sfdc.pages.contracts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represent to a form to create or edit a Contract.
 */
public class ContractForm extends AbstractBasePage {

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    @FindBy(id = "ctrc7")
    @CacheLookup
    private WebElement accountNameTextBox;

    @FindBy(id = "ctrc7_lkwgt")
    @CacheLookup
    private WebElement accountNameLoopIconBtn;

    @FindBy(id = "ctrc16")
    @CacheLookup
    private WebElement customerSignedByTextBox;

    @FindBy(id = "ctrc16_lkwgt")
    @CacheLookup
    private WebElement customerSignedByLoopBtn;

    @FindBy(id = "CustomerSignedTitle")
    @CacheLookup
    private WebElement customerSignedTitle;

    @FindBy(id = "ctrc6")
    @CacheLookup
    private WebElement customerSignedDateTextBox;

    @FindBy(css = "span.dateFormat a[tabindex='4']")
    @CacheLookup
    private WebElement customerSignedDateTodayLink;

    @FindBy(id = "ctrc17")
    @CacheLookup
    private WebElement priceBookMultiSelect;

    @FindBy(id = "ctrc15")
    @CacheLookup
    private WebElement statusMultiselect;

    @FindBy(id = "ctrc5")
    @CacheLookup
    private WebElement contractStartDateTextBox;

    @FindBy(css = "span.dateFormat a[tabindex='7']")
    @CacheLookup
    private WebElement contractStartDateTodayLink;

    @FindBy(id = "ctrc40")
    @CacheLookup
    private WebElement contractTermMonthsTextBox;

    @FindBy(id = "ctrc13")
    @CacheLookup
    private WebElement ownerExpirationNoticeMultiSelect;

    @FindBy(id = "CompanySigned")
    @CacheLookup
    private WebElement companySignedByTextBox;

    @FindBy(id = "CompanySigned_lkwgt")
    @CacheLookup
    private WebElement companySignedByLoopIcon;

    @FindBy(id = "CompanySignedDate")
    @CacheLookup
    private WebElement companySignedDateTextBox;

    @FindBy(css = "span.dateFormat a[tabindex='11']")
    @CacheLookup
    private WebElement todayCompanySignedDateLink;

    /**
     * This method sets a customer signed by.
     *
     * @param customerSignedBy is the new name of a customer signed by.
     * @return a contract form.
     */
    public ContractForm setCustomerSignedBy(final String customerSignedBy) {
        customerSignedByTextBox.clear();
        customerSignedByTextBox.sendKeys(customerSignedBy);
        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return a contract form.
     */
    public ContractForm setAccountName(final String accountName) {
        accountNameTextBox.clear();
        accountNameTextBox.sendKeys(accountName);
        return this;
    }

    /**
     * This method sets a customer signed title.
     *
     * @param customerSignedTitle is a string name.
     * @return a contract form.
     */
    public ContractForm setCustomerSignedTitle(final String customerSignedTitle) {
        customerSignedByTextBox.clear();
        customerSignedByTextBox.sendKeys(customerSignedTitle);
        return this;
    }

    /**
     * This method  sets the customer signed date.
     *
     * @param customerSignedDate a string to set.
     * @return a contract form..
     */
    public ContractForm setCustomerSignedDate(final String customerSignedDate) {
        customerSignedDateTextBox.clear();
        customerSignedDateTextBox.sendKeys(customerSignedDate);
        return this;
    }

    /**
     * This method sets the customer signed date by default.
     *
     * @return a contract form.
     */
    public ContractForm setCustomerSignedDateWithCurrentDate() {
        customerSignedDateTextBox.clear();
        customerSignedDateTodayLink.click();
        return this;
    }

    /**
     * This method sets the price book.
     *
     * @param type is a string type.
     * @return a contract form.
     */
    public ContractForm choosePriceBookType(final String type) {
        Select selectBox = new Select(priceBookMultiSelect);
        selectBox.selectByVisibleText(type);
        return this;
    }

    /**
     * This method chooses the status.
     *
     * @param status is a string type.
     * @return a contract form.
     */
    public ContractForm chooseStatus(final String status) {
        Select selectBox = new Select(statusMultiselect);
        selectBox.selectByVisibleText(status);
        return this;
    }

    /**
     * This method  sets the contract start date.
     *
     * @param contractStartDate a string to set.
     * @return a contract form.
     */
    public ContractForm setContractStartDate(final String contractStartDate) {
        contractStartDateTextBox.clear();
        contractStartDateTextBox.sendKeys(contractStartDate);
        return this;
    }

    /**
     * This method sets the contract start date by default.
     *
     * @return a contract form.
     */
    public ContractForm setContractStartDateWithCurrentDate() {
        contractStartDateTextBox.clear();
        contractStartDateTodayLink.click();
        return this;
    }

    /**
     * This method sets the contract term in months.
     *
     * @param contractTermMonths a string to set.
     * @return a contract form.
     */
    public ContractForm setContractTermMonths(final String contractTermMonths) {
        contractTermMonthsTextBox.clear();
        contractStartDateTextBox.sendKeys(contractTermMonths);
        return this;
    }

    /**
     * This method chooses the owner expiration notice.
     *
     * @param ownerExpirationNotice is a string type.
     * @return a contract form.
     */
    public ContractForm chooseOwnerExpirationNotice(final String ownerExpirationNotice) {
        Select selectBox = new Select(ownerExpirationNoticeMultiSelect);
        selectBox.selectByVisibleText(ownerExpirationNotice);
        return this;
    }

    /**
     * This method sets the company signed by field.
     *
     * @param companySignedBy is a string.
     * @return a opportunity form.
     */
    public ContractForm setCompanySignedBy(final String companySignedBy) {
        companySignedByTextBox.clear();
        companySignedByTextBox.sendKeys(companySignedBy);
        return this;
    }

    /**
     * This method  sets the company signed date.
     *
     * @param companySignedDate a string to set.
     * @return a contract form..
     */
    public ContractForm setCompanySignedDate(final String companySignedDate) {
        companySignedDateTextBox.clear();
        companySignedDateTextBox.sendKeys(companySignedDate);
        return this;
    }

    /**
     * This method sets the the company signed date by default.
     *
     * @return a contract form.
     */
    public ContractForm setCompanySignedDateWithCurrentDate() {
        companySignedDateTextBox.clear();
        todayCompanySignedDateLink.click();
        return this;
    }

    /**
     * This method makes click to save button.
     *
     * @return ContractHome Detail page object.
     */
    public ContractDetail clickSaveBtn() {
        saveBtn.click();
        return new ContractDetail();
    }

    /**
     * This method makes click on account name.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickAccountNameLoopIcon() {
        CommonActions.clickElement(accountNameLoopIconBtn);
        return new LookUpWindow();
    }

    /**
     * This method makes click on customer signed by loop icon.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickCustomerSignedByLoopIcon() {
        CommonActions.clickElement(customerSignedByLoopBtn);
        return new LookUpWindow();
    }

    /**
     * This method makes click on company signed by loop icon.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickCompanySignedByLoopIcon() {
        CommonActions.clickElement(companySignedByLoopIcon);
        return new LookUpWindow();
    }

    /**
     * Method that to permit set values to create a new ContractHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the contract create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put("accountName",
                () -> setAccountName(String.valueOf(values.get("accountName"))));
        strategyMap.put("customerSignedBy",
                () -> setCustomerSignedBy(String.valueOf(values.get("customerSignedBy"))));
        strategyMap.put("customerSignedTitle",
                () -> setCustomerSignedTitle(String.valueOf(values.get("customerSignedTitle"))));
        strategyMap.put("customerSignedDate",
                () -> setCustomerSignedDate(String.valueOf(values.get("customerSignedDate"))));
        strategyMap.put("priceBook",
                () -> choosePriceBookType(String.valueOf(values.get("priceBook"))));
        strategyMap.put("status",
                () -> chooseStatus(String.valueOf(values.get("status"))));
        strategyMap.put("contractStartDate",
                () -> setContractStartDate(String.valueOf(values.get("contractStartDate"))));
        strategyMap.put("contractTermMonths",
                () -> setContractTermMonths(String.valueOf(values.get("contractTermMonths"))));
        strategyMap.put("ownerExpirationNotice",
                () -> setAccountName(String.valueOf(values.get("ownerExpirationNotice"))));
        strategyMap.put("companySignedBy",
                () -> setCompanySignedBy(String.valueOf(values.get("companySignedBy"))));
        strategyMap.put("companySignedDate",
                () -> setCompanySignedDate(String.valueOf(values.get("companySignedDate"))));

        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map with the info of the Json file.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
