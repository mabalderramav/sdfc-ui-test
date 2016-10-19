package org.fundacionjala.saleforceuitest.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class ElementFormBasePage extends AbstractBasePage {


    @FindBy(name = "new")
    protected WebElement newElementBtn;

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newButton;

    @FindBy(linkText = "Create New View")
    @CacheLookup
    private WebElement createNewViewLink;

    @FindBy(linkText = "Edit")
    @CacheLookup
    private WebElement editViewLink;


    public ObjectFormPage clickNewButton() {
        wait.until(ExpectedConditions
                .visibilityOf(newButton));
        newButton.click();
        return new ObjectFormPage();
    }

    public ViewFormBasePage clickCreateNewViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(createNewViewLink));
        createNewViewLink.click();
        return new ViewFormBasePage();
    }

    public ViewFormBasePage clickEditViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(editViewLink));
        editViewLink.click();
        return new ViewFormBasePage();
    }

    @SuppressWarnings("finally")
	public Boolean existByLinkText(String value)
    {
        Boolean result = false;
        try {
            driver.findElement(By.linkText(value));
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }

}