package Pages.Leads;

import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class LeadDetailsPage {

    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

    @FindBy(id = "ep")
    @CacheLookup
    WebElement leadDescription;

    //endregion

    public LeadDetailsPage(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public String getLeadDescription() {
        return leadDescription.getText();
    }

}
