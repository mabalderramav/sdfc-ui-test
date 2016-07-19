package Pages.Leads;

import Pages.LookUp.CampaignLookup;
import Pages.LookUp.LeadSearchSectionFrame;

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
