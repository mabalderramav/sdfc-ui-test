package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class to manage the User Information Page.
 */
public class UserInformationPage extends AbstractBasePage {

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editBtn;

    @FindBy(css = "table.detailList tr:nth-child(4) td.col02")
    private WebElement userName;

    /**
     * Method that gets the User Name.
     * @return String with the user name.
     */
    public String getUserName() {
        return CommonActions.getText(userName);
    }

}
