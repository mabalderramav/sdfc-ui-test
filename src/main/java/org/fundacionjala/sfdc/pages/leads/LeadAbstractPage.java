package org.fundacionjala.sfdc.pages.leads;

import org.fundacionjala.sfdc.pages.base.ElementFormBasePage;

/**
 * This class holds leads home page elements and inherits from FormBasePage the basic button "new"
 */

public class LeadAbstractPage extends ElementFormBasePage {

    /**
     * This method make a click on the new button to create a new Lead.
     *
     * @return the Form to create a new Lead.
     */
    public LeadForm clickNewBtn() {
        newElementBtn.click();
        return new LeadForm();
    }
}