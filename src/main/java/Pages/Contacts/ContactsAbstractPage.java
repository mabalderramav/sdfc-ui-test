package Pages.Contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractBasePage;

/**
 * Created by Gisela on 6/28/2015.
 */
public class ContactsAbstractPage extends AbstractBasePage {

    //region Locators


    @FindBy(xpath = "//input[@name='new']")
    @CacheLookup
    WebElement newButton;
    //endregion


    public NewContactForm clickPostLnk() {
        CommonActions.click(newButton);
        return new NewContactForm();
    }



}
