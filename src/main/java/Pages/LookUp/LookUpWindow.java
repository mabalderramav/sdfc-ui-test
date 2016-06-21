package Pages.LookUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Base.AbstractModalWindow;
import Pages.Campaigns.NewCampaignForm;
import Pages.Opportunities.NewOpportunityForm;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class LookUpWindow extends AbstractModalWindow{


    @FindBy(xpath = "//div[@class='pBody']/select")
    @CacheLookup
    WebElement SearchWithinDropdown;

    @FindBy(xpath = "//div[@class='pBody']/input[@type='text']")
    @CacheLookup
    WebElement SearchField;

    @FindBy(xpath = "//div[@class='pBody']/input[@class='btn' and @type='submit']")
    @CacheLookup
    WebElement GoButton;

    @FindBy(className = "dataRow even last first")
    @CacheLookup
    WebElement RowsContaine;


    @FindBy(id = "searchFrame")
    @CacheLookup
    WebElement SearchFrame;

    @FindBy(id = "resultsFrame")
    @CacheLookup
    WebElement SearchResultFrame;
    //endregion

    public LookUpWindow selectSearchWithinDropdown(String item) {
        CommonActions.selectItem(SearchWithinDropdown, item);

        return this;
    }

    public LookUpWindow setSearchWithinField(String text) {
        CommonActions.setValue(SearchField, text);
        return this;
    }

    public LookUpWindow clickGoButton() {
        CommonActions.click(GoButton);

        return this;
    }

    public NewCampaignForm clickResult(String text) {
        CommonActions.click(RowsContaine.findElement(By.xpath("//a[contains(.,'" + text + "')]")));
        driver.switchTo().defaultContent();

        return new NewCampaignForm();
    }

    public NewOpportunityForm clickResultGotoNewOpportunityForm(String text) {
        CommonActions.click(RowsContaine.findElement(By.xpath("//a[contains(.,'" + text + "')]")));
        driver.switchTo().defaultContent();

        return new NewOpportunityForm();
    }

    public LookUpWindow switchSearchFrame()
    {
        driver.switchTo().frame(SearchFrame);
        return this;
    }

    public LookUpWindow switchResultsFrame()
    {
        driver.switchTo().frame(SearchResultFrame);
        return this;
    }



}
