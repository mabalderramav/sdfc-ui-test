package org.fundacionjala.sfdc.pages.opportunities;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents to opportunity pages.
 */
public class Opportunity extends AbstractBasePage {

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;

    /**
     * This method makes click in new button in opportunity page.
     *
     * @return a opportunity form page object.
     */
    public OpportunityForm clickNewButton() {
        CommonActions.clickElement(NewButtton);
        return new OpportunityForm();
    }

    /**
     * This method goes a opportunity detail.
     *
     * @param url a string with url of the page.
     * @return OpportunityDetail page object.
     */
    public OpportunityDetail goOpportunityDetail(String url) {
        driver.navigate().to(url);
        return new OpportunityDetail();
    }

    /**
     * This method makes click on account link.
     *
     * @param accountName a string with name account.
     * @return OpportunityDetail page object.
     */
    public OpportunityDetail clickOnAccount(String accountName) {
        driver.findElement(By.linkText(accountName)).click();
        return new OpportunityDetail();
    }

}
