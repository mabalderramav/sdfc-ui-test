package org.fundacionjala.sfdc.pages.lookup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class to represent the list section frame.
 */
public class ListSectionFrame extends SectionFrame {

    @FindBy(className = " dataCell ")
    private WebElement linkToSelect;

    /**
     * Method that select the list in the frame section.
     */
    public ListSectionFrame() {
        driver.switchTo().frame("resultsFrame");
    }

    /**
     * Method that select a campaign link from the list.
     */
    public void selectACampaignFromTheList() {
        wait.until(ExpectedConditions.visibilityOf(linkToSelect));
        linkToSelect.click();
    }
}
