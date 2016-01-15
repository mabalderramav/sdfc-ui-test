package Framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Miguel.Pari on 6/24/2015.
 *
 * Updated by Pablo Zubieta on 27/08/2015.
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, Opportunity, Products
 */

public class CommonActions {

    public static void click(WebElement element)
    {
        element.click();
    }


    public static void setValue(WebElement element, String text)
    {
    	element.clear();
        element.sendKeys(text);
    }
    public static void selectItem(WebElement element, String item)
    {
        Select dropdown = new Select(element);
        dropdown.selectByValue(item);
    }

    public static void check(WebElement element)
    {
        if(!element.isSelected())
        {
            element.click();
        }
    }

    public static void deleteMe(WebDriver driver) {
        WebElement deleteElementBtn;
        deleteElementBtn = driver.findElement(By.xpath("//input[@title='Delete']"));
        deleteElementBtn.click();
        Alert deleteAlert = driver.switchTo().alert();
        deleteAlert.accept();
    }

}
