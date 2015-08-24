package Pages.Chatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;



public class PostForm {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindAll({
		@FindBy(id = "publishereditablearea"),
		@FindBy(id = "quickActionFeedBodyInput")
		})
    @CacheLookup
    WebElement postTxt;
	
	@FindBy(id = "publishersharebutton")
    @CacheLookup
    WebElement shareBtn;
	
	
	@FindBy(id = "quickActionSubmitButton")
    @CacheLookup
    WebElement saveBtn;
	
	@FindBy(id = "quickActionFeedBodyInput")
	@CacheLookup
    WebElement editTxtArea;
	
	public PostForm() {
		driver = BrowserManager.getInstance().getDriver();
		wait = BrowserManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public PostForm setPostTxt(String postText) {
		wait.until(ExpectedConditions.visibilityOf(postTxt));
		postTxt.clear();
		postTxt.sendKeys(postText);
		return this;
	}
	
	public PostForm editPostTxt(String postTxt) {
		wait.until(ExpectedConditions.visibilityOf(editTxtArea));
		editTxtArea.click();
		editTxtArea.clear();
		editTxtArea.sendKeys(postTxt);
		return this;
		
	}
	public PostContainer clickShareBtn() {
		wait.until(ExpectedConditions.visibilityOf(shareBtn));
		shareBtn.click();		
		return new PostContainer();
	}
	
	public void clickSaveBtn() {
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();		
	}

}
