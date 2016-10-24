package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;

/**
 * Created by Pablo Zubieta on 27/08/2015.
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, Opportunity, Products
 */
public abstract class FormBase extends AbstractBasePage {
    @FindBy(name = "save")
    protected WebElement saveButton;

    @FindBy(name = "save_new")
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    protected WebElement cancelBtn;

    //Calendar
    @FindBy(id = "calMonthPicker")
    protected WebElement monthPicker;

    @FindBy(id = "calYearPicker")
    protected WebElement yearPicker;

    /**
     * Clicks on "save" button.
     *
     * @return {@link DetailBase}
     */
    public abstract AbstractBasePage clickSaveButton();

    /**
     * Clicks on "Save&New" button.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickSaveNewButton();

    /**
     * Clicks on "Cancel" button.
     */
    public void clickCancelButton() {
        CommonActions.clickElement(cancelBtn);
    }

    /**
     * Selects the month,year and date fields.
     *
     * @param month the month to be selected.
     * @param day   the day to be selected.
     * @param year  the year to be selected.
     */
    protected void selectDatePicker(final Integer month,
                                    final Integer day,
                                    final Integer year) {
        final String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        final int count = 1;
        CommonActions.selectItemByVisibleText(monthPicker, months[month - count]);
        CommonActions.selectItemByVisibleText(yearPicker, year.toString());
        WebElement selectDate = driver.findElement(
                By.xpath("//div[@class='calBody']/descendant::td[contains(.,'" + day + "')]"));
        CommonActions.clickElement(selectDate);
    }
}
