package org.fundacionjala.sfdc.pages.lookup;

/**
 * Class to manage the search popup for Lead.
 */
public class LeadSearchSectionFrame extends SearchSectionFrame {
    /**
     * Method that makes the search given the campaign name.
     *
     * @param campaign String with the campaign name.
     */
    public void searchTheCampaign(final String campaign) {
        setCampaign(campaign);
    }
}
