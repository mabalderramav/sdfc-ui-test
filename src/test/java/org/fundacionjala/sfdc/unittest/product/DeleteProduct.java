package org.fundacionjala.sfdc.unittest.product;


import java.util.Map;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.fundacionjala.sfdc.utils.Common;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class handle deleted a product.
 */
public class DeleteProduct {

    private static final String PRODUCT_DATA_PATH = "src/test/resources/json/product/CreateProductData.json";
    private Map<String, String> valuesMapJson;
    private ProductHome productHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private ProductDetail productDetail;
    private ProductForm newProductForm;

    /**
     * This method is Before setup.
     */
    @BeforeTest
    public void setup() {
        valuesMapJson = Common.getMapJson(PRODUCT_DATA_PATH);
        mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        productHome = tabBar.clickOnProductsHome();
        newProductForm = productHome.clickNewButton();
        newProductForm.fillTheForm(valuesMapJson);
        productDetail = newProductForm.clickSaveButton();
    }

    /**
     * This method delete a product.
     */
    @Test
    public void deleteProduct() {
        productDetail.clickDeleteButton();
        Assert.assertFalse(productDetail.isProductDisplayed(valuesMapJson.get("productName")), "ProductHome Deleted");
    }
}
