package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class is a test to create a opportunity
 */
public class CreateContact {


    private ContactHome contactsHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private ContactsDetail contactsDetail;
    public static final String CONTACT_DATA_PATH = "src/test/resources/json/contact/CreateContactData.json";
    private Map<String, String> valuesMapJson;
    private ContactForm contactForm;
    private LoginPage loginPage;

    /**
     * This method is a preconditions to create a contact.
     */
    @BeforeTest
    public void login() {
        valuesMapJson = JsonMapper.getMapJson(CONTACT_DATA_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();
    }

    /**
     * This a test to create a contact.
     */
    @Test
    public void createContact() {
        contactForm = contactsHome.clickPostLnk();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();
        new AssertContact().assertDetailValues(contactsDetail, valuesMapJson);
    }

    /**
     * This is a post conditions of a contact.
     */
    @AfterMethod
    public void afterTest() {
        contactsDetail.deleteContact();

    }

}