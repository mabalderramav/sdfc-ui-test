package Scripts;

import Framework.BrowserManager;
import Pages.LoginPage;
import Pages.Products.NewProductForm;
import Pages.Products.ProductProfile;
import Pages.Products.ProductsHome;
import Pages.TopBar.TabBar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by ivan on 28-06-15.
 */
public class CreateProduct {

    //region Objects
    TabBar          tapBar;
    ProductsHome    productsHome;
    NewProductForm  newProductForm;
    ProductProfile  productProfile;
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
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("vasquez.vn@gmail.com")
                .setPasswordField("123Control")
                .clickLogInToSalesforceButton();
    }

    @Test
    public void CreateProduct()
    {
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

        Assert.assertEquals(productProfile.getProductName(), productName);
        Assert.assertEquals(productProfile.getProductcode(), productCode);
        Assert.assertEquals(productProfile.isActiveFlag(), isActive);
        Assert.assertEquals(productProfile.getProductFamily(), productFamily);
        Assert.assertEquals(productProfile.getDescription(), descriptionProduct);

    }

    @AfterTest
    public void afterTest()
    {
        productProfile.pressDeleteBtn();
    }
}
