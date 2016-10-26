package org.fundacionjala.sfdc.tests.lead;

import org.fundacionjala.sfdc.pages.leads.LeadForm;
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
    private LeadForm leadForm;

    /**
     * This method execute the preconditions to make the validation for update and delete test.
     */
    @BeforeTest
    public void setUp(){
        LoginPage loginPage = new LoginPage();
        MainApp mainApp = loginPage.loginAsPrimaryUser();
        TabBar tabBar = new MainApp().goToTabBar();
        leadHomePage = tabBar.clickLead();
        leadForm = leadHomePage.clickNewButton();
        leadDetails = leadForm
                .setFirstNameTextField("Test Name 01")
                .setLastNameTextField("Test LastName")
                .setCompanyTextField("Company Test")
                .clickSaveButton();
    }
//    @Test
//    public void deleteLead(){
//        leadDetails.deleteLead();
//        assertFalse(leadHomePage.isLeadDisplayed("Test Name 01"));
//    }
    @Test void updateLead(){
        String companyNameEdited = "ComapnyName UPDATED";
        leadDetails.clickEditButton();
        leadForm = new LeadForm.LeadBuilder("Last name Edited",companyNameEdited)
                .setFirstName("Edited firstName")
                .setCountry("Argentina")
                .build();
        leadDetails = leadForm.saveLead();

        new AssertLead().assertDetailValues(leadDetails,leadForm.getLeadValues());

    }
    @AfterClass
    public void tearDown(){

    }
}
