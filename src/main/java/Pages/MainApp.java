package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;
import Framework.CommonActions;

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
    	CommonActions.click(userBtn);
    	return this;
    }
    
    public void clickLogout () {
    	CommonActions.click(logoutBtn);
    }
    
   public TabBar goToTabBar() {
	   return new TabBar();
   }
   
   public void closeMainApp() {
   		driver.quit();      
   }
   
   

}
