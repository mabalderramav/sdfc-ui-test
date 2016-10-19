package org.fundacionjala.sfdc.pages.opportunities;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 26-06-15.
 */
public class OpportunitiesAbstractPage extends AbstractBasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;
    private String accountName;

    public OpportunitiesAbstractPage()
    {
        super();
    }

    public NewOpportunityForm clickNewButton() {
        CommonActions.clickElement(NewButtton);

        return new NewOpportunityForm();
    }

    public OpportunityProfile goOpportunityProfile(String url) {
        driver.navigate().to(url);

        return new OpportunityProfile();
    }

    public OpportunityProfile clickOnAccount(String accountName)
    {
        driver.findElement(By.linkText(accountName)).click();
        return new OpportunityProfile();
    }


}
