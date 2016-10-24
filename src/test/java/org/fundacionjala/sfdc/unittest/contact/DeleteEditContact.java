package org.fundacionjala.sfdc.unittest.contact;


import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.fundacionjala.sfdc.utils.Common;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.fundacionjala.sfdc.unittest.contact.CreateContact.CONTACT_DATA_PATH;


/**
 * This test is to delete and
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

    @BeforeMethod
    public void login() {
        valuesMapJson = Common.getMapJson(CONTACT_DATA_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();

        contactForm = contactsHome.clickPostLnk();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();
    }

    @Test
    public void EditContact() {
        contactForm = contactsDetail.clickEditContact();
        valuesMapEditJson = Common.getMapJson(CONTACT_DATA_EDIT_PATH);
        contactForm.fillTheForm(valuesMapEditJson);
        contactsDetail = contactForm.clickSaveButton();
        new AssertContact().assertDetailValues(contactsDetail, valuesMapEditJson);
    }

    @Test
    public void DeleteContact() {
        contactsDetail.deleteContact();
        Assert.assertFalse(contactsDetail.isContactDisplayed(valuesMapJson.get("lastName")
                .concat(COLON).concat(valuesMapJson.get("contactName"))));
    }

    @AfterMethod
    public void afterTest() {
        mainApp.clickUserButton().clickLogout();
    }

}