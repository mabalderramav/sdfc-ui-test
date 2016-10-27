package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.CommonActions;

/**
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, ContractFields, Products.
 */
public abstract class FormBase extends AbstractBasePage {

    @FindBy(name = "save")
    protected WebElement saveButton;

    @FindBy(name = "save_new")
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    protected WebElement cancelBtn;

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
}
