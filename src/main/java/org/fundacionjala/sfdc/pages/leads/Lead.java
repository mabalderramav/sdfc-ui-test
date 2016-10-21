package org.fundacionjala.sfdc.pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import org.fundacionjala.sfdc.pages.base.ElementFormBasePage;

/**
 * This class holds leads home page elements and inherits from FormBasePage the basic button "new".
 */

public class Lead extends ElementFormBasePage {

    /**
     * This method make a click on the new button to create a new Lead.
     *
     * @return the Form to create a new Lead.
     */
    public LeadForm clickNewBtn() {
        newElementBtn.click();
        return new LeadForm();
    }
    public boolean isLeadDisplayed(String lead) {
        try {
            String leadContainer = driver.findElement(By.linkText(lead)).getText();
            return true;
        } catch(WebDriverException e) {
            return false;
        }
    }
}