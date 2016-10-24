package org.fundacionjala.sfdc.unittest.opportunity;

import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by Pc- Bruno on 10/23/2016.
 */
public class AssertOpportunity {
    public void assertDetailValues(OpportunityDetail opportunityDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(opportunityDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
