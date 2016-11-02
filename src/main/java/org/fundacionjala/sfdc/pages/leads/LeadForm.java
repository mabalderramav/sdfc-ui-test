package org.fundacionjala.sfdc.pages.leads;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;

import static org.fundacionjala.sfdc.pages.leads.LeadFields.ADDRESS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ANNUAL_REVENUE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ASSIGN_RULE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.CAMPAIGN;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.CITY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.COMPANY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.COUNTRY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.CURRENT_GENERATORS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.DESCRIPTION;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.EMAIL;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FAX;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FIRST_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FULL_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.INDUSTRY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.LAST_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.LEAD_SOURCE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.LEAD_STATUS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.MOBILE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.NAME_SALUTATION;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.NUMBER_LOCATIONS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.NUM_EMPLOYEES;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.PHONE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.PRIMARY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.PRODUCT_INTEREST;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.RATING;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.SICCODE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.STATE_PROVINCE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.STREET;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.TITLE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.WEBSITE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ZIP_CODE;


/**
 * This class represent the Form to create a new LeadHome.
 */
public class LeadForm extends FormBase {

    @FindBy(id = "name_lastlea2")
    @CacheLookup
    private WebElement lastNameTextField;

    @FindBy(id = "lea13")
    @CacheLookup
    private WebElement leadStatustTextField;

    @FindBy(id = "lea3")
    @CacheLookup
    private WebElement companyTextField;

    @FindBy(id = "name_firstlea2")
    @CacheLookup
    private WebElement firstNameTextField;

    @FindBy(id = "lea16street")
    @CacheLookup
    private WebElement streetTextField;

    @FindBy(id = "lea16city")
    @CacheLookup
    private WebElement cityTextField;

    @FindBy(id = "lea20")
    @CacheLookup
    private WebElement campaingTextField;

    @FindBy(id = "name_salutationlea2")
    @CacheLookup
    private WebElement nameSalutationSelect;

    @FindBy(id = "lea4")
    @CacheLookup
    private WebElement titleField;

    @FindBy(id = "lea5")
    @CacheLookup
    private WebElement leadSourceSelect;

    @FindBy(id = "lea6")
    @CacheLookup
    private WebElement industrySelect;

    @FindBy(id = "lea7")
    @CacheLookup
    private WebElement annualRevenueTextField;

    @FindBy(id = "lea8")
    @CacheLookup
    private WebElement phoneTextField;

    @FindBy(id = "lea9")
    @CacheLookup
    private WebElement mobileTextField;

    @FindBy(id = "lea10")
    @CacheLookup
    private WebElement faxTextField;

    @FindBy(id = "lea11")
    @CacheLookup
    private WebElement emailTextField;

    @FindBy(id = "lea12")
    @CacheLookup
    private WebElement websiteTextField;

    @FindBy(id = "lea14")
    @CacheLookup
    private WebElement ratingTextField;

    @FindBy(id = "lea15")
    @CacheLookup
    private WebElement numEmployeesTextField;

    @FindBy(id = "lea16state")
    @CacheLookup
    private WebElement stateTextField;

    @FindBy(id = "lea16zip")
    @CacheLookup
    private WebElement zipCodeTextField;

    @FindBy(id = "lea16country")
    @CacheLookup
    private WebElement countryTextField;

    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::span/select")
    @CacheLookup
    private WebElement productInterestSelect;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::input")
    @CacheLookup
    private WebElement sicCodeTextField;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::input")
    @CacheLookup
    private WebElement numLocationsTextField;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::input")
    @CacheLookup
    private WebElement currentGeneratorsTextField;

    @FindBy(xpath = "//td[contains(.,'Primary')]/following::span/select")
    @CacheLookup
    private WebElement primarySelect;

    /*Others*/
    @FindBy(id = "lea17")
    @CacheLookup
    private WebElement descriptionTextArea;

    @FindBy(id = "lea21")
    @CacheLookup
    private WebElement assignRuleCheckBox;

    @FindBy(id = "lea20_lkwgt")
    private WebElement campaignIcon;

    private LeadBuilder leadBuilder;

    private Map<String, String> mapValues;

    /**
     * Constructor that call the parent constructor.
     */
    public LeadForm() {
        super();
    }

    /**
     * Constructor that initialize the values.
     *
     * @param leadBuilder the builder class.
     */
    private LeadForm(final LeadBuilder leadBuilder) {
        mapValues = new HashMap<>();
        this.leadBuilder = leadBuilder;
    }

    /**
     * Method that save the LeadFields Form.
     *
     * @return {@link LeadDetails}.
     */
    public LeadDetails saveLead() {
        mapValues = leadBuilder.getStrategyMap();
        fillTheForm(mapValues);
        return clickSaveButton();
    }

    /**
     * Method that return the built Map int the LeadBuilder class.
     *
     * @return the Map with the Form data Info.
     */
    public Map<String, String> getLeadValues() {
        return mapValues;
    }

    /**
     * This method selects the campaign where the LeadHome is take in account.
     *
     * @param campaignLookupText the campaign name.
     */
    private void selectCampaign(final String campaignLookupText) {
        wait.until(ExpectedConditions.elementToBeClickable(this.campaignIcon));
        campaignIcon.click();
        CampaignLookup campaignLookup = new CampaignLookup();
        campaignLookup.selectCampaignWithName(campaignLookupText);
    }

    /**
     * This method sets the Last name in the field.
     *
     * @param lastName the last name of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setLastNameTextField(final String lastName) {
        CommonActions.sendKeys(lastNameTextField, lastName);
        return this;
    }

    /**
     * This method sets the Status of the LeadHome.
     *
     * @param status the status of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setStatusField(final String status) {
        CommonActions.sendKeys(leadStatustTextField, status);
        return this;
    }

    /**
     * This method sets the company name of the LeadHome.
     *
     * @param company the company where the lead is working.
     * @return {@link LeadForm}
     */
    public LeadForm setCompanyTextField(final String company) {
        CommonActions.sendKeys(companyTextField, company);
        return this;
    }

    /**
     * This method sets the first name of the LeadHome.
     *
     * @param firstName the first name info.
     * @return {@link LeadForm}
     */
    public LeadForm setFirstNameTextField(final String firstName) {
        CommonActions.sendKeys(firstNameTextField, firstName);
        return this;
    }

    /**
     * This method set the Street of the LeadHome.
     *
     * @param street the street info of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setStreetTextField(final String street) {
        CommonActions.sendKeys(streetTextField, street);
        return this;
    }

    /**
     * This method set the city of the LeadHome.
     *
     * @param city the city info of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setCityTextField(final String city) {
        CommonActions.sendKeys(cityTextField, city);
        return this;
    }

    /**
     * Method that check the field "Assign Rule" if the sent data is "Yes".
     *
     * @param assignRule if this data is "yes" the field is checked
     */
    public void setAssignRule(final String assignRule) {
        if (String.valueOf(assignRule).equals("yes")) {
            CommonActions.check(assignRuleCheckBox);
        }
    }

    /**
     * Method to fill the form given a Json file or the builder class.
     *
     * @param valuesMapCreate Map with the Json or builder map values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method to give a format the Json, according this new Json is built according the details Page.
     *
     * @param valuesMap Original Json.
     * @return the new Json that was formatted.
     */
    public Map<String, String> formatJson(final Map<String, String> valuesMap) {
        String fullName = valuesMap.get(NAME_SALUTATION.toString()) + " "
                + valuesMap.get(FIRST_NAME.toString()) + " "
                + valuesMap.get(LAST_NAME.toString());
        fullName = formatString(fullName);

        String address = formatAddress(valuesMap);

        if (valuesMap.containsKey(ANNUAL_REVENUE.toString())) {
            String annualRevenueFormatted = formatNumber(valuesMap.get(ANNUAL_REVENUE.toString()));
            valuesMap.put(ANNUAL_REVENUE.toString(), annualRevenueFormatted);
        }

        valuesMap.put(FULL_NAME.toString(), fullName);
        valuesMap.put(ADDRESS.toString(), address);

        valuesMap.remove(NAME_SALUTATION.toString());
        valuesMap.remove(FIRST_NAME.toString());
        valuesMap.remove(LAST_NAME.toString());
        valuesMap.remove(CAMPAIGN.toString());

        valuesMap.remove(STREET.toString());
        valuesMap.remove(CITY.toString());
        valuesMap.remove(STATE_PROVINCE.toString());
        valuesMap.remove(ZIP_CODE.toString());
        valuesMap.remove(COUNTRY.toString());

        valuesMap.remove(ASSIGN_RULE.toString());

        return valuesMap;
    }

    /**
     * Method that give format to a number.
     *
     * @param number String with the number to be Formatted.
     * @return a String with the number formatted.
     */
    private String formatNumber(final String number) {
        return NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(number));
    }

    /**
     * Method that give a format to an Address.
     *
     * @param valuesMap Map that contain the address values to be formatted.
     * @return a String with the formatted address.
     */
    private String formatAddress(final Map<String, String> valuesMap) {
        String address = "";
        if (String.valueOf(valuesMap.get(ZIP_CODE.toString())).equals("null")) {
            address = valuesMap.get(STREET.toString()) + "\n"
                    + valuesMap.get(CITY.toString())
                    + ", " + valuesMap.get(STATE_PROVINCE.toString())
                    + "\n" + valuesMap.get(COUNTRY.toString());
        } else {
            address = valuesMap.get(STREET.toString()) + "\n"
                    + valuesMap.get(CITY.toString())
                    + ", " + valuesMap.get(STATE_PROVINCE.toString())
                    + " " + valuesMap.get(ZIP_CODE.toString())
                    + "\n" + valuesMap.get(COUNTRY.toString());
        }
        return formatString(address);
    }

    /**
     * Method that give a format to a string.
     *
     * @param value String with the value data.
     * @return the string formatted.
     */
    private String formatString(final String value) {
        String result = value.replaceAll("null", "").trim();
        if (result.startsWith(",")) {
            result = result.replaceAll(",", "").trim();
        }
        return result;
    }

    /**
     * Method to sets the values to create a new LeadFields.
     *
     * @param values Map with the information to be mapped.
     * @return a Map with the corresponding values.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(NAME_SALUTATION.toString(),
                () -> CommonActions.selectItem(nameSalutationSelect, values.get(NAME_SALUTATION.toString())));
        strategyMap.put(FIRST_NAME.toString(),
                () -> setFirstNameTextField(values.get(FIRST_NAME.toString())));
        strategyMap.put(LAST_NAME.toString(),
                () -> setLastNameTextField(values.get(LAST_NAME.toString())));
        strategyMap.put(COMPANY.toString(),
                () -> setCompanyTextField(values.get(COMPANY.toString())));
        strategyMap.put(TITLE.toString(),
                () -> CommonActions.sendKeys(titleField, values.get(TITLE.toString())));
        strategyMap.put(LEAD_SOURCE.toString(),
                () -> CommonActions.selectItem(leadSourceSelect, values.get(LEAD_SOURCE.toString())));
        strategyMap.put(CAMPAIGN.toString(),
                () -> CommonActions.sendKeys(campaingTextField, values.get(CAMPAIGN.toString())));
        strategyMap.put(INDUSTRY.toString(),
                () -> CommonActions.selectItem(industrySelect, values.get(INDUSTRY.toString())));
        strategyMap.put(ANNUAL_REVENUE.toString(),
                () -> CommonActions.sendKeys(annualRevenueTextField, values.get(ANNUAL_REVENUE.toString())));
        strategyMap.put(PHONE.toString(),
                () -> CommonActions.sendKeys(phoneTextField, values.get(PHONE.toString())));
        strategyMap.put(MOBILE.toString(),
                () -> CommonActions.sendKeys(mobileTextField, values.get(MOBILE.toString())));
        strategyMap.put(FAX.toString(),
                () -> CommonActions.sendKeys(faxTextField, values.get(FAX.toString())));
        strategyMap.put(EMAIL.toString(),
                () -> CommonActions.sendKeys(emailTextField, values.get(EMAIL.toString())));
        strategyMap.put(WEBSITE.toString(),
                () -> CommonActions.sendKeys(websiteTextField, values.get(WEBSITE.toString())));
        strategyMap.put(LEAD_STATUS.toString(),
                () -> CommonActions.selectItem(leadStatustTextField, values.get(LEAD_STATUS.toString())));
        strategyMap.put(RATING.toString(),
                () -> CommonActions.selectItem(ratingTextField, values.get(RATING.toString())));
        strategyMap.put(NUM_EMPLOYEES.toString(),
                () -> CommonActions.sendKeys(numEmployeesTextField, values.get(NUM_EMPLOYEES.toString())));
        strategyMap.put(STREET.toString(),
                () -> CommonActions.sendKeys(streetTextField, values.get(STREET.toString())));
        strategyMap.put(CITY.toString(), () -> CommonActions.sendKeys(cityTextField, values.get(CITY.toString())));
        strategyMap.put(STATE_PROVINCE.toString(),
                () -> CommonActions.sendKeys(stateTextField, values.get(STATE_PROVINCE.toString())));
        strategyMap.put(ZIP_CODE.toString(),
                () -> CommonActions.sendKeys(zipCodeTextField, values.get(ZIP_CODE.toString())));
        strategyMap.put(COUNTRY.toString(),
                () -> CommonActions.sendKeys(countryTextField, values.get(COUNTRY.toString())));
        strategyMap.put(PRODUCT_INTEREST.toString(),
                () -> CommonActions.selectItem(productInterestSelect, values.get(PRODUCT_INTEREST.toString())));
        strategyMap.put(SICCODE.toString(),
                () -> CommonActions.sendKeys(sicCodeTextField, values.get(SICCODE.toString())));
        strategyMap.put(NUMBER_LOCATIONS.toString(),
                () -> CommonActions.sendKeys(numLocationsTextField, values.get(NUMBER_LOCATIONS.toString())));
        strategyMap.put(CURRENT_GENERATORS.toString(),
                () -> CommonActions.sendKeys(currentGeneratorsTextField, values.get(CURRENT_GENERATORS.toString())));
        strategyMap.put(PRIMARY.toString(),
                () -> CommonActions.selectItem(primarySelect, values.get(PRIMARY.toString())));
        strategyMap.put(DESCRIPTION.toString(),
                () -> CommonActions.sendKeys(descriptionTextArea, values.get(DESCRIPTION.toString())));
        strategyMap.put(ASSIGN_RULE.toString(),
                () -> setAssignRule(values.get(ASSIGN_RULE.toString())));

        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadForm clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new LeadForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadDetails clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new LeadDetails();
    }

    /**
     * Inner class that manage the values to be built.
     */
    public static class LeadBuilder {
        /*LeadHome Information*/
        private String nameSalutation;
        private String firstName;
        private String lastName;
        private String company;
        private String title;
        private String leadSource;
        private String campaign;
        private String industry;
        private String annualRevenue;
        private String phone;
        private String mobile;
        private String fax;
        private String email;
        private String website;
        private String leadStatus;
        private String rating;
        private String numEmployees;

        /*Address Information*/
        private String street;
        private String city;
        private String stateProvince;
        private String zipCode;
        private String country;

        /*additional information*/
        private String productInterest;
        private String sicCode;
        private String numberLocations;
        private String currentGenerators;
        private String primary;

        /*Others*/
        private String description;
        private String assignRule;

        private Map<String, String> strategyMap;

        /**
         * Constructor that set the required values for the Lead Form.
         *
         * @param lastName Last Name required value.
         * @param company  company data.
         */
        public LeadBuilder(final String lastName, final String company) {
            strategyMap = new HashMap<>();
            this.lastName = lastName;
            this.company = company;
            strategyMap.put(LAST_NAME.toString(), lastName);
            strategyMap.put(COMPANY.toString(), company);
        }

        /**
         * Method that set the Salutation for the Lead.
         *
         * @param nameSalutation Salutation info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNameSalutation(final String nameSalutation) {
            this.nameSalutation = nameSalutation;
            strategyMap.put(NAME_SALUTATION.toString(), nameSalutation);
            return this;
        }

        /**
         * Method that set the first name data.
         *
         * @param firstName String with the first name info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setFirstName(final String firstName) {
            this.firstName = firstName;
            strategyMap.put(FIRST_NAME.toString(), firstName);
            return this;
        }

        /**
         * Method that set the Last name data.
         *
         * @param lastName String with the Last Name info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLastName(final String lastName) {
            this.lastName = lastName;
            strategyMap.put(LAST_NAME.toString(), lastName);
            return this;
        }

        /**
         * Method that set the Lead company.
         *
         * @param company String with the company info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCompany(final String company) {
            this.company = company;
            strategyMap.put(COMPANY.toString(), company);
            return this;
        }

        /**
         * Method that sets the Lead title data.
         *
         * @param title String with the title info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setTitle(final String title) {
            this.title = title;
            strategyMap.put(TITLE.toString(), title);
            return this;
        }

        /**
         * Method that sets the Lead source info.
         *
         * @param leadSource String with the source info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLeadSource(final String leadSource) {
            this.leadSource = leadSource;
            strategyMap.put(LEAD_SOURCE.toString(), leadSource);
            return this;
        }

        /**
         * Method that sets the Lead campaign.
         *
         * @param campaign String with the Campaign name.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCampaign(final String campaign) {
            this.campaign = campaign;
            strategyMap.put(CAMPAIGN.toString(), campaign);
            return this;
        }

        /**
         * Method that sets the Lead industry.
         *
         * @param industry String with the industry data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setIndustry(final String industry) {
            this.industry = industry;
            strategyMap.put(INDUSTRY.toString(), industry);
            return this;
        }

        /**
         * Method that sets the Lead Annual Revenue info.
         *
         * @param annualRevenue String with the annual revenue data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setAnnualRevenue(final String annualRevenue) {
            this.annualRevenue = annualRevenue;
            strategyMap.put(ANNUAL_REVENUE.toString(), annualRevenue);
            return this;
        }

        /**
         * Method that sets the Lead phone number.
         *
         * @param phone String with the phone data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setPhone(final String phone) {
            this.phone = phone;
            strategyMap.put(PHONE.toString(), phone);
            return this;
        }

        /**
         * Method that sets the Lead mobile number.
         *
         * @param mobile String with the phone data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setMobile(final String mobile) {
            this.mobile = mobile;
            strategyMap.put(MOBILE.toString(), mobile);
            return this;
        }

        /**
         * Method that sets the Lead Fax number.
         *
         * @param fax String with the fax data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setFax(final String fax) {
            this.fax = fax;
            strategyMap.put(FAX.toString(), fax);
            return this;
        }

        /**
         * Method that sets the Lead Email info.
         *
         * @param email String with the email data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setEmail(final String email) {
            this.email = email;
            strategyMap.put(EMAIL.toString(), email);
            return this;
        }

        /**
         * Method that sets the Lead website.
         *
         * @param website String with the website data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setWebsite(final String website) {
            this.website = website;
            strategyMap.put(WEBSITE.toString(), website);
            return this;
        }

        /**
         * Method that sets the Lead status.
         *
         * @param leadStatus String with the status data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLeadStatus(final String leadStatus) {
            this.leadStatus = leadStatus;
            strategyMap.put(LEAD_STATUS.toString(), leadStatus);
            return this;
        }

        /**
         * Method that sets the Lead rating.
         *
         * @param rating String with the Rating data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setRating(final String rating) {
            this.rating = rating;
            strategyMap.put(RATING.toString(), rating);
            return this;
        }

        /**
         * Method that sets the Lead employee number.
         *
         * @param numEmployees String with the employee data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNumEmployees(final String numEmployees) {
            this.numEmployees = numEmployees;
            strategyMap.put(NUM_EMPLOYEES.toString(), numEmployees);
            return this;
        }

        /**
         * Method that sets the Lead street.
         *
         * @param street String with the street data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setStreet(final String street) {
            this.street = street;
            strategyMap.put(STREET.toString(), street);
            return this;
        }

        /**
         * Method that sets the Lead city.
         *
         * @param city String with the city data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCity(final String city) {
            this.city = city;
            strategyMap.put(CITY.toString(), city);
            return this;
        }

        /**
         * Method that sets the Lead State or Province.
         *
         * @param stateProvince String with the state/province data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setStateProvince(final String stateProvince) {
            this.stateProvince = stateProvince;
            strategyMap.put(STATE_PROVINCE.toString(), stateProvince);
            return this;
        }

        /**
         * Method that sets the Lead Zip code.
         *
         * @param zipCode String with the zip code data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setZipCode(final String zipCode) {
            this.zipCode = zipCode;
            strategyMap.put(ZIP_CODE.toString(), zipCode);
            return this;
        }

        /**
         * Method that sets the Lead country.
         *
         * @param country String with the country data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCountry(final String country) {
            this.country = country;
            strategyMap.put(COUNTRY.toString(), country);
            return this;
        }

        /**
         * Method that sets the Lead product interest.
         *
         * @param productInterest String with the product interest data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setProductInterest(final String productInterest) {
            this.productInterest = productInterest;
            strategyMap.put(PRODUCT_INTEREST.toString(), productInterest);
            return this;
        }

        /**
         * Method that sets the Lead siccode.
         *
         * @param sicCode String with the sic code data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setSicCode(final String sicCode) {
            this.sicCode = sicCode;
            strategyMap.put(SICCODE.toString(), sicCode);
            return this;
        }

        /**
         * Method that sets the Lead number locations.
         *
         * @param numberLocations String with the number locations data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNumberLocations(final String numberLocations) {
            this.numberLocations = numberLocations;
            strategyMap.put(NUMBER_LOCATIONS.toString(), numberLocations);
            return this;
        }

        /**
         * Method that sets the current generators.
         *
         * @param currentGenerators String with the current generator data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCurrentGenerators(final String currentGenerators) {
            this.currentGenerators = currentGenerators;
            strategyMap.put(CURRENT_GENERATORS.toString(), currentGenerators);
            return this;
        }

        /**
         * Method that sets the Lead primary.
         *
         * @param primary String with the primary data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setPrimary(final String primary) {
            this.primary = primary;
            strategyMap.put(PRIMARY.toString(), primary);
            return this;
        }

        /**
         * Method that sets the Lead description.
         *
         * @param description String with the description data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setDescription(final String description) {
            this.description = description;
            strategyMap.put(DESCRIPTION.toString(), description);
            return this;
        }

        /**
         * Method that sets the assign rule.
         *
         * @param assignRule String with the assign rule info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setAssignRule(final String assignRule) {
            this.assignRule = assignRule;
            strategyMap.put(ASSIGN_RULE.toString(), assignRule);
            return this;
        }

        /**
         * Method that return the map with the values sent to fill the lead form.
         *
         * @return the Map with the saved values.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        /**
         * Method that build the Lead.
         *
         * @return {@link LeadForm}
         */
        public LeadForm build() {
            return new LeadForm(this);
        }
    }
}
