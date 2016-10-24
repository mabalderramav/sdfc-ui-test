package org.fundacionjala.sfdc.unittest.contact;


import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.fundacionjala.sfdc.utils.Common;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by Ruber Cuellar
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

    @BeforeTest
    public void login() {
        valuesMapJson = Common.getMapJson(CONTACT_DATA_PATH);
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();
    }

    @Test
    public void createContact() {
        contactForm = contactsHome.clickPostLnk();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();
        new AssertContact().assertDetailValues(contactsDetail, valuesMapJson);

    }

    @AfterMethod
    public void afterTest() {
        contactsDetail.deleteContact();

    }

}