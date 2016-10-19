package org.fundacionjala.saleforceuitest.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.saleforceuitest.framework.browser.DriverManager;


public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    
    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
}
