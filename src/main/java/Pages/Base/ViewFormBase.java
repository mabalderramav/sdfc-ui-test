package Pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class ViewFormBase extends NewElementFormBase {
	
	private static final int TIMEOUT_NORMAL = 15;

    @FindBy(xpath = "//form[@id='editPage']")
    @CacheLookup
    public WebElement viewTitle;

    @FindBy(xpath = "//input[@data-uidsfdc='3']")
    @CacheLookup
    public WebElement saveButton;

    @FindBy(id = "fname")
    @CacheLookup
    public WebElement viewName;

    @FindBy(id = "devname")
    @CacheLookup
    public WebElement viewUniqueName;

    public ViewFormBase(WebDriver driver) {        
        try {
        	driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, TimeUnit.SECONDS);
            driver.manage().window().maximize();     
            
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS).until(
                    ExpectedConditions.visibilityOf(viewTitle));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    public ViewFormBase setViewName(String name) {
        viewName.clear();
        viewName.sendKeys(name);
        return this;
    }

    public ViewFormBase setUniqueViewName(String name) {
        viewUniqueName.clear();
        viewUniqueName.sendKeys(name);
        return this;
    }

    public ViewDetailsPage clickSaveView() {
        saveButton.click();
        return new ViewDetailsPage();
    }

	@Override
	protected Object clickSaveBtn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object clickSaveNewBtn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object clickCancelBtn() {
		// TODO Auto-generated method stub
		return null;
	}
}