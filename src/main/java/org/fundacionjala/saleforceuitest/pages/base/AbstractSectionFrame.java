package org.fundacionjala.saleforceuitest.pages.base;

/**
 * Created by ccatari on 5/22/2016.
 */
public abstract class AbstractSectionFrame extends AbstractBasePage {
    public void returnDefault(){
        driver.switchTo().defaultContent();
    }
    public void returnRoot(){
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
    }
}
