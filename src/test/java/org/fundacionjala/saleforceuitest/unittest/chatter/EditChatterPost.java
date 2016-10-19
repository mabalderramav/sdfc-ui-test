package org.fundacionjala.saleforceuitest.unittest.chatter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.saleforceuitest.pages.LoginPage;
import org.fundacionjala.saleforceuitest.pages.MainApp;
import org.fundacionjala.saleforceuitest.pages.TabBar;
import org.fundacionjala.saleforceuitest.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.saleforceuitest.pages.chatter.PostContainer;
import org.fundacionjala.saleforceuitest.pages.chatter.PostForm;

/**
* Created by Franklin Plaza
*/
public class EditChatterPost {
		
	private ChatterAbstractPage chatterHome;
	private MainApp mainApp;
	private TabBar tabBar;
	private PostForm postForm;
	private PostContainer postContainer;
	private LoginPage loginPage;
	private String postContain = "TestEditPost";
	private String newPostContain = "TestPost123";
    
	@BeforeMethod
	public void createPost() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
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
