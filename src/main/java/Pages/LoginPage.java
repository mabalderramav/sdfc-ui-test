package Pages;

import Framework.BrowserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    //region Locators
    @FindBy(id = "username")
    @CacheLookup
    WebElement userNameField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    WebElement loginField;
    //endregion

    public LoginPage()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserNameField(String email) {
        userNameField.clear();
        userNameField.sendKeys(email);
        return this;
    }

    public LoginPage setPasswordField(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public MainApp clickLogInToSalesforceButton() {
        loginField.click();
        return new MainApp();
    }
}
