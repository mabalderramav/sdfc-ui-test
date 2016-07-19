package Pages.Base;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by ccatari on 5/22/2016.
 */
public class AbstractModalWindow extends AbstractBasePage{
    private LinkedList<String> windowsList;

    public void init(){
        Set<String> windowsHandleSet = driver.getWindowHandles();
        this.windowsList = new LinkedList<String>(windowsHandleSet);
        driver.switchTo().window(this.windowsList.getLast());
    }
    public void switchToParentWithoutCloseAction(){
        driver.switchTo().window(windowsList.getFirst());
    }
}
