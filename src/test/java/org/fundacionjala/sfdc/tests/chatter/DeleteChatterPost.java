package org.fundacionjala.sfdc.tests.chatter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

/**
 * Class to verify the deletion of chatter post.
 */
public class DeleteChatterPost {
    private static final String POST_CONTAIN = "TestDeletePost";
    private ChatterAbstractPage chatterHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private PostContainer postContainer;

    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
        PostForm postForm = chatterHome.clickPostLnk().setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
    }

    /**
     * Method that verify if a chatter is deleted.
     */
    @Test
    public void deleteChatterPostTest() {
        postContainer.deletePost(POST_CONTAIN);
        tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
        Assert.assertFalse(postContainer.isPostDisplayed(), "Chatter Post Deleted");
    }

}
