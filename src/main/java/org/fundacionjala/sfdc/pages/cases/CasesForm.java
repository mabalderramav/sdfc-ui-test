package org.fundacionjala.sfdc.pages.cases;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

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

import static java.lang.String.valueOf;


/**
 * This class manage the cases form page objects.
 */
public class CasesForm extends FormBase {

    @FindBy(id = "cas7")
    @CacheLookup
    private WebElement statusDropDownList;

    @FindBy(id = "cas11")
    @CacheLookup
    private WebElement caseOriginDropDownList;

    @FindBy(css = "select[id=\"00N4100000BTana\"]")
    @CacheLookup
    private WebElement slaDropDownList;

    @FindBy(id = "00N4100000BTanX")
    @CacheLookup
    private WebElement engieeneringNumberTextField;

    @FindBy(css = "select[id=\"00N4100000BTanY\"]")
    @CacheLookup
    private WebElement liabilityDropDownList;

    @FindBy(css = "select[id=\"00N4100000BTanZ\"]")
    @CacheLookup
    private WebElement productDropDownList;

    @FindBy(id = "cas6")
    @CacheLookup
    private WebElement caseReasonDropDownList;

    @FindBy(id = "cas5")
    @CacheLookup
    private WebElement typeDropDownList;

    @FindBy(css = "select[id=\"cas8\"]")
    @CacheLookup
    private WebElement priorityDropDownList;


    @FindBy(css = "input[id=\"cas14\"]")
    @CacheLookup
    private WebElement subjectTextBox;

    @FindBy(css = "textarea[id=\"cas15\"]")
    @CacheLookup
    private WebElement descriptionTextBox;

    /**
     * {@inheritDoc}
     */
    @Override
    public CaseInformation clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new CaseInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        return null;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * fill the map whit the sensed value.
     *
     * @param values Map whit the values.
     * @return Map whit the values.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();
        strategyMap.put(STATUS_DROOPDOWNLIST.getValue(),
                () -> setStatusDropDownList(valueOf(values.get(STATUS_DROOPDOWNLIST.getValue()))));
        strategyMap.put(CASES_ORIGIN_DROOPDOWNLIST.getValue(),
                () -> setCaseOriginDropDownList(valueOf(values.get(CASES_ORIGIN_DROOPDOWNLIST.getValue()))));
        strategyMap.put(PRIORITY_VALUE.getValue(),
                () -> setPriority(valueOf(values.get(PRIORITY_VALUE.getValue()))));
        strategyMap.put(TYPE_VALUE.getValue(), () -> setType(valueOf(values.get(TYPE_VALUE.getValue()))));
        strategyMap.put(CASE_REASON.getValue(), () -> setCaseReason(valueOf(values.get(CASE_REASON.getValue()))));
        strategyMap.put(PRODUCT_VALUE.getValue(), () -> setProduct(valueOf(values.get(PRODUCT_VALUE.getValue()))));
        strategyMap.put(POTENTIAL_LIABILITY.getValue(),
                () -> setPotentialLiability(valueOf(values.get(POTENTIAL_LIABILITY.getValue()))));
        strategyMap.put(ENGINEERING_NUMBER.getValue(),
                () -> setEngineeringNumber(valueOf(values.get(ENGINEERING_NUMBER.getValue()))));
        strategyMap.put(SLA_VIOLATION.getValue(),
                () -> setSlaViolation(valueOf(values.get(SLA_VIOLATION.getValue()))));
        strategyMap.put(SUBJECT_TEXT.getValue(),
                () -> setSubjectText(valueOf(values.get(SUBJECT_TEXT.getValue()))));
        strategyMap.put(DESCRIPTION_TEXT.getValue(),
                () -> setDescriptionText(valueOf(values.get(DESCRIPTION_TEXT.getValue()))));
        return strategyMap;
    }


    /**
     * set the description text.
     *
     * @param description String whit the text.
     * @return CasesForm class.
     */
    private CasesForm setDescriptionText(final String description) {
        CommonActions.sendKeys(descriptionTextBox, description);
        return this;
    }

    /**
     * set the subject text.
     *
     * @param subject String
     * @return CasesForm class.
     */
    private CasesForm setSubjectText(final String subject) {
        CommonActions.sendKeys(subjectTextBox, subject);
        return this;
    }

    /**
     * set the sla text.
     *
     * @param sla String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setSlaViolation(final String sla) {
        CommonActions.selectItem(slaDropDownList, sla);
        return this;
    }

    /**
     * set the engineering Number.
     *
     * @param engieeneringNumber String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setEngineeringNumber(final String engieeneringNumber) {
        CommonActions.sendKeys(engieeneringNumberTextField, engieeneringNumber);
        return this;
    }

    /**
     * set the liability value.
     *
     * @param liability String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setPotentialLiability(final String liability) {
        CommonActions.selectItem(liabilityDropDownList, liability);
        return this;
    }

    /**
     * set the product text.
     *
     * @param product String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setProduct(final String product) {
        CommonActions.selectItem(productDropDownList, product);
        return this;
    }

    /**
     * set te case Reason text.
     *
     * @param caseReason String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setCaseReason(final String caseReason) {
        CommonActions.selectItem(caseReasonDropDownList, caseReason);
        return this;
    }

    /**
     * set the type text.
     *
     * @param type String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setType(final String type) {
        CommonActions.selectItem(typeDropDownList, type);
        return this;
    }

    /**
     * set the priority text.
     *
     * @param priority String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setPriority(final String priority) {
        CommonActions.selectItem(priorityDropDownList, priority);
        return this;
    }

    /**
     * set the case origin text.
     *
     * @param caseOrigin String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setCaseOriginDropDownList(final String caseOrigin) {
        CommonActions.selectItem(caseOriginDropDownList, caseOrigin);
        return this;
    }

    /**
     * set the estatus value.
     *
     * @param status String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setStatusDropDownList(final String status) {
        CommonActions.selectItem(statusDropDownList, status);
        return this;
    }


}
