package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.framework.browser.DriverManager;
import org.fundacionjala.sfdc.framework.utils.LoggerManager;


public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoggerManager loggerManager;

    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        loggerManager = LoggerManager.getInstance();
        PageFactory.initElements(driver, this);
    }
}
