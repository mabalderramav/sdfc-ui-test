package org.fundacionjala.sfdc.tests.cases;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.cases.CaseDetail;
import org.fundacionjala.sfdc.pages.cases.CaseInformation;
import org.fundacionjala.sfdc.pages.cases.CasesForm;
import org.fundacionjala.sfdc.pages.cases.CasesHome;
import org.fundacionjala.sfdc.pages.cases.Cases;
import org.fundacionjala.sfdc.tests.Asserts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * This class manage the test create.
 */
public class CreateCases {

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
    }

    /**
     * This method create a case whit json file.
     */
    @Test
    public void createCaseWhitJsonFile() {
        CasesForm casesForm = casesHome.clickNewButton();
        casesForm.fillTheForm(valuesMapJson);
        caseInformation = casesForm.clickSaveButton();
        caseDetail = caseInformation.clickOndetailsPanelOption();
        Asserts.assertDetailValues(caseDetail, valuesMapJson);

    }

    /**
     * This method create a case whit builder pattern.
     */
    @Test()
    public void createCaseWhitBuilderPattern() {
        casesHome.clickNewButton();
        Cases cases = new Cases.CasesBuilder(valuesMapJson.get("status"), valuesMapJson.get("caseOrigin"))
                .setPriority(valuesMapJson.get("priority"))
                .setTypeValue(valuesMapJson.get("type"))
                .setCaseReason(valuesMapJson.get("caseReason"))
                .setSubject(valuesMapJson.get("subject"))
                .setDescription(valuesMapJson.get("description"))
                .build();
        caseDetail = cases.createCases();
        Asserts.assertDetailValues(caseDetail, cases.getValuesMap());
    }

    /**
     * Eliminate the case created.
     */
    @AfterMethod
    public void tearDown() {
        casesHome = caseDetail.clickDeleteButton();


    }
}
