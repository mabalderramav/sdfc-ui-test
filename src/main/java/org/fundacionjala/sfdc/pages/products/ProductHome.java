package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This base page the product abstract class.
 */
public class ProductHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    public ProductForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        CommonActions.clickElement(createNewViewLink);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        CommonActions.clickElement(editViewLink);
        return new ProductForm();
    }
}
