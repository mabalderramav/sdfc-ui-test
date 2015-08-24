package Scripts;

import Framework.BrowserManager;
import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import Pages.Products.NewProductForm;
import Pages.Products.ProductProfile;
import Pages.Products.ProductsHome;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by Ivan Vasquez on 6/29/2015.
 */
public class EditProduct {

    //region Objects
    TabBar tapBar;
    ProductsHome productsHome;
    NewProductForm newProductForm;
    ProductProfile productProfile;
    private MainApp mainApp;
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
    private String  productFamilyUpdated        = "";
    //endregion

    @BeforeTest
    public void BeforeTest()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        mainApp = new LoginPage()
                .setUserNameField("vasquez.vn@gmail.com")
                .setPasswordField("123Control")
                .clickLogInToSalesforceButton();

        createProduct();
    }

    private void createProduct() {
        productsHome = tapBar
                .clickProductsTab();

        newProductForm = productsHome
                .clickNewButton();

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
        newProductForm = productProfile
                .pressEditBtn();

        productProfile = newProductForm
                .setProductName(productNameUpdated)
                .setProductCode(productCodeUpdated)
                .uncheckActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamilyUpdated)
                .setDescription(descriptionProductUpdated)
                .pressSaveBtn();

        Assert.assertEquals(productProfile.getProductName(), productNameUpdated);
        Assert.assertEquals(productProfile.getProductcode(), productCodeUpdated);
        Assert.assertEquals(productProfile.isActiveFlag(), false);
        Assert.assertEquals(productProfile.getProductFamily(), "-None-");
        Assert.assertEquals(productProfile.getDescription(), descriptionProductUpdated);

    }

    @AfterTest
    public void afterTest()
    {
        productProfile.pressDeleteBtn();
    }
}
