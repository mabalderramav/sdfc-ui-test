package org.fundacionjala.sfdc.pages.lookup;

import org.fundacionjala.sfdc.pages.campaigns.NewCampaignForm;

/**
 * This class handle campaign lookup.
 */
public class CampaignLookup extends ModalWindow {

    public static final String ALL_CAMPAIGN = "All Campaigns";


    /**
     * Constructor that call the parent constructor.
     */
    public CampaignLookup() {
        init();
    }


    /**
     * 
     */
    public void setACampaignFromResults() {
        ListSectionFrame listFrame = new ListSectionFrame();
        listFrame.selectACampaignFromTheList();
        switchToParentWithoutCloseAction();
    }
}
