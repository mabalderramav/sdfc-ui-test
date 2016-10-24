package org.fundacionjala.sfdc.unittest.product;

import java.util.Map;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.fundacionjala.sfdc.utils.Common;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Ruber Cuellar
 */
public class EditProduct {

    private static final String PRODUCT_DATA_PATH = "src/test/resources/json/product/CreateProductData.json";
    private Map<String, String> valuesMapJson;
    private ProductHome productHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private ProductDetail productDetail;
    private ProductForm newProductForm;
    private LoginPage loginPage;

    private String productName = "product_001";
    private String productNameUpdated = "product_002";
    private String productCode = "prod_001";
    private String productCodeUpdated = "prod_002";
    private String descriptionProduct = "description Test";
    private String descriptionProductUpdated = "description Test2";
    private boolean isActive = true;
    private String productFamily = "None";

    @BeforeTest
    public void BeforeTest() {
        valuesMapJson = Common.getMapJson(PRODUCT_DATA_PATH);
        mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        productHome = tabBar.clickOnProductsHome();
        newProductForm = productHome.clickNewButton();
        newProductForm.fillTheForm(valuesMapJson);
        productDetail = newProductForm.clickSaveButton();
//        loginPage = new LoginPage();
//        mainApp = loginPage.loginAsPrimaryUser();
//        tabBar = mainApp.goToTabBar();
//        productHome = tabBar.clickOnProductsHome();
//        newProductForm = productHome.clickNewButton();
//        productDetail = newProductForm
//                .setProductName(productName)
//                .setProductCode(productCode)
//                .checkActiveFlag(isActive)
//                .chooseProductFamilyDdl(productFamily)
//                .setDescription(descriptionProduct)
//                .clickSaveButton();
    }

    @Test
    public void EditProduct() {
        newProductForm = productDetail.clickEditButton();
        productDetail = newProductForm
                .setProductName(productNameUpdated)
                .setProductCode(productCodeUpdated)
                .checkActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamily)
                .setDescription(descriptionProductUpdated)
                .clickSaveButton();

        Assert.assertEquals(productDetail.getProductName(), productNameUpdated);
        Assert.assertEquals(productDetail.getProductCode(), productCodeUpdated);
        Assert.assertEquals(productDetail.isActiveFlag(), isActive);
        Assert.assertEquals(productDetail.getProductFamily(), productFamily);
        Assert.assertEquals(productDetail.getDescription(), descriptionProductUpdated);

    }

    @AfterTest
    public void afterTest() {
        productDetail.clickDeleteButton();
    }
}
