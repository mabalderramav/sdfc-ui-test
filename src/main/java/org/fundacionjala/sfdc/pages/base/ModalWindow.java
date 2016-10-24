package org.fundacionjala.sfdc.pages.base;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by ccatari on 5/22/2016.
 */
public class ModalWindow extends AbstractBasePage{
    private LinkedList<String> windowsList;

    /**
     * Saves the flow between windows to advance, change or return to a window.
     */
    public void init(){
        Set<String> windowsHandleSet = driver.getWindowHandles();
        this.windowsList = new LinkedList<String>(windowsHandleSet);
        driver.switchTo().window(this.windowsList.getLast());
    }

    /**
     * Switch from the actual window to the parent window, without close it.
     */
    public void switchToParentWithoutCloseAction(){
        driver.switchTo().window(windowsList.getFirst());
    }
}
