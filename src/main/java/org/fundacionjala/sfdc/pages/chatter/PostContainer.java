package org.fundacionjala.sfdc.pages.chatter;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Class to represent the post container.
 */
public class PostContainer extends AbstractBasePage {

    private static final int EXPECTATION_TIME_OUT = 15;
    private static final int SLEEP_IN_MILLISECONDS = 100;

    @FindBy(linkText = "Delete")
    @CacheLookup
    private WebElement deleteOptn;

    @FindBy(linkText = "Edit")
    @CacheLookup
    private WebElement editOptn;
    private String postText;

    /**
     * Deletes a determined post.
     *
     * @param postTxt Is the post text used to identify the
     *                publication to be deleted.
     * @return Class Post Form.
     */
    public PostForm deletePost(final String postTxt) {
        clickActionMenu(postTxt);
        CommonActions.clickElement(deleteOptn);
        WebDriverWait wait = new WebDriverWait(driver, EXPECTATION_TIME_OUT, SLEEP_IN_MILLISECONDS);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new PostForm();
    }

    /**
     * Edits a determined post.
     *
     * @param postTxt Is the post text used to identify the
     *                publication to be edited.
     * @return {@link PostForm}
     */
    public PostForm editPost(final String postTxt) {
        clickActionMenu(postTxt);
        CommonActions.clickElement(editOptn);
        return new PostForm();

    }

    /**
     * Makes click on the action menu of a determined post.
     *
     * @param postTxt Is the post text used to identify the
     *                publication to click its action menu.
     */
    public void clickActionMenu(final String postTxt) {
        WebElement actionMenu = driver.findElement(By.xpath("//span[contains(.,'" + postTxt + "')]/ancestor::div["
                + "@class='feeditembody']/following::a[@class='zen-trigger feeditemActionMenuButton']"));
        CommonActions.clickElement(actionMenu);
    }

    /**
     * Method that verify os an element is present.
     *
     * @return true if the element is present.
     */
    public boolean isPostDisplayed() {
        WebElement postContainer;
        try {
            postContainer = driver.findElement(By.xpath("//span[contains(.,'" + this.getPostxt() + "')]"));
        } catch (WebDriverException e) {
            return false;
        }
        return isElementPresent(postContainer);
    }

    /**
     * Method that verify if an element is present in the page.
     *
     * @param webElement the element to search.
     * @return true if the element is present.
     */
    public boolean isElementPresent(final WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * Method that get the Post.
     *
     * @return a String with the Post.
     */
    public String getPostxt() {
        return this.postText;
    }

    /**
     * Method that sets the Post.
     *
     * @param postTxt String with the post.
     * @return {@link PostContainer}
     */
    public PostContainer setPostTxt(final String postTxt) {
        this.postText = postTxt;
        return this;
    }

    /**
     * Method that makes click on comment link.
     *
     * @param postTxt String with the Post.
     * @return {@link PostForm}
     */
    public PostForm clickCommentLkn(final String postTxt) {
        WebElement postContainer = driver.findElement(By.xpath("//span[contains(.,'"
                + postTxt + "')]/following::a[text()='Comment']"));
        CommonActions.clickElement(postContainer);
        return new PostForm();

    }

}
