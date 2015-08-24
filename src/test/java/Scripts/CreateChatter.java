package Scripts;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework.BrowserManager;
import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import Pages.Chatter.ChatterHome;
import Pages.Chatter.PostContainer;
import Pages.Chatter.PostForm;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.NewContactForm;
import Pages.LookUp.LookUpWindow;

/**
 * Created by Franklin Plaza
 */
public class CreateChatter {
	
    
    private ChatterHome chatterHome;
    private NewContactForm newContactForm;
    private LookUpWindow lookUpWindow;
    private ContactsProfile contactsProfile;
    private MainApp mainApp;
    private TabBar tabBar;
    private PostForm postForm;
    private PostContainer postContainer;
    private String postContain = "TestPost";
    private LoginPage loginPage;
    @BeforeTest
	public void login() {
		
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        
        loginPage = new LoginPage()
        			.setUserNameField("fplaza07@softlayer.com")
        			.setPasswordField("Control123!@#");
        mainApp = loginPage.clickLogInToSalesforceButton();
                
       
        tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
       
       
	}
	
	@Test
	public void createChatterPostTest(){
		 postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
		 postContainer = postForm.clickShareBtn();
		 /*
		 Assert.assertTrue("Opportunity Name Displayed",opportunity1.isOppNameDisplayed());
		 Assert.assertTrue("Account Name Displayed",opportunity1.isOppAccountNameDisplayed());
		 Assert.assertTrue("Stage Displayed",opportunity1.isOppStageDisplayed());
		 Assert.assertTrue("Close date Displayed",opportunity1.isOppCloseDateDisplayed());
		 
		 */
		 
		 
	}
	
	@AfterTest
	public void tearDown() {
		postContainer.deletePost(postContain);
		
		
	}	
	
}