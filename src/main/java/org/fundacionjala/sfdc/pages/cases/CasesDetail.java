package org.fundacionjala.sfdc.pages.cases;


import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AlvaroDaza on 10/19/2016.
 */
public class CasesDetail extends AbstractBasePage {

    @FindBy(css = "div[class=\"rsbody\"]")
    private WebElement cardElements;

    public String getSubject(String element) {
       // List<WebElement> list = cardElements.findElements(By.cssSelector("li[class=\"rsproperty\"]"));
       // list.stream().filter(webElement -> webElement.equals(element)).forEach(webElement -> webElement.getText());

        return null;

    }
}
