package org.fundacionjala.sfdc.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;

/**
 * This class handle the product details.
 */
public class ProductDetail extends DetailBase {

    private static final String CHECKED = "Checked";

    private static final String TITLE = "title";


    // product name
    @FindBy(id = "Name_ileinner")
    @CacheLookup
    private WebElement productNameLabel;

    // product code
    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    private WebElement productCodeLabel;

    // product description
    @FindBy(id = "Description_ileinner")
    @CacheLookup
    private WebElement productDescriptionLabel;

    // active flag
    @FindBy(id = "IsActive_chkbox")
    @CacheLookup
    private WebElement activeFlagImg;

    // product family
    @FindBy(id = "Family_ileinner")
    @CacheLookup
    private WebElement productFamilyLabel;

    /**
     * This method doing click on "Delete" button.
     */
    public void clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        driver.switchTo().alert().accept();
    }

    /**
     * {@link AbstractBasePage}
     */
    @Override
    public ProductForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new ProductForm();
    }

    /**
     * This method verify that product is displayed.
     *
     * @param product String with product.
     * @return returns <code>true<code/> if product is displayed.
     */
    public boolean isProductDisplayed(final String product) {
        return CommonActions.isElementPresent(driver.findElement(By.linkText(product)));
    }

    /**
     * This method verify that flag is active.
     *
     * @return Return true if is active.
     */
    public boolean isActiveFlag() {
        return CHECKED.equals(activeFlagImg.getAttribute(TITLE));
    }

    /**
     * This method obtains the product family.
     *
     * @return String with product family.
     */
    public String getProductFamily() {
        return CommonActions.getText(productFamilyLabel);
    }

    /**
     * This method obtains the product name.
     *
     * @return String with product name.
     */
    public String getProductName() {
        return CommonActions.getText(productNameLabel);
    }

    /**
     * This method obtains the product code.
     *
     * @return String with product code.
     */
    public String getProductCode() {
        return CommonActions.getText(productCodeLabel);
    }

    /**
     * This method obtains the product code.
     *
     * @return String with product code.
     */
    public String getDescription() {
        return CommonActions.getText(productDescriptionLabel);
    }

}
