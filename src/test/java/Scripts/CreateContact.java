package Scripts;


import Framework.BrowserManager;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.ContactsHome;
import Pages.Contacts.NewContactForm;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.NewContactForm;
import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import Pages.LookUp.LookUpWindow;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gisela on 6/28/2015.
 */
public class CreateContact {
    TabBar tapBar;
    ContactsHome contactsHome;
    NewContactForm newContactForm;
    LookUpWindow lookUpWindow;
    ContactsProfile contactsProfile;
    MainApp mainApp;
    
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

        contactsProfile = newContactForm
                .clickSaveButton();

        String contactName = contactsProfile.getContactNameLabel();
        Assert.assertEquals(contactName, "Prof. Test100 TestLastName100");
        contactsProfile.getContactNameLabel();
    }

    @BeforeTest
    public void BeforeTest()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        mainApp = new LoginPage()
                .setUserNameField("giselitamt6@gmail.com")
                .setPasswordField("Control123")
                .clickLogInToSalesforceButton();
    }

    @AfterTest
    public void afterTest()
    {
        contactsProfile.deleteContact();
    }
}
