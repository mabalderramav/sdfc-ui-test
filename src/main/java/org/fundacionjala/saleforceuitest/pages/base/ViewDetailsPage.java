package org.fundacionjala.saleforceuitest.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ViewDetailsPage extends DetailsPage {

    @FindBy(xpath = "//select[@class='title']")
    @CacheLookup
    protected WebElement ViewNameText;

    @FindBy(linkText = "Edit")
    @CacheLookup
    public WebElement editLink;

    @FindBy(linkText = "Delete")
    @CacheLookup
    public WebElement deleteLink;

    public String getViewName() {
        Select select = new Select(ViewNameText);
        return select.getFirstSelectedOption().getText();
    }


    public ViewFormBasePage clickEditViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(editLink));
        editLink.click();
        return new ViewFormBasePage();
    }

    /*
    public ElementFormBasePage clickDeleteViewLink() {
       // Todo    	
    }
    */
}