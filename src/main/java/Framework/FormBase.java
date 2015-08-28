package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo Zubieta on 27/08/2015.
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, Opportunity, Products
 */
public abstract class FormBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "new")
    protected WebElement newElementBtn;

    @FindBy(name = "save_new")
    protected WebElement saveAndNewBtn;

    @FindBy(name = "cancel")
    protected WebElement cancelBtn;

}
