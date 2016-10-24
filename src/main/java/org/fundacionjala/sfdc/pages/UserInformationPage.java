package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AngelaValdez on 10/24/2016.
 */
public class UserInformationPage extends DetailBase {

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editBtn;

    @FindBy(css = "table.detailList tr:nth-child(4) td.col02")
    private WebElement userName;

    @Override
    public AbstractBasePage clickEditButton() {
        CommonActions.clickElement(editBtn);
        return null;
    }

    public String getUserName() {
        return CommonActions.getText(userName);
    }

}
