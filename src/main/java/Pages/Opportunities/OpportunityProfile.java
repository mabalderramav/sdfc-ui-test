package Pages.Opportunities;

import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 26-06-15.
 */
public class OpportunityProfile {

    private WebDriver       driver;
    private WebDriverWait   wait;

    //region Locators

    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editBtn;

    //Opportunity Name
    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement opportunityNameLabel;

    //Account Name
    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement accountNameLabel;

    //Close Date
    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDateLabel;

    //Stage
    @FindBy(id = "opp11_ilecell")
    @CacheLookup
    private WebElement stageLabel;

    //Order Number
    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::div")
    @CacheLookup
    private WebElement orderNumberLabel;

    //Delivery/Installation Status
    @FindBy(xpath = "//td[contains(.,'Delivery/Installation Status')]/following::div")
    @CacheLookup
    private WebElement deliveryInstallLabel;

    // private Flag
    @FindBy(id = "opp2_chkbox")
    @CacheLookup
    private WebElement privateFlagImg;

    //endregion


    public OpportunityProfile(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public void pressDeleteBtn() {
        deleteBtn.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public NewOpportunityForm pressEditBtn() {
        editBtn.click();

        return new NewOpportunityForm(driver);
    }

    public boolean isPrivateFlag() {
        boolean result = false;
        String attributeState = privateFlagImg.getAttribute("title");

        if (attributeState.equals("Checked"))
        {
            result = true;
        }

        return result;
    }

    //region getters

    //Opportunity Name
    public String getOpportunityName() {
        return opportunityNameLabel.getText();
    }

    //Account Name
    public String getAccountName() {
        return accountNameLabel.getText();
    }

    //Close Date
    public String getCloseDate() {
        return closeDateLabel.getText();
    }

    //Stage
    public String getStage() {
        return stageLabel.getText();
    }

    //Order Number
    public String getOrderNumber() {
        return orderNumberLabel.getText();
    }

    //Delivery/Installation Status
    public String getDeliveryInstallation() {
        return deliveryInstallLabel.getText();
    }
    //endregion

}
