package org.fundacionjala.sfdc.pages.leads;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class holds leads home page elements and inherits from FormBasePage the basic button "new".
 */

public class LeadHome extends HomeBase {

    /**
     * This method verify if the Deleted Lead is displayed in the page.
     *
     * @param lead the name of the Lead.
     * @return <lead>true<lead/> if Lead is displayed.
     */
    public boolean isLeadDisplayed(final String lead) {
        return CommonActions.existElementByLinkText(lead);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new LeadForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        CommonActions.clickElement(createNewViewLink);
        return new LeadForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        CommonActions.clickElement(editViewLink);
        return new LeadForm();
    }

}
