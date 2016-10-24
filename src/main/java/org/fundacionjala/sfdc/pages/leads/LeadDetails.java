package org.fundacionjala.sfdc.pages.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * Class to manage the Detail of the Lead Page when it was created.
 */
public class LeadDetails extends FormBase {

    //region Locators

    /*Lead Information*/
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
    @FindBy(xpath = "//td[contains(.,'ProductHome Interest')]/following::div")
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
     * Method that gets the Owner that was registered in the creation of Lead.
     *
     * @return a string that is the Owner data.
     */
    public String getOwner() {
        return owner.getText();
    }

    /**
     * This method gets the Lead Name that was registered in the creation of Lead.
     *
     * @return the Lead Name.
     */
    public String getName() {
        return name.getText();
    }

    /**
     * This method gets the Company that was registered in the creation of Lead.
     *
     * @return a String that is the company information.
     */
    public String getCompany() {
        return company.getText();
    }

    /**
     * This method gets the Title of the Lead.
     *
     * @return a String that is the Lead Title.
     */
    public String getTitle() {
        return title.getText();
    }

    /**
     * This method gets the Source info of the Lead.
     *
     * @return a String that is the Source info of the Lead.
     */
    public String getLeadSource() {
        return leadSource.getText();
    }

    /**
     * This method gets the selected industry for the Lead.
     *
     * @return a String with the industry info.
     */
    public String getIndustry() {
        return industry.getText();
    }

    /**
     * This method gets the Annual Revenue info for the Lead.
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
     * This method gets the status of the Lead.
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
    public String getCampaign() {
        return campaign.getText();
    }

    /**
     * This method gets the name of the user that created the Lead.
     *
     * @return a String with the user name.
     */
    public String getCreatedBy() {
        return createdBy.getText();
    }

    /**
     * This method gets the user name that was the last that modify the info of the Lead.
     *
     * @return a String with the user name.
     */
    public String getLastModifiedBy() {
        return lastModifiedBy.getText();
    }

    /**
     * This method click on delete button to delete the Lead.
     *
     * @return a Lead
     */
    public Lead deleteLead() {
        CommonActions.deleteMe(driver);
        return new Lead();

    }
}