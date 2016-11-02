package org.fundacionjala.sfdc.pages.lookup;

import java.util.LinkedList;
import java.util.Set;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * Class to Manage the emergent windows.
 */
class ModalWindow extends AbstractBasePage {

    private LinkedList<String> windowsList;

    /**
     * Saves the flow between windows to advance, change or return to a window.
     */
    void init() {
        Set<String> windowsHandleSet = driver.getWindowHandles();
        windowsList = new LinkedList<>(windowsHandleSet);
        driver.switchTo().window(windowsList.getLast());
    }

    /**
     * Switch from the actual window to the parent window, without close it.
     */
    void switchToParentWithoutCloseAction() {
        driver.switchTo().window(windowsList.getFirst());
    }
}
