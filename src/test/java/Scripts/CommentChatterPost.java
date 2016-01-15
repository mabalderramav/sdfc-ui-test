package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import Pages.Chatter.ChatterHome;
import Pages.Chatter.PostContainer;
import Pages.Chatter.PostForm;

public class CommentChatterPost {
	
	private ChatterHome chatterHome;
	private MainApp mainApp;
	private TabBar tabBar;
	private PostForm postForm;
	private PostForm commentForm;
	private PostContainer comment;
	private PostContainer postContainer;
	private String postContain = "TestCommentPost";
	private String commentContain = "TestComment";

	
	@BeforeMethod
	public void createPost() {
		
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    chatterHome = tabBar.clickOnChatterTab();
	    postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
		postContainer = postForm.clickShareBtn();
	    
	}
		
	@Test
	public void commentChatterPostTest(){
		commentForm = postContainer.clickCommentLkn(postContain);
		commentForm.setCommentTxt(commentContain,postContain);
		comment = commentForm.clickCommentBtn();
		Assert.assertTrue(comment.isPostDisplayed(), "Chatter Comment Displayed");
	}
	
	@AfterMethod
	public void deleteChatterPost() {
		postContainer.deletePost(postContain);
		
	}	

}
