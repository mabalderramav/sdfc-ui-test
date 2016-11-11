package org.fundacionjala.sfdc.pages.lookup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * Class to represent the list section frame.
 */
public class ListSectionFrame extends AbstractBasePage {

    private static final String RESULTS_FRAME = "resultsFrame";

    @FindBy(className = " dataCell ")
    private WebElement linkToSelect;

    /**
     * Constructor that select the list in the frame section.
     */
    public ListSectionFrame() {
        driver.switchTo().frame(RESULTS_FRAME);
    }

    /**
     * Method that select a campaign link from the list.
     */
    void selectAResultFromTheList() {
        CommonActions.clickElement(linkToSelect);
    }
}
