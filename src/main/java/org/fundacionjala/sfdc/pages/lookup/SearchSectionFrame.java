package org.fundacionjala.sfdc.pages.lookup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


class SearchSectionFrame extends SectionFrame {
    @FindBy(id = "searchFrame")
    private WebElement searchSection;
    @FindBy(id = "campaignScope")
    private WebElement campaginScopeSelect;
    @FindBy(id = "lksrch")
    private WebElement campaignNameField;
    @FindBy(name = "go")
    private WebElement searchButton;

    SearchSectionFrame() {
        driver.switchTo().frame(0);
        ExpectedConditions.frameToBeAvailableAndSwitchToIt(searchSection);
    }

    private void setScope(String scope) {
        scopeRequired(scope);
    }

    public void setCampaign(String campaign) {
        setCampaignName(campaign);
        clickSearch();
        returnRoot();
    }

    void searchTheCampaign(String parentCampaign, String scope) {
        setScope(scope);
        setCampaign(parentCampaign);
    }

    void searchTheCampaign(String campaign) {
        setCampaign(campaign);
    }

    private void scopeRequired(String scope) {
        if (scope != null) {
            setCampaignScope(scope);
        }
    }

    private void clickSearch() {
        wait.until(ExpectedConditions.visibilityOf(this.searchButton));
        searchButton.click();
    }

    private void setCampaignScope(String campaignScope) {
        wait.until(ExpectedConditions.visibilityOf(this.campaginScopeSelect));
        Select campaignScopeSelect = new Select(this.campaginScopeSelect);
        campaignScopeSelect.selectByVisibleText(campaignScope);
    }

    private void setCampaignName(String campaignName) {
        wait.until(ExpectedConditions.visibilityOf(this.campaignNameField));
        this.campaignNameField.clear();
        this.campaignNameField.sendKeys(campaignName);
    }

}
