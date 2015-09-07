package Pages.Products;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 28-06-15.
 */
public class ProductProfile {

    //region Locators

    // delete button
    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

    // edit button
    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editBtn;

    // product name
    @FindBy(id = "Name_ileinner")
    @CacheLookup
    private WebElement productNameLabel;

    // product code
    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    private WebElement productCodeLabel;

    // product description
    @FindBy(id = "Description_ileinner")
    @CacheLookup
    private WebElement productDescriptionLabel;

    // active flag
    @FindBy(id = "IsActive_chkbox")
    @CacheLookup
    private WebElement activeFlagImg;

    // product family
    @FindBy(id = "Family_ileinner")
    @CacheLookup
    private WebElement productFamilyLabel;

    @FindBy(xpath = "//input[@name='edit']")
    @CacheLookup
    private WebElement editButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductProfile() {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public void pressDeleteBtn() {
        deleteBtn.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public NewProductForm pressEditBtn() {
        editBtn.click();

        return new NewProductForm();
    }

    // product name
    public String getProductName() {
        return productNameLabel.getText();
    }

    // product code
    public String getProductcode() {
        return productCodeLabel.getText();
    }

    // description
    public String getDescription() {
        return productDescriptionLabel.getText();
    }

    // active
    public boolean isActiveFlag() {
        boolean result = false;
        String attributeState = activeFlagImg.getAttribute("title");

        if (attributeState.equals("Checked"))
        {
            result = true;
        }

        return result;
    }

    // product family
    public String getProductFamily() {
        String result = "None";
        if (productFamilyLabel.getText().equals("None")) {
            result = productFamilyLabel.getText();
        }
        return result;
    }

    public NewProductForm clickEditProduct() {
        CommonActions.click(editButton);
        return new NewProductForm();
    }

    public boolean isProductDisplayed(String Product) {
        WebElement productContainer;
        try {
            productContainer = driver.findElement(By.linkText(Product));
        } catch(WebDriverException e) {
            return false;
        }
        return isElementPresent(productContainer);

    }
    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

}
