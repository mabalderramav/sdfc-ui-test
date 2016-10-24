package org.fundacionjala.sfdc.unittest.chatter;

import org.fundacionjala.sfdc.pages.LoginPage;
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
        mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        chatterHome = tabBar.clickOnChatterTab();
        postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
        postContainer = postForm.clickShareBtn();
    }

    @Test
    public void editChatterPostTest() {
        postForm = postContainer.editPost(postContain);
        postContainer = postForm.editPostTxt(newPostContain).clickSaveBtn();
        Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");
    }

    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(newPostContain);
    }

}
