package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.openqa.selenium.By;

/**
 * It is the account base page, abstract class.
 */
public class AccountHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        CommonActions.clickElement(createNewViewLink);
        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        CommonActions.clickElement(editViewLink);
        return new AccountForm();
    }

    /**
     * Method that makes click on Account link.
     *
     * @param accountName String with the account name.
     * @return {@AccountDetail}
     */
    public AccountDetail clickOnAccount(final String accountName) {
        CommonActions.clickElement(driver.findElement(By.linkText(accountName)));
        return new AccountDetail();
    }

    /**
     * This method finds the account name.
     *
     * @param accountName a string with account name.
     * @return {@link AccountDetail}.
     */
    public AccountDetail clickAccountName(final String accountName) {
        driver.findElement(By.xpath("//a[contains(.,'" + accountName + "')]")).click();
        return new AccountDetail();
    }

    /**
     * This method verify that account is displayed.
     *
     * @param account String with account.
     * @return returns <account>true<account/> if account is displayed or <account>false<account/> if it is not.
     */
    public boolean isAccountDisplayed(final String account) {
        return CommonActions.existElementByLinkText(account);
    }

}
