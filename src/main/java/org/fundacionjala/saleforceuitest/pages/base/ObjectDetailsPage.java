package org.fundacionjala.saleforceuitest.pages.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ObjectDetailsPage extends DetailsPage{
	@FindBy(className = "topName")
    @CacheLookup
    protected WebElement objectNameText;

    @FindBy(className = "pageDescription")
    @CacheLookup
    protected WebElement pageDescriptionText;

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editButton;

    @FindBy(name = "delete")
    @CacheLookup
    protected WebElement deleteAccountButton;

    @FindBy(name = "del")
    @CacheLookup
    protected WebElement deleteOppButton;


    public String getObjectName() {
        return objectNameText.getText();
    }

    public String getPageDescription() {
        return pageDescriptionText.getText();
    }

    public ObjectFormPage clickEditButton() {
        wait.until(ExpectedConditions
                .visibilityOf(editButton));
        editButton.click();
        return new ObjectFormPage();
    }

    /*
    public ElementFormBasePage clickDeleteButton() {
        //todo
    }
    */    

}
