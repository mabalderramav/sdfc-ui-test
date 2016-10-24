package org.fundacionjala.sfdc.pages.contacts;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents to contact pages.
 */
public class ContactHome extends AbstractBasePage {

    @FindBy(xpath = "//input[@name='new']")
    @CacheLookup
    private WebElement newButton;

    /**
<<<<<<< HEAD
     * This method makes click in post link.
     *
     * @return a Contact Form.
=======
     * @return
>>>>>>> upstream/develop
     */
    public ContactForm clickPostLnk() {
        CommonActions.clickElement(newButton);
        return new ContactForm();
    }


}
