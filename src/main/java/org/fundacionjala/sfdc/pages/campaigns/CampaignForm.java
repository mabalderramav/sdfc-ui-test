package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class CampaignForm extends FormBase {

    //region Locators

    @FindBy(id = "cpn1")
    @CacheLookup
    WebElement CampaingNameField;

    @FindBy(id = "cpn16")
    @CacheLookup
    WebElement ActiveCheckbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    WebElement typeDropdown;

    @FindBy(id = "cpn3")
    @CacheLookup
    WebElement statusDropdown;


    @FindBy(id = "cpn5")
    @CacheLookup
    WebElement startDateField;


    @FindBy(id = "cpn6")
    @CacheLookup
    WebElement endDateField;

    @FindBy(id = "Parent")
    @CacheLookup
    WebElement ParentCampaing;

    @FindBy(id = "Parent_lkwgt")
    @CacheLookup
    WebElement LookUpIcon;

    @FindBy(name = "save")
    @CacheLookup
    WebElement SaveButton;

    @FindBy(css = "a[tabindex=\"5\"]")
    @CacheLookup
    WebElement dateLink;

    @FindBy(className = "hotListElement")
    @CacheLookup
    WebElement allCampaigns;

    @FindBy(id = "cpn8")
    @CacheLookup
    WebElement revenueTextField;




    //endregion

    public CampaignForm setCampaingNameField(String text) {
        CommonActions.sendKeys(CampaingNameField, text);
        return this;
    }

    public CampaignForm checkActiveCheckbox() {
        CommonActions.check(ActiveCheckbox);
        return this;
    }

    public CampaignForm selectTypeDropdown(String item) {
        CommonActions.selectItem(typeDropdown, item);
        return this;
    }

    public CampaignForm selectStatusDropdown(String item) {
        CommonActions.selectItem(statusDropdown, item);
        return this;
    }



    public CampaignForm setStartDateField(String date) {
        CommonActions.sendKeys(startDateField, date);
        return this;
    }

    private CampaignForm setEndDateField(String endDate) {
        CommonActions.sendKeys(endDateField,endDate);
        CommonActions.clickElement(CampaingNameField);
        return this;
    }

    public CampaignLookup clickLookUpIcon() {
        CommonActions.clickElement(LookUpIcon);
        return new CampaignLookup();
    }
//    public CampaignDetail clickSaveButton() {
//        CommonActions.clickElement(SaveButton);
//        return new CampaignDetail();
//    }

    @Override
    public CampaignDetail clickSaveButton() {
        CommonActions.clickElement(SaveButton);
        return new CampaignDetail();
    }

    @Override
    public AbstractBasePage clickSaveNewButton() {

        return null;
    }

    public CampaignForm clickOnStartDate() {
        CommonActions.clickElement(dateLink);
        return new CampaignForm();
    }

//    public CampaignForm setDate(final Integer month,
//                                final Integer day,
//                                final Integer year) {
//        CommonActions.clickElement(startDateField);
//        selectDatePicker(month, day, year);
//        return new CampaignForm();
//    }


    public boolean campaingUpdate(String campaignUpdated) {
        List<WebElement> campaigns = allCampaigns.findElements(By.className("dataCell"));
        return campaigns.stream().filter(x -> x.equals(campaignUpdated)).findAny().isPresent();

    }
    /**
     * Method that to permit set values to create a new OpportunityHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();
        strategyMap.put("campaignName", () -> setCampaingNameField(String.valueOf(values.get("campaignName"))));
        strategyMap.put("active", this::checkActiveCheckbox);
        strategyMap.put("typeDropDown", () -> selectTypeDropdown(String.valueOf(values.get("typeDropDown"))));
        strategyMap.put("statusDropDown", () -> selectStatusDropdown(String.valueOf(values.get("statusDropDown"))));
        strategyMap.put("startDate", () -> setStartDateField(String.valueOf(values.get("startDate"))));
        strategyMap.put("endDate", () -> setEndDateField(String.valueOf(values.get("endDate"))));
        strategyMap.put("revenue", () -> setRevenue(String.valueOf(values.get("revenue"))));
        return strategyMap;
    }



    public void setRevenue(String quantity){
        CommonActions.clearTextField(revenueTextField);
        CommonActions.sendKeys(revenueTextField,quantity);
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
