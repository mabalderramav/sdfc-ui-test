package org.fundacionjala.sfdc.unittest.lead;

import java.util.Map;

import org.testng.Assert;

import org.fundacionjala.sfdc.pages.leads.LeadDetails;

/**
 * Created by lourdesVillca on 10/24/2016.
 */
public class AssertLead {
    public void assertDetailValues(LeadDetails leadDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(leadDetail.getStrategyAssertLead().get(value),
                        valuesMapJson.get(value)));
    }
}
