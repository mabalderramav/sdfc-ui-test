package org.fundacionjala.sfdc.pages.contacts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.pages.contacts.ContactFields.CONTACT_NAME;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.DEPARTMENT;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.FIRST_NAME_CATEGORY;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.LAST_NAME;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.TITLE;

/**
 * This class represent Contact Form.
 */
public class ContactForm extends FormBase {

    @FindBy(id = "name_salutationcon2")
    @CacheLookup
    private WebElement firstNameCategoryField;

    @FindBy(id = "name_firstcon2")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(id = "name_lastcon2")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(id = "con4")
    @CacheLookup
    private WebElement accountNameField;

    @FindBy(id = "con5")
    @CacheLookup
    private WebElement titleField;

    @FindBy(id = "con6")
    @CacheLookup
    private WebElement departmentField;

    @FindBy(id = "con7")
    @CacheLookup
    private WebElement birthDateField;

    @FindBy(id = "con8")
    @CacheLookup
    private WebElement reportToField;

    @FindBy(id = "con9")
    @CacheLookup
    private WebElement leadSourceField;

    @FindBy(id = "con10")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(xpath = "//input[@tabindex='33']")
    @CacheLookup
    private WebElement cancelBtn;

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm selectFirstNameCategory(final String item) {
        CommonActions.selectItem(firstNameCategoryField, item);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return @return {@link ContactForm}.
     */
    public ContactForm setContactNameField(final String text) {
        CommonActions.sendKeys(firstNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setLastName(final String text) {
        CommonActions.sendKeys(lastNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setAccountName(final String text) {
        CommonActions.sendKeys(accountNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setTitle(final String text) {
        CommonActions.sendKeys(titleField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setDepartment(final String text) {
        CommonActions.sendKeys(departmentField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param date a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setBirthDate(final String date) {
        CommonActions.sendKeys(birthDateField, date);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm selectLeadSource(final String item) {
        CommonActions.selectItem(leadSourceField, item);
        return this;
    }

    /**
     * This method makes click in save new button.
     *
     * @return {@link ContactsDetail}.
     */
    @Override
    public ContactsDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new ContactsDetail();
    }

    /**
     * This method makes click in save button.
     *
     * @return {@link ContactsDetail}.
     */
    @Override
    public ContactsDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new ContactsDetail();
    }

    /**
     * Method that to permit set values to create a new Contact Home.
     *
     * @param values a map to set of the strategy.
     * @return a Map with the values of the opportunity create.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(FIRST_NAME_CATEGORY.getValue(),
                () -> selectFirstNameCategory(values.get(FIRST_NAME_CATEGORY.getValue())));
        strategyMap.put(CONTACT_NAME.getValue(), () -> setContactNameField(values.get(CONTACT_NAME.getValue())));
        strategyMap.put(LAST_NAME.getValue(), () -> setLastName(values.get(LAST_NAME.getValue())));
        strategyMap.put(TITLE.getValue(), () -> setTitle(values.get(TITLE.getValue())));
        strategyMap.put(DEPARTMENT.getValue(), () -> setDepartment(values.get(DEPARTMENT.getValue())));

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
