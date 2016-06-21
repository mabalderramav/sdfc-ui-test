package Pages.Contacts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractBasePage;
import Pages.MainApp;

/**
 * Created by Gisela on 6/28/2015.
 */
public class ContactsProfile extends AbstractBasePage {


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
