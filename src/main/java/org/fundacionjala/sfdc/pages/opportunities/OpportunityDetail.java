package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ivan on 26-06-15.
 */
public class OpportunityDetail extends AbstractBasePage {

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



    /**
     * This method makes click on delete button.
     *
     * @return main app.
     */
    public MainApp clickDeteleBtn() {
        CommonActions.clickElement(deleteBtn);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new MainApp();
    }

    /**
     * This method makes a click on edit button.
     *
     * @return a opportunity form.
     */
    public OpportunityForm clickEditBtn() {
        CommonActions.clickElement(editBtn);
        return new OpportunityForm();
    }

    public OpportunityForm pressEditBtn() {
        editBtn.click();

        return new OpportunityForm();
    }

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
     * @return a string with delivery install text.
     */
    public String getDeliveryInstallation() {
        return deliveryInstallLabel.getText();
    }

    /**
     * This method verify if opportunity is displayed.
     *
     * @param Opportunity string with name opportunity.
     * @return a boolean.
     */
    public boolean isOpportunityDisplayed(String Opportunity) {
        try {
            driver.findElement(By.linkText(Opportunity));
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of opportunity edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap();

        strategyMap.put("opportunityName", this::getOpportunityName);
        strategyMap.put("stage", this::getStage);
        strategyMap.put("orderNumber", this::getOrderNumber);
        strategyMap.put("deliveryInstallStatus", this::getDeliveryInstallation);
        strategyMap.put("accountName", this::getAccountName);

        return strategyMap;
    }

}
