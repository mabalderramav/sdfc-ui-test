package org.fundacionjala.sfdc.pages.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

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
        CommonActions.clickElement(newButton);
        return new NewContactForm();
    }



}
