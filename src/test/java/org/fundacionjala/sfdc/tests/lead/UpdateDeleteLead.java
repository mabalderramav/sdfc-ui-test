package org.fundacionjala.sfdc.tests.lead;

import org.fundacionjala.sfdc.pages.leads.Lead;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadHome;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * This class update and delete LeadHome.
 */
public class UpdateDeleteLead {
    private LeadDetails leadDetails;
    private LeadHome leadHomePage;

    /**
     * This method execute the preconditions to make the validation for update and delete test.
     */
    @BeforeTest
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
    @Test
    public void deleteLead(){
        leadDetails.deleteLead();
        assertFalse(leadHomePage.isLeadDisplayed("Test Name 01"));
    }
    @Test void updateLead(){
        String companyNameEdited = "ComapnyName UPDATED";
        Lead lead = new Lead.LeadBuilder("Last name Edited",companyNameEdited)
                .setFirstName("Edited firstName")
                .setCountry("Argentina")
                .build();
        leadDetails = lead.createLead();

        assertEquals(companyNameEdited,leadDetails.getCompany());

    }
    @AfterClass
    public void tearDown(){

    }
}
