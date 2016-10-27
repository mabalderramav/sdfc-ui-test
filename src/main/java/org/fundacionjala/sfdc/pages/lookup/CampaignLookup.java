package org.fundacionjala.sfdc.pages.lookup;


import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.leads.LeadForm;


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

    public CampaignForm selectCampaignWithNameByScope(String parentCampaign, String scope) {
        setSearchCampaignByScope(parentCampaign, scope);
        setACampaignFromResults();
        return new CampaignForm();
    }

    private void setSearchCampaignByScope(String campaign, String scope) {
        SearchSectionFrame searchFrame = new SearchSectionFrame();
        searchFrame.searchTheCampaign(campaign, scope);
    }

    /**
     *
     */
    private void setACampaignFromResults() {
        ListSectionFrame listFrame = new ListSectionFrame();
        listFrame.selectACampaignFromTheList();
        switchToParentWithoutCloseAction();
    }

    /**
     * This method select the campaign given a name.
     *
     * @param parentCampaign the campaign name to be selected.
     * @return the current LeadHome form.
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
    private void setSearchCampaign(final String campaign) {
        SearchSectionFrame searchFrame = new SearchSectionFrame();
        searchFrame.searchTheCampaign(campaign);
    }
}
