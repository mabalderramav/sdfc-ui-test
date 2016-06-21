package Pages.Chatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractBasePage;

/**
 * Created by Gisela on 6/29/2015.
 */
public class ChatterAbstractPage extends AbstractBasePage {
    //private WebDriver Driver;
    //WebDriverWait wait;

    //region Locators


    @FindBy(xpath = "//textarea[@id='publishereditablearea']")
    @CacheLookup
    WebElement publisheredArea;


    @FindBy(id = "publishersharebutton")
    WebElement shareButton;
    //endregion

    @FindBy(xpath = "//a[@onclick='chatter.getFeed().showCommentBoxViaAnchor(this);']")
    @CacheLookup
    WebElement CommentLink;


    @FindBy(xpath = "//textarea[@data-uidsfdc='126']")
    @CacheLookup
    WebElement commentText;
   //driver.findElement(By.xpath("//input[@type='button']"));
    //driver.findElement(By.xpath("//input[contains(@id,'ext-gen8')]"));
    @FindBy(xpath = "//input[contains(@id,'ext-gen8')]")
    @CacheLookup
    WebElement CommentButton;
    
    @FindBy(id = "publishereditablearea")
    @CacheLookup
    WebElement textArea;

    /*
    public ChatterAbstractPage setPubliSheredArea(String text) {
        CommonActions.setValue(publisheredArea, text);
        return this;
    }
    public ChatterAbstractPage clickPostButton() {
        CommonActions.click(shareButton);
        return this;
    }

    public ChatterAbstractPage clickCommentLink() {
        CommonActions.click(CommentLink);
        return this;
    }

    public ChatterAbstractPage setPCommentText(String text) {
        CommonActions.setValue(commentText, text);
        return this;
    }

    public ChatterAbstractPage clickCommentButton() {
        CommonActions.click(CommentButton);
        return this;
    }
    */
    
    public PostForm clickPostLnk() {
    	CommonActions.click(textArea);
        //Actions action = new Actions(driver);
        //action.moveToElement(textArea).build();
    	return new PostForm();
    }
}
