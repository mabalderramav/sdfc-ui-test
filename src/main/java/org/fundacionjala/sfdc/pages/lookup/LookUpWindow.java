package org.fundacionjala.sfdc.pages.lookup;


import java.util.LinkedList;
import java.util.Set;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * Class tha represents a modal lookUp.
 */
public class LookUpWindow extends AbstractBasePage {

    public static final String ALL_CAMPAIGN = "All Campaigns";

    private SearchSectionFrame searchFrame;
    private ListSectionFrame resultFrame;
    private LinkedList<String> windowsList;

    /**
     * Constructor that switch the LookUp window.
     */
    public LookUpWindow() {
        Set<String> windowsHandleSet = driver.getWindowHandles();
        windowsList = new LinkedList<>(windowsHandleSet);
        driver.switchTo().window(windowsList.getLast());
    }

    /**
     * Switch from the actual window to the parent window, without close it.
     */
    public void switchToParentWithoutCloseAction() {
        driver.switchTo().window(windowsList.getFirst());
    }

    /**
     * Method that select a campaign given a scope.
     *
     * @param parentCampaign String with the campaign name.
     * @param scope          String with the scope info.
     */
    public void selectCampaignWithNameByScope(final String parentCampaign, final String scope) {
        searchFrame = new SearchSectionFrame();
        searchFrame.searchTheCampaign(parentCampaign, scope);
        setALinkFromResults();
    }

    /**
     * This method select the campaign given a name.
     *
     * @param parentCampaign the campaign name to be selected.
     */
    public void selectCampaignWithName(final String parentCampaign) {
        searchFrame = new SearchSectionFrame();
        searchFrame.searchTheCampaign(parentCampaign);
        setALinkFromResults();
    }

    /**
     * Method that select the campaigns name link from the result search.
     */
    private void setALinkFromResults() {
        resultFrame = new ListSectionFrame();
        resultFrame.selectAResultFromTheList();
        switchToParentWithoutCloseAction();
    }

}
