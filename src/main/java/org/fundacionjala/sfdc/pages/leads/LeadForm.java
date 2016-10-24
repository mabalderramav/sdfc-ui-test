package org.fundacionjala.sfdc.pages.leads;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.framework.objects.Lead;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBasePage;

/**
 * This class represent the Form to create a new LeadHome.
 */
public class LeadForm extends FormBasePage {

    public static final String LEAD_DATA_PATH = "src\\test\\resources\\json\\CreateLeadData.json";

    @FindBy(id = "name_lastlea2")
    @CacheLookup
    private WebElement lastNameField;
    @FindBy(id = "lea13")
    @CacheLookup
    private WebElement leadStatusField;
    @FindBy(id = "lea3")
    @CacheLookup
    private WebElement companyField;
    @FindBy(id = "name_firstlea2")
    @CacheLookup
    private WebElement firstNameField;
    @FindBy(id = "lea16street")
    @CacheLookup
    private WebElement streetField;
    @FindBy(id = "lea16city")
    @CacheLookup
    private WebElement leadCityField;
    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveButton;
    @FindBy(xpath = "//input[@id='lea20']")
    @CacheLookup
    private WebElement campaingLookupField;
    @FindBy(id = "name_salutationlea2")
    @CacheLookup
    private WebElement nameSalutationField;
    @FindBy(id = "lea4")
    @CacheLookup
    private WebElement titleField;
    @FindBy(id = "lea5")
    @CacheLookup
    private WebElement leadSourceField;
    @FindBy(id = "lea6")
    @CacheLookup
    private WebElement industryField;
    @FindBy(id = "lea7")
    @CacheLookup
    private WebElement annualRevenueField;
    @FindBy(id = "lea8")
    @CacheLookup
    private WebElement phoneField;
    @FindBy(id = "lea9")
    @CacheLookup
    private WebElement mobileField;
    @FindBy(id = "lea10")
    @CacheLookup
    private WebElement faxField;
    @FindBy(id = "lea11")
    @CacheLookup
    private WebElement emailField;
    @FindBy(id = "lea12")
    @CacheLookup
    private WebElement websiteField;
    @FindBy(id = "lea14")
    @CacheLookup
    private WebElement ratingField;
    @FindBy(id = "lea15")
    @CacheLookup
    private WebElement numEmployeesField;
    @FindBy(id = "lea16state")
    @CacheLookup
    private WebElement stateField;
    @FindBy(id = "lea16zip")
    @CacheLookup
    private WebElement zipCodeField;
    @FindBy(id = "lea16country")
    @CacheLookup
    private WebElement countryField;
    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::span/select")
    @CacheLookup
    private WebElement productInterestField;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::input")
    @CacheLookup
    private WebElement sicCodeField;
    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::input")
    @CacheLookup
    private WebElement numLocationsField;
    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::input")
    @CacheLookup
    private WebElement currentGeneratorsField;
    @FindBy(xpath = "//td[contains(.,'Primary')]/following::span/select")
    @CacheLookup
    private WebElement primaryField;
    /*Others*/
    @FindBy(id = "lea17")
    @CacheLookup
    private WebElement descriptionField;
    @FindBy(id = "lea21")
    @CacheLookup
    private WebElement assignRuleCheck;
    @FindBy(id = "lea20_lkwgt")
    private WebElement campaignIcon;

    private Lead leadObject;

    /**
     * This method fill the Form with the information of the Json.
     */
    public void fillTheForm() {
        CommonActions.sendKeys(lastNameField, leadObject.lastName);
        CommonActions.sendKeys(companyField, leadObject.company);
        CommonActions.selectItem(leadStatusField, leadObject.leadStatus);
        //CommonActions.sendKeys(campaingLookupField, leadObject.campaignLookup);
        selectCampaign(leadObject.campaignLookup);
        CommonActions.selectItem(nameSalutationField, leadObject.nameSalutation);
        CommonActions.sendKeys(firstNameField, leadObject.firstName);
        CommonActions.sendKeys(titleField, leadObject.title);
        CommonActions.selectItem(leadSourceField, leadObject.leadSource);
        CommonActions.selectItem(industryField, leadObject.industry);
        CommonActions.sendKeys(annualRevenueField, leadObject.annualRevenue);
        CommonActions.sendKeys(phoneField, leadObject.phone);
        CommonActions.sendKeys(mobileField, leadObject.mobile);
        CommonActions.sendKeys(faxField, leadObject.fax);
        CommonActions.sendKeys(emailField, leadObject.email);
        CommonActions.sendKeys(websiteField, leadObject.website);
        CommonActions.selectItem(ratingField, leadObject.rating);
        CommonActions.sendKeys(numEmployeesField, leadObject.numEmployees);
        CommonActions.sendKeys(streetField, leadObject.street);
        CommonActions.sendKeys(leadCityField, leadObject.city);
        CommonActions.sendKeys(stateField, leadObject.stateProvince);
        CommonActions.sendKeys(zipCodeField, leadObject.zipCode);
        CommonActions.sendKeys(countryField, leadObject.country);
        CommonActions.selectItem(productInterestField, leadObject.productInterest);
        CommonActions.sendKeys(sicCodeField, leadObject.SICCode);
        CommonActions.sendKeys(numLocationsField, leadObject.numberLocations);
        CommonActions.sendKeys(currentGeneratorsField, leadObject.currentGenerators);
        CommonActions.selectItem(primaryField, leadObject.primary);
        CommonActions.sendKeys(descriptionField, leadObject.description);
        if (leadObject.assignRule == "yes") {
            CommonActions.check(assignRuleCheck);
        }
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param path the path where is the Json file.
     * @return the LeadHome form.
     */
    public LeadForm fillNewLeadFromJson(final String path) {
        try {
            leadObject = (Lead) JsonMapper.getData(path, new Lead());
            fillTheForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * This method selects the campaign where the LeadHome is take in account.
     *
     * @param campaignLookupText the campaign name.
     */
    private void selectCampaign(final String campaignLookupText) {
        wait.until(ExpectedConditions.elementToBeClickable(this.campaignIcon));
        campaignIcon.click();
        LeadCampaignLookup campaignLookup = new LeadCampaignLookup();
        campaignLookup.selectCampaignWithName(campaignLookupText);
    }

    /**
     * This method sets the Last name in the field.
     *
     * @param lastName the last name of the LeadHome.
     * @return LeadForm object
     */
    public LeadForm setLastNameField(final String lastName) {
        CommonActions.sendKeys(lastNameField, lastName);
        return this;
    }

    /**
     * This method sets the Status of the LeadHome.
     *
     * @param status the status of the LeadHome.
     */
    public LeadForm setStatusField(final String status) {
        CommonActions.sendKeys(leadStatusField, status);
        return this;
    }

    /**
     * This method sets the company name of the LeadHome.
     *
     * @param company the company where the lead is working.
     * @return LeadForm object
     */
    public LeadForm setCompanyField(final String company) {
        CommonActions.sendKeys(companyField, company);
        return this;
    }

    /**
     * This method sets the first name of the LeadHome.
     *
     * @param firstName the first name info.
     * @return LeadForm object
     */
    public LeadForm setFirstNameField(final String firstName) {
        CommonActions.sendKeys(firstNameField, firstName);
        return this;
    }

    /**
     * This method set the Street of the LeadHome.
     *
     * @param street the street info of the LeadHome.
     */
    public LeadForm setStreetField(final String street) {
        CommonActions.sendKeys(streetField, street);
        return this;
    }

    /**
     * This method set the city of the LeadHome.
     *
     * @param city the city info of the LeadHome.
     */
    public LeadForm setLeadCityField(final String city) {
        CommonActions.sendKeys(leadCityField, city);
        return this;
    }

    /**
     * This method Click on save button.
     *
     * @return the LeadDetails page.
     */
    public LeadDetails clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new LeadDetails();
    }

    public void fillTheForm(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();

        strategyMap.put("nameSalutation", () -> CommonActions.sendKeys(nameSalutationField, String.valueOf(values.get("nameSalutation"))));
        strategyMap.put("firstName", () -> setFirstNameField(String.valueOf(values.get("firstName"))));
        strategyMap.put("lastName", () -> setLastNameField(String.valueOf(values.get("lastName"))));
        strategyMap.put("company", () -> setCompanyField(String.valueOf(values.get("company"))));
        strategyMap.put("title", () -> CommonActions.sendKeys(titleField, String.valueOf(values.get("title"))));
        strategyMap.put("leadSource", () -> CommonActions.selectItem(leadSourceField, String.valueOf(values.get("leadSource"))));
        strategyMap.put("campaign", () -> selectCampaign(String.valueOf(values.get("campaign"))));
        strategyMap.put("industry", () -> CommonActions.selectItem(industryField, String.valueOf(values.get("industry"))));
        strategyMap.put("annualRevenue", () -> CommonActions.sendKeys(annualRevenueField, String.valueOf(values.get("annualRevenue"))));
        strategyMap.put("phone", () -> CommonActions.sendKeys(phoneField, String.valueOf(values.get("phone"))));
        strategyMap.put("mobile", () -> CommonActions.sendKeys(mobileField, String.valueOf(values.get("mobile"))));
        strategyMap.put("fax", () -> CommonActions.sendKeys(faxField, String.valueOf(values.get("fax"))));

        strategyMap.put("email", () -> CommonActions.sendKeys(emailField, String.valueOf(values.get("email"))));
        strategyMap.put("website", () -> CommonActions.sendKeys(websiteField, String.valueOf(values.get("website"))));
        strategyMap.put("leadStatus", () -> CommonActions.selectItem(leadStatusField, String.valueOf(values.get("leadStatus"))));
        strategyMap.put("rating", () -> CommonActions.selectItem(ratingField, String.valueOf(values.get("rating"))));
        strategyMap.put("numEmployees", () -> CommonActions.sendKeys(numEmployeesField, String.valueOf(values.get("numEmployees"))));
        strategyMap.put("street", () -> CommonActions.sendKeys(streetField, String.valueOf(values.get("street"))));
        strategyMap.put("city", () -> CommonActions.sendKeys(leadCityField, String.valueOf(values.get("city"))));
        strategyMap.put("stateProvince", () -> CommonActions.sendKeys(stateField, String.valueOf(values.get("stateProvince"))));
        strategyMap.put("zipCode", () -> CommonActions.sendKeys(zipCodeField, String.valueOf(values.get("zipCode"))));
        strategyMap.put("country", () -> CommonActions.sendKeys(countryField, String.valueOf(values.get("country"))));
        strategyMap.put("productInterest", () -> CommonActions.selectItem(productInterestField, String.valueOf(values.get("productInterest"))));
        strategyMap.put("SICCode", () -> CommonActions.sendKeys(sicCodeField, String.valueOf(values.get("SICCode"))));
        strategyMap.put("numberLocations", () -> CommonActions.sendKeys(numLocationsField, String.valueOf(values.get("numberLocations"))));
        strategyMap.put("currentGenerators", () -> CommonActions.sendKeys(currentGeneratorsField, String.valueOf(values.get("currentGenerators"))));
        strategyMap.put("primary", () -> CommonActions.selectItem(primaryField, String.valueOf(values.get("primary"))));
        strategyMap.put("description", () -> CommonActions.sendKeys(descriptionField, String.valueOf(values.get("description"))));
        strategyMap.put("assignRule", () -> setAssignRule(String.valueOf(values.get("assignRule"))));

        return strategyMap;
    }

    public void setAssignRule(final String assignRule) {
        if (leadObject.assignRule == "yes") {
            CommonActions.check(assignRuleCheck);
        }
    }

}
