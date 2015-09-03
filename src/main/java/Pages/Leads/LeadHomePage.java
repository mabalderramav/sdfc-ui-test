package Pages.Leads;

import Framework.BrowserManager;
import Framework.FormBase;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Pablo Zubieta on 27/08/2015.
 * This class holds leads home page elements and inherits from FormBase the basic button "new"
 */

public class LeadHomePage extends FormBase {

    public LeadHomePage()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public NewLeadPage clickNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newElementBtn));
        super.newElementBtn.click();
        return new NewLeadPage();
    }
}