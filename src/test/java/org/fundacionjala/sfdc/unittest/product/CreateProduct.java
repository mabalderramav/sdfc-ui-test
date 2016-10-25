package org.fundacionjala.sfdc.unittest.product;

import java.util.Map;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import org.fundacionjala.sfdc.utils.Common;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class handle create a new product.
 */
public class CreateProduct {

    private static final String PRODUCT_DATA_PATH = "src/test/resources/json/product/CreateProductData.json";

    private ProductHome productHome;

    private Map<String, String> valuesMapJson;
    private ProductDetail productDetail;

    /**
     * This method is Before setup.
     */
    @BeforeTest
    public void setup() {
        valuesMapJson = Common.getMapJson(PRODUCT_DATA_PATH);
        final MainApp mainApp = new MainApp();
        final TabBar tabBar = mainApp.goToTabBar();
        productHome = tabBar.clickOnProductsHome();
    }

    /**
     * This method that is created a new product.
     */
    @Test
    public void createProduct() {
        final ProductForm newProductForm = productHome.clickNewButton();
        newProductForm.fillTheForm(valuesMapJson);
        productDetail = newProductForm.clickSaveButton();
        AssertProduct.assertDetailValues(productDetail, valuesMapJson);
    }

    /**
     * This method is executed after scenario.
     */
    @AfterTest
    public void tearDown() {
        productDetail.clickDeleteButton();
    }
}
