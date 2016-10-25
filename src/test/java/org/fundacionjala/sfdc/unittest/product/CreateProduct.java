package org.fundacionjala.sfdc.unittest.product;

import java.util.Map;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.Product;
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

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";

    private static final String NAME_TEST = "nameTest";

    private static final String DESCRIPTION_TEST = "description test";

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
     * This method that is created a new product with json.
     */
    @Test
    public void createProductWithJson() {
        final ProductForm newProductForm = productHome.clickNewButton();
        newProductForm.fillTheForm(valuesMapJson);
        productDetail = newProductForm.clickSaveButton();
        AssertProduct.assertDetailValues(productDetail, valuesMapJson);
    }

    /**
     * This method that is created a new product.
     */
    @Test
    public void createProduct() {
        productHome.clickNewButton();
        Product product = new Product.ProductBuilder(NAME_TEST)
                .setDescription(DESCRIPTION_TEST)
                .build();
        productDetail = product.createProduct();
        AssertProduct.assertDetailValues(productDetail, product.getValuesMap());
    }

    /**
     * This method is executed after scenario.
     */
    @AfterTest
    public void tearDown() {
        productDetail.clickDeleteButton();
    }
}
