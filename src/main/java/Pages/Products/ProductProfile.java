package Pages.Products;

import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 28-06-15.
 */
public class ProductProfile {

    private WebDriver       driver;
    private WebDriverWait   wait;

    //region Locators

    // delete button
    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

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

    //endregion

    public ProductProfile(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public void pressDeleteBtn() {
        deleteBtn.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
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
    public boolean getActiveflag() {
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
        return productFamilyLabel.getText();
    }

}
