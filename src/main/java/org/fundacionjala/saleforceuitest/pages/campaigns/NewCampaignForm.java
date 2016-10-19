package org.fundacionjala.saleforceuitest.pages.campaigns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.saleforceuitest.framework.common.CommonActions;
import org.fundacionjala.saleforceuitest.pages.base.AbstractBasePage;
import org.fundacionjala.saleforceuitest.pages.lookup.CampaignLookup;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class NewCampaignForm extends AbstractBasePage {

    //region Locators

    @FindBy(id = "cpn1")
    @CacheLookup
    WebElement CampaingNameField;

    @FindBy(id = "cpn16")
    @CacheLookup
    WebElement ActiveCheckbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    WebElement TypeDropdown;

    @FindBy(id = "cpn5")
    @CacheLookup
    WebElement StartDateField;

    @FindBy(id = "Parent")
    @CacheLookup
    WebElement ParentCampaing;

    @FindBy(id = "Parent_lkwgt")
    @CacheLookup
    WebElement LookUpIcon;

    @FindBy(name = "save")
    @CacheLookup
    WebElement SaveButton;
    //endregion

    public NewCampaignForm setCampaingNameField(String text) {
        CommonActions.sendKeys(CampaingNameField, text);
        return this;
    }
    public NewCampaignForm checkActiveCheckbox() {
        CommonActions.check(ActiveCheckbox);
        return this;
    }
    public NewCampaignForm selectTypeDropdown(String item) {
        CommonActions.selectItem(TypeDropdown, item);
        return this;
    }
    public NewCampaignForm setStartDateField(String date) {
        CommonActions.sendKeys(StartDateField, date);
        return this;
    }
    public CampaignLookup clickLookUpIcon() {
        CommonActions.clickElement(LookUpIcon);
        return new CampaignLookup();
    }
    public CampaignProfile clickSaveButton() {
        CommonActions.clickElement(SaveButton);
        return new CampaignProfile();
    }
}
