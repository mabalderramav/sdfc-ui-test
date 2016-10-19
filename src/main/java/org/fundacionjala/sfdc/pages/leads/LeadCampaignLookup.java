package org.fundacionjala.sfdc.pages.leads;

import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.fundacionjala.sfdc.pages.lookup.LeadSearchSectionFrame;

/**
 * Created by ccatari on 6/20/2016.
 */
public class LeadCampaignLookup extends CampaignLookup {

    public NewLeadPage selectCampaignWithName(String parentCampaign) {
        setSearchCampaign(parentCampaign);
        setACampaignFromResults();
        return new NewLeadPage();
    }

    public void setSearchCampaign(String campaign){
        LeadSearchSectionFrame searchFrame = new LeadSearchSectionFrame();
        searchFrame.searchTheCampaign(campaign);
    }
}
