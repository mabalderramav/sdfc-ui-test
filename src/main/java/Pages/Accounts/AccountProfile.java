package Pages.Accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Pages.Base.AbstractBasePage;
import Pages.MainApp;

/**
 * Created by ivan on 30-06-15.
 */
public class AccountProfile extends AbstractBasePage{

    // private Flag
    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountNameLabel;

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

    public MainApp deleteAccount() {
        return new MainApp();
    }
}
