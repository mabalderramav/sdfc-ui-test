package org.fundacionjala.sfdc.unittest.lead;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.Lead;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadHome;

/**
 * This class update and delete LeadHome.
 */
public class UpdateDeleteLead {
    private LeadDetails leadDetails;
    private LeadHome leadHomePage;

    /**
     * This method execute the preconditions to make the validation for update and delete test.
     */
    @BeforeMethod
    public void setUp(){
        LoginPage loginPage = new LoginPage();
        MainApp mainApp = loginPage.loginAsPrimaryUser();
        TabBar tabBar = new MainApp().goToTabBar();
        leadHomePage = tabBar.clickLead();
        leadDetails = leadHomePage.clickNewButton()
                .setFirstNameField("Test Name 01")
                .setLastNameField("Test LastName")
                .setCompanyField("Company Test")
                .clickSaveButton();
    }
//    @Test
//    public void deleteLead(){
//        leadDetails.deleteLead();
//        assertFalse(leadHomePage.isLeadDisplayed("Test Name 01"));
//    }
    @Test void updateLead(){
        String companyNameEdited = "CompanyName UPDATED";
        LeadForm leadForm = leadDetails.clickEditButton();
        Lead lead = new Lead.LeadBuilder("Last name Edited",companyNameEdited)
                .setFirstName("Edited firstName")
                .setCity("CITY")
                .setStateProvince("State Province")
                .setZipCode("ZIP CODE")
                .setCountry("Argentina")
                .build();
        leadDetails = lead.createLead();

        new AssertLead().assertDetailValues(leadDetails,lead.getLeadValues());

    }
    @AfterClass
    public void tearDown(){
        //leadDetails.deleteLead();
    }
}
