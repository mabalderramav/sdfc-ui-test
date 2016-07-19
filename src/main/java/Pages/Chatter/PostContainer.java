package Pages.Chatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractBasePage;


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
		CommonActions.click(deleteOptn);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	    
	}
	
	public PostForm editPost(String postTxt) {
		clickActionMenu(postTxt);
		CommonActions.click(editOptn);
		return new PostForm();
	    
	}
	
	public void clickActionMenu(String postTxt) {
		actionMenu = driver.findElement(By.xpath("//span[contains(.,'"+postTxt+"')]/ancestor::div[@class='feeditembody']/following::a[@class='zen-trigger feeditemActionMenuButton']"));	
		CommonActions.click(actionMenu);
	}
	
	public boolean isPostDisplayed() {
		WebElement postContainer;
		try {	
			postContainer = driver.findElement(By.xpath("//span[contains(.,'"+this.getPostxt()+"')]"));		
		} catch(WebDriverException e) {
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
		WebElement postContainer = driver.findElement(By.xpath("//span[contains(.,'"+postTxt+"')]/following::a[text()='Comment']"));
		CommonActions.click(postContainer);
		return new PostForm();
		
	}

}
