package org.fundacionjala.sfdc.unittest.chatter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

public class CommentChatterPost {
	
	private ChatterAbstractPage chatterHome;
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
