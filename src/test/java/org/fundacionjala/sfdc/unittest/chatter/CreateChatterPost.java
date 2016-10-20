package org.fundacionjala.sfdc.unittest.chatter;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

/**
 * Created by Franklin Plaza
 */
public class CreateChatterPost {
	
    
    private ChatterAbstractPage chatterHome;
    private TabBar tabBar;
    private PostForm postForm;
    private PostContainer postContainer;
    private String postContain = "TestCreatePost";
	private MainApp mainApp;
    

	@Test
	public void createChatterPostTest(){
		mainApp = new MainApp();
		tabBar = mainApp.goToTabBar();
		chatterHome = tabBar.clickOnChatterTab();
		postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
		postContainer = postForm.clickShareBtn();
		Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteChatterPost() {
		postContainer.deletePost(postContain);
		
	}	
	
}