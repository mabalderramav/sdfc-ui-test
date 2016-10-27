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
 * Class to verify the comments chatter post.
 */
public class CommentChatterPost {

    private final String postContain = "TestCommentPost";
    private PostContainer postContainer;

    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ChatterAbstractPage chatterHome = tabBar.clickOnChatterTab();
        PostForm postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
        postContainer = postForm.clickShareBtn();
    }

    /**
     * Method that verify the comments in the post.
     */
    @Test
    public void commentChatterPostTest() {
        PostForm commentForm = postContainer.clickCommentLkn(postContain);
        final String commentContain = "TestComment";
        commentForm.setCommentTxt(commentContain, postContain);
        PostContainer comment = commentForm.clickCommentBtn();
        Assert.assertTrue(comment.isPostDisplayed(), "Chatter Comment Displayed");
    }

    /**
     * Method that delete the post.
     */
    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(postContain);
    }

}
