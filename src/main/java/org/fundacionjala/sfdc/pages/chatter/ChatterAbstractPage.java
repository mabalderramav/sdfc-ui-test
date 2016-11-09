package org.fundacionjala.sfdc.pages.chatter;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class to represent the Chatter options.
 */
public class ChatterAbstractPage extends AbstractBasePage {

    @FindBy(id = "publishereditablearea")
    @CacheLookup
    private WebElement textArea;

    /**
     * Method tha click on post link.
     *
     * @return {@link PostForm}
     */
    public PostForm clickPostLnk() {
        CommonActions.clickElement(textArea);
        return new PostForm();
    }
}
