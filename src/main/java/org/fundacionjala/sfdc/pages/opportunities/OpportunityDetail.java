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

    //endregion

    public MainApp clickDeteleBtn() {
        CommonActions.clickElement(deleteBtn);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new MainApp();
    }

    public OpportunityForm clickEditBtn() {
        CommonActions.clickElement(editBtn);
        return new OpportunityForm();
    }

    public OpportunityForm pressEditBtn() {
        editBtn.click();

        return new OpportunityForm();
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
    public boolean isOpportunityDisplayed(String Opportunity) {
        WebElement opportunityContainer;
        try {
            opportunityContainer = driver.findElement(By.linkText(Opportunity));
        } catch(WebDriverException e) {
            return false;
        }
        return isElementPresent(opportunityContainer);

    }
    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap();

        strategyMap.put("opportunityName",()-> getOpportunityName().toString());
        strategyMap.put("stage", ()-> getStage().toString());
        strategyMap.put("orderNumber", ()-> getOrderNumber().toString());
        strategyMap.put("deliveryInstallStatus", ()-> getDeliveryInstallation().toString());
        strategyMap.put("accountName", ()-> getAccountName().toString());

        return strategyMap;
    }

}
