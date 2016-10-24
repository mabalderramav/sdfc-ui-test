package org.fundacionjala.sfdc.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * This class handle the product form.
 */
public class ProductForm extends AbstractBasePage {

    private static final String BLANK = "";

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveButton;

    @FindBy(id = "Name")
    @CacheLookup
    private WebElement productNameTextbox;

    @FindBy(id = "ProductCode")
    @CacheLookup
    private WebElement productCodeTextbox;

    @FindBy(id = "IsActive")
    @CacheLookup
    private WebElement activeFlag;


    @FindBy(id = "Family")
    @CacheLookup
    private WebElement multiSelectProductFamily;

    @FindBy(id = "Description")
    @CacheLookup
    private WebElement descriptionTextArea;


    /**
     * This method set the product name in the text field.
     *
     * @param productName String with the product name.
     * @return Return this class.
     */
    public ProductForm setProductName(String productName) {
        CommonActions.sendKeys(productNameTextbox, productName);
        return this;
    }

    /**
     * This method checked element.
     *
     * @param flag Boolean with flag.
     * @return Return this class.
     */
    public ProductForm checkActiveFlag(boolean flag) {
        if (!CommonActions.isSelected(activeFlag) && flag) {
            CommonActions.clickElement(activeFlag);
        }
        return this;
    }

    /**
     * This method set the product code in the text field.
     *
     * @param productCode String with the product code.
     * @return Return this class.
     */
    public ProductForm setProductCode(String productCode) {
        CommonActions.sendKeys(productCodeTextbox, productCode);
        return this;
    }

    /**
     * This method chose product family.
     *
     * @param productFamily String with the product family.
     * @return Return this class.
     */
    public ProductForm chooseProductFamilyDdl(String productFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(multiSelectProductFamily));
        Select selectBox = new Select(multiSelectProductFamily);
        if (productFamily.isEmpty()) {
            int index = 0;
            selectBox.selectByIndex(index);
        } else {
            selectBox.selectByVisibleText(productFamily);
        }
        return this;
    }

    /**
     * This method chose product description.
     *
     * @param description String with the description.
     * @return Return this class.
     */
    public ProductForm setDescription(String description) {
        CommonActions.sendKeys(descriptionTextArea, description);
        return this;
    }

    /**
     * This method doing click on "Save" button.
     *
     * @return Return this class.
     */
    public ProductDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new ProductDetail();
    }
}
