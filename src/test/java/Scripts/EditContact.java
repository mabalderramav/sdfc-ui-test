package Scripts;

import Framework.BrowserManager;
import Pages.Contacts.ContactsHome;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.NewContactForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.TopBar.TabBar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gisela on 6/29/2015.
 */
public class EditContact {
    TabBar tapBar;
    ContactsHome contactsHome;
    NewContactForm newContactForm;
    LookUpWindow lookUpWindow;
    ContactsProfile contactsProfile;
    ContactsProfile contactsProfileEdit;
    NewContactForm newContactFormEdit;

    @Test
    public void CreateContact()
    {
        contactsHome = tapBar.clickContacts();

        newContactForm = contactsHome
                .clickNewButton();

        //lookUpWindow =
        newContactForm.selectFirstNameCategory("Prof.")
                .setContactNameField("Test100")
                .setLastName("TestLastName100")
                .setTitle("TestTitle100")
                .setDepartment("TestDepartment100");
        //.setBirthDate("6/2/2014");
        // .clickReportTo();
        //.setAccountName("TestAccount100")
        //.selectLeadSource("Test100");
//
//        newContactForm = lookUpWindow
//                .switchSearchFrame()
//                .selectSearchWithinDropdown("My Campaigns")
//                .setSearchWithinField("Test01")
//                .clickGoButton()
//                .switchResultsFrame()
//                .clickResult("Test01");

        contactsProfile = newContactForm.clickSaveButton();
        //String contactName = contactsProfile.getContactNameLabel();

        newContactFormEdit = contactsProfile.clickEditContact();
        newContactFormEdit.selectFirstNameCategory("Prof.")
                .setContactNameField("Test200")
                .setLastName("TestLastName200")
                .setTitle("TestTitle200")
                .setDepartment("TestDepartment200");

        contactsProfileEdit = newContactFormEdit.clickSaveButton();
        String contactNameEdit = contactsProfileEdit.getContactNameLabel();
        Assert.assertEquals(contactNameEdit, "Prof. Test200 TestLastName100TestLastName200");


    }

    @BeforeTest
    public void BeforeTest()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("giselitamt6@gmail.com")
                .setPasswordField("Control123")
                .clickLogInToSalesforceButton();
    }

    @AfterTest
    public void afterTest()
    {
        //contactsProfile.deleteContact();
    }
}
