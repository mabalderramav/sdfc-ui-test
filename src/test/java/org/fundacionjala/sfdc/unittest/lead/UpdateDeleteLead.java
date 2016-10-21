package org.fundacionjala.sfdc.unittest.lead;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.Lead;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;

import static org.testng.Assert.assertFalse;

/**
 * This class update and delete Lead.
 */
public class UpdateDeleteLead {
    private LeadDetails leadDetails;
    private Lead leadHomePage;
    @BeforeTest
    public void setUp(){
        LoginPage loginPage = new LoginPage();
        MainApp mainApp = loginPage.loginAsPrimaryUser();
        TabBar tabBar = new MainApp().goToTabBar();
        leadHomePage = tabBar.clickLead();
        leadDetails = leadHomePage.clickNewBtn()
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

    }
    @AfterTest
    public void tearDown(){

    }
}
