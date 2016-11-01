package org.fundacionjala.sfdc.pages.accounts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;



import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_SITE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.PHONE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.WEBSITE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.EMPLOYEES;

/**
 * It is the account base page, abstract class.
 */
public class AccountForm extends FormBase {

    //account form fields
    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement nameTextField;
    @FindBy(id = "acc23")
    @CacheLookup
    private WebElement siteTextField;
    @FindBy(id = "acc10")
    @CacheLookup
    private WebElement phoneTextField;
    @FindBy(id = "acc12")
    @CacheLookup
    private WebElement websiteTextField;
    @FindBy(id = "acc15")
    @CacheLookup
    private WebElement employeesTextField;

    private AccountBuilder accountBuilder;

    private Map<String, String> valuesMap;

    /**
     * Constructor that call the parent constructor.
     */
    AccountForm() {
        super();
    }

    /**
     * Private constructor.
     *
     * @param accountBuilder AccountBuilder class.
     */
    private AccountForm(final AccountBuilder accountBuilder) {
        valuesMap = new HashMap<>();
        this.accountBuilder = accountBuilder;
    }

    /**
     * This method save a new account on "AccountFields" form.
     *
     * @return {@link AccountDetail}
     */
    public AccountDetail saveAccount() {
        valuesMap = accountBuilder.getStrategyMap();
        fillTheForm(valuesMap);
        return clickSaveButton();
    }

    /**
     * This method obtains values the Map set.
     *
     * @return A map with values set on "account" form.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new AccountDetail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new AccountDetail();
    }


    /**
     * This method set the account name in the text field.
     *
     * @param accountName String with the account name.
     * @return Return this class.
     */
    public AccountForm setNameTextField(final String accountName) {
        CommonActions.sendKeys(nameTextField, accountName);
        return this;
    }

    /**
     * This method set the account site in the text field.
     *
     * @param accountSite String with the site account name.
     * @return Return this class.
     */
    private AccountForm setSiteTextField(final String accountSite) {
        CommonActions.sendKeys(siteTextField, accountSite);
        return this;
    }

    /**
     * This method set the account phone in the text field.
     *
     * @param accountPhone String with the site account name.
     * @return Return this class.
     */
    private AccountForm setPhoneTextField(final String accountPhone) {
        CommonActions.sendKeys(phoneTextField, accountPhone);
        return this;
    }

    /**
     * This method set the account website in the text field.
     *
     * @param accountWebsite String with the site account name.
     * @return Return this class.
     */
    private AccountForm setWebsiteTextField(final String accountWebsite) {
        CommonActions.sendKeys(websiteTextField, accountWebsite);
        return this;
    }

    /**
     * This method set the account employees in the text field.
     *
     * @param accountEmployees String with the site account name.
     * @return Return this class.
     */
    private AccountForm setEmployeesTextField(final String accountEmployees) {
        CommonActions.sendKeys(employeesTextField, accountEmployees);
        return this;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map with the json values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new AccountHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the account created.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(ACCOUNT_NAME.toString(), () -> setNameTextField(values.get(ACCOUNT_NAME.toString())));
        strategyMap.put(ACCOUNT_SITE.toString(), () -> setSiteTextField(values.get(ACCOUNT_SITE.toString())));
        strategyMap.put(PHONE.toString(), () -> setPhoneTextField(values.get(PHONE.toString())));
        strategyMap.put(WEBSITE.toString(), () -> setWebsiteTextField(values.get(WEBSITE.toString())));
        strategyMap.put(EMPLOYEES.toString(),
                    () -> setEmployeesTextField(values.get(EMPLOYEES.toString())));

        return strategyMap;
    }

    /**
     * This class handle the account builder pattern.
     */
    public static class AccountBuilder {

        private String accountName;

        private String accountSite;

        private String phone;

        private String website;

        private String employees;

        private Map<String, String> strategyMap;

        /**
         * This method build the Account form.
         * @return {@link AccountForm}.
         */
        public AccountForm build() {
            return new AccountForm(this);
        }

        /**
         * Constructor the AccountBuilder class.
         *
         * @param accountName Name required by the class.
         */
        public AccountBuilder(final String accountName) {
            strategyMap = new HashMap<>();
            strategyMap.put(ACCOUNT_NAME.toString(), accountName);
            this.accountName = accountName;
        }

        /**
         * This method set the product's site.
         *
         * @param accountSite String with site.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setSite(final String accountSite) {
            strategyMap.put(ACCOUNT_SITE.toString(), accountSite);
            this.accountSite = accountSite;
            return this;
        }

        /**
         * This method set the account's phone.
         *
         * @param phone String with phone.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setPhone(final String phone) {
            strategyMap.put(PHONE.toString(), phone);
            this.phone = phone;
            return this;
        }

        /**
         * This method set the account's website.
         *
         * @param website String with website.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setWebsite(final String website) {
            strategyMap.put(WEBSITE.toString(), website);
            this.website = website;
            return this;
        }

        /**
         * This method set the account's employees.
         *
         * @param employees String with employees.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setEmployees(final String employees) {
            strategyMap.put(EMPLOYEES.toString(), employees);
            this.employees = employees;
            return this;
        }

        /**
         * This method set the strategyMap account.
         *
         * @return A map with values set on "account" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }
}
