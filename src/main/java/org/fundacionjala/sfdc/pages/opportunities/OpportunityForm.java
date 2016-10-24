package org.fundacionjala.sfdc.pages.opportunities;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represent to a form to create or edit a opportunity
 */
public class OpportunityForm extends AbstractBasePage {


    /* Top Button Row */
    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    /* OpportunityHome Information */
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

    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::input")
    @CacheLookup
    private WebElement orderNumberTextBox;

    @FindBy(xpath = "//td[contains(.,'Delivery')]/following::span/select")
    @CacheLookup
    private WebElement multiSelectDeliveryInstallationStatus;

    @FindBy(id = "opp14")
    @CacheLookup
    private WebElement descriptionTextArea;

    /**
     * This method checks private config.
     *
     * @param flag is a boolean.
     * @return a opportunity form.
     */
    public OpportunityForm checkPrivateFlag(final boolean flag) {
        if (!privateFlag.isSelected() && flag) {
            privateFlag.click();
        }
        return this;
    }

    /**
     * This method unchecks private config.
     *
     * @param flag is a boolean.
     * @return a opportunity form.
     */
    public OpportunityForm uncheckPrivateFlag(final boolean flag) {

        if (privateFlag.isSelected() && flag) {
            privateFlag.click();
        }

        return this;
    }

    /**
     * This method sets a opportunity name.
     *
     * @param opportunityName is a boolean.
     * @return a opportunity form.
     */
    public OpportunityForm setOpportunityName(final String opportunityName) {
        opportunityNameTextBox.clear();
        opportunityNameTextBox.sendKeys(opportunityName);

        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return a opportunity form.
     */
    public OpportunityForm setAccountName(final String accountName) {
        accountNameTextBox.clear();
        accountNameTextBox.sendKeys(accountName);

        return this;
    }

    /**
     * This method sets a type.
     *
     * @param type is a string type.
     * @return a opportunity form.
     */
    public OpportunityForm chooseTypeDdl(final String type) {
        Select selectBox = new Select(multiSelectType);
        selectBox.selectByVisibleText(type);

        return this;
    }

    /**
     * This method chooses leadSource.
     *
     * @param leadSource is a string type.
     * @return a opportunity form.
     */
    public OpportunityForm chooseLeadSourceDdl(final String leadSource) {
        Select selectBox = new Select(multiSelectLeadSource);
        selectBox.selectByVisibleText(leadSource);
        return this;
    }

    /**
     * Thid method  sets amount.
     *
     * @param amount a string to set.
     * @return a opportunity form.
     */
    public OpportunityForm setAmount(final String amount) {
        amountTextBox.clear();
        amountTextBox.sendKeys(amount);
        return this;
    }

    /**
     * This method  sets a close date
     *
     * @param closeDate a string to set.
     * @return a opportunity form..
     */
    public OpportunityForm setCloseDate(final String closeDate) {
        closeDateTextBox.clear();
        closeDateTextBox.sendKeys(closeDate);
        return this;
    }

    /**
     * This method sets a close date by default.
     *
     * @return a opportunity form.
     */
    public OpportunityForm setCurrentCloseDate() {
        closeDateTextBox.clear();
        todayLink.click();
        return this;
    }

    /**
     * This method sets next step.
     *
     * @param nextStep is a string.
     * @return a opportunity form.
     */
    public OpportunityForm setNextStep(final String nextStep) {
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(nextStep);
        return this;
    }

    /**
     * This method selects a stage.
     *
     * @param stage is a string to select.
     * @return a opportunity form.
     */
    public OpportunityForm chooseStageDdl(final String stage) {
        Select selectBox = new Select(multiSelectStage);
        selectBox.selectByVisibleText(stage);

        return this;
    }

    public OpportunityForm setProbability(final String probability) {
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(probability);

        return this;
    }

    public OpportunityForm setPrimaryCampaignSource(final String primaryCampaignSource) {
        primaryCampaignSourceTextBox.clear();
        primaryCampaignSourceTextBox.sendKeys(primaryCampaignSource);

        return this;
    }

    /**
     * This method is to add information.
     *
     * @param orderNumber is a string to add.
     * @return a opportunity form.
     */
    public OpportunityForm setOrderNumber(final String orderNumber) {
        orderNumberTextBox.clear();
        orderNumberTextBox.sendKeys(orderNumber);
        return this;
    }

    /**
     * This method chooses install status.
     *
     * @param deleveryInstallationStatus a string to choose.
     * @return a opportunity form.
     */
    public OpportunityForm chooseDeliveryInstallationStatusDdl(final String deleveryInstallationStatus) {
        Select selectBox = new Select(multiSelectDeliveryInstallationStatus);
        selectBox.selectByVisibleText(deleveryInstallationStatus);
        return this;
    }

    /**
     * This method sets a description
     *
     * @param description a string to sets.
     * @return a opportunity form.
     */
    public OpportunityForm setDescription(final String description) {
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);
        return this;
    }

    /**
     * This method makes click to save button.
     *
     * @return OpportunityHome Detail page object.
     */
    public OpportunityDetail pressSaveBtn() {
        saveBtn.click();
        return new OpportunityDetail();
    }

    /**
     * This method makes click on account name.
     *
     * @return LookUpWindow object.
     */
    public LookUpWindow clickAccountNameLookUpIcon() {
        CommonActions.clickElement(accountNameLookupIconBtn);
        return new LookUpWindow();
    }

    /**
     * This method maks click on primary campaingn.
     *
     * @returnLookUpWindow object.
     */
    public LookUpWindow clickPrimaryCampaignSrcLookUpIcon() {
        CommonActions.clickElement(primaryCampaignSourceLookupIconBtn);
        return new LookUpWindow();
    }

    /**
     * Method that to permit set values to create a new OpportunityHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();

        strategyMap.put("opportunityName", () -> setOpportunityName(String.valueOf(values.get("opportunityName"))));
        strategyMap.put("type", () -> chooseTypeDdl(String.valueOf(values.get("type"))));
        strategyMap.put("leadSource", () -> chooseLeadSourceDdl(String.valueOf(values.get("leadSource"))));
        strategyMap.put("amount", () -> setAmount(String.valueOf(values.get("amount"))));
        strategyMap.put("nextStep", () -> setNextStep(String.valueOf(values.get("nextStep"))));
        strategyMap.put("stage", () -> chooseStageDdl(String.valueOf(values.get("stage"))));
        strategyMap.put("orderNumber", () -> setOrderNumber(String.valueOf(values.get("orderNumber"))));
        strategyMap.put("deliveryInstallStatus", () -> chooseDeliveryInstallationStatusDdl(String.valueOf(values.get("deliveryInstallStatus"))));
        strategyMap.put("accountName", () -> setAccountName(String.valueOf(values.get("accountName"))));
        strategyMap.put("CurrentCloseDate", () -> setCloseDate(String.valueOf(values.get("CurrentCloseDate"))));
        strategyMap.put("PrivateFlag", () -> checkPrivateFlag(Boolean.valueOf(values.get("PrivateFlag"))));

        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate
     */
    public void fillTheForm(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
