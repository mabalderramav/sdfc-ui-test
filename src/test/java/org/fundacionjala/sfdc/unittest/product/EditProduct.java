package org.fundacionjala.sfdc.unittest.product;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.products.ProductsAbstractPage;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.NewProductForm;
import org.fundacionjala.sfdc.pages.products.ProductProfile;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

/**
 * Created by Ruber Cuellar
 */
public class EditProduct {

    //region Objects
    private ProductsAbstractPage productsHome;
    private LookUpWindow lookUpWindow;
    private MainApp mainApp;
    private TabBar tabBar;
    private ProductProfile productProfile;
    private NewProductForm newProductForm;
    private LoginPage loginPage;
    //endregion

    //region values
    private String  productName                 = "product_001";
    private String  productNameUpdated          = "product_002";
    private String  productCode                 = "prod_001";
    private String  productCodeUpdated          = "prod_002";
    private String  descriptionProduct          = "description Test";
    private String  descriptionProductUpdated   = "description Test2";
    private boolean isActive                    = true;
    private String  productFamily               = "None";
    //endregion

    @BeforeTest
    public void BeforeTest()
    {
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
                .pressSaveBtn();
    }

    @Test
    public void EditProduct()
    {
        newProductForm = productProfile.clickEditProduct();
        productProfile = newProductForm
                .setProductName(productNameUpdated)
                .setProductCode(productCodeUpdated)
                .checkActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamily)
                .setDescription(descriptionProductUpdated)
                .pressSaveBtn();

        Assert.assertEquals(productProfile.getProductName(), productNameUpdated);
        Assert.assertEquals(productProfile.getProductcode(), productCodeUpdated);
        Assert.assertEquals(productProfile.isActiveFlag(), isActive);
        Assert.assertEquals(productProfile.getProductFamily(), productFamily);
        Assert.assertEquals(productProfile.getDescription(), descriptionProductUpdated);

    }

    @AfterTest
    public void afterTest()
    {
        productProfile.pressDeleteBtn();
    }
}
