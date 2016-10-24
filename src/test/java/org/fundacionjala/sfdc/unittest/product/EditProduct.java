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
 * Created by Ruber Cuellar
 */
public class EditProduct {

    private static final String PRODUCT_DATA_PATH = "src/test/resources/json/product/CreateProductData.json";

    private static final String OPPORTUNITY_DATA_EDIT_PATH = "src/test/resources/json/product/EditProductData.json";

    private ProductDetail productDetail;
    private ProductForm newProductForm;

    @BeforeTest
    public void setup() {
        Map<String, String> valuesMapJson = Common.getMapJson(PRODUCT_DATA_PATH);
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ProductHome productHome = tabBar.clickOnProductsHome();
        newProductForm = productHome.clickNewButton();
        newProductForm.fillTheForm(valuesMapJson);
        productDetail = newProductForm.clickSaveButton();
    }

    @Test
    public void editProduct() {
        newProductForm = productDetail.clickEditButton();
        Map<String, String> valuesMapEditJson = Common.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        newProductForm.fillTheForm(valuesMapEditJson);
        productDetail = newProductForm.clickSaveButton();
        new AssertProduct().assertDetailValues(productDetail, valuesMapEditJson);
    }

    @AfterTest
    public void afterTest() {
        productDetail.clickDeleteButton();
    }
}
