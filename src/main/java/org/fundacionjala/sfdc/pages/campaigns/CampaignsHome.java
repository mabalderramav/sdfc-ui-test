package org.fundacionjala.sfdc.pages.campaigns;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class is in charge to manage the elements of the page.
 */
public class CampaignsHome extends AbstractBasePage {


    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    private WebElement newButtton;

    @FindBy(className = "hotListElement")
    @CacheLookup
    private WebElement allCampaigns;

    @FindBy(className = " dataCell ")
    @CacheLookup
    private WebElement campaignNameLink;

    /**
     * click on the new button.
     *
     * @return CampaignForm.
     */
    public CampaignForm clickNewButton() {
        CommonActions.clickElement(newButtton);
        return new CampaignForm();
    }

    /**
     * verify if the campaign exist.
     *
     * @param campaignName String whit the name of he campaign.
     * @return boolean.
     */
    public boolean existCampaign(final String campaignName) {
        List<WebElement> campaigns = allCampaigns.findElements(By.className("dataCell"));
        return campaigns.stream().filter(x -> x.equals(campaignName)).findAny().isPresent();
    }

    /**
     * Method that select the campaign name from the list.
     *
     * @param campaignName String with the campaign name.
     * @return {@link CampaignDetail}.
     */
    public CampaignDetail selectCampaign(final String campaignName) {
        allCampaigns.findElement(By.linkText(campaignName)).click();
        return new CampaignDetail();
    }
}
