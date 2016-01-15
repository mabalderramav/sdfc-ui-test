package Pages.Chatter;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Base.HomeBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Gisela on 6/29/2015.
 */
public class ChatterHome extends HomeBase{
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
    
    @FindBy(className = "publisherattachtext")
    @CacheLookup
    WebElement postLnk;

    public ChatterHome()
    {
        super();        
    }
    /*
    public ChatterHome setPubliSheredArea(String text) {
        CommonActions.setValue(publisheredArea, text);
        return this;
    }
    public ChatterHome clickPostButton() {
        CommonActions.click(shareButton);
        return this;
    }

    public ChatterHome clickCommentLink() {
        CommonActions.click(CommentLink);
        return this;
    }

    public ChatterHome setPCommentText(String text) {
        CommonActions.setValue(commentText, text);
        return this;
    }

    public ChatterHome clickCommentButton() {
        CommonActions.click(CommentButton);
        return this;
    }
    */
    
    public PostForm clickPostLnk() {
    	CommonActions.click(postLnk);
    	return new PostForm();
    }
}
