package org.fundacionjala.sfdc.pages.chatter;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.lookup.SectionFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that represents the form where to introduce the text on chatter.
 */
public class PostForm extends SectionFrame {

    @FindBy(id = "cke_26_contents")
    @CacheLookup
    private WebElement createTxtArea;

    @FindBy(id = "publishersharebutton")
    @CacheLookup
    private WebElement shareBtn;

    @FindBy(name = "quickActionSubmitButton")
    @CacheLookup
    private WebElement saveBtn;

    @FindBy(css = "body.chatterPublisherRTE.cke_editable")
    @CacheLookup
    private WebElement editTxtArea;

    @FindBy(css = "iframe[class='cke_wysiwyg_frame cke_reset']")
    @CacheLookup
    private WebElement textAreaFrame;

    @FindBy(tagName = "body")
    @CacheLookup
    private WebElement textAreaField;

    private String postText;

    /**
     * Edits the text of the post publication.
     *
     * @param postText Is the text that is going to be
     *                 written in the post text field.
     * @return {@link PostForm}
     */
    public PostForm setPostTxt(final String postText) {
        this.postText = postText;
        Actions action = new Actions(driver);
        action.moveToElement(textAreaField).sendKeys(postText).build().perform();
        returnRoot();
        return this;
    }

    /**
     * Edits the text of a comment from a publication.
     *
     * @param commentText Is the text that is going to be
     *                    written in the comment text field.
     * @param postText    Is the post to fin to write the comment.
     * @return {@link PostForm}
     */
    public PostForm setCommentTxt(final String commentText, final String postText) {
        this.postText = commentText;
        WebElement commentTxt = driver.findElement(By.xpath("//span[contains(.,'"
                + postText + "')]/following::textarea[contains(@class,"
                + "'foobar cxnewcommenttext groupAtMentionsEnabled')]"));
        CommonActions.sendKeys(commentTxt, commentText);
        return this;
    }

    /**
     * Edits the text of the post already published.
     *
     * @param postTxt Is the text that is going to be
     *                written in the post text field.
     * @return {@link PostForm}
     */
    public PostForm editPostTxt(final String postTxt) {
        this.postText = postTxt;
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(textAreaFrame));
        CommonActions.sendKeys(editTxtArea, postTxt);
        returnDefault();
        return this;

    }

    /**
     * Makes click on the Share button.
     *
     * @return {@link PostContainer}
     */
    public PostContainer clickShareBtn() {
        CommonActions.clickElement(shareBtn);
        return new PostContainer().setPostTxt(postText);
    }

    /**
     * Makes click on the save button.
     *
     * @return {@link PostContainer}
     */
    public PostContainer clickSaveBtn() {
        CommonActions.clickElement(saveBtn);
        return new PostContainer().setPostTxt(postText);
    }

    /**
     * Makes click on the comment button.
     *
     * @return {@link PostContainer}
     */
    public PostContainer clickCommentBtn() {
        WebElement commentBtn = driver.findElement(
                By.xpath("//span[contains(.,'" + this.postText + "')]/following::input[@value = 'Comment']"));
        CommonActions.clickElement(commentBtn);
        return new PostContainer().setPostTxt(this.postText);
    }

}
