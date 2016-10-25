package org.fundacionjala.sfdc.pages.leads;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.DetailBase;


/**
 * Class to manage the Detail of the LeadHome Page when it was created.
 */
public class LeadDetails extends DetailBase {

    //region Locators

    /*LeadHome Information*/
    @FindBy(id = "lea1_ileinner")
    @CacheLookup
    private WebElement owner;
    @FindBy(id = "lea2_ileinner")
    @CacheLookup
    private WebElement name;
    @FindBy(id = "lea3_ileinner")
    @CacheLookup
    private WebElement company;
    @FindBy(id = "lea4_ileinner")
    @CacheLookup
    private WebElement title;
    @FindBy(id = "lea5_ileinner")
    @CacheLookup
    private WebElement leadSource;
    @FindBy(id = "lea6_ileinner")
    @CacheLookup
    private WebElement industry;
    @FindBy(id = "lea7_ileinner")
    @CacheLookup
    private WebElement annualRevenue;
    @FindBy(id = "lea8_ileinner")
    @CacheLookup
    private WebElement phone;
    @FindBy(id = "lea9_ileinner")
    @CacheLookup
    private WebElement mobile;
    @FindBy(id = "lea10_ileinner")
    @CacheLookup
    private WebElement fax;
    @FindBy(id = "lea11_ileinner")
    @CacheLookup
    private WebElement email;
    @FindBy(id = "lea12_ileinner")
    @CacheLookup
    private WebElement website;
    @FindBy(id = "lea13_ileinner")
    @CacheLookup
    private WebElement leadStatus;
    @FindBy(id = "lea14_ileinner")
    @CacheLookup
    private WebElement rating;
    @FindBy(id = "lea15_ileinner")
    @CacheLookup
    private WebElement numEmployees;
    /*Address Information*/
    @FindBy(id = "lea16_ileinner")
    @CacheLookup
    private WebElement address;
    /*additional information*/
    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::div")
    @CacheLookup
    private WebElement productInterest;
    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::div")
    @CacheLookup
    private WebElement sicCode;
    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::div")
    @CacheLookup
    private WebElement numLocations;
    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    @CacheLookup
    private WebElement currentGenerators;
    @FindBy(xpath = "//td[contains(.,'Primary')]/following::div")
    @CacheLookup
    private WebElement primary;
    /*Others*/
    @FindBy(id = "lea17_ileinner")
    @CacheLookup
    private WebElement description;
    @FindBy(id = "lea20")
    @CacheLookup
    private WebElement campaign;
    @FindBy(id = "CreatedBy_ileinner")
    @CacheLookup
    private WebElement createdBy;
    @FindBy(id = "LastModifiedBy_ileinner")
    @CacheLookup
    private WebElement lastModifiedBy;
    //endregion

    /**
     * Method that gets the Owner that was registered in the creation of LeadHome.
     *
     * @return a string that is the Owner data.
     */
    public String getOwner() {
        return owner.getText();
    }

    /**
     * This method gets the LeadHome Name that was registered in the creation of LeadHome.
     *
     * @return the LeadHome Name.
     */
    public String getName() {
        return name.getText();
    }

    /**
     * This method gets the Company that was registered in the creation of LeadHome.
     *
     * @return a String that is the company information.
     */
    public String getCompany() {
        return company.getText();
    }

    /**
     * This method gets the Title of the LeadHome.
     *
     * @return a String that is the LeadHome Title.
     */
    public String getTitle() {
        return title.getText();
    }

    /**
     * This method gets the Source info of the LeadHome.
     *
     * @return a String that is the Source info of the LeadHome.
     */
    public String getLeadSource() {
        return leadSource.getText();
    }

    /**
     * This method gets the selected industry for the LeadHome.
     *
     * @return a String with the industry info.
     */
    public String getIndustry() {
        return industry.getText();
    }

    /**
     * This method gets the Annual Revenue info for the LeadHome.
     *
     * @return a String with the Anunal Revenue info.
     */
    public String getAnnualRevenue() {
        return annualRevenue.getText();
    }

    /**
     * This method gets the Phone number.
     *
     * @return a String with the Phone number.
     */
    public String getPhone() {
        return phone.getText();
    }

    /**
     * This method gets the Mobile number.
     *
     * @return a String with the Phone number.
     */
    public String getMobile() {
        return mobile.getText();
    }

    /**
     * This method gets the Fax number.
     *
     * @return a String with the Fax number.
     */
    public String getFax() {
        return fax.getText();
    }

    /**
     * This method gets the registered Email.
     *
     * @return a String with the Email data.
     */
    public String getEmail() {
        return email.getText();
    }

    /**
     * This method gets the website.
     *
     * @return a String with the website info.
     */
    public String getWebsite() {
        return website.getText();
    }

    /**
     * This method gets the status of the LeadHome.
     *
     * @return a String with the status info.
     */
    public String getLeadStatus() {
        return leadStatus.getText();
    }

    /**
     * This method gets the rating.
     *
     * @return a String with the Rating info.
     */
    public String getRating() {
        return rating.getText();
    }

    /**
     * This method gets the number of Employees.
     *
     * @return a String with the number of the employees.
     */
    public String getNumEmployees() {
        return numEmployees.getText();
    }

    /**
     * this method gets the Address.
     *
     * @return a String with the Address info.
     */
    public String getAddress() {
        return address.getText();
    }

    /**
     * This method gets the product interest for the lead.
     *
     * @return a String with the Products interest info.
     */
    public String getProductInterest() {
        return productInterest.getText();
    }

    /**
     * This method gets the SIC code.
     *
     * @return a String with the SIC code.
     */
    public String getSicCode() {
        return sicCode.getText();
    }

    /**
     * This method gets the number of Locations.
     *
     * @return a String with the number of locations info.
     */
    public String getNumLocations() {
        return numLocations.getText();
    }

    /**
     * This method gets the Current generator.
     *
     * @return a String with the current generator.
     */
    public String getCurrentGenerators() {
        return currentGenerators.getText();
    }

    /**
     * This method gets the selected Primary info.
     *
     * @return a String with the primary info.
     */
    public String getPrimary() {
        return primary.getText();
    }

    /**
     * This method gets the description.
     *
     * @return a String with the description info.
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * This method gets the campaign that was selected.
     *
     * @return a String with the campaign name.
     */
    public String getCampaign(String campaignName) {
        String text = driver.findElement(By.xpath("//a[contains(.,\'" + campaignName + "\')]")).getText();
        return driver.findElement(By.xpath("//a[contains(.," + campaignName + ")]")).getText();
        //return campaign.getText();
    }

    /**
     * This method gets the name of the user that created the LeadHome.
     *
     * @return a String with the user name.
     */
    public String getCreatedBy() {
        return createdBy.getText();
    }

    /**
     * This method gets the user name that was the last that modify the info of the LeadHome.
     *
     * @return a String with the user name.
     */
    public String getLastModifiedBy() {
        return lastModifiedBy.getText();
    }

    /**
     * This method click on delete button to delete the LeadHome.
     *
     * @return a LeadHome
     */
    public LeadHome deleteLead() {
        CommonActions.deleteMe(driver);
        return new LeadHome();
    }

    /**
     * method that load the Strategy Map to make the assertions.
     *
     * @param valuesMapJson Json Map with the information.
     * @return the Map with the values to make assertions.
     */
    public Map<String, AssertsDetails> getStrategyAssertLead(Map<String, String> valuesMapJson) {
        final Map<String, AssertsDetails> strategyMap = new HashMap();

        strategyMap.put("fullName", this::getName);
        strategyMap.put("company", this::getCompany);
        strategyMap.put("title", this::getTitle);
        strategyMap.put("leadSource", this::getLeadSource);
        // strategyMap.put("campaignLookup", () -> getCampaign(valuesMapJson.get("campaignLookup")));
        strategyMap.put("industry", this::getIndustry);
        //strategyMap.put("annualRevenue", this::getAnnualRevenue);
        strategyMap.put("phone", this::getPhone);
        strategyMap.put("mobile", this::getMobile);
        strategyMap.put("fax", this::getFax);

        strategyMap.put("email", this::getEmail);
        strategyMap.put("website", this::getWebsite);
        strategyMap.put("leadStatus", this::getLeadStatus);
        strategyMap.put("rating", this::getRating);
        strategyMap.put("numEmployees", this::getNumEmployees);
        strategyMap.put("address", this::getAddress);
//        strategyMap.put("city", () -> getAddress());
//        strategyMap.put("stateProvince", () -> getAddress());
//        strategyMap.put("zipCode", () -> getAddress() );
//        strategyMap.put("country", () ->getAddress());

        strategyMap.put("productInterest", this::getProductInterest);
        strategyMap.put("SICCode", this::getSicCode);
        strategyMap.put("numberLocations", this::getNumLocations);
        strategyMap.put("currentGenerators", this::getCurrentGenerators);
        strategyMap.put("primary", this::getPrimary);

        strategyMap.put("description", this::getDescription);

        return strategyMap;
    }

    @Override
    public LeadForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new LeadForm();
    }
}