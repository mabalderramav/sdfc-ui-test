package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class CampaignProfile extends AbstractBasePage {

    //region Locators

    @FindBy(className = "pageDescription")
    @CacheLookup
    WebElement CampaingNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    WebElement DeleteButton;
    //endregion


    public String getCampaingNameLabel() {
        return CampaingNameLabel.getText();
    }

    public CampaignsHome clickDeleteButton() {
        CommonActions.clickElement(DeleteButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return new CampaignsHome();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
