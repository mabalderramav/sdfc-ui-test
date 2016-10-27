package org.fundacionjala.sfdc.tests.campaign;

import java.util.Map;

import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;

import static org.junit.Assert.assertEquals;

/**
 * Class to manage the assertions for campaign.
 */
public final class AssertCampaign {

    /**
     * Private constructor.
     */
    private AssertCampaign() {
    }

    /**
     * Method that makes the assertions.
     * @param campaignDetail {@link CampaignDetail}
     * @param valuesMapJson Json values to be asserts.
     */
    static void assertDetailValues(final CampaignDetail campaignDetail, final Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> assertEquals(campaignDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
