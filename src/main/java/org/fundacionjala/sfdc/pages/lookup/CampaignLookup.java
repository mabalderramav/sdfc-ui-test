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

    /**
     * Method that select a campaign given a scope.
     *
     * @param parentCampaign String with the campaign name.
     * @param scope          String with the scope info.
     * @return {@link CampaignForm}.
     */
    public CampaignForm selectCampaignWithNameByScope(final String parentCampaign, final String scope) {

        setSearchCampaignByScope(parentCampaign, scope);
        setACampaignFromResults();
        return new CampaignForm();
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
     * Method that makes the campaign search by the scope.
     *
     * @param campaign String with the campaign name.
     * @param scope    String with the scope info.
     */
    private void setSearchCampaignByScope(final String campaign, final String scope) {
        SearchSectionFrame searchFrame = new SearchSectionFrame();
        searchFrame.searchTheCampaign(campaign, scope);
    }

    /**
     * Method that select the campaigns name link from the result search.
     */
    private void setACampaignFromResults() {
        ListSectionFrame listFrame = new ListSectionFrame();
        listFrame.selectACampaignFromTheList();
        switchToParentWithoutCloseAction();
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
