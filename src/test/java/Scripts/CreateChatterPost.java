package Scripts;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import Pages.Chatter.ChatterAbstractPage;
import Pages.Chatter.PostContainer;
import Pages.Chatter.PostForm;

/**
 * Created by Franklin Plaza
 */
public class CreateChatterPost {
	
    
    private ChatterAbstractPage chatterHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private PostForm postForm;
    private PostContainer postContainer;
    private String postContain = "TestCreatePost";
    private LoginPage loginPage;
    
    @BeforeTest
	public void login() {
    	
    	loginPage = new LoginPage();
    	mainApp = loginPage.loginAsPrimaryUser();  
        tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();    
	}
	
	@Test
	public void createChatterPostTest(){
		
		postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
		postContainer = postForm.clickShareBtn();
		Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteChatterPost() {
		postContainer.deletePost(postContain);
		
	}	
	
}