package Pages.LookUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Pages.Base.AbstractSectionFrame;

/**
 * Created by ccatari on 5/22/2016.
 */
public class SearchSectionFrame extends AbstractSectionFrame {
    @FindBy(id = "searchFrame")
    private WebElement searchSection;
    @FindBy(id = "campaignScope")
    private WebElement campaginScopeSelect;
    @FindBy(id = "lksrch")
    private WebElement campaignNameField;
    @FindBy(name = "go")
    private WebElement searchButton;

    public SearchSectionFrame(){
        driver.switchTo().frame(0);
        ExpectedConditions.frameToBeAvailableAndSwitchToIt(searchSection);
    }
    public void setScope(String scope){
        scopeRequired(scope);
    }
    public void setCampaign(String campaign){
        setCampaignName(campaign);
        clickSearch();
        returnRoot();
    }
    public void searchTheCampaign(String parentCampaign, String scope) {
        setScope(scope);
        setCampaign(parentCampaign);
    }
    public void scopeRequired(String scope){
        if(scope!=null) {
            setCampaignScope(scope);
        }
    }
    public void clickSearch() {
        wait.until(ExpectedConditions.visibilityOf(this.searchButton));
        searchButton.click();
    }

    public void setCampaignScope(String campaignScope) {
        wait.until(ExpectedConditions.visibilityOf(this.campaginScopeSelect));
        Select campaignScopeSelect = new Select(this.campaginScopeSelect);
        campaignScopeSelect.selectByVisibleText(campaignScope);
    }

    public void setCampaignName(String campaignName) {
        wait.until(ExpectedConditions.visibilityOf(this.campaignNameField));
        this.campaignNameField.clear();
        this.campaignNameField.sendKeys(campaignName);
    }

}
