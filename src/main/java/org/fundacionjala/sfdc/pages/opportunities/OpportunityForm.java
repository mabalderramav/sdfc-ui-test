package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * This class represent to a form to create or edit a opportunity
 */
public class OpportunityForm extends FormBase {

    @FindBy(id = "opp2")
    @CacheLookup
    private WebElement activeFlagCheckBox;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opportunityNameTextField;

    @FindBy(id = "opp4")
    @CacheLookup
    private WebElement accountNameTextField;

    @FindBy(xpath = ".//*[@id='opp4_lkwgt']/img")
    @CacheLookup
    private WebElement accountNameLookupIconBtn;

    @FindBy(id = "opp5")
    @CacheLookup
    private WebElement selectTypeCheckBox;

    @FindBy(id = "opp6")
    @CacheLookup
    private WebElement selectLeadSourceCheckBox;

    @FindBy(id = "opp7")
    @CacheLookup
    private WebElement amountTextField;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement closeDateField;

    @FindBy(xpath = "//input[@id='opp9']/following::a")
    @CacheLookup
    private WebElement todayLink;

    @FindBy(id = "opp10")
    @CacheLookup
    private WebElement nextStepTextField;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement selectStageField;

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
     * {@link FormBase}
     */
    @Override
    public OpportunityDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new OpportunityDetail();
    }

    /**
     * {@link FormBase}
     */
    @Override
    public OpportunityDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new OpportunityDetail();
    }

    /**
     * This method checks in.
     *
     * @param flag Boolean with flag.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm checkPrivateFlag(final boolean flag) {
        if (!CommonActions.isSelected(activeFlagCheckBox) && flag) {
            CommonActions.clickElement(activeFlagCheckBox);
        }
        return this;
    }

    /**
     * This method sets a opportunity name.
     *
     * @param opportunityName is a boolean.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setOpportunityName(final String opportunityName) {
        CommonActions.sendKeys(opportunityNameTextField, opportunityName);
        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setAccountName(final String accountName) {
        CommonActions.sendKeys(accountNameTextField, accountName);
        return this;
    }

    /**
     * This method sets a type.
     *
     * @param type is a string type.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseTypeDdl(final String type) {
        Select selectBox = new Select(selectTypeCheckBox);
        selectBox.selectByVisibleText(type);

        return this;
    }

    /**
     * This method chooses leadSource.
     *
     * @param leadSource is a string type.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseLeadSourceDdl(final String leadSource) {
        Select selectBox = new Select(selectLeadSourceCheckBox);
        selectBox.selectByVisibleText(leadSource);
        return this;
    }

    /**
     * Thid method  sets amount.
     *
     * @param amount a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setAmount(final String amount) {
        CommonActions.sendKeys(amountTextField, amount);
        return this;
    }

    /**
     * This method  sets a close date
     *
     * @param closeDate a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setCloseDate(final String closeDate) {
        CommonActions.sendKeys(closeDateField, closeDate);
        return this;
    }

    /**
     * This method sets a close date by default.
     *
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setCurrentCloseDate() {
        closeDateField.clear();
        todayLink.click();
        return this;
    }

    /**
     * This method sets next step.
     *
     * @param nextStep is a string.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setNextStep(final String nextStep) {
        nextStepTextField.clear();
        nextStepTextField.sendKeys(nextStep);
        return this;
    }

    /**
     * This method selects a stage.
     *
     * @param stage is a string to select.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseStageDdl(final String stage) {
        Select selectBox = new Select(selectStageField);
        selectBox.selectByVisibleText(stage);
        return this;
    }

    /**
     * This method sets a probability to opportunity/
     * @param probability a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setProbability(final String probability) {
        CommonActions.sendKeys(nextStepTextField, probability);
        return this;
    }

    /**
     * This method sets a probability to opportunity/
     * @param primaryCampaignSource
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setPrimaryCampaignSource(final String primaryCampaignSource) {
        CommonActions.sendKeys(primaryCampaignSourceTextBox, primaryCampaignSource);
        return this;
    }

    /**
     * This method is to add information.
     *
     * @param orderNumber is a string to add.
     * @return {@link OpportunityForm}
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
     * @return {@link OpportunityForm}
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
     * @return {@link OpportunityForm}
     */
    public OpportunityForm setDescription(final String description) {
        CommonActions.sendKeys(descriptionTextArea, description);
        return this;
    }

    /**
     * This method makes click on account name.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickAccountNameLookUpIcon() {
        CommonActions.clickElement(accountNameLookupIconBtn);
        return new LookUpWindow();
    }

    /**
     * This method marks click on primary campaingn.
     *
     * @return {@link LookUpWindow}.
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
        strategyMap.put("currentCloseDate", () -> setCloseDate(String.valueOf(values.get("currentCloseDate"))));
        strategyMap.put("PrivateFlag", () -> checkPrivateFlag(Boolean.valueOf(values.get("PrivateFlag"))));

        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     */
    public void fillTheForm(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
