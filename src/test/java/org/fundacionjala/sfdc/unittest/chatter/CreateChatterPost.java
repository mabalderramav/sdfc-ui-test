package org.fundacionjala.sfdc.unittest.chatter;


import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Franklin Plaza
 */
public class CreateChatterPost {

    private static final String POST_CONTAIN = "TestCreatePost";
    private ChatterAbstractPage chatterHome;
    private PostContainer postContainer;

    @BeforeMethod
    public void setUp() {
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
    }

    @Test
    public void createChatterPostTest() {
        PostForm postForm = chatterHome.clickPostLnk().setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
        Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");
    }

    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(POST_CONTAIN);
    }

}