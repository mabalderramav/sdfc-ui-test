package org.fundacionjala.sfdc.unittest.product;


import java.util.Map;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.fundacionjala.sfdc.utils.Common;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class handle deleted a product.
 */
public class DeleteProduct {

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";
    private Map<String, String> valuesMapJson;
    private ProductDetail productDetail;

    /**
     * This method is Before setup.
     */
    @BeforeMethod
    public void setup() {
        valuesMapJson = Common.getMapJson(PRODUCT_DATA_PATH);
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ProductHome productHome = tabBar.clickOnProductsHome();
        ProductForm newProductForm = productHome.clickNewButton();
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
