package org.fundacionjala.saleforceuitest.unittest.contact;

import org.fundacionjala.saleforceuitest.pages.contacts.ContactsAbstractPage;
import org.fundacionjala.saleforceuitest.pages.contacts.ContactsProfile;
import org.fundacionjala.saleforceuitest.pages.contacts.NewContactForm;
import org.fundacionjala.saleforceuitest.pages.LoginPage;
import org.fundacionjala.saleforceuitest.pages.MainApp;
import org.fundacionjala.saleforceuitest.pages.TabBar;
import org.fundacionjala.saleforceuitest.pages.lookup.LookUpWindow;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Ruber Cuellar
 */
public class EditContact {
    private ContactsAbstractPage contactsHome;
    private LookUpWindow lookUpWindow;
    private MainApp mainApp;
    private TabBar tabBar;
    private ContactsProfile contactsProfile;
    private NewContactForm newContactForm;
    private LoginPage loginPage;
    private String firstNameCategory = "Prof.";
    private String contactName = "Test122";
    private String lastName = "lastName22";
    private String title = "title22";
    private String department = "department22";

    private String firstNameCategoryEdit = "Mr.";
    private String contactNameEdit = "NewEdit";
    private String lastNameEdit = "lastEdit";
    private String titleEdit = "TitleEdit";
    private String departmentEdit = "DepEdit";


    @BeforeTest
    public void login() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();
        newContactForm = contactsHome.clickPostLnk();
        newContactForm.selectFirstNameCategory(firstNameCategory)
                .setContactNameField(contactName)
                .setLastName(lastName)
                .setTitle(title)
                .setDepartment(title);

        contactsProfile = newContactForm.clickSaveButton();
    }
    @Test
    public void EditContact()
    {
        newContactForm = contactsProfile.clickEditContact();
        newContactForm.selectFirstNameCategory(firstNameCategoryEdit)
                .setContactNameField(contactNameEdit)
                .setLastName(lastNameEdit)
                .setTitle(titleEdit)
                .setDepartment(departmentEdit);

        contactsProfile = newContactForm.clickSaveButton();
        String contactNameEditLabel = contactsProfile.getContactNameLabel();
        Assert.assertEquals(contactNameEditLabel,  firstNameCategoryEdit + " " + contactNameEdit + " " + lastNameEdit);


    }


    @AfterTest
    public void afterTest()
    {
        contactsProfile.deleteContact();
    }
}
