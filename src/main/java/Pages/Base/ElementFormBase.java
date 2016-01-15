package Pages.Base;

import Framework.CommonActions;
import Framework.FormBase;
import Pages.Leads.NewLeadPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Pablo Zubieta on 03/09/2015.
 */

public abstract class ElementFormBase extends FormBase{


    @FindBy(name = "new")
    protected WebElement newElementBtn;

    public ElementFormBase() {
      super();
    }

    public abstract Object clickNewBtn();

}