package Pages.Leads;

import Framework.BrowserManager;
import Framework.CommonActions;
import Framework.FormBase;
import Framework.Objects.Lead;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.JSONMapper;

/**
 * Created by Miguel.Pari on 6/24/2015.
 * Updated by Pablo Zubieta on 09/01/2015
 */
public class NewLeadPage extends FormBase{

    @FindBy(id = "name_lastlea2")
    @CacheLookup
    WebElement lastNameField;

    @FindBy(id = "lea13")
    @CacheLookup
    WebElement leadStatusField;

    @FindBy(id = "lea3")
    @CacheLookup
    WebElement companyField;

    @FindBy(id = "name_firstlea2")
    @CacheLookup
    WebElement firstNameField;

    @FindBy(id = "lea16street")
    @CacheLookup
    WebElement streetField;

    @FindBy(id = "lea16city")
    @CacheLookup
    WebElement leadCityField;

    @FindBy(name = "save")
    @CacheLookup
    WebElement SaveButton;

    @FindBy(xpath = "//input[@id='lea20']")
    @CacheLookup
    WebElement campaingLookupField;

    @FindBy(id = "name_salutationlea2")
    @CacheLookup
    WebElement nameSalutationField;

    @FindBy(id = "lea4")
    @CacheLookup
    WebElement titleField;

    @FindBy(id = "lea5")
    @CacheLookup
    WebElement leadSourceField;

    @FindBy(id = "lea6")
    @CacheLookup
    WebElement industryField;

    @FindBy(id = "lea7")
    @CacheLookup
    WebElement annualRevenueField;

    @FindBy(id = "lea8")
    @CacheLookup
    WebElement phoneField;

    @FindBy(id = "lea9")
    @CacheLookup
    WebElement mobileField;

    @FindBy(id = "lea10")
    @CacheLookup
    WebElement faxField;

    @FindBy(id = "lea11")
    @CacheLookup
    WebElement emailField;

    @FindBy(id = "lea12")
    @CacheLookup
    WebElement websiteField;

    @FindBy(id = "lea14")
    @CacheLookup
    WebElement ratingField;

    @FindBy(id = "lea15")
    @CacheLookup
    WebElement numEmployeesField;

    @FindBy(id = "lea16state")
    @CacheLookup
    WebElement stateField;

    @FindBy(id = "lea16zip")
    @CacheLookup
    WebElement zipCodeField;

    @FindBy(id = "lea16country")
    @CacheLookup
    WebElement countryField;

    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::span/select")
    @CacheLookup
    WebElement productInterestField;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::input")
    @CacheLookup
    WebElement SICcodeField;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::input")
    @CacheLookup
    WebElement numLocationsField;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::input")
    @CacheLookup
    WebElement currentGeneratorsField;

    @FindBy(xpath = "//td[contains(.,'Primary')]/following::span/select")
    @CacheLookup
    WebElement primaryField;

    /*Others*/
    @FindBy(id = "lea17")
    @CacheLookup
    WebElement descriptionField;

    @FindBy(id = "lea21")
    @CacheLookup
    WebElement assignRuleCheck;

    private Lead leadObject;

    public NewLeadPage()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        try {
            leadObject = JSONMapper.getLeadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Lead getLoadedLead(){
        return leadObject;
    }

    public boolean fillNewLead(Lead leadObject){
        boolean result = false;

        try {

            CommonActions.setValue(lastNameField, leadObject.lastName);
            CommonActions.setValue(companyField, leadObject.company);
            CommonActions.selectItem(leadStatusField, leadObject.leadStatus);
            CommonActions.setValue(campaingLookupField, leadObject.campaignLookup);
            CommonActions.selectItem(nameSalutationField, leadObject.nameSalutation);
            CommonActions.setValue(firstNameField, leadObject.firstName);
            CommonActions.setValue(titleField, leadObject.title);
            CommonActions.selectItem(leadSourceField, leadObject.leadSource);
            CommonActions.selectItem(industryField, leadObject.industry);
            CommonActions.setValue(annualRevenueField, leadObject.annualRevenue);
            CommonActions.setValue(phoneField, leadObject.phone);
            CommonActions.setValue(mobileField, leadObject.mobile);
            CommonActions.setValue(faxField, leadObject.fax);
            CommonActions.setValue(emailField, leadObject.email);
            CommonActions.setValue(websiteField, leadObject.website);
            CommonActions.selectItem(ratingField, leadObject.rating);
            CommonActions.setValue(numEmployeesField, leadObject.numEmployees);
            CommonActions.setValue(streetField, leadObject.street);
            CommonActions.setValue(leadCityField, leadObject.city);
            CommonActions.setValue(stateField, leadObject.stateProvince);
            CommonActions.setValue(zipCodeField, leadObject.zipCode);
            CommonActions.setValue(countryField, leadObject.country);
            CommonActions.selectItem(productInterestField, leadObject.productInterest);
            CommonActions.setValue(SICcodeField, leadObject.SICCode);
            CommonActions.setValue(numLocationsField, leadObject.numberLocations);
            CommonActions.setValue(currentGeneratorsField, leadObject.currentGenerators);
            CommonActions.selectItem(primaryField, leadObject.primary);
            CommonActions.setValue(descriptionField, leadObject.description);
            if (leadObject.assignRule == "yes"){
                CommonActions.check(assignRuleCheck);
            }
            result = true;

        } catch (Exception e) {
        e.printStackTrace();
        }

        return result;

    }

    public NewLeadPage setLastNameField(String text) {
        CommonActions.setValue(lastNameField, text);
        return this;
    }


    public NewLeadPage setStatusField(String text) {
        CommonActions.setValue(leadStatusField, text);
        return this;
    }

    public NewLeadPage setCompanyField(String text){
        CommonActions.setValue(companyField, text);
        return this;
    }

    public NewLeadPage setFirstNameField(String text){
        CommonActions.setValue(firstNameField, text);
        return this;
    }

    public NewLeadPage setStreetField(String text){
        CommonActions.setValue(streetField, text);
        return this;
    }

    public NewLeadPage setLeadCityField(String text){
        CommonActions.setValue(leadCityField, text);
        return this;
    }

    public LeadDetailsPage clickSaveButton() {
        CommonActions.click(SaveButton);
        return new LeadDetailsPage();
    }
}
