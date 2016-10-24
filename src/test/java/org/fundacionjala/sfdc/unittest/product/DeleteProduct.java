package org.fundacionjala.sfdc.unittest.product;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Ruber Cuellar
 */
public class DeleteProduct {

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
    private String productCode = "prod_001";
    private String descriptionProduct = "description Test";
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
    public void DeleteProduct() {
        productProfile.clickDeleteButton();
        Assert.assertFalse(productProfile.isProductDisplayed(productName), "ProductHome Deleted");
    }

    @AfterTest
    public void afterTest() {
        mainApp.clickUserButton().clickLogout();
    }

}
