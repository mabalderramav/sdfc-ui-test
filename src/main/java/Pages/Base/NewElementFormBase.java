package Pages.Base;

import Framework.FormBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Pablo Zubieta on 03/09/2015.
 */
public abstract class  NewElementFormBase extends FormBase {

    @FindBy(name = "save")
    protected WebElement saveBtn;

    @FindBy(name = "save_new")
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    protected WebElement cancelBtn;

    //Calendar
    @FindBy(id = "calMonthPicker")
    protected WebElement monthPicker;

    @FindBy(id = "calYearPicker")
    protected WebElement yearPicker;

    protected String[] months;

    protected abstract Object clickSaveBtn();
    protected abstract Object clickSaveNewBtn();
    protected abstract Object clickCancelBtn();

    protected void clickSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();

    }

    protected void clickSaveNewButton() {
        wait.until(ExpectedConditions.visibilityOf(saveNewBtn));
        saveNewBtn.click();

    }

    protected void clickCancelButton() {
        wait.until(ExpectedConditions.visibilityOf(cancelBtn));
        cancelBtn.click();

    }

    protected void selectDatePicker(Integer month, Integer day, Integer year){
        months = new String []{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.selectItemComboBox(monthPicker, months[month - 1]);
        this.selectItemComboBox(yearPicker, year.toString());
        WebElement selectDate = driver.findElement(
                By.xpath("//div[@class='calBody']/descendant::td[contains(.,'" + day + "')]"));
        selectDate.click();
    }

    protected void selectItemComboBox(WebElement webElement, String value){
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            Select comboBox = new Select(webElement);
            comboBox.selectByVisibleText(value);
        }
        catch(WebDriverException e){
            throw new WebDriverException("The value " + value + "couldn't be selected");
        }
    }
}
