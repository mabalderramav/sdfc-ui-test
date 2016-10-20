package org.fundacionjala.sfdc.pages.leads;

import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.fundacionjala.sfdc.pages.lookup.LeadSearchSectionFrame;

/**
 * Class to manage the campaign lookup.
 */
public class LeadCampaignLookup extends CampaignLookup {

    /**
     * This method select the campaign given a name.
     *
     * @param parentCampaign the campaign name to be selected
     * @return the current Lead form.
     */
    public LeadForm selectCampaignWithName(final String parentCampaign) {
        setSearchCampaign(parentCampaign);
        setACampaignFromResults();
        return new LeadForm();
    }

    /**
     * This method search the campaign by its name.
     *
     * @param campaign the campaign name.
     */
    public void setSearchCampaign(final String campaign) {
        LeadSearchSectionFrame searchFrame = new LeadSearchSectionFrame();
        searchFrame.searchTheCampaign(campaign);
    }
}
