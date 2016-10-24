package org.fundacionjala.sfdc.unittest.opportunity;

import java.util.Map;

import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.testng.Assert;

/**
 * This class is to assert of opportunities.
 */
public class AssertOpportunity {
    /**
     * This method verify the values in opportunity detail.
     *
     * @param opportunityDetail is a object.
     * @param valuesMapJson     is a map with values of a json file.
     */
    public void assertDetailValues(final OpportunityDetail opportunityDetail, final Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(opportunityDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
