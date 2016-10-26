package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * It is the account base page, abstract class.
 *
 * {@link FormBase}
 */
public class AccountViewForm extends FormBase {
    @FindBy(id = "fname")
    @CacheLookup
    private WebElement viewNameText;

    @FindBy(id = "devname")
    @CacheLookup
    private WebElement viewUniqueNameText;

    @FindBy(id = "fcol1")
    @CacheLookup
    private WebElement filterAccountName;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement filterAccountOption;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement filterAccountValue;

    @FindBy(id = "fscope1")
    @CacheLookup
    private WebElement myAccountsRadioButton;

    @FindBy(id = "colselector_select_0")
    @CacheLookup
    private WebElement availableFields;

    @FindBy(id = "colselector_select_1")
    @CacheLookup
    private WebElement selectedFields;

    /**
     * This method set the view account name in the text field.
     *
     * @param viewName String with the view name.
     * @return Return this class.
     */
    public AccountViewForm setViewNameText(String viewName) {
        CommonActions.sendKeys(viewNameText, viewName);
        return this;
    }

    /**
     * This method set the unique view account name.
     *
     * @param uniqueName String with the unique view name.
     * @return Return this class.
     */
    public AccountViewForm setViewUniqueNameText(String uniqueName) {
        CommonActions.sendKeys(viewUniqueNameText, uniqueName);
        return this;
    }

    /**
     * This method set the accounts who will be able to see this view.
     *
     * @return Return this class.
     */
    public AccountViewForm setMyAccounts() {
        CommonActions.clickElement(myAccountsRadioButton);
        return this;
    }

    /**
     * {@link AccountForm}
     */
    @Override
    public AccountForm clickSaveButton() {
        return new AccountForm();
    }

    /**
     * {@link AccountForm}
     */
    @Override
    public AccountForm clickSaveNewButton() {
        return new AccountForm();
    }
}
