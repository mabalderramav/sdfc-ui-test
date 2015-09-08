package Pages.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class ElementFormBase extends FormBase{


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

    public ElementFormBase(WebDriver driver) {
        super(driver);
    }

    public ObjectFormPage clickNewButton() {
        wait.until(ExpectedConditions
                .visibilityOf(newButton));
        newButton.click();
        return new ObjectFormPage();
    }

    public ViewFormPage clickCreateNewViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(createNewViewLink));
        createNewViewLink.click();
        return new ViewFormPage();
    }

    public ViewFormPage clickEditViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(editViewLink));
        editViewLink.click();
        return new ViewFormPage();
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