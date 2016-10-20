package org.fundacionjala.sfdc.framework.common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.framework.browser.DriverManager;


/**
 * Created by Miguel.Pari on 6/24/2015.
 * <p>
 * Updated by Pablo Zubieta on 27/08/2015.
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, Opportunity, Products
 */
public final class CommonActions {


    /**
     * Constructor private.
     */
    private CommonActions() {
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param element Element to wait and clickElement.
     */
    public static void clickElement(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    /**
     * This method waits and fill the element.
     *
     * @param element Element to wait and fill.
     * @param text    text to fill.
     */
    public static void sendKeys(final WebElement element, final String text) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method waits and clear the element.
     *
     * @param element Element to wait and clear.
     */
    public static void clearTextField(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    /**
     * This method waits and select the item.
     *
     * @param element Element to wait.
     * @param item    Item to selected.
     */
    public static void selectItem(final WebElement element, final String item) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByValue(item);
    }

    /**
     * This method waits and check the element.
     *
     * @param element Element to wait and check.
     */
    public static void check(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * This method verify that element is selected.
     *
     * @param element WebElement with element.
     * @return Return true if element is selected.
     */
    public static boolean isSelected(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        return element.isSelected();
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param element Element to wait and clickElement.
     * @return text to element.
     */
    public static String getText(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * This method waits and delete the element.
     *
     * @param driver Driver to wait and deleted elements.
     */
    public static void deleteMe(final WebDriver driver) {
        WebElement deleteElementBtn;
        deleteElementBtn = driver.findElement(By.xpath("//input[@title='Delete']"));
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(deleteElementBtn));
        deleteElementBtn.click();
        Alert deleteAlert = driver.switchTo().alert();
        deleteAlert.accept();
    }

}
