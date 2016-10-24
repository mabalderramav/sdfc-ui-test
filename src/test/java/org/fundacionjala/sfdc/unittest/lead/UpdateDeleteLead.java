package org.fundacionjala.sfdc.unittest.lead;

import org.fundacionjala.sfdc.pages.leads.LeadHome;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;

import static org.testng.Assert.assertFalse;

/**
 * This class update and delete LeadHome.
 */
public class UpdateDeleteLead {
    private LeadDetails leadDetails;
    private LeadHome leadHomeHomePage;
    @BeforeTest
    public void setUp(){
        LoginPage loginPage = new LoginPage();
        MainApp mainApp = loginPage.loginAsPrimaryUser();
        TabBar tabBar = new MainApp().goToTabBar();
        leadHomeHomePage = tabBar.clickLead();
        leadDetails = leadHomeHomePage.clickNewBtn()
                .setFirstNameField("Test Name 01")
                .setLastNameField("Test LastName")
                .setCompanyField("Company Test")
                .clickSaveButton();
    }
    @Test
    public void deleteLead(){
        leadDetails.deleteLead();
        assertFalse(leadHomeHomePage.isLeadDisplayed("Test Name 01"));
    }
    @Test void updateLead(){

    }
    @AfterTest
    public void tearDown(){

    }
}
