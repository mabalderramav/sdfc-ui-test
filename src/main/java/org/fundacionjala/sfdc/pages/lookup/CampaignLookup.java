package org.fundacionjala.sfdc.pages.lookup;


import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;


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
     * Method that makes the campaign search by the scope.
     *
     * @param campaign String with the campaign name.
     * @param scope    String with the scope info.
     */
    public void setSearchCampaignByScope(final String campaign, final String scope) {
        SearchSectionFrame searchFrame = new SearchSectionFrame();
        searchFrame.searchTheCampaign(campaign, scope);
    }

    /**
     * Method that select the campaigns name link from the result search.
     */
    public void setACampaignFromResults() {
        ListSectionFrame listFrame = new ListSectionFrame();
        listFrame.selectACampaignFromTheList();
        switchToParentWithoutCloseAction();
    }
}
