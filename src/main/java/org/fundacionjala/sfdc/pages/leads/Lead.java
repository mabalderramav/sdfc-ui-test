package org.fundacionjala.sfdc.pages.leads;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class holds leads home page elements and inherits from FormBase the basic button "new"
 */

public class Lead extends HomeBase {
    /**
     * {@link HomeBase}
     */
    @Override
    public LeadForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new LeadForm();
    }

    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        return null;
    }

    @Override
    public AbstractBasePage clickEditViewLink() {
        return null;
    }
}