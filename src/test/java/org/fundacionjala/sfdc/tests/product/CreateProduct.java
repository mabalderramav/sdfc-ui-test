package org.fundacionjala.sfdc.tests.product;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * This class handle create a new product.
 */
public class CreateProduct {

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";

    private static final String NAME_TEST = "nameTest";

    private static final String DESCRIPTION_TEST = "description test";

    private ProductForm productForm;

    private Map<String, String> valuesMapJson;

    private ProductDetail productDetail;

    /**
     * This method is Before setup.
     */
    @BeforeMethod
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(PRODUCT_DATA_PATH);
        final MainApp mainApp = new MainApp();
        final TabBar tabBar = mainApp.goToTabBar();
        final ProductHome productHome = tabBar.clickOnProductsHome();
        productForm = productHome.clickNewButton();
    }

    /**
     * This method that is created a new product with json.
     */
    @Test
    public void createProductWithJson() {
        productForm.fillTheForm(valuesMapJson);
        productDetail = productForm.clickSaveButton();
        assertDetailValues(productDetail, valuesMapJson);
    }

    /**
     * This method that is created a new product.
     */
    @Test
    public void createProduct() {
        productForm = new ProductForm.ProductBuilder(NAME_TEST)
                .setDescription(DESCRIPTION_TEST)
                .build();
        productDetail = productForm.saveProduct();
        assertDetailValues(productDetail, productForm.getValuesMap());
    }

    /**
     * This method is executed after scenario.
     */
    @AfterMethod
    public void tearDown() {
        productDetail.clickDeleteButton();
    }
}
