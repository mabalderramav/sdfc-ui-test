package org.fundacionjala.sfdc.pages.chatter;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class to represent the Chatter options.
 */
public class ChatterAbstractPage extends AbstractBasePage {

    @FindBy(xpath = "//textarea[@id='publishereditablearea']")
    @CacheLookup
    private WebElement publisheredArea;

    @FindBy(id = "publishersharebutton")
    private WebElement shareButton;

    @FindBy(xpath = "//a[@onclick='chatter.getFeed().showCommentBoxViaAnchor(this);']")
    @CacheLookup
    private WebElement commentLink;


    @FindBy(xpath = "//textarea[@data-uidsfdc='126']")
    @CacheLookup
    private WebElement commentText;

    @FindBy(xpath = "//input[contains(@id,'ext-gen8')]")
    @CacheLookup
    private WebElement commentButton;

    @FindBy(id = "publishereditablearea")
    @CacheLookup
    private WebElement textArea;

    /*
    public ChatterAbstractPage setPubliSheredArea(String text) {
        CommonActions.sendKeys(publisheredArea, text);
        return this;
    }
    public ChatterAbstractPage clickPostButton() {
        CommonActions.clickElement(shareButton);
        return this;
    }

    public ChatterAbstractPage clickCommentLink() {
        CommonActions.clickElement(commentLink);
        return this;
    }

    public ChatterAbstractPage setPCommentText(String text) {
        CommonActions.sendKeys(commentText, text);
        return this;
    }

    public ChatterAbstractPage clickCommentButton() {
        CommonActions.clickElement(commentButton);
        return this;
    }
    */

    /**
     * Method tha click on post link.
     *
     * @return {@link PostForm}
     */
    public PostForm clickPostLnk() {
        CommonActions.clickElement(textArea);
        //Actions action = new Actions(driver);
        //action.moveToElement(textArea).build();
        return new PostForm();
    }
}
