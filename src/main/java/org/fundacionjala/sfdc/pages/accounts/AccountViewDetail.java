package org.fundacionjala.sfdc.pages.accounts;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;

/**
 * Class to manage the account view detail page.
 */
public class AccountViewDetail extends DetailBase {

    /**
     * Verify if a column exist.
     *
     * @param value String with the column value to search
     * @return returns <value>true<value/> if account is displayed or <value>false<value/> if it's not.
     */
    public Boolean existColumnName(final String value) {
        Boolean result = false;
        try {
            driver.findElement(By.cssSelector("[title='" + value + "']"));
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }

    /**
     * Verify if a view name exist.
     *
     * @param value String with the name value to search.
     * @return returns <value>true<value/> if account is displayed or <value>false<value/> if it's not.
     */
    public Boolean existViewName(final String value) {
        Boolean result = false;
        try {
            Select select = new Select(driver.findElement(By.className("title")));
            select.selectByVisibleText(value);
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditButton() {
        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickDeleteButton() {
        deleteBtn.click();
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
        return new MainApp();
    }

    @Override
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        return null;
    }

}
