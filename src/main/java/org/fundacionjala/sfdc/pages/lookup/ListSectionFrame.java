package org.fundacionjala.sfdc.pages.lookup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.CommonActions;

/**
 * Class to represent the list section frame.
 */
class ListSectionFrame extends SectionFrame {

    private static final String RESULTS_FRAME = "resultsFrame";
    @FindBy(className = " dataCell ")
    private WebElement linkToSelect;

    /**
     * Method that select the list in the frame section.
     */
    ListSectionFrame() {
        driver.switchTo().frame(RESULTS_FRAME);
    }

    /**
     * Method that select a campaign link from the list.
     */
    void selectACampaignFromTheList() {
        CommonActions.clickElement(linkToSelect);
    }
}
