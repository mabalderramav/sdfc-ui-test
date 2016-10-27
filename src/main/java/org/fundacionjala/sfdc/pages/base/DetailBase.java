package org.fundacionjala.sfdc.pages.base;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;

/**
 * Class that represents the details options.
 */
public abstract class DetailBase extends AbstractBasePage {

    @FindBy(className = "topName")
    @CacheLookup
    protected WebElement objectNameText;

    @FindBy(className = "pageDescription")
    @CacheLookup
    protected WebElement pageDescriptionText;

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editBtn;

    @FindBy(name = "del")
    @CacheLookup
    protected WebElement deleteBtn;

    @FindBy(name = "clone")
    @CacheLookup
    protected WebElement cloneBtn;

    /**
     * Returns the name of the object.
     *
     * @return object name.
     */
    public String getObjectName() {
        return CommonActions.getText(objectNameText);
    }

    /**
     * Returns the description of the object.
     *
     * @return object description.
     */
    public String getPageDescription() {
        return CommonActions.getText(pageDescriptionText);
    }

    /**
     * Clicks on "edit" button.
     *
     * @return {@link AbstractBasePage}
     */
    public abstract AbstractBasePage clickEditButton();

    /**
     * Clicks on "delete" button.
     *
     * @return {@link AbstractBasePage}
     */
    public abstract AbstractBasePage clickDeleteButton();

    /**
     * Method that load the Strategy Map to make the assertions.
     * @return the Map with the values to make assertions.
     */
    public abstract Map<String, AssertsDetails> getStrategyAssertMap();

}
