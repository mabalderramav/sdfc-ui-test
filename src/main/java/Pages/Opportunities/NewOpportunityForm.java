package Pages.Opportunities;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.LookUp.LookUpWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by ivan on 26-06-15.
 */
public class NewOpportunityForm {

    private WebDriver       driver;
    private WebDriverWait   wait;

    // to manage window popup
    private String          mainWindowId;
    private Set<String>     windows;

    //region Locators

    /* Top Button Row */
    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    /* Opportunity Information */
    @FindBy(id = "opp2")
    @CacheLookup
    private WebElement privateFlag;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opportunityNameTextBox;

    @FindBy(id = "opp4")
    @CacheLookup
    private WebElement accountNameTextBox;

    @FindBy(xpath = ".//*[@id='opp4_lkwgt']/img")
    @CacheLookup
    private WebElement accountNameLookupIconBtn;

    //@FindBy(id = "opp4_lkwgt")
    //@CacheLookup
    //private WebElement accountNameLookupIconBtn;

    @FindBy(id = "opp5")
    @CacheLookup
    private WebElement multiSelectType;

    @FindBy(id = "opp6")
    @CacheLookup
    private WebElement multiSelectLeadSource;

    @FindBy(id = "opp7")
    @CacheLookup
    private WebElement amountTextBox;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement closeDateTextBox;

    @FindBy(xpath = "//input[@id='opp9']/following::a")
    @CacheLookup
    private WebElement todayLink;

    @FindBy(id = "opp10")
    @CacheLookup
    private WebElement nextStepTextBox;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement multiSelectStage;

    @FindBy(id = "opp12")
    @CacheLookup
    private WebElement probabilityTextBox;

    @FindBy(id = "opp17")
    @CacheLookup
    private WebElement primaryCampaignSourceTextBox;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    private WebElement primaryCampaignSourceLookupIconBtn;

    /* Additional Information */
    // TODO: change it to xpath locator

    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::input")
    @CacheLookup
    private WebElement orderNumberTextBox;

    @FindBy(xpath = "//td[contains(.,'Delivery')]/following::span/select")
    @CacheLookup
    private WebElement multiSelectDeliveryInstallationStatus;

    /* Description Information */

    @FindBy(id = "opp14")
    @CacheLookup
    private WebElement descriptionTextArea;

    //endregion

    public NewOpportunityForm() {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        mainWindowId = driver.getWindowHandle();

    }

    // TODO: Implement method to switch to popup window

    /* Set Opportunity Information */
    public NewOpportunityForm checkPrivateFlag(boolean flag) {

        if (!privateFlag.isSelected() && flag) {
            privateFlag.click();
        }

        return this;
    }

    public NewOpportunityForm uncheckPrivateFlag(boolean flag) {

        if (privateFlag.isSelected() && flag) {
            privateFlag.click();
        }

        return this;
    }

    public NewOpportunityForm setOpportunityName(String opportunityName) {
        opportunityNameTextBox.clear();
        opportunityNameTextBox.sendKeys(opportunityName);

        return this;
    }

    public NewOpportunityForm setAccountName(String accountName) {
        accountNameTextBox.clear();
        accountNameTextBox.sendKeys(accountName);

        return this;
    }

    public NewOpportunityForm chooseTypeDdl(String type) {
        Select selectBox = new Select(multiSelectType);
        selectBox.selectByVisibleText(type);

        return this;
    }

    public NewOpportunityForm chooseLeadSourceDdl(String leadSource) {
        Select selectBox = new Select(multiSelectLeadSource);
        selectBox.selectByVisibleText(leadSource);

        return this;
    }

    public NewOpportunityForm setAmount(String amount) {
        amountTextBox.clear();
        amountTextBox.sendKeys(amount);

        return this;
    }

    public NewOpportunityForm setCloseDate(String closeDate) {
        closeDateTextBox.clear();
        closeDateTextBox.sendKeys(closeDate);

        return this;
    }

    public NewOpportunityForm setCurrentCloseDate() {
        closeDateTextBox.clear();
        todayLink.click();

        return this;
    }

    public NewOpportunityForm setNextStep(String nextStep) {
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(nextStep);

        return this;
    }

    public NewOpportunityForm chooseStageDdl(String stage) {
        Select selectBox = new Select(multiSelectStage);
        selectBox.selectByVisibleText(stage);

        return this;
    }

    public NewOpportunityForm setProbability(String probability) {
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(probability);

        return this;
    }

    public NewOpportunityForm setPrimaryCampaignSource(String primaryCampaignSource) {
        primaryCampaignSourceTextBox.clear();
        primaryCampaignSourceTextBox.sendKeys(primaryCampaignSource);

        return this;
    }

    /* Set Additional Information */
    public NewOpportunityForm setOrderNumber(String orderNumber) {
        orderNumberTextBox.clear();
        orderNumberTextBox.sendKeys(orderNumber);

        return this;
    }

    public NewOpportunityForm chooseDeliveryInstallationStatusDdl(String deleveryInstallationStatus) {
        Select selectBox = new Select(multiSelectDeliveryInstallationStatus);
        selectBox.selectByVisibleText(deleveryInstallationStatus);

        return this;
    }

    /* Description Information */
    public NewOpportunityForm setDescription(String description) {
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);

        return this;
    }

    /* Save form */
    public OpportunityProfile pressSaveBtn() {
        saveBtn.click();

        return new OpportunityProfile();
    }

    public LookUpWindow clickAccountNameLookUpIcon() {
        CommonActions.click(accountNameLookupIconBtn);

        return new LookUpWindow(driver);
    }

    public LookUpWindow clickPrimaryCampaignSrcLookUpIcon() {
        CommonActions.click(primaryCampaignSourceLookupIconBtn);

        return new LookUpWindow(driver);
    }
}
