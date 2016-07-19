package Pages.LookUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Pages.Base.AbstractSectionFrame;

/**
 * Created by ccatari on 5/22/2016.
 */
public class ListSectionFrame extends AbstractSectionFrame {
    @FindBy(className=" dataCell ")
    private WebElement linkToSelect;


    public ListSectionFrame(){
        driver.switchTo().frame("resultsFrame");
    }
    public void selectACampaignFromTheList() {
        wait.until(ExpectedConditions.visibilityOf(linkToSelect));
        linkToSelect.click();
        // it's not required to run to default due that the window is automatically closed.
    }
}
