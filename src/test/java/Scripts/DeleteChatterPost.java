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

public class DeleteChatterPost {
	
	private ChatterAbstractPage chatterHome;
	private MainApp mainApp;
	private TabBar tabBar;
	private PostForm postForm;
	private PostContainer postContainer;
	private String postContain = "TestDeletePost";

	@BeforeMethod
	public void createPost() {
		
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    chatterHome = tabBar.clickOnChatterTab();
	    postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
		postContainer = postForm.clickShareBtn();
	    
	}
		
	@Test
	public void deleteChatterPostTest(){
		postContainer.deletePost(postContain);
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    chatterHome = tabBar.clickOnChatterTab();
		Assert.assertFalse(postContainer.isPostDisplayed(), "Chatter Post Deleted");
	}
		
	@AfterMethod
	public void tearDown() {	
		//mainApp.clickUserButton().clickLogout();		
	}	

}
