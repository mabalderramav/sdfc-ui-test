package org.fundacionjala.saleforceuitest.pages.leads;

import org.fundacionjala.saleforceuitest.pages.base.ElementFormBasePage;

/**
 * Created by Pablo Zubieta on 27/08/2015.
 * This class holds leads home page elements and inherits from FormBasePage the basic button "new"
 */

public class LeadAbstractPagePage extends ElementFormBasePage {

    public NewLeadPage clickNewBtn() {
        //wait.until(ExpectedConditions.visibilityOf(newElementBtn));
        newElementBtn.click();
        return new NewLeadPage();
    }
}