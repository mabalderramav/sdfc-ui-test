package org.fundacionjala.sfdc.tests.chatter;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteChatterPost {
    private static final String POST_CONTAIN = "TestDeletePost";
    private ChatterAbstractPage chatterHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private PostContainer postContainer;

    @BeforeMethod
    public void setUp() {
        mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
        PostForm postForm = chatterHome.clickPostLnk().setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
    }

    @Test
    public void deleteChatterPostTest() {
        postContainer.deletePost(POST_CONTAIN);
        tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
        Assert.assertFalse(postContainer.isPostDisplayed(), "Chatter Post Deleted");
    }

}
