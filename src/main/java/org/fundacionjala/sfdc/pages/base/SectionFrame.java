package org.fundacionjala.sfdc.pages.base;

/**
 * Created by ccatari on 5/22/2016.
 */
public abstract class SectionFrame extends AbstractBasePage {

    /**
     * Returns to the current window.
     */
    public void returnRoot(){
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
    }

    /**
     * Returns to the content by default window.
     */
    public void returnDefault(){
        driver.switchTo().defaultContent();
    }
}
