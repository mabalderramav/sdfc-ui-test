package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.browser.DriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.Environment;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

public class LoginPage extends AbstractBasePage {
    public static final String baseURL = "https://na24.salesforce.com/";
   
    @FindBy(id = "username")
    @CacheLookup
    WebElement userNameField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    WebElement loginField;

    public LoginPage() {
        driver.get(baseURL);
    }

    /**
     * This method set the username in the text field.
     *
     * @param email String with the username or email.
     */
    public LoginPage setUserNameField(String email) {
        userNameField.clear();
        userNameField.sendKeys(email);
        return this;
    }

    /**
     * This method set the password in the text field.
     *
     * @param password String  whit the password.
     */
    public LoginPage setPasswordField(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    /**
     * Method to click on button to logging the application..
     *
     * @return The home page.
     */
    public MainApp clickLogInToSalesforceButton() {
        loginField.click();
        return new MainApp();
    }

    /**
     * Method used to perform a login to Salesforce application.
     *
     * @param username Username used to perform a login to Salesforce application.
     * @param password Password used to perform a login to Salesforce application.
     * @return The main page after login to Salesforce application.
     */
    public MainApp loginAs(String username, String password) {
        return setUserNameField(username).setPasswordField(password).clickLogInToSalesforceButton();
    }

    /**
     * Method to perform a login with other user.
     *
     * @param userName Username to perform a login with other user.
     * @param password Password to perform a login with other user.
     * @return The login to Mach2 application.
     */
    public MainApp loginOtherUser(final String userName, final String password) {
        MainApp homePage;
        try {
            homePage = new MainApp();
            if (!homePage.clickUserInformationLink().getUserName()
                    .equals(userName)) {
                homePage.clickLogout();
                homePage = loginAs(userName, password);
            }
        } catch (WebDriverException e) {
            DriverManager.getInstance().getDriver().get(Environment.getInstance().getBaseUrl());
            homePage = loginAs(userName, password);
        }
        return homePage;
    }

    /**
     * Method to perform a login as Primary user.
     *
     * @return Main page after login to Salesforce application.
     */
    public MainApp loginAsPrimaryUser() {
        return loginOtherUser(Environment.getInstance().getPrimaryUser(),
                Environment.getInstance().getPrimaryPassword());
    }
}
