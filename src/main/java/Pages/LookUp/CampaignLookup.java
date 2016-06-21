package Pages.LookUp;

import Pages.Base.AbstractModalWindow;
import Pages.Campaigns.NewCampaignForm;

/**
 * Created by ccatari on 5/22/2016.
 */
public class CampaignLookup extends AbstractModalWindow {

    public static final String ALL_CAMPAIGN = "All Campaigns";

    public CampaignLookup(){
        init();
    }

    public NewCampaignForm selectCampaignWithNameByScope(String parentCampaign,String scope) {
        setSearchCampaignByScope(parentCampaign,scope);
        setACampaignFromResults();
        return new NewCampaignForm();
    }

    public void setSearchCampaignByScope(String campaign, String scope){
        SearchSectionFrame searchFrame = new SearchSectionFrame();
        searchFrame.searchTheCampaign(campaign,scope);
    }
    public void setACampaignFromResults(){
        ListSectionFrame listFrame = new ListSectionFrame();
        listFrame.selectACampaignFromTheList();
        switchToParentWithoutCloseAction();
    }
}
