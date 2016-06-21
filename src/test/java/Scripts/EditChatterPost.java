package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Chatter.ChatterAbstractPage;
import Pages.Chatter.PostContainer;
import Pages.Chatter.PostForm;

/**
* Created by Franklin Plaza
*/
public class EditChatterPost {
		
	private ChatterAbstractPage chatterHome;
	private MainApp mainApp;
	private TabBar tabBar;
	private PostForm postForm;
	private PostContainer postContainer;
	private String postContain = "TestEditPost";
	private String newPostContain = "TestPost123";
    
	@BeforeMethod
	public void createPost() {
		
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    chatterHome = tabBar.clickOnChatterTab();
	    postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
		postContainer = postForm.clickShareBtn();
	    
	}
	
	@Test
	public void editChatterPostTest(){
		
		postForm = postContainer.editPost(postContain);
		postContainer = postForm.editPostTxt(newPostContain).clickSaveBtn();
		Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");	
		
		}
		
	@AfterMethod
	public void deleteChatterPost() {	
		postContainer.deletePost(newPostContain);
			
	}	
		
}
