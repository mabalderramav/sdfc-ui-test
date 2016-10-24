package org.fundacionjala.sfdc.pages.chatter;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class PostContainer extends AbstractBasePage {


    @FindBy(linkText = "Delete")
    @CacheLookup
    protected WebElement deleteOptn;

    @FindBy(linkText = "Edit")
    @CacheLookup
    private WebElement editOptn;
    private WebElement actionMenu;
    private String postText;

    public void deletePost(String postTxt) {
        clickActionMenu(postTxt);
        CommonActions.clickElement(deleteOptn);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public PostForm editPost(String postTxt) {
        clickActionMenu(postTxt);
        CommonActions.clickElement(editOptn);
        return new PostForm();

    }

    public void clickActionMenu(String postTxt) {
        actionMenu = driver.findElement(By.xpath("//span[contains(.,'" + postTxt + "')]/ancestor::div[@class='feeditembody']/following::a[@class='zen-trigger feeditemActionMenuButton']"));
        CommonActions.clickElement(actionMenu);
    }

    public boolean isPostDisplayed() {
        WebElement postContainer;
        try {
            postContainer = driver.findElement(By.xpath("//span[contains(.,'" + this.getPostxt() + "')]"));
        } catch (WebDriverException e) {
            return false;
        }

        return isElementPresent(postContainer);

    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public String getPostxt() {
        return this.postText;

    }

    public PostContainer setPostTxt(String postTxt) {
        this.postText = postTxt;
        return this;
    }

    public PostForm clickCommentLkn(String postTxt) {
        WebElement postContainer = driver.findElement(By.xpath("//span[contains(.,'" + postTxt + "')]/following::a[text()='Comment']"));
        CommonActions.clickElement(postContainer);
        return new PostForm();

    }

}
