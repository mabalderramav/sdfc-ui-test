package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

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
     * Method that to permit set values to create a new AccountHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the account created.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put("accountName", () -> setNameTextField(String.valueOf(values.get("accountName"))));
        strategyMap.put("accountSite", () -> setSiteTextField(String.valueOf(values.get("accountSite"))));
        strategyMap.put("accountPhone", () -> setPhoneTextField(String.valueOf(values.get("accountPhone"))));
        strategyMap.put("accountWebsite", () -> setWebsiteTextField(String.valueOf(values.get("accountWebsite"))));
        strategyMap.put("accountEmployees",
                () -> setEmployeesTextField(String.valueOf(values.get("accountEmployees"))));
        return strategyMap;
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
}
