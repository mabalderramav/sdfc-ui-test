package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractBasePage;

public class MainApp extends AbstractBasePage{

    @FindBy(id = "userNavButton")
    @CacheLookup
    private WebElement userBtn;
    
    
    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement logoutBtn;

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
