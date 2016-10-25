package org.fundacionjala.sfdc.unittest.product;

import java.util.Map;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.Product;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.fundacionjala.sfdc.utils.Common;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Ruber Cuellar
 */
public class EditProduct {

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";

    private static final String OPPORTUNITY_DATA_EDIT_PATH = "product/EditProductData.json";

    private static final String NAME_TEST = "nameTestUpdate";

    private static final String DESCRIPTION_TEST = "description test update";

    private ProductDetail productDetail;

    private ProductForm newProductForm;

    @BeforeMethod
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
    public void editProductWithJson() {
        newProductForm = productDetail.clickEditButton();
        Map<String, String> valuesMapEditJson = Common.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        newProductForm.fillTheForm(valuesMapEditJson);
        productDetail = newProductForm.clickSaveButton();
        AssertProduct.assertDetailValues(productDetail, valuesMapEditJson);
    }

    @Test
    public void editProduct() {
        productDetail.clickEditButton();
        Product product = new Product.ProductBuilder(NAME_TEST)
                .setDescription(DESCRIPTION_TEST)
                .build();
        productDetail = product.createProduct();
        AssertProduct.assertDetailValues(productDetail, product.getValuesMap());
    }

    @AfterMethod
    public void afterTest() {
        productDetail.clickDeleteButton();
    }
}
