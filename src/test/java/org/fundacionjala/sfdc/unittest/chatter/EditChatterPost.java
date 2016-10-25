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
public class EditChatterPost {

    private final static String POST_CONTAIN = "TestEditPost";
    private final static String NEW_POST_CONTAIN = "TestPost123";
    private PostForm postForm;
    private PostContainer postContainer;

    @BeforeMethod
    public void setUp() {
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ChatterAbstractPage chatterHome = tabBar.clickOnChatterTab();
        postForm = chatterHome.clickPostLnk().setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
    }

    @Test
    public void editChatterPostTest() {
        postForm = postContainer.editPost(POST_CONTAIN);
        postContainer = postForm.editPostTxt(NEW_POST_CONTAIN).clickSaveBtn();
        Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");
    }

    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(NEW_POST_CONTAIN);
    }

}
