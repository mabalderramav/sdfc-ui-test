package org.fundacionjala.sfdc.pages.contacts;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gisela on 6/28/2015.
 */
public class ContactForm extends AbstractBasePage {

    @FindBy(id = "name_salutationcon2")
    @CacheLookup
    WebElement firstNameCategoryField;

    //@FindBy(xpath = "//input[@id='name_firstcon2']")
    @FindBy(id = "name_firstcon2")
    @CacheLookup
    WebElement firstNameField;

    // @FindBy(xpath = "//input[@id='name_lastcon2']")
    @FindBy(id = "name_lastcon2")
    @CacheLookup
    WebElement lastNameField;

    //@FindBy(xpath = "//input[@id='con4']")
    @FindBy(id = "con4")
    @CacheLookup
    WebElement accountNameField;

    //@FindBy(xpath = "//input[@id='con5']")
    @FindBy(id = "con5")
    @CacheLookup
    WebElement titleField;

    //@FindBy(xpath = "//input[@id='con6']")
    @FindBy(id = "con6")
    @CacheLookup
    WebElement departmentField;

    //@FindBy(xpath = "//input[@data-uidsfdc='39']")
    @FindBy(id = "con7")
    @CacheLookup
    WebElement birthDateField;

    //@FindBy(xpath = "//input[@id='con8']")
    @FindBy(id = "con8")
    @CacheLookup
    WebElement reportToField;

    //@FindBy(xpath = "//select[@id='con9']")
    @FindBy(id = "con9")
    @CacheLookup
    WebElement leadSourceField;

    //@FindBy(xpath = "//input[@id='con10']")
    @FindBy(id = "con10")
    @CacheLookup
    WebElement phoneField;


    //Button
    @FindBy(xpath = "//input[@tabindex='31']")
    // @FindBy(id = "//*[@name='save']")
    @CacheLookup
    WebElement saveBtn;

    @FindBy(xpath = "//input[@tabindex='32']")
    @CacheLookup
    WebElement saveNewBtn;

    @FindBy(xpath = "//input[@tabindex='33']")
    @CacheLookup
    WebElement cancelBtn;

    public ContactForm selectFirstNameCategory(String item) {
        CommonActions.selectItem(firstNameCategoryField, item);
        return this;
    }

    public ContactForm setContactNameField(String text) {
        CommonActions.sendKeys(firstNameField, text);
        return this;
    }

    public ContactForm setLastName(String text) {
        CommonActions.sendKeys(lastNameField, text);
        return this;
    }

    public ContactForm setAccountName(String text) {
        CommonActions.sendKeys(accountNameField, text);
        return this;
    }

    public ContactForm setTitle(String text) {
        CommonActions.sendKeys(titleField, text);
        return this;
    }

    public ContactForm setDepartment(String text) {
        CommonActions.sendKeys(departmentField, text);
        return this;
    }

    public ContactForm setBirthDate(String date) {
        CommonActions.sendKeys(birthDateField, date);
        return this;
    }

    public ContactForm selectLeadSource(String item) {
        CommonActions.selectItem(leadSourceField, item);
        return this;
    }

    public ContactsDetail clickSaveButton() {
        CommonActions.clickElement(saveBtn);
        return new ContactsDetail();
    }

    /**
     * Method that to permit set values to create a new OpportunityHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();

        strategyMap.put("firstNameCategory", () -> selectFirstNameCategory(String.valueOf(values.get("firstNameCategory"))));
        strategyMap.put("contactName", () -> setContactNameField(String.valueOf(values.get("contactName"))));
        strategyMap.put("lastName", () -> setLastName(String.valueOf(values.get("lastName"))));
        strategyMap.put("title", () -> setTitle(String.valueOf(values.get("title"))));
        strategyMap.put("department", () -> setDepartment(String.valueOf(values.get("department"))));

        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate
     */
    public void fillTheForm(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
