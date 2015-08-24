package Pages.Chatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;


public class PostContainer {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(linkText = "Delete")
    @CacheLookup
    protected WebElement deleteOptn;
	
	@FindBy(linkText = "Edit")
    @CacheLookup
    protected WebElement editOptn;
	
	public PostContainer() {
		driver = BrowserManager.getInstance().getDriver();
		wait = BrowserManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
		
	}
	
	public void deletePost(String postTxt) {
		clickActionMenu(postTxt);
		wait.until(ExpectedConditions.elementToBeClickable(deleteOptn));
		deleteOptn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	    
	}
	
	public PostForm editPost(String postTxt) {
		clickActionMenu(postTxt);
		wait.until(ExpectedConditions.elementToBeClickable(editOptn));
		editOptn.click();
		return new PostForm();
	    
	}
	
	public void clickActionMenu(String postTxt) {
		WebElement actionMenu = driver.findElement(By.xpath("//span[contains(.,'"+postTxt+"')]/ancestor::div[@class='feeditembody']/following::a[@class='zen-trigger feeditemActionMenuButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(actionMenu));		
		actionMenu.click();
	}

}
