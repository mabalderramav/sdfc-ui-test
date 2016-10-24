package org.fundacionjala.sfdc.unittest.product;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Created by Ruber Cuellar
 */
public class EditProduct {

    //region Objects
    private ProductHome productsHome;
    private LookUpWindow lookUpWindow;
    private MainApp mainApp;
    private TabBar tabBar;
    private ProductDetail productProfile;
    private ProductForm newProductForm;
    private LoginPage loginPage;
    //endregion

    //region values
    private String productName = "product_001";
    private String productNameUpdated = "product_002";
    private String productCode = "prod_001";
    private String productCodeUpdated = "prod_002";
    private String descriptionProduct = "description Test";
    private String descriptionProductUpdated = "description Test2";
    private boolean isActive = true;
    private String productFamily = "None";
    //endregion

    @BeforeTest
    public void BeforeTest() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        productsHome = tabBar.clickOnProductsHome();
        newProductForm = productsHome.clickNewButton();
        productProfile = newProductForm
                .setProductName(productName)
                .setProductCode(productCode)
                .checkActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamily)
                .setDescription(descriptionProduct)
                .clickSaveButton();
    }

    @Test
    public void EditProduct() {
        newProductForm = productProfile.clickEditButton();
        productProfile = newProductForm
                .setProductName(productNameUpdated)
                .setProductCode(productCodeUpdated)
                .checkActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamily)
                .setDescription(descriptionProductUpdated)
                .clickSaveButton();

        Assert.assertEquals(productProfile.getProductName(), productNameUpdated);
        Assert.assertEquals(productProfile.getProductCode(), productCodeUpdated);
        Assert.assertEquals(productProfile.isActiveFlag(), isActive);
        Assert.assertEquals(productProfile.getProductFamily(), productFamily);
        Assert.assertEquals(productProfile.getDescription(), descriptionProductUpdated);

    }

    @AfterTest
    public void afterTest() {
        productProfile.clickDeleteButton();
    }
}
