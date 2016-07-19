package Scripts;


import Pages.Contacts.ContactsAbstractPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.NewContactForm;
import Pages.LookUp.LookUpWindow;

/**
 * Created by Ruber Cuellar
 */
public class CreateContact {


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

    @BeforeTest
    public void login() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();
    }

    @Test
    public void createChatterPostTest(){
        newContactForm = contactsHome.clickPostLnk();
        newContactForm.selectFirstNameCategory(firstNameCategory)
                .setContactNameField(contactName)
                .setLastName(lastName)
                .setTitle(title)
                .setDepartment(title);

        contactsProfile = newContactForm.clickSaveButton();

        String contactNameLabel = contactsProfile.getContactNameLabel();
        Assert.assertEquals(contactNameLabel, firstNameCategory + " " + contactName + " " + lastName);
        contactsProfile.getContactNameLabel();

    }

    @AfterMethod
    public void afterTest() {
        contactsProfile.deleteContact();

    }

}