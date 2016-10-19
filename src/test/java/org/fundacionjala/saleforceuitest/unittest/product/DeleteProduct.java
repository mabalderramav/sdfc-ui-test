package org.fundacionjala.saleforceuitest.unittest.product;

import org.fundacionjala.saleforceuitest.pages.LoginPage;
import org.fundacionjala.saleforceuitest.pages.lookup.LookUpWindow;
import org.fundacionjala.saleforceuitest.pages.MainApp;
import org.fundacionjala.saleforceuitest.pages.products.ProductsAbstractPage;
import org.fundacionjala.saleforceuitest.pages.TabBar;
import org.fundacionjala.saleforceuitest.pages.products.NewProductForm;
import org.fundacionjala.saleforceuitest.pages.products.ProductProfile;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

/**
 * Created by Ruber Cuellar
 */
public class DeleteProduct {

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
    public void DeleteProduct()
    {
        productProfile.pressDeleteBtn();
        Assert.assertFalse(productProfile.isProductDisplayed(productName), "Product Deleted");
    }

    @AfterTest
    public void afterTest()
    {
        mainApp.clickUserButton().clickLogout();
    }

}
