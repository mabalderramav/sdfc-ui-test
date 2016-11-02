package org.fundacionjala.sfdc.pages.cases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;


/**
 * This class manage the information page objects.
 */
public class CaseInformation extends AbstractBasePage {

    @FindBy(css = "a.optionItem.efpDetailsView")
    @CacheLookup
    private WebElement detailsPanelOptions;

    /**
     * click on the details button panel.
     *
     * @return CaseDetail.
     */
    public CaseDetail clickOndetailsPanelOption() {
        CommonActions.clickElement(detailsPanelOptions);
        return new CaseDetail();
    }

}
