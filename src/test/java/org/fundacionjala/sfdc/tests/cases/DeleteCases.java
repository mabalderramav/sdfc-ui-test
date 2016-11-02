package org.fundacionjala.sfdc.tests.cases;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.cases.CaseDetail;
import org.fundacionjala.sfdc.pages.cases.CaseInformation;
import org.fundacionjala.sfdc.pages.cases.CasesForm;
import org.fundacionjala.sfdc.pages.cases.CasesHome;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertFalse;

/**
 * This is in charge to execute the test Delete Case.
 */
public class DeleteCases {

    static final String CASES_DATA_PATH = "cases/CreateCasesData.json";
    private Map<String, String> valuesMapJson;
    private CasesHome casesHome;
    private CaseInformation caseInformation;
    private CaseDetail caseDetail;

    /**
     * This method is a preconditions to create a case.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(CASES_DATA_PATH);
        final MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        casesHome = tabBar.clickOnCasesHome();
        CasesForm casesForm = casesHome.clickNewButton();
        casesForm.fillTheForm(valuesMapJson);
        caseInformation = casesForm.clickSaveButton();
        caseDetail = caseInformation.clickOndetailsPanelOption();
    }

    /**
     * This method test the elimination of a Case.
     */
    @Test
    public void createCaseWhitJsonFile() {
        casesHome = caseDetail.clickDeleteButton();
        assertFalse(casesHome.existCase(valuesMapJson.get("subject")));
    }

}
