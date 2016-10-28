package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_SITE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.PHONE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.WEBSITE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.EMPLOYEES;

/**
 * This class content all the Account data.
 */
public class AccountDetail extends DetailBase {

    // Account fields
    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountName;
    @FindBy(id = "acc23_ileinner")
    @CacheLookup
    private WebElement accountSite;
    @FindBy(id = "acc10_ileinner")
    @CacheLookup
    private WebElement accountPhone;
    @FindBy(id = "acc12_ileinner")
    @CacheLookup
    private WebElement accountWebsite;
    @FindBy(id = "acc15_ileinner")
    @CacheLookup
    private WebElement accountEmployees;
    @FindBy(name = "delete")
    @CacheLookup
    private WebElement deleteButton;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MainApp clickDeleteButton() {
        CommonActions.clickElement(deleteButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return new MainApp();
    }

    /**
     * Returns the account name.
     *
     * @return String with account name
     */
    public String getName() {
        String accountName = this.accountName.getText();
        return accountName.substring(0, accountName.indexOf("[") - 1);
    }

    /**
     * Returns the account site.
     *
     * @return String with account site
     */
    private String getSite() {
        return accountSite.getText();
    }

    /**
     * Returns the account phone.
     *
     * @return String with account phone
     */
    private String getPhone() {
        return accountPhone.getText();
    }

    /**
     * Returns the account website.
     *
     * @return String with account website
     */
    private String getWebsite() {
        return accountWebsite.getText();
    }

    /**
     * Returns the account employees.
     *
     * @return String with account employees
     */
    private String getEmployees() {
        return accountEmployees.getText();
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of account edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();


        strategyMap.put(ACCOUNT_NAME.toString(), this::getName);
        strategyMap.put(ACCOUNT_SITE.toString(), this::getSite);
        strategyMap.put(PHONE.toString(), this::getPhone);
        strategyMap.put(WEBSITE.toString(), this::getWebsite);
        strategyMap.put(EMPLOYEES.toString(), this::getEmployees);

        return strategyMap;
    }

}
