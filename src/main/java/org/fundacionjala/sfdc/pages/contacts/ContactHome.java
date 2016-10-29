package org.fundacionjala.sfdc.pages.contacts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class represents to contact pages.
 */
public class ContactHome extends HomeBase {
    /**
     * {@inheritDoc}.
     */
    @Override
    public ContactForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ContactForm();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public ContactForm clickCreateNewViewLink() {
        CommonActions.clickElement(createNewViewLink);
        return new ContactForm();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public ContactForm clickEditViewLink() {
        CommonActions.clickElement(editViewLink);
        return new ContactForm();
    }

}
