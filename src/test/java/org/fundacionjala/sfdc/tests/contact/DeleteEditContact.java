package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.tests.contact.CreateContact.CONTACT_DATA_PATH;


/**
 * This method is a preconditions to edit and delete a contact.
 */
public class DeleteEditContact {

    public static final String COLON = ", ";
    private ContactHome contactsHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private ContactsDetail contactsDetail;
    private ContactForm contactForm;
    private LoginPage loginPage;

    public static final String CONTACT_DATA_EDIT_PATH = "src/test/resources/json/contact/CreateContactData.json";
    private Map<String, String> valuesMapJson;
    private Map<String, String> valuesMapEditJson;

    /**
     * This method is a preconditions to edit and delete a contact.
     */
    @BeforeMethod
    public void login() {
        valuesMapJson = JsonMapper.getMapJson(CONTACT_DATA_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();

        contactForm = contactsHome.clickPostLnk();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();
    }

    /**
     * This method is to edit a contact.
     */
    @Test
    public void EditContact() {
        contactForm = contactsDetail.clickEditContact();
        valuesMapEditJson = JsonMapper.getMapJson(CONTACT_DATA_EDIT_PATH);
        contactForm.fillTheForm(valuesMapEditJson);
        contactsDetail = contactForm.clickSaveButton();
        new AssertContact().assertDetailValues(contactsDetail, valuesMapEditJson);
    }

    /**
     * This method is to delete a contact.
     */
    @Test
    public void DeleteContact() {
        contactsDetail.deleteContact();
        Assert.assertFalse(contactsDetail.isContactDisplayed(valuesMapJson.get("lastName")
                .concat(COLON).concat(valuesMapJson.get("contactName"))));
    }

    /**
     * This is a post conditions of a opportunity.
     */
    @AfterMethod
    public void afterTest() {
        mainApp.clickUserButton().clickLogout();
    }

}