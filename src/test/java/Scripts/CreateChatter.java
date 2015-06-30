package Scripts;

import Pages.Chatter.ChatterHome;
import Framework.BrowserManager;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.NewContactForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.TopBar.TabBar;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gisela on 6/29/2015.
 */
public class CreateChatter {
    TabBar tapBar;
    ChatterHome chatterHome;
    NewContactForm newContactForm;
    LookUpWindow lookUpWindow;
    ContactsProfile contactsProfile;

    @Test
    public void CreateChatter()
    {
        chatterHome = tapBar.clickChatter();

        chatterHome.setPubliSheredArea("TestComment1")
                .clickPostButton();
                //.clickCommentLink();
                //.setPCommentText("Added Comment2");

       //Assert.assertEquals("TestComment1", "TestComment1");

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
