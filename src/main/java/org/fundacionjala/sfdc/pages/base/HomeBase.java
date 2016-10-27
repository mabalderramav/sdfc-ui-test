package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class to represent the displayed buttons in the home pages.
 */
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
}
