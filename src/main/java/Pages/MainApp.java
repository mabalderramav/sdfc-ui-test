package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;


public class MainApp {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "userNavButton")
    @CacheLookup
    private WebElement userBtn;
    
    
    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement logoutBtn;
    
    public MainApp() {
    	driver = BrowserManager.getInstance().getDriver();
    	wait = BrowserManager.getInstance().getWait();
    	PageFactory.initElements(driver, this);
    }
    
    
    public MainApp clickUserButton(){
    	userBtn.click();
    	return this;
    }
    
    public void clickLogout () {
    	wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
    	logoutBtn.click();
    }
    
   public TabBar goToTabBar() {
	   return new TabBar();
   }

}
