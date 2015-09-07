package Pages.Products;

import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 28-06-15.
 */
public class NewProductForm {


    //region Locators

    // Save button
    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    // product name
    @FindBy(id = "Name")
    @CacheLookup
    private WebElement productNameTextbox;

    // product code
    @FindBy(id = "ProductCode")
    @CacheLookup
    private WebElement productCodeTextbox;

    // Active
    @FindBy(id = "IsActive")
    @CacheLookup
    private WebElement activeFlag;

    // Product Family
    @FindBy(id = "Family")
    @CacheLookup
    private WebElement multiSelectProductFamily;

    // Description
    @FindBy(id = "Description")
    @CacheLookup
    private WebElement descriptionTextArea;

    private WebDriver driver;
    private WebDriverWait wait;


    public NewProductForm() {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public NewProductForm setProductName(String productName) {
        productNameTextbox.clear();
        productNameTextbox.sendKeys(productName);

        return this;
    }

    public NewProductForm checkActiveFlag(boolean flag) {
        if (!activeFlag.isSelected() && flag) {
            activeFlag.click();
        }

        return this;
    }

    public NewProductForm uncheckActiveFlag(boolean flag) {
        if (activeFlag.isSelected() && flag) {
            activeFlag.click();
        }

        return this;
    }

    public NewProductForm setProductCode(String productCode) {
        productCodeTextbox.clear();
        productCodeTextbox.sendKeys(productCode);

        return this;
    }

    public NewProductForm chooseProductFamilyDdl(String productFamily) {
        Select selectBox = new Select(multiSelectProductFamily);
        if (productFamily.equals("")) {
            selectBox.selectByIndex(0);
        } else {
            selectBox.selectByVisibleText(productFamily);
        }

        return this;
    }

    public NewProductForm setDescription(String description) {
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);

        return this;
    }

    public ProductProfile pressSaveBtn() {
        saveBtn.click();

        return new ProductProfile();
    }
}
