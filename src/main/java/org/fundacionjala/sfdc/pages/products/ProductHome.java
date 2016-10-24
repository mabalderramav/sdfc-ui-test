package org.fundacionjala.sfdc.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * This base page the product abstract class.
 */
public class ProductHome extends AbstractBasePage {

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    private WebElement newButton;

    /**
     * This method doing click on "New" button.
     *
     * @return ProductForm page.
     */
    public ProductForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ProductForm();
    }
}
