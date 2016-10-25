package org.fundacionjala.sfdc.pages.lookup;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

public abstract class SectionFrame extends AbstractBasePage {

    /**
     * Returns to the current window.
     */
    public void returnRoot() {
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
    }

    /**
     * Returns to the content by default window.
     */
    public void returnDefault() {
        driver.switchTo().defaultContent();
    }
}
