package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.framework.browser.DriverManager;

/**
 * Created by Pablo Zubieta on 27/08/2015.
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, Opportunity, Products
 */
public class FormBasePage extends AbstractBasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public FormBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public FormBasePage(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
