package Pages.Products;

import Framework.CommonActions;
import Pages.Base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 26-06-15.
 */
public class ProductsAbstractPage extends AbstractBasePage {


    private WebDriver       driver;
    private WebDriverWait   wait;

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;

    public ProductsAbstractPage()
    {
        super();
    }

    public NewProductForm clickNewButton() {
        CommonActions.click(NewButtton);
        return new NewProductForm();
    }
}
