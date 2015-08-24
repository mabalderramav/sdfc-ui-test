package Pages.Products;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 26-06-15.
 */
public class ProductsHome {

    private WebDriver       driver;
    private WebDriverWait   wait;

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;

    public ProductsHome(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public NewProductForm clickNewButton() {
        CommonActions.click(NewButtton);
        return new NewProductForm(driver);
    }
}
