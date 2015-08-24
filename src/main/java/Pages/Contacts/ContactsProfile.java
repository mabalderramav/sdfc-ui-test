package Pages.Contacts;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Gisela on 6/28/2015.
 */
public class ContactsProfile {
    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

    @FindBy(className = "topName")
    @CacheLookup
    WebElement ContactNameLabel;

    ////input[contains(@value,'Delete')]
    //@FindBy(xpath = "//a[contains(.,'Delete')]")
    @FindBy(xpath = "//input[@name='del']")
    @CacheLookup
    private WebElement deleteButton;
    //endregion


    @FindBy(xpath = "//input[@name='edit']")
    @CacheLookup
    private WebElement editButton;


    public ContactsProfile(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public String getContactNameLabel() {
        return ContactNameLabel.getText();
    }

    public void deleteContact() {
        deleteButton.click();
        Alert javascriptAlert = Driver.switchTo().alert();
        javascriptAlert.accept();
    }

    public NewContactForm clickEditContact() {
//        editButton.click();
//        Alert javascriptAlert = Driver.switchTo().alert();
//        javascriptAlert.accept();
        CommonActions.click(editButton);
        return new NewContactForm(Driver);
    }
}
