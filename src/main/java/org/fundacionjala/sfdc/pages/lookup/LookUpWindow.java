package org.fundacionjala.sfdc.pages.lookup;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class to manage the lookup window, where the search is performed.
 */
public class LookUpWindow extends ModalWindow {


    @FindBy(xpath = "//div[@class='pBody']/select")
    @CacheLookup
    private WebElement searchWithinDropdown;

    @FindBy(xpath = "//div[@class='pBody']/input[@type='text']")
    @CacheLookup
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='pBody']/input[@class='btn' and @type='submit']")
    @CacheLookup
    private WebElement goButton;

    @FindBy(className = "dataRow even last first")
    @CacheLookup
    private WebElement rowsContainer;

    @FindBy(id = "searchFrame")
    @CacheLookup
    private WebElement searchFrame;

    @FindBy(id = "resultsFrame")
    @CacheLookup
    private WebElement searchResultFrame;

    /**
     * Method that select the item in the Search within dropdown.
     *
     * @param item String with the item to be selected.
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow selectSearchWithinDropdown(final String item) {
        CommonActions.selectItem(searchWithinDropdown, item);
        return this;
    }

    /**
     * This method sets the text to be searched.
     *
     * @param text String with the text to search.
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow setSearchWithinField(final String text) {
        CommonActions.sendKeys(searchField, text);
        return this;
    }

    /**
     * Method that makes click on go button.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickGoButton() {
        CommonActions.clickElement(goButton);
        return this;
    }

    /**
     * Method that click in the link name of the search result.
     *
     * @param text String with the text searched.
     * @return {@link CampaignForm}.
     */
    public CampaignForm clickResult(final String text) {
        CommonActions.clickElement(rowsContainer.findElement(By.xpath("//a[contains(.,'" + text + "')]")));
        driver.switchTo().defaultContent();
        return new CampaignForm();
    }

    /**
     * Method that makes click on new button in the search popup.
     *
     * @param text String with the text that contain the opportunity name.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm clickResultGotoNewOpportunityForm(final String text) {
        CommonActions.clickElement(rowsContainer.findElement(By.xpath("//a[contains(.,'" + text + "')]")));
        driver.switchTo().defaultContent();
        return new OpportunityForm();
    }

    /**
     * Method that change to the search frame.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow switchSearchFrame() {
        driver.switchTo().frame(searchFrame);
        return this;
    }

    /**
     * Method that change to result frame.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow switchResultsFrame() {
        driver.switchTo().frame(searchResultFrame);
        return this;
    }
}
