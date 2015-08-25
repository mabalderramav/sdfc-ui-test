package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
public class EditChatterPost {
		
	private ChatterHome chatterHome;
	private NewContactForm newContactForm;
	private LookUpWindow lookUpWindow;
	private ContactsProfile contactsProfile;
	private MainApp mainApp;
	private TabBar tabBar;
	private PostForm postForm;
	private PostContainer postContainer;
	private String postContain = "TestEditPost";
	private String newPostContain = "TestPost123";
	private LoginPage loginPage;
    
	@BeforeMethod
	public void login() {
		
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    chatterHome = tabBar.clickOnChatterTab();
	    postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
		postContainer = postForm.clickShareBtn();
	    
	}
	
	@Test
	public void createChatterPostTest(){
		
		postForm = postContainer.editPost(postContain);
		postContainer = postForm.editPostTxt(newPostContain).clickSaveBtn();
		Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");	
		
		}
		
	@AfterMethod
	public void deleteChatterPost() {	
		postContainer.deletePost(newPostContain);
			
	}	
		
}
