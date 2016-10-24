package org.fundacionjala.sfdc.unittest.lead;

import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadHome;
import org.fundacionjala.sfdc.utils.Common;

/**
 * This class verify the Creation of LeadHome.
 */
public class CreateLead {
    private LeadHome leadHomePage;
    private MainApp mainApp;
    private TabBar tabBar;
    private LeadDetails leadDetails;
    private LoginPage loginPage;
    public static final String LEAD_DATA_PATH = "src/test/resources/json/lead/CreateLeadData.json";
    private Map<String, String> valuesMapJson;


    /**
     * This method execute the preconditions to make the validation to the creation of lead.
     *
     */
    @BeforeTest
    public void setUp() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = new MainApp().goToTabBar();
        leadHomePage = tabBar.clickLead();
        // create campaign
    }

    /**
     * This method create a new LeadHome and make the corresponding assertions.
     */
    @Test
    public void createLeadTest(){
/*
        leadDetails = leadHomePage.clickNewButton()

                .fillNewLeadFromJson(LeadForm.LEAD_DATA_PATH)
                .clickSaveButton();
        org.fundacionjala.sfdc.framework.objects.LeadHome expectedLead =
                (org.fundacionjala.sfdc.framework.objects.LeadHome)JsonMapper.getData(LeadForm.LEAD_DATA_PATH,new org.fundacionjala.sfdc.framework.objects.LeadHome());
        assertEquals(leadDetails.getName(), expectedLead.nameSalutation + " " + expectedLead.firstName
                + " " + expectedLead.lastName, "LeadHome not created properly, names does not match");
                */
//        String firstName = "Test Name 01";
//        String lastName = "Test LastName";
//        String company = "Company Test";
//        LeadForm leadForm = leadHomePage.clickNewBtn();
//        leadForm = new LeadBuilder()
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setCompany(company)
//                .build();
//        leadDetails = leadForm.clickSaveButton();
        LeadForm leadForm = leadHomePage.clickNewBtn();
        valuesMapJson = Common.getMapJson(LEAD_DATA_PATH);
        leadForm.fillTheForm(valuesMapJson);
        leadDetails = leadForm.clickSaveButton();
        new AssertLead().assertDetailValues(leadDetails, valuesMapJson);


    }

    /**
     * This method delete the created LeadHome.
     */
    @AfterTest
    public void tearDown() {
        leadDetails.deleteLead();
    }
}


