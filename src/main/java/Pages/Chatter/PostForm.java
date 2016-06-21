package Pages.Chatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractSectionFrame;


public class PostForm extends AbstractSectionFrame{

	
	@FindBy(id = "cke_26_contents")
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

	@FindBy(css = "iframe[class='cke_wysiwyg_frame cke_reset']")
	@CacheLookup
	private WebElement textAreaFrame;
	@FindBy(css = ".chatterPublisherRTE.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders > p")
	@CacheLookup
	private WebElement textAreaField;
	
	private String postText;

	public void PostForm(){
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(textAreaFrame));
		CommonActions.click(createTxtArea);
		Actions action = new Actions(driver);
		action.moveToElement(createTxtArea).build().perform();
		driver.switchTo().frame(textAreaFrame);
		System.out.println("To string: "+driver.toString());
	}
	
	public PostForm setPostTxt(String postText) {
		Actions action = new Actions(driver);
		action.moveToElement(textAreaField).click().build().perform();
		this.postText = postText;
		CommonActions.setValue(textAreaField, postText);
		returnRoot();
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
