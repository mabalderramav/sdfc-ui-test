package org.fundacionjala.sfdc.pages.cases;


import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AlvaroDaza on 10/19/2016.
 */
public class CasesForm extends AbstractBasePage {

    @FindBy(id = "cas7")
    private WebElement statusComboBox;
    @FindBy(id = "cas8")
    private WebElement priorityComboBox;

    @FindBy(id = "cas11")
    private WebElement caseOriginComboBox;

    @FindBy(id = "cas5")
    private WebElement typeComboBox;

    @FindBy(id = "cas6")
    private WebElement caseReasonComboBox;

    @FindBy(css = "td[id=\"topButtonRow\"] > input[class=\"btn\"][name=\"save\"]")
    private WebElement saveButton;

    @FindBy(id = "cas14")
    private WebElement subjectTextField;

    @FindBy(id = "cas15")
    private WebElement descriptionTextField;

    @FindBy(id = "cas16")
    private WebElement internalCommentsTextField;

    @FindBy(id = "00N4100000BTanZ")
    private WebElement productComboBox;

    @FindBy(id = "00N4100000BTanY")
    private WebElement potentialLiabilityComboBox;

    @FindBy(id = "00N4100000BTanX")
    private WebElement engineeringNumberTextField;

    @FindBy(id = "00N4100000BTana")
    private WebElement slaViolation;


    public void clickOnStatusComboBox() {
        CommonActions.clickElement(statusComboBox);

    }

    public void clickOnComboBoxOption(String option) {
    //    driver.findElement(By.cssSelector("option[value=\"" + option + "\"]")).click();
        CommonActions.clickElement( driver.findElement(By.cssSelector("option[value=\"" + option + "\"]")));
    }

    public void clickOnCaseOriginComboBox() {
        caseOriginComboBox.click();
    }

    public CasesDetail clickOnSaveButton() {
       CommonActions.clickElement(saveButton);
        return new CasesDetail();
    }

    public void clickOnPriorityComboBoxOption() {
        priorityComboBox.click();
    }


    public void setSubjectText(String subject) {
        CommonActions.clearTextField(subjectTextField);
        CommonActions.sendKeys(subjectTextField,subject);
    }

    public void setDescriptionText(String description) {
        CommonActions.clearTextField(descriptionTextField);
        CommonActions.sendKeys(descriptionTextField,description);

    }

    public void clickOnTypeComboBox() {
       CommonActions.clickElement(typeComboBox);
    }

    public void clickOnCaseReasonComboBox() {
        CommonActions.clickElement(caseReasonComboBox);
    }

    public void setInternalDescription(String internalDescription) {
        CommonActions.clearTextField(internalCommentsTextField);
        CommonActions.sendKeys(internalCommentsTextField,internalDescription);
    }

    public void clickOnProductComboBox() {
        productComboBox.click();
    }

    public void clickOnPotentialLiabilityComboBox() {
        potentialLiabilityComboBox.click();
    }

    public void setEngineeringNumber(String number) {

        CommonActions.clearTextField(engineeringNumberTextField);
        CommonActions.sendKeys(engineeringNumberTextField,number);
    }

    public void clickOnSLAViolationComboBox() {
       CommonActions.clickElement(slaViolation);
    }
}
