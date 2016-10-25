package org.fundacionjala.sfdc.pages.products;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;


/**
 * This class handle the product form.
 */
public class ProductForm extends FormBase {

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
     * {@link FormBase}
     */
    @Override
    public ProductDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new ProductDetail();
    }

    /**
     * {@link FormBase}
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new ProductDetail();
    }

    /**
     * Method that to permit set values to create a new ContractHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();

        strategyMap.put("productName", () -> setProductName(String.valueOf(values.get("productName"))));
        strategyMap.put("productCode", () -> setProductCode(String.valueOf(values.get("productCode"))));
        strategyMap.put("isActive", () -> checkActiveFlag(Boolean.valueOf(values.get("isActive"))));
        strategyMap.put("productFamily", () -> chooseProductFamilyDdl(String.valueOf(values.get("productFamily"))));
        strategyMap.put("descriptionProduct", () -> setDescription(String.valueOf(values.get("descriptionProduct"))));

        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map with values.
     */
    public void fillTheForm(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
