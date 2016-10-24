package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;

public abstract class HomeBase extends AbstractBasePage {
    @FindBy(name = "new")
    @CacheLookup
    protected WebElement newButton;

    @FindBy(linkText = "Create New View")
    @CacheLookup
    protected WebElement createNewViewLink;

    @FindBy(linkText = "Edit")
    @CacheLookup
    protected WebElement editViewLink;

    /**
     * Clicks on "New" button.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickNewButton();

    /**
     * Clicks on "Create New View" link.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickCreateNewViewLink();

    /**
     * Clicks on "Edit" link.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickEditViewLink();

    /**
     * Search an object within the initial list on the corresponding page.
     *
     * @param value the string value for search on the page object.
     * @return a boolean value, true or false.
     */
    public Boolean existByLinkText(final String value) {
        return CommonActions.existElementByLinkText(value);
    }
}