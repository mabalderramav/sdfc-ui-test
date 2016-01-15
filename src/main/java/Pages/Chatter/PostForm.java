package Pages.Chatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;
import Framework.CommonActions;



public class PostForm {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id = "publishereditablearea")
	@CacheLookup
	private WebElement createTxtArea;	
	
	@FindBy(id = "publishersharebutton")
    @CacheLookup
    private WebElement shareBtn;
	
	
	@FindBy(name = "quickActionSubmitButton")
    @CacheLookup
    private WebElement saveBtn;
	
	@FindBy(id = "quickActionFeedBodyInput")
	@CacheLookup
    private WebElement editTxtArea;
	
	private String postText;
	
	public PostForm() {
		driver = BrowserManager.getInstance().getDriver();
		wait = BrowserManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public PostForm setPostTxt(String postText) {
		this.postText = postText;
		CommonActions.setValue(createTxtArea, postText);		
		return this;
	}
	
	public PostForm setCommentTxt(String commentText, String postText) {
		this.postText = commentText;
		WebElement commentTxt = driver.findElement(By.xpath("//span[contains(.,'"+postText+"')]/following::textarea[contains(@class,'foobar cxnewcommenttext groupAtMentionsEnabled')]"));
		CommonActions.setValue(commentTxt, commentText);		
		return this;
	}
	
	public PostForm editPostTxt(String postTxt) {	
		this.postText = postTxt;
		CommonActions.setValue(editTxtArea, postTxt);
		return this;
		
	}
	public PostContainer clickShareBtn() {
		CommonActions.click(shareBtn);		
		return new PostContainer().setPostTxt(postText);
	}
	
	public PostContainer clickSaveBtn() {
		CommonActions.click(saveBtn);
		return new PostContainer().setPostTxt(postText);
	}
	
	public PostContainer clickCommentBtn() {
		WebElement commentBtn = driver.findElement(By.xpath("//span[contains(.,'"+this.postText+"')]/following::input[@value = 'Comment']"));
		CommonActions.click(commentBtn);
		return new PostContainer().setPostTxt(this.postText);
	}

}
