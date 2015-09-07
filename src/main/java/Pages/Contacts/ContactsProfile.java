package Pages.Contacts;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.MainApp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Gisela on 6/28/2015.
 */
public class ContactsProfile {


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


    private WebDriver driver;
    private WebDriverWait wait;

    public ContactsProfile()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public String getContactNameLabel() {
        return ContactNameLabel.getText();
    }

    public MainApp deleteContact() {
        deleteButton.click();
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
        return new MainApp();
    }

    public NewContactForm clickEditContact() {
//        editButton.click();
//        Alert javascriptAlert = Driver.switchTo().alert();
//        javascriptAlert.accept();
        CommonActions.click(editButton);
        return new NewContactForm();
    }
    public boolean isContactDisplayed(String Contact) {
        WebElement contactContainer;
        try {
            contactContainer = driver.findElement(By.xpath("//span[contains(.,'" + Contact + "')]"));
        } catch(WebDriverException e) {
            return false;
        }
        return isElementPresent(contactContainer);

    }
    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

}
