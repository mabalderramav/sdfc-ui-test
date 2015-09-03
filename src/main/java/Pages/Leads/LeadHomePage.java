package Pages.Leads;

import Framework.ElementFormBase;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Pablo Zubieta on 27/08/2015.
 * This class holds leads home page elements and inherits from FormBase the basic button "new"
 */

public class LeadHomePage extends ElementFormBase {

    public LeadHomePage() {
        super();
    }

    @Override
    public NewLeadPage clickNewBtn() {
        //wait.until(ExpectedConditions.visibilityOf(newElementBtn));
        newElementBtn.click();
        return new NewLeadPage();
    }
}