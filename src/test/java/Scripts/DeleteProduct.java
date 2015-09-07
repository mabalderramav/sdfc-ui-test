package Scripts;

import Framework.BrowserManager;
import Pages.Contacts.ContactsHome;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.NewContactForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.MainApp;
import Pages.TabBar;
import Pages.Products.NewProductForm;
import Pages.Products.ProductProfile;
import Pages.Products.ProductsHome;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

/**
 * Created by Ruber Cuellar
 */
public class DeleteProduct {

    //region Objects
    private ProductsHome productsHome;
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
