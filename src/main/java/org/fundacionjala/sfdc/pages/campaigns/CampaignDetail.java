package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */

public class CampaignDetail extends DetailBase{


    //region Locators

    @FindBy(className = "pageDescription")
    @CacheLookup
    WebElement campaingNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    WebElement deleteButton;

    @FindBy(name = "edit")
    @CacheLookup
    WebElement editButton;
    //endregion


    public String getCampaingNameLabel() {
        return CommonActions.getText(campaingNameLabel);
    }

    public Campaigns clickDeleteButton() {
        CommonActions.clickElement(deleteButton);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return new Campaigns();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public CampaignForm clickEditButton() {
        CommonActions.clickElement(editButton);
        return new CampaignForm();
    }
}
