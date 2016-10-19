package org.fundacionjala.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.Environment;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

public class LoginPage extends AbstractBasePage {
    public static final String baseURL = "https://na24.salesforce.com/";
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

    public LoginPage(){
        driver.get(baseURL);
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
    
    public MainApp loginAs(String username, String password) {
    	//DriverManager.getInstance().goStartPage("https://login.salesforce.com/");
    	MainApp mainApp = this.setUserNameField(username).setPasswordField(password).clickLogInToSalesforceButton();
        return mainApp;
    }

    public MainApp loginAsPrimaryUser() {
        return loginAs(Environment.getInstance().getPrimaryUser(),
                Environment.getInstance().getPrimaryPassword());
    }
}
