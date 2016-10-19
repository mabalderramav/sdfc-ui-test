package org.fundacionjala.saleforceuitest.pages.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.saleforceuitest.framework.common.CommonActions;
import org.fundacionjala.saleforceuitest.framework.utils.JsonMapper;
import org.fundacionjala.saleforceuitest.framework.objects.Lead;
import org.fundacionjala.saleforceuitest.pages.base.FormBasePage;

/**
 * Created by Miguel.Pari on 6/24/2015.
 * Updated by Pablo Zubieta on 09/01/2015
 */
public class NewLeadPage extends FormBasePage {

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
    private WebElement SaveButton;

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
    private WebElement SICcodeField;

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

    @FindBy(id="lea20_lkwgt")
    private WebElement campaignIcon;

    private Lead leadObject;
    public static final String LEAD_DATA_PATH = "src\\test\\resources\\CreateLeadData.json";

    public Lead getLoadedLead(){
        return leadObject;
    }

    public void loadDataFromJson(String path){
        try {
            leadObject = JsonMapper.getLeadData(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fillTheForm(){
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
        CommonActions.sendKeys(SICcodeField, leadObject.SICCode);
        CommonActions.sendKeys(numLocationsField, leadObject.numberLocations);
        CommonActions.sendKeys(currentGeneratorsField, leadObject.currentGenerators);
        CommonActions.selectItem(primaryField, leadObject.primary);
        CommonActions.sendKeys(descriptionField, leadObject.description);
        if (leadObject.assignRule == "yes"){
            CommonActions.check(assignRuleCheck);
        }

    }

    public NewLeadPage fillNewLeadFromJson(String path){
        try {
            loadDataFromJson(path);
            fillTheForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    private void selectCampaign(String campaignLookupText) {
        wait.until(ExpectedConditions.elementToBeClickable(this.campaignIcon));
        campaignIcon.click();
        LeadCampaignLookup campaignLookup = new LeadCampaignLookup();
        campaignLookup.selectCampaignWithName(campaignLookupText);
    }

    public NewLeadPage setLastNameField(String text) {
        CommonActions.sendKeys(lastNameField, text);
        return this;
    }


    public NewLeadPage setStatusField(String text) {
        CommonActions.sendKeys(leadStatusField, text);
        return this;
    }

    public NewLeadPage setCompanyField(String text){
        CommonActions.sendKeys(companyField, text);
        return this;
    }

    public NewLeadPage setFirstNameField(String text){
        CommonActions.sendKeys(firstNameField, text);
        return this;
    }

    public NewLeadPage setStreetField(String text){
        CommonActions.sendKeys(streetField, text);
        return this;
    }

    public NewLeadPage setLeadCityField(String text){
        CommonActions.sendKeys(leadCityField, text);
        return this;
    }

    public LeadDetailsPage clickSaveButton() {
        CommonActions.clickElement(SaveButton);
        return new LeadDetailsPage();
    }
}
