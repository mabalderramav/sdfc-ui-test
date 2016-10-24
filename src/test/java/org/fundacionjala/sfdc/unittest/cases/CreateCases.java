package org.fundacionjala.sfdc.unittest.cases;


import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.cases.Cases;
import org.fundacionjala.sfdc.pages.cases.CasesDetail;
import org.fundacionjala.sfdc.pages.cases.CasesForm;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by AlvaroDaza on 10/19/2016.
 */
public class CreateCases {
    private LoginPage loginPage;
    private MainApp mainApp;
    private TabBar tabBar;
    private CasesForm newCasesForm;

    private Cases casesAbstractPage;

   private String subject = "Alvaro Daza Quiroga";

    String description = "This case is a test for Sales Force";

    String internalDescription = "This is a internal Description for Sales force ";

    @BeforeTest
    public void beforeTest() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        casesAbstractPage = tabBar.clickOnCasesTab();
        newCasesForm = casesAbstractPage.clickNewButton();

    }

    @Test
    public void createCases() {

        newCasesForm.setSubjectText(subject);
        newCasesForm.setDescriptionText(description);
        newCasesForm.setInternalDescription(internalDescription);
        newCasesForm.clickOnProductComboBox();
        newCasesForm.clickOnComboBoxOption("GC3040");
        newCasesForm.clickOnPotentialLiabilityComboBox();
        newCasesForm.clickOnComboBoxOption("No");
        newCasesForm.clickOnStatusComboBox();
        newCasesForm.clickOnComboBoxOption("Working");
        newCasesForm.clickOnTypeComboBox();
        newCasesForm.clickOnComboBoxOption("Electrical");
        newCasesForm.clickOnCaseReasonComboBox();
        newCasesForm.clickOnComboBoxOption("Breakdown");
        newCasesForm.clickOnCaseOriginComboBox();
        newCasesForm.clickOnComboBoxOption("Web");
        newCasesForm.clickOnPriorityComboBoxOption();
        newCasesForm.clickOnComboBoxOption("Medium");
        newCasesForm.setEngineeringNumber("123456");
        newCasesForm.clickOnSLAViolationComboBox();
        newCasesForm.clickOnComboBoxOption("Yes");
        CasesDetail casesProfile = newCasesForm.clickOnSaveButton();
       // Assert.assertEquals(CasesDetail.getSubject(),subject);
    }
}
