package org.fundacionjala.sfdc.pages.leads;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.DetailBase;

import static org.fundacionjala.sfdc.pages.leads.LeadFields.ADDRESS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ANNUAL_REVENUE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.COMPANY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.CURRENT_GENERATORS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.DESCRIPTION;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.EMAIL;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FAX;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FULL_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.INDUSTRY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.LEAD_SOURCE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.LEAD_STATUS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.MOBILE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.NUMBER_LOCATIONS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.NUM_EMPLOYEES;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.PHONE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.PRIMARY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.PRODUCT_INTEREST;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.RATING;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.SICCODE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.TITLE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.WEBSITE;

/**
 * Class to manage the Detail of the LeadHome Page when it was created.
 */
public class LeadDetails extends DetailBase {

    /*LeadHome Information*/
    @FindBy(id = "lea1_ileinner")
    @CacheLookup
    private WebElement ownerLabel;

    @FindBy(id = "lea2_ileinner")
    @CacheLookup
    private WebElement nameLabel;

    @FindBy(id = "lea3_ileinner")
    @CacheLookup
    private WebElement companyLabel;

    @FindBy(id = "lea4_ileinner")
    @CacheLookup
    private WebElement titleLabel;

    @FindBy(id = "lea5_ileinner")
    @CacheLookup
    private WebElement leadSourceLabel;

    @FindBy(id = "lea6_ileinner")
    @CacheLookup
    private WebElement industryLabel;

    @FindBy(id = "lea7_ileinner")
    @CacheLookup
    private WebElement annualRevenueLabel;

    @FindBy(id = "lea8_ileinner")
    @CacheLookup
    private WebElement phoneLabel;

    @FindBy(id = "lea9_ileinner")
    @CacheLookup
    private WebElement mobileLabel;

    @FindBy(id = "lea10_ileinner")
    @CacheLookup
    private WebElement faxLabel;

    @FindBy(id = "lea11_ileinner")
    @CacheLookup
    private WebElement emailLabel;

    @FindBy(id = "lea12_ileinner")
    @CacheLookup
    private WebElement websiteLabel;

    @FindBy(id = "lea13_ileinner")
    @CacheLookup
    private WebElement leadStatusLabel;

    @FindBy(id = "lea14_ileinner")
    @CacheLookup
    private WebElement ratingLabel;

    @FindBy(id = "lea15_ileinner")
    @CacheLookup
    private WebElement numEmployeesLabel;

    /*Address Information*/
    @FindBy(id = "lea16_ileinner")
    @CacheLookup
    private WebElement addressLabel;

    /*additional information*/
    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::div")
    @CacheLookup
    private WebElement productInterestLabel;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::div")
    @CacheLookup
    private WebElement sicCodeLabel;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::div")
    @CacheLookup
    private WebElement numLocationsLabel;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    @CacheLookup
    private WebElement currentGeneratorsLabel;

    @FindBy(xpath = "//td[contains(.,'Primary')]/following::div")
    @CacheLookup
    private WebElement primaryLabel;

    /*Others*/
    @FindBy(id = "lea17_ileinner")
    @CacheLookup
    private WebElement descriptionLabel;

    @FindBy(id = "CreatedBy_ileinner")
    @CacheLookup
    private WebElement createdByLabel;

    @FindBy(id = "LastModifiedBy_ileinner")
    @CacheLookup
    private WebElement lastModifiedByLabel;

    @FindBy(css = "div.listRelatedObject.campaignBlock table.list")
    @CacheLookup
    private WebElement campaignBlock;

    /**
     * Method that gets the Owner that was registered in the creation of LeadHome.
     *
     * @return a string that is the Owner data.
     */
    public String getOwnerLabel() {
        return ownerLabel.getText();
    }

    /**
     * This method gets the LeadHome Name that was registered in the creation of LeadHome.
     *
     * @return the LeadHome Name.
     */
    public String getNameLabel() {
        return nameLabel.getText();
    }

    /**
     * This method gets the Company that was registered in the creation of LeadHome.
     *
     * @return a String that is the company information.
     */
    public String getCompanyLabel() {
        return companyLabel.getText();
    }

    /**
     * This method gets the Title of the LeadHome.
     *
     * @return a String that is the LeadHome Title.
     */
    public String getTitleLabel() {
        return titleLabel.getText();
    }

    /**
     * This method gets the Source info of the LeadHome.
     *
     * @return a String that is the Source info of the LeadHome.
     */
    public String getLeadSourceLabel() {
        return leadSourceLabel.getText();
    }

    /**
     * This method gets the selected industry for the LeadHome.
     *
     * @return a String with the industry info.
     */
    public String getIndustryLabel() {
        return industryLabel.getText();
    }

    /**
     * This method gets the Annual Revenue info for the LeadHome.
     *
     * @return a String with the Annual Revenue info.
     */
    public String getAnnualRevenueLabel() {

        return annualRevenueLabel.getText().substring(1);
    }

    /**
     * This method gets the Phone number.
     *
     * @return a String with the Phone number.
     */
    public String getPhoneLabel() {
        return phoneLabel.getText();
    }

    /**
     * This method gets the Mobile number.
     *
     * @return a String with the Mobile number.
     */
    public String getMobileLabel() {
        return mobileLabel.getText();
    }

    /**
     * This method gets the Fax number.
     *
     * @return a String with the Fax number.
     */
    public String getFaxLabel() {
        return faxLabel.getText();
    }

    /**
     * This method gets the registered Email.
     *
     * @return a String with the Email data.
     */
    public String getEmailLabel() {
        return emailLabel.getText();
    }

    /**
     * This method gets the website.
     *
     * @return a String with the website info.
     */
    public String getWebsiteLabel() {
        return websiteLabel.getText();
    }

    /**
     * This method gets the status of the LeadHome.
     *
     * @return a String with the status info.
     */
    public String getLeadStatusLabel() {
        return leadStatusLabel.getText();
    }

    /**
     * This method gets the rating.
     *
     * @return a String with the Rating info.
     */
    public String getRatingLabel() {
        return ratingLabel.getText();
    }

    /**
     * This method gets the number of Employees.
     *
     * @return a String with the number of the employees.
     */
    public String getNumEmployeesLabel() {
        return numEmployeesLabel.getText();
    }

    /**
     * this method gets the Address.
     *
     * @return a String with the Address info.
     */
    public String getAddressLabel() {
        return addressLabel.getText();
    }

    /**
     * This method gets the product interest for the lead.
     *
     * @return a String with the Products interest info.
     */
    public String getProductInterestLabel() {
        return productInterestLabel.getText();
    }

    /**
     * This method gets the SIC code.
     *
     * @return a String with the SIC code.
     */
    public String getSicCodeLabel() {
        return sicCodeLabel.getText();
    }

    /**
     * This method gets the number of Locations.
     *
     * @return a String with the number of locations info.
     */
    public String getNumLocationsLabel() {
        return numLocationsLabel.getText();
    }

    /**
     * This method gets the Current generator.
     *
     * @return a String with the current generator.
     */
    public String getCurrentGeneratorsLabel() {
        return currentGeneratorsLabel.getText();
    }

    /**
     * This method gets the selected Primary info.
     *
     * @return a String with the primary info.
     */
    public String getPrimaryLabel() {
        return primaryLabel.getText();
    }

    /**
     * This method gets the description.
     *
     * @return a String with the description info.
     */
    public String getDescriptionLabel() {
        return descriptionLabel.getText();
    }

    /**
     * This method gets the campaign that was selected.
     *
     * @param campaignName String with the campaign name.
     * @return a String with the campaign name.
     */
    public String getCampaign(final String campaignName) {
        return campaignBlock.findElement(By.linkText(campaignName)).getText();
    }

    /**
     * This method gets the nameLabel of the user that created the LeadHome.
     *
     * @return a String with the user name.
     */
    public String getCreatedByLabel() {
        return createdByLabel.getText();
    }

    /**
     * This method gets the user name that was the last that modify the info of the LeadHome.
     *
     * @return a String with the user name.
     */
    public String getLastModifiedByLabel() {
        return lastModifiedByLabel.getText();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(FULL_NAME.toString(), this::getNameLabel);
        strategyMap.put(COMPANY.toString(), this::getCompanyLabel);
        strategyMap.put(TITLE.toString(), this::getTitleLabel);
        strategyMap.put(LEAD_SOURCE.toString(), this::getLeadSourceLabel);
        strategyMap.put(INDUSTRY.toString(), this::getIndustryLabel);
        strategyMap.put(PHONE.toString(), this::getPhoneLabel);
        strategyMap.put(MOBILE.toString(), this::getMobileLabel);
        strategyMap.put(FAX.toString(), this::getFaxLabel);
        strategyMap.put(ANNUAL_REVENUE.toString(), this::getAnnualRevenueLabel);

        strategyMap.put(EMAIL.toString(), this::getEmailLabel);
        strategyMap.put(WEBSITE.toString(), this::getWebsiteLabel);
        strategyMap.put(LEAD_STATUS.toString(), this::getLeadStatusLabel);
        strategyMap.put(RATING.toString(), this::getRatingLabel);
        strategyMap.put(NUM_EMPLOYEES.toString(), this::getNumEmployeesLabel);
        strategyMap.put(ADDRESS.toString(), this::getAddressLabel);

        strategyMap.put(PRODUCT_INTEREST.toString(), this::getProductInterestLabel);
        strategyMap.put(SICCODE.toString(), this::getSicCodeLabel);
        strategyMap.put(NUMBER_LOCATIONS.toString(), this::getNumLocationsLabel);
        strategyMap.put(CURRENT_GENERATORS.toString(), this::getCurrentGeneratorsLabel);
        strategyMap.put(PRIMARY.toString(), this::getPrimaryLabel);

        strategyMap.put(DESCRIPTION.toString(), this::getDescriptionLabel);

        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new LeadForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadHome clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new LeadHome();
    }
}
