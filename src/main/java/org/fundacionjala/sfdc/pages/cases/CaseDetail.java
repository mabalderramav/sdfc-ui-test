package org.fundacionjala.sfdc.pages.cases;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.sfdc.pages.cases.CasesFields.DESCRIPTION_TEXT;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.SLA_VIOLATION;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.SUBJECT_TEXT;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.ENGINEERING_NUMBER;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.POTENTIAL_LIABILITY;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.PRODUCT_VALUE;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.CASE_REASON;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.TYPE_VALUE;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.PRIORITY_VALUE;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.STATUS_DROOPDOWNLIST;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.CASES_ORIGIN_DROOPDOWNLIST;


/**
 * This class manage the Detail page objects.
 */
public class CaseDetail extends DetailBase {


    @FindBy(id = "cas11_ilecell")
    @CacheLookup
    private WebElement caseOriginTextField;

    @FindBy(id = "cas7_ilecell")
    @CacheLookup
    private WebElement statusTextField;

    @FindBy(css = "span[title=\"High\"]")
    @CacheLookup
    private WebElement priorityLabel;

    @FindBy(id = "cas5_ileinner")
    @CacheLookup
    private WebElement typeLabel;

    @FindBy(id = "cas6_ileinner")
    @CacheLookup
    private WebElement casesReasonLabel;

    @FindBy(id = "00N4100000BTanZ_ileinner")
    @CacheLookup
    private WebElement productLabel;

    @FindBy(id = "00N4100000BTanY_ileinner")
    @CacheLookup
    private WebElement liabilityLabel;

    @FindBy(id = "00N4100000BTanX_ileinner")
    @CacheLookup
    private WebElement engineeringNumberLabel;

    @FindBy(id = "00N4100000BTana_ileinner")
    @CacheLookup
    private WebElement slaLabel;

    @FindBy(id = "cas14_ileinner")
    @CacheLookup
    private WebElement subjectLabel;

    @FindBy(id = "cas15_ileinner")
    @CacheLookup
    private WebElement descriptionLabel;

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditButton() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CasesHome clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return new CasesHome();
    }


    /**
     * fill the map.
     *
     * @return Map whi the values charged.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();
        strategyMap.put(CASES_ORIGIN_DROOPDOWNLIST.getValue(), this::getCasesOrigin);
        strategyMap.put(STATUS_DROOPDOWNLIST.getValue(), this::getStatus);
        strategyMap.put(PRIORITY_VALUE.getValue(), this::getPriority);
        strategyMap.put(TYPE_VALUE.getValue(), this::getType);
        strategyMap.put(CASE_REASON.getValue(), this::getCasesReason);
        strategyMap.put(PRODUCT_VALUE.getValue(), this::getProduct);
        strategyMap.put(POTENTIAL_LIABILITY.getValue(), this::getLiability);
        strategyMap.put(ENGINEERING_NUMBER.getValue(), this::getEngineeringNumber);
        strategyMap.put(SLA_VIOLATION.getValue(), this::getSla);
        strategyMap.put(SUBJECT_TEXT.getValue(), this::getSubject);
        strategyMap.put(DESCRIPTION_TEXT.getValue(), this::getDescription);
        return strategyMap;
    }

    /**
     * get the description text.
     *
     * @return string whit the description.
     */
    private String getDescription() {
        return CommonActions.getText(descriptionLabel);
    }

    /**
     * get a subject text.
     *
     * @return String whit the subject text.
     */
    private String getSubject() {
        return CommonActions.getText(subjectLabel);
    }

    /**
     * get the sla value.
     *
     * @return String whit the sla value.
     */
    private String getSla() {
        return CommonActions.getText(slaLabel);
    }

    /**
     * get the engineering number.
     *
     * @return String whit the number.
     */
    private String getEngineeringNumber() {
        return CommonActions.getText(engineeringNumberLabel);

    }

    /**
     * get the liability text.
     *
     * @return String whit the value.
     */
    private String getLiability() {
        return CommonActions.getText(liabilityLabel);
    }

    /**
     * get the product name.
     *
     * @return String whit the name of the product.
     */
    private String getProduct() {
        return CommonActions.getText(productLabel);
    }

    /**
     * get the cases reason Text.
     *
     * @return String whit the value.
     */
    private String getCasesReason() {
        return CommonActions.getText(casesReasonLabel);
    }

    /**
     * get the type.
     *
     * @return String whit the type.
     */
    private String getType() {
        return CommonActions.getText(typeLabel);
    }

    /**
     * get the priority.
     *
     * @return String whit the value.
     */
    private String getPriority() {
        return CommonActions.getText(priorityLabel);
    }

    /**
     * get Case origin.
     *
     * @return String whit the value.
     */
    private String getCasesOrigin() {
        return CommonActions.getText(caseOriginTextField);
    }

    /**
     * get the status.
     *
     * @return String whit the status.
     */
    private String getStatus() {
        return CommonActions.getText(statusTextField);
    }


}
