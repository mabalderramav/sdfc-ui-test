package org.fundacionjala.sfdc.tests.chatter;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommentChatterPost {

    private static final String POST_CONTAIN = "TestCommentPost";
    private PostContainer postContainer;

    @BeforeMethod
    public void setUp() {
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ChatterAbstractPage chatterHome = tabBar.clickOnChatterTab();
        PostForm postForm = chatterHome.clickPostLnk().setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
    }

    @Test
    public void commentChatterPostTest() {
        PostForm commentForm = postContainer.clickCommentLkn(POST_CONTAIN);
        final String commentContain = "TestComment";
        commentForm.setCommentTxt(commentContain, POST_CONTAIN);
        PostContainer comment = commentForm.clickCommentBtn();
        Assert.assertTrue(comment.isPostDisplayed(), "Chatter Comment Displayed");
    }

    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(POST_CONTAIN);
    }

}
