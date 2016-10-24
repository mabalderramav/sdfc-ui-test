package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This base page the product abstract class.
 */
public class ProductHome extends HomeBase {

    /**
     * {@link HomeBase}
     */
    public ProductForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ProductForm();
    }

    /**
     * {@link HomeBase}
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        CommonActions.clickElement(createNewViewLink);
        return new ProductForm();
    }

    /**
     * {@link HomeBase}
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        CommonActions.clickElement(editViewLink);
        return new ProductForm();
    }
}
