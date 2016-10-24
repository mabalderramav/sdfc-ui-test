package org.fundacionjala.sfdc.pages.lookup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.pages.base.SectionFrame;

/**
 * Created by ccatari on 5/22/2016.
 */
public class ListSectionFrame extends SectionFrame {
    @FindBy(className=" dataCell ")
    private WebElement linkToSelect;


    public ListSectionFrame(){
        driver.switchTo().frame("resultsFrame");
    }
    public void selectACampaignFromTheList() {
        wait.until(ExpectedConditions.visibilityOf(linkToSelect));
        linkToSelect.click();
        // it's not required to run to default due that the window is automatically closed.
    }
}
