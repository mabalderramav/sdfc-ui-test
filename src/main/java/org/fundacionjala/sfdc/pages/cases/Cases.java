package org.fundacionjala.sfdc.pages.cases;


import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by AlvaroDaza on 10/19/2016.
 */
public class Cases extends AbstractBasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    private WebElement NewButtton;
    private String accountName;


}
