package Framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Miguel.Pari on 6/24/2015.
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


    //Select dropdown = new Select(driver.findElement(By.id("identifier")));

}
