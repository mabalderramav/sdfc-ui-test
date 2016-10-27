package org.fundacionjala.sfdc.tests.product;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * Class to verify the edition of product.
 */
public class EditProduct {

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";

    private static final String OPPORTUNITY_DATA_EDIT_PATH = "product/EditProductData.json";

    private static final String NAME_TEST = "nameTestUpdate";

    private static final String DESCRIPTION_TEST = "description test update";

    private ProductDetail productDetail;

    private ProductForm productForm;

    /**
     * Method that define the preconditions before to execute the product edition test.
     */
    @BeforeMethod
    public void setup() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(PRODUCT_DATA_PATH);
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ProductHome productHome = tabBar.clickOnProductsHome();
        productForm = productHome.clickNewButton();
        productForm.fillTheForm(valuesMapJson);
        productDetail = productForm.clickSaveButton();
        productForm = productDetail.clickEditButton();
    }

    /**
     * Test to verify the edition of product given a Json file.
     */
    @Test
    public void editProductWithJson() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        productForm.fillTheForm(valuesMapEditJson);
        productDetail = productForm.clickSaveButton();
        assertDetailValues(productDetail, valuesMapEditJson);
    }

    /**
     * Test to verify the Edition of product using the builder pattern.
     */
    @Test
    public void editProduct() {
        productForm = new ProductForm.ProductBuilder(NAME_TEST)
                .setDescription(DESCRIPTION_TEST)
                .build();
        productDetail = productForm.saveProduct();
        assertDetailValues(productDetail, productForm.getValuesMap());
    }

    /**
     * Method that delete the create product in the precondition.
     */
    @AfterMethod
    public void afterTest() {
        productDetail.clickDeleteButton();
    }
}
