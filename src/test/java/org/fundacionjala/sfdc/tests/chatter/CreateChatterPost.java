package org.fundacionjala.sfdc.tests.chatter;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

/**
 * Method that verify the creation of chatter.
 */
public class CreateChatterPost {

    private final String postContain = "TestCreatePost";
    private ChatterAbstractPage chatterHome;
    private PostContainer postContainer;

    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
    }

    /**
     * Method that verify the creation of chatter post.
     */
    @Test
    public void createChatterPostTest() {
        PostForm postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
        postContainer = postForm.clickShareBtn();
        Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");
    }

    /**
     * Method that delete the created post.
     */
    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(postContain);
    }

}
