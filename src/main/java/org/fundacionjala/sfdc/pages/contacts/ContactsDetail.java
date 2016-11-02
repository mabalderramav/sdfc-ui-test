package org.fundacionjala.sfdc.pages.contacts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.pages.contacts.ContactFields.BIRTH_DATE;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.CONTACT_NAME;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.DEPARTMENT;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.FIRST_NAME_CATEGORY;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.LAST_NAME;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.LEAD_SOURCE;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.MAIL;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.MAILING_STREET;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.OTHER_STREET;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.TITLE;

/**
 * This method represent to contact detail.
 */
public class ContactsDetail extends DetailBase {

    public static final int NAME_LABEL_LENGTH = 3;
    @FindBy(id = "con2_ileinner")
    @CacheLookup
    private WebElement nameLabel;

    @FindBy(id = "con5_ileinner")
    @CacheLookup
    private WebElement titleLabel;

    @FindBy(id = "con6_ileinner")
    @CacheLookup
    private WebElement departmentLabel;

    @FindBy(id = "con7_ileinner")
    @CacheLookup
    private WebElement birthDateLabel;

    @FindBy(id = "con9_ileinner")
    @CacheLookup
    private WebElement leadSorceLabel;

    @FindBy(id = "con15_ileinner")
    @CacheLookup
    private WebElement mailLabel;

    @FindBy(id = "con19_ileinner")
    @CacheLookup
    private WebElement mailingStreet;

    @FindBy(id = "con18_ileinner")
    @CacheLookup
    private WebElement otherStreet;

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getNameLabel() {
        return getTopName().length == NAME_LABEL_LENGTH ? getTopName()[1] : getTopName()[0];
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getFirstNameCategoryLabel() {
        return getTopName()[0];
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getLastNameLabel() {
        return getTopName().length == NAME_LABEL_LENGTH ? getTopName()[2] : getTopName()[1];
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String[] getTopName() {
        return nameLabel.getText().split(" ");
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getDepartmentLabel() {
        return departmentLabel.getText();
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getTitleLabel() {
        return titleLabel.getText();
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getBirthDateLabel() {
        return birthDateLabel.getText();
    }

    /**
     * This method gets lead source label.
     *
     * @return a name label.
     */
    public String getLeadSourceLabel() {
        return leadSorceLabel.getText();
    }

    /**
     * This method gets other street label.
     *
     * @return a other street label.
     */
    private String getOtherStreetLabel() {
        return otherStreet.getText();
    }

    /**
     * This method gets mailing street label.
     *
     * @return a mailing street label.
     */
    private String getMailingStreetLabel() {
        return mailingStreet.getText();
    }

    /**
     * This method gets mail label.
     *
     * @return a mail street label.
     */
    private String getMailLabel() {
        return mailLabel.getText();
    }

    /**
     * This method gets name label.
     *
     * @param contact String with the contact name.
     * @return a name label.
     */
    public boolean isContactDisplayed(final String contact) {
        WebElement contactContainer;
        try {
            contactContainer = driver.findElement(By.xpath("//span[contains(.,'" + contact + "')]"));
        } catch (WebDriverException e) {
            return false;
        }
        return isElementPresent(contactContainer);

    }

    /**
     * This method gets name label.
     *
     * @param webElement the element to find in the page.
     * @return a name label.
     */
    public boolean isElementPresent(final WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public ContactForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new ContactForm();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public MainApp clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
        return new MainApp();
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of contact edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(CONTACT_NAME.getValue(), this::getNameLabel);
        strategyMap.put(FIRST_NAME_CATEGORY.getValue(), this::getFirstNameCategoryLabel);
        strategyMap.put(LAST_NAME.getValue(), this::getLastNameLabel);
        strategyMap.put(TITLE.getValue(), this::getTitleLabel);
        strategyMap.put(DEPARTMENT.getValue(), this::getDepartmentLabel);
        strategyMap.put(BIRTH_DATE.getValue(), this::getBirthDateLabel);
        strategyMap.put(LEAD_SOURCE.getValue(), this::getLeadSourceLabel);
        strategyMap.put(MAIL.getValue(), this::getMailLabel);
        strategyMap.put(MAILING_STREET.getValue(), this::getMailingStreetLabel);
        strategyMap.put(OTHER_STREET.getValue(), this::getOtherStreetLabel);
        return strategyMap;
    }


}
