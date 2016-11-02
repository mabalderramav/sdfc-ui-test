package org.fundacionjala.sfdc.tests.lead;


import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadHome;

import static org.fundacionjala.sfdc.pages.leads.LeadFields.CITY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.COMPANY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.COUNTRY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FIRST_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.LAST_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.STATE_PROVINCE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ZIP_CODE;
import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;
import static org.testng.AssertJUnit.assertFalse;

/**
 * This class update and delete LeadHome.
 */
public class UpdateDeleteLead {

    public static final String LEAD_DATA_PATH = "lead/CreateLeadData.json";
    private LeadDetails leadDetails;
    private LeadHome leadHomePage;
    private LeadForm leadForm;
    private Map<String, String> valuesMapJson;

    /**
     * This method execute the preconditions to make the validation for update and delete test.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(LEAD_DATA_PATH);
        TabBar tabBar = new MainApp().goToTabBar();
        leadHomePage = tabBar.clickLead();
        leadForm = leadHomePage.clickNewButton();
        leadDetails = leadForm
                .setFirstNameTextField(valuesMapJson.get(FIRST_NAME.toString()))
                .setLastNameTextField(valuesMapJson.get(LAST_NAME.toString()))
                .setCompanyTextField(valuesMapJson.get(COMPANY.toString()))
                .clickSaveButton();
    }

    /**
     * This test verify the delete process of LeadFields.
     */
    @Test
    public void deleteLead() {
        leadDetails.clickDeleteButton();
        assertFalse(leadHomePage.isLeadDisplayed(valuesMapJson.get(FIRST_NAME.toString())));
    }

    /**
     * This test update the created LeadFields and make the corresponding assertions.
     */
    @Test
    public void updateLead() {
        final String companyNameEdited = "CompanyName UPDATED";
        final String lastNameEdited = "LastName UPDATED";
        final String firstNameEdited = "firstName UPDATED";
        leadDetails.clickEditButton();
        leadForm = new LeadForm.LeadBuilder(lastNameEdited, companyNameEdited)
                .setFirstName(firstNameEdited)
                .setCity(valuesMapJson.get(CITY.toString()))
                .setStateProvince(valuesMapJson.get(STATE_PROVINCE.toString()))
                .setZipCode(valuesMapJson.get(ZIP_CODE.toString()))
                .setCountry(valuesMapJson.get(COUNTRY.toString()))
                .build();
        leadDetails = leadForm.saveLead();
        assertDetailValues(leadDetails, leadForm.formatJson(leadForm.getLeadValues()));
    }

    /**
     * This method delete the created LeadFields.
     */
    @AfterClass
    public void tearDown() {
        leadDetails.clickDeleteButton();
    }
}
