package org.fundacionjala.sfdc.pages.contracts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;

import static org.fundacionjala.sfdc.pages.contracts.ContractFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CUSTOMER_SIGNED_BY;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CUSTOMER_SIGNED_TITLE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.COMPANY_SIGNED_BY;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CONTRACT_START_DATE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.COMPANY_SIGNED_DATE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CONTRACT_TERM_MONTHS;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CUSTOMER_SIGNED_DATE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.OWNER_EXPIRATION_NOTICE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.PRICE_BOOK;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.STATUS;

/**
 * This class represents a form to create or edit a contract.
 */
public class ContractForm extends FormBase {


    @FindBy(id = "ctrc7")
    @CacheLookup
    private WebElement accountNameTextField;

    @FindBy(id = "ctrc7_lkwgt")
    @CacheLookup
    private WebElement accountNameLoopIconBtn;

    @FindBy(id = "ctrc16")
    @CacheLookup
    private WebElement customerSignedByTextField;

    @FindBy(id = "ctrc16_lkwgt")
    @CacheLookup
    private WebElement customerSignedByLoopBtn;

    @FindBy(id = "CustomerSignedTitle")
    @CacheLookup
    private WebElement customerSignedTitle;

    @FindBy(id = "ctrc6")
    @CacheLookup
    private WebElement customerSignedDateTextField;

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

    private ContractBuilder contractBuilder;

    private Map<String, String> valuesMap;

    /**
     * Contractor by default.
     */
    public ContractForm() {
        super();
    }

    /**
     * Constructor that initialize the builder and hash map.
     *
     * @param contractBuilder {@link ContractBuilder}
     */
    public ContractForm(final ContractBuilder contractBuilder) {
        valuesMap = new HashMap<>();
        this.contractBuilder = contractBuilder;
    }

    /**
     * This method save a new contract on "ContractFields" form.
     *
     * @return {@link ContractDetail}
     */
    public ContractDetail saveContract() {
        valuesMap = contractBuilder.getStrategyMap();
        fillTheForm(valuesMap);
        return clickSaveButton();
    }

    /**
     * This method obtains values the Map set.
     *
     * @return A map with values set on "product" form.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * This method sets a customer signed by.
     *
     * @param customerSignedBy is the new name of a customer signed by.
     * @return a contract form.
     */
    public ContractForm setCustomerSignedBy(final String customerSignedBy) {
        customerSignedByTextField.clear();
        customerSignedByTextField.sendKeys(customerSignedBy);
        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return a contract form.
     */
    public ContractForm setAccountName(final String accountName) {
        accountNameTextField.clear();
        accountNameTextField.sendKeys(accountName);
        return this;
    }

    /**
     * This method sets a customer signed title.
     *
     * @param customerSignedTitle is a string name.
     * @return a contract form.
     */
    public ContractForm setCustomerSignedTitle(final String customerSignedTitle) {
        customerSignedByTextField.clear();
        customerSignedByTextField.sendKeys(customerSignedTitle);
        return this;
    }

    /**
     * This method  sets the customer signed date.
     *
     * @param customerSignedDate a string to set.
     * @return a contract form..
     */
    public ContractForm setCustomerSignedDate(final String customerSignedDate) {
        customerSignedDateTextField.clear();
        customerSignedDateTextField.sendKeys(customerSignedDate);
        return this;
    }

    /**
     * This method sets the customer signed date by default.
     *
     * @return a contract form.
     */
    public ContractForm setCustomerSignedDateWithCurrentDate() {
        customerSignedDateTextField.clear();
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
     * This method chooses the STATUS.
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
     * @return a contract form..
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
        contractTermMonthsTextBox.sendKeys(contractTermMonths);
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
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate is the map that contains all the values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new ContractHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the contract create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(ACCOUNT_NAME.toString(), () -> setAccountName(values.get(ACCOUNT_NAME.toString())));
        strategyMap.put(CUSTOMER_SIGNED_BY.toString(), () ->
                setCustomerSignedBy(values.get(CUSTOMER_SIGNED_BY.toString())));
        strategyMap.put(CUSTOMER_SIGNED_TITLE.toString(), () ->
                setCustomerSignedTitle(values.get(CUSTOMER_SIGNED_TITLE.toString())));
        strategyMap.put(CUSTOMER_SIGNED_DATE.toString(), () ->
                setCustomerSignedDate(values.get(CUSTOMER_SIGNED_DATE.toString())));
        strategyMap.put(PRICE_BOOK.toString(), () -> choosePriceBookType(values.get(PRICE_BOOK.toString())));
        strategyMap.put(STATUS.toString(), () -> chooseStatus(values.get(STATUS.toString())));
        strategyMap.put(CONTRACT_START_DATE.toString(), () ->
                setContractStartDate(values.get(CONTRACT_START_DATE.toString())));
        strategyMap.put(CONTRACT_TERM_MONTHS.toString(), () ->
                setContractTermMonths(values.get(CONTRACT_TERM_MONTHS.toString())));
        strategyMap.put(OWNER_EXPIRATION_NOTICE.toString(), () ->
                setAccountName(values.get(OWNER_EXPIRATION_NOTICE.toString())));
        strategyMap.put(COMPANY_SIGNED_BY.toString(), () ->
                setCompanySignedBy(values.get(COMPANY_SIGNED_BY.toString())));
        strategyMap.put(COMPANY_SIGNED_DATE.toString(), () ->
                setCompanySignedDate(values.get(COMPANY_SIGNED_DATE.toString())));

        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new ContractDetail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new ContractDetail();
    }

    /**
     * This class handle the builder pattern.
     */
    public static class ContractBuilder {

        private String accountName;

        private String customerSignedBy;

        private String customerSignedTitle;

        private String customerSignedDate;

        private String priceBook;

        private String status;

        private String contractStartDate;

        private String contractTermMonths;

        private String ownerExpirationNotice;

        private String companySignedBy;

        private String companySignedDate;

        private Map<String, String> strategyMap;

        /**
         * Constructor of the ContractBuilder class.
         *
         * @param accountName        Account name is a required field to create a contract.
         * @param status             Status is a required field to create a contract.
         * @param contractStartDate  ContractFields Start Date is a required field to create a contract.
         * @param contractTermMonths ContractFields Term in months is a required field to create a contract.
         */
        public ContractBuilder(
                final String accountName, final String status, final String contractStartDate,
                final String contractTermMonths) {
            strategyMap = new HashMap<>();
            this.accountName = accountName;
            this.status = status;
            this.contractStartDate = contractStartDate;
            this.contractTermMonths = contractTermMonths;
            strategyMap.put(ACCOUNT_NAME.toString(), accountName);
            strategyMap.put(STATUS.toString(), status);
            strategyMap.put(CONTRACT_START_DATE.toString(), contractStartDate);
            strategyMap.put(CONTRACT_TERM_MONTHS.toString(), contractTermMonths);
            //this.OWNER_EXPIRATION_NOTICE = "--None--";
        }

        /**
         * Sets the account name field in the form.
         *
         * @param accountName Is the new account name.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setAccountName(final String accountName) {
            this.accountName = accountName;
            strategyMap.put(ACCOUNT_NAME.toString(), accountName);
            return this;
        }

        /**
         * Returns the value of the customer signed by field.
         *
         * @return the customer signed by value of the form.
         */
        public String getCustomerSignedBy() {
            return customerSignedBy;
        }

        /**
         * Sets the customer signed by field in the form.
         *
         * @param customerSignedBy Is the new customer signed by value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedBy(final String customerSignedBy) {
            this.customerSignedBy = customerSignedBy;
            strategyMap.put(CUSTOMER_SIGNED_BY.toString(), customerSignedBy);
            return this;
        }

        /**
         * Returns the value of the customer signed title field.
         *
         * @return the customer signed title value of the form.
         */
        public String getCustomerSignedTitle() {
            return customerSignedTitle;
        }

        /**
         * Sets the customer signed title field in the form.
         *
         * @param customerSignedTitle Is the new customer signed title value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedTitle(final String customerSignedTitle) {
            this.customerSignedTitle = customerSignedTitle;
            strategyMap.put(CUSTOMER_SIGNED_TITLE.toString(), customerSignedTitle);
            return this;
        }

        /**
         * Returns the value of the customer signed date field.
         *
         * @return the customer signed date value of the form.
         */
        public String getCustomerSignedDate() {
            return customerSignedDate;
        }

        /**
         * Sets the customer signed date field in the form.
         *
         * @param customerSignedDate Is the new customer signed date value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedDate(final String customerSignedDate) {
            this.customerSignedDate = customerSignedDate;
            strategyMap.put(CUSTOMER_SIGNED_DATE.toString(), customerSignedDate);
            return this;
        }

        /**
         * Returns the value of the price book field.
         *
         * @return the price book value of the form.
         */
        public String getPriceBook() {
            return priceBook;
        }

        /**
         * Sets the price book field in the form.
         *
         * @param priceBook Is the new price book value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setPriceBook(final String priceBook) {
            this.priceBook = priceBook;
            strategyMap.put(PRICE_BOOK.toString(), priceBook);
            return this;
        }

        /**
         * Returns the value of the status field.
         *
         * @return the status value of the form.
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the status field in the form.
         *
         * @param status Is the new status value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setStatus(final String status) {
            this.status = status;
            strategyMap.put(STATUS.toString(), status);
            return this;
        }

        /**
         * Returns the value of the contract start date field.
         *
         * @return the contract start date value of the form.
         */
        public String getContractStartDate() {
            return contractStartDate;
        }

        /**
         * Sets the contract start date field in the form.
         *
         * @param contractStartDate Is the new contract start date value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractStartDate(final String contractStartDate) {
            this.contractStartDate = contractStartDate;
            strategyMap.put(CONTRACT_START_DATE.toString(), contractStartDate);
            return this;
        }

        /**
         * Returns the value of the contract term months field.
         *
         * @return the contract term months value of the form.
         */
        public String getContractTermMonths() {
            return contractTermMonths;
        }

        /**
         * Sets the contract term months field in the form.
         *
         * @param contractTermMonths Is the new contract term months value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractTermMonths(final String contractTermMonths) {
            this.contractTermMonths = contractTermMonths;
            strategyMap.put(CONTRACT_TERM_MONTHS.toString(), contractTermMonths);
            return this;
        }

        /**
         * Returns the value of the owner expiration notice field.
         *
         * @return the owner expiration notice value of the form.
         */
        public String getOwnerExpirationNotice() {
            return ownerExpirationNotice;
        }

        /**
         * Sets the owner expiration notice field in the form.
         *
         * @param ownerExpirationNotice Is the new owner expiration notice value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setOwnerExpirationNotice(final String ownerExpirationNotice) {
            this.ownerExpirationNotice = ownerExpirationNotice;
            strategyMap.put(OWNER_EXPIRATION_NOTICE.toString(), ownerExpirationNotice);
            return this;
        }

        /**
         * Returns the value of the company signed by field.
         *
         * @return the company signed by value of the form.
         */
        public String getCompanySignedBy() {
            return companySignedBy;
        }

        /**
         * Sets the company signed by field in the form.
         *
         * @param companySignedBy Is the new contract term months value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedBy(final String companySignedBy) {
            this.companySignedBy = companySignedBy;
            strategyMap.put(COMPANY_SIGNED_BY.toString(), companySignedBy);
            return this;
        }

        /**
         * Returns the value of the company signed date field.
         *
         * @return the company signed date value of the form.
         */
        public String getCompanySignedDate() {
            return companySignedDate;
        }

        /**
         * This method set the company signed date.
         *
         * @param companySignedDate String with the new company signed date.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedDate(final String companySignedDate) {
            this.companySignedDate = companySignedDate;
            strategyMap.put(COMPANY_SIGNED_DATE.toString(), companySignedDate);
            return this;
        }

        /**
         * This method set the strategyMap contract.
         *
         * @return A map with values set on "contract" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        /**
         * Builds the builder pattern design.
         * @return {@link ContractForm}
         */
        public ContractForm build() {
            return new ContractForm(this);
        }

    }
}
