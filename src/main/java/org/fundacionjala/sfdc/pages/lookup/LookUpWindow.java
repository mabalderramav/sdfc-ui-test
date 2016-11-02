package org.fundacionjala.sfdc.pages.lookup;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class tha represents a modal lookUp.
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
     * Searches a coincidence inside a dropdown.
     *
     * @param item is the item to search.
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow selectSearchWithinDropdown(final String item) {
        CommonActions.selectItem(searchWithinDropdown, item);
        return this;
    }

    /**
     * Edits the search field.
     *
     * @param text Is the new test.
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow setSearchWithinField(final String text) {
        CommonActions.sendKeys(searchField, text);
        return this;
    }

    /**
     * Makes click on go button.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickGoButton() {
        CommonActions.clickElement(goButton);

        return this;
    }

    /**
     * Changes the frame to a search frame.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow switchSearchFrame() {
        driver.switchTo().frame(searchFrame);
        return this;
    }

    /**
     * Changes the frame to a search result frame.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow switchResultsFrame() {
        driver.switchTo().frame(searchResultFrame);
        return this;
    }


}
