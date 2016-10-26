package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.*;

/**
 * This class represents of the opportunity detail.
 */
public class OpportunityDetail extends DetailBase {

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement opportunityNameLabel;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement accountNameLabel;

    @FindBy(id = "opp5_ileinner")
    @CacheLookup
    private WebElement typeLabel;

    @FindBy(id = "opp6_ileinner")
    @CacheLookup
    private WebElement leadSourceLabel;

    @FindBy(id = "opp7_ileinner")
    @CacheLookup
    private WebElement amountLabel;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDateLabel;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    private WebElement nextStepLabel;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement stageLabel;

    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::div")
    @CacheLookup
    private WebElement orderNumberLabel;

    @FindBy(xpath = "//td[contains(.,'Delivery/Installation Status')]/following::div")
    @CacheLookup
    private WebElement deliveryInstallLabel;

    @FindBy(id = "opp2_chkbox")
    @CacheLookup
    private WebElement privateFlagImg;

    /**
     * {@link DetailBase}
     */
    @Override
    public OpportunityForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new OpportunityForm();
    }

    /**
     * {@link DetailBase}
     */
    @Override
    public MainApp clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new MainApp();
    }

    /**
     * This method compare the title.
     *
     * @return a boolean.
     */
    public boolean isPrivateFlag() {
        String attributeState = privateFlagImg.getAttribute("title");
        return attributeState.equals("Checked");
    }

    /**
     * This method gets the opportunity name.
     *
     * @return a string with opportunity name text.
     */
    public String getOpportunityName() {
        return opportunityNameLabel.getText();
    }

    /**
     * This method gets the account name.
     *
     * @return a string with account name text.
     */
    public String getAccountName() {
        return accountNameLabel.getText();
    }

    /**
     * This method gets the close date.
     *
     * @return a string with the close date text.
     */
    public String getCloseDate() {
        return closeDateLabel.getText();
    }

    /**
     * This method gets the stage.
     *
     * @return a string with stage text.
     */
    public String getStage() {
        return stageLabel.getText();
    }

    /**
     * This method gets the order number.
     *
     * @return a string with order number text.
     */
    public String getOrderNumber() {
        return orderNumberLabel.getText();
    }

    /**
     * This method gets the delivery install.
     *
     * @return a string with delivery install label
     */
    public String getDeliveryInstallation() {
        return deliveryInstallLabel.getText();
    }

    /**
     * This method gets the amount label.
     *
     * @return a string with amount label.
     */
    public String getAmount() {
        return amountLabel.getText();
    }

    /**
     * This method gets the type label.
     *
     * @return a string with type label.
     */
    public String getTypeText() {
        return typeLabel.getText();
    }

    /**
     * This method gets the lead source label.
     *
     * @return a string with lead source label.
     */
    public String getLeadSource() {
        return leadSourceLabel.getText();
    }

    /**
     * This method gets the delivery install.
     *
     * @return a string with delivery install text.
     */
    public String getNextStep() {
        return nextStepLabel.getText();
    }

    /**
     * This method verify if opportunity is displayed.
     *
     * @param opportunityName string with name opportunity.
     * @return a boolean.
     */
    public boolean isOpportunityDisplayed(String opportunityName) {
        try {
            driver.findElement(By.linkText(opportunityName)).getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of opportunity edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(OPPORTUNITY_NAME.VALUE, this::getOpportunityName);
        strategyMap.put(STAGE.VALUE, this::getStage);
        strategyMap.put(ORDER_NUMBER.VALUE, this::getOrderNumber);
        strategyMap.put(DELIVERY_INSTALL_STATUS.VALUE, this::getDeliveryInstallation);
        strategyMap.put(ACCOUNT_NAME.VALUE, this::getAccountName);
        strategyMap.put(CURRENT_CLOSE_DATE.VALUE, this::getCloseDate);
        strategyMap.put(TYPE.VALUE, this::getTypeText);
        strategyMap.put(LEAD_SOURCE.VALUE, this::getLeadSource);
        strategyMap.put(NEXT_STEP.VALUE, this::getNextStep);
        strategyMap.put(AMOUNT.VALUE, this::getAmount);

        return strategyMap;
    }

}
