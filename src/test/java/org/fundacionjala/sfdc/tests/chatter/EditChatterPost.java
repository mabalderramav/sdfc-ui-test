package org.fundacionjala.sfdc.tests.chatter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.Navigator;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

/**
 * Class to Edit Chatter post.
 */
public class EditChatterPost {

    private final String postContain = "TestEditPost";
    private final String newPostContain = "TestPost123";
    private PostForm postForm;
    private PostContainer postContainer;

    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        ChatterAbstractPage chatterHome = Navigator.goToChatter();
        postForm = chatterHome.clickPostLnk().setPostTxt(postContain);
        postContainer = postForm.clickShareBtn();
    }

    /**
     * Test to verify the Edition of chatter post.
     */
    @Test
    public void editChatterPostTest() {
        postForm = postContainer.editPost(postContain);
        postForm.editPostTxt(newPostContain);
        postContainer = postForm.clickSaveBtn();
        Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");
    }

    /**
     * Method to delete the created post in the precondition.
     */
    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(newPostContain);
    }

}
