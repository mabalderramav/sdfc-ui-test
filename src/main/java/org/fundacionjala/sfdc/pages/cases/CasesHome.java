package org.fundacionjala.sfdc.pages.cases;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class manage the page objects.
 */
public class CasesHome extends HomeBase {

    @FindBy(css = "table[class=\"list\"]")
    @CacheLookup
    private WebElement casesList;

    /**
     * {@inheritDoc}
     */
    @Override
    public CasesForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new CasesForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        return null;
    }

    /**
     * find if the subject case exist.
     *
     * @param subject String  subject text.
     * @return Boolean value.
     */
    public boolean existCase(final String subject) {
        List<WebElement> casesRows = casesList.findElements(By.cssSelector("td[class=\" dataCell  \"]"));
        return casesRows.stream().filter(webElement -> webElement.getText().equals(subject)).findAny().isPresent();
    }
}
