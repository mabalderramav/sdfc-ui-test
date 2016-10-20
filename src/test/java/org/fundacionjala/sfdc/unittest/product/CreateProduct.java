package org.fundacionjala.sfdc.unittest.product;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.Product;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

/**
 * Created by Ruber Cuellar
 */
public class CreateProduct {

    //region Objects
    private Product productsHome;
    private LookUpWindow lookUpWindow;
    private MainApp mainApp;
    private TabBar tabBar;
    private ProductDetail productProfile;
    private ProductForm newProductForm;
    private LoginPage loginPage;
    //endregion

    //region values
    private String  productName         = "product_001";
    private String  productCode         = "prod_001";
    private String  descriptionProduct  = "description Test";
    private boolean isActive            = true;
    private String  productFamily       = "None";
    //endregion

    @BeforeTest
    public void BeforeTest()
    {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        productsHome = tabBar.clickOnProductsHome();
    }

    @Test
    public void CreateProduct()
    {
        newProductForm = productsHome.clickNewButton();
        productProfile = newProductForm
                .setProductName(productName)
                .setProductCode(productCode)
                .checkActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamily)
                .setDescription(descriptionProduct)
                .clickSaveButton();

        Assert.assertEquals(productProfile.getProductName(), productName);
        Assert.assertEquals(productProfile.getProductCode(), productCode);
        Assert.assertEquals(productProfile.isActiveFlag(), isActive);
        Assert.assertEquals(productProfile.getProductFamily(), productFamily);
        Assert.assertEquals(productProfile.getDescription(), descriptionProduct);

    }

    @AfterTest
    public void afterTest()
    {
        productProfile.clickDeleteButton();
    }
}
