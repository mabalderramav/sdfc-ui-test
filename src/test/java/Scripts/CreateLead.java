package Scripts;

/**
 * Created by Ronald on 23/06/2015.
 */


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework.JSONMapper;
import Framework.Objects.Lead;
import Pages.Leads.LeadAbstractPagePage;
import Pages.Leads.LeadDetailsPage;
import Pages.Leads.NewLeadPage;
import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;

public class CreateLead {
    private LeadAbstractPagePage leadHomePage;
    private NewLeadPage newLeadPage;
    private MainApp mainApp;
    private TabBar tabBar;

    private LoginPage loginPage;
    private String path="src\\test\\resources\\CreateLeadData.json";

    @BeforeTest
    public void setUp() throws Exception {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        leadHomePage = tabBar.clickLead();
        // create campaign
    }

    @Test
    public void createLeadTest() throws Exception {
        LeadDetailsPage leadDetailsPage  = leadHomePage.clickNewBtn().fillNewLeadFromJson(NewLeadPage.LEAD_DATA_PATH).clickSaveButton();
        Lead expectedLead = JSONMapper.getLeadData(NewLeadPage.LEAD_DATA_PATH);
        Assert.assertEquals(leadDetailsPage.getName(),expectedLead.nameSalutation + " " + expectedLead.firstName + " " + expectedLead.lastName, "Lead not created properly, names does not match");
    }

    @AfterTest
    public void tearDown() throws Exception {

    }
}


