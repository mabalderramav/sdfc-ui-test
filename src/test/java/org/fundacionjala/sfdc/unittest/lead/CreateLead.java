package org.fundacionjala.sfdc.unittest.lead;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.Lead;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadForm;

/**
 * This class verify the Creation of Lead.
 */
public class CreateLead {
    private Lead leadHomePage;
    private MainApp mainApp;
    private TabBar tabBar;
    private LeadDetails leadDetails;
    private LoginPage loginPage;

    /**
     * This method execute the preconditions to make the validation to the creation of lead.
     *
     */
    @BeforeTest
    public void setUp() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        leadHomePage = tabBar.clickLead();
        // create campaign
    }

    /**
     * This method create a new Lead and make the corresponding assertions.
     */
    @Test
    public void createLeadTest(){
        leadDetails = leadHomePage.clickNewButton()
                .fillNewLeadFromJson(LeadForm.LEAD_DATA_PATH)
                .clickSaveButton();
        org.fundacionjala.sfdc.framework.objects.Lead expectedLead = (org.fundacionjala.sfdc.framework.objects.Lead)JsonMapper.getData(LeadForm.LEAD_DATA_PATH,new org.fundacionjala.sfdc.framework.objects.Lead());
        Assert.assertEquals(leadDetails.getName(), expectedLead.nameSalutation + " " + expectedLead.firstName
                + " " + expectedLead.lastName, "Lead not created properly, names does not match");
    }

    /**
     * This method delete the created Lead.
     */
    @AfterTest
    public void tearDown() {
        leadDetails.deleteLead();
    }
}


