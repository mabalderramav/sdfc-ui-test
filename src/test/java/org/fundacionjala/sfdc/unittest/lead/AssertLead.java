package org.fundacionjala.sfdc.unittest.lead;

import java.util.Map;

import org.testng.Assert;

import org.fundacionjala.sfdc.pages.leads.LeadDetails;

/**
 * Class to manage the assertions for Lead Page.
 */
public class AssertLead {
    /**
     * Method to make the assertions.
     *
     * @param leadDetail    {@link LeadDetails}
     * @param valuesMapJson Json values to be asserts.
     */
    public void assertDetailValues(LeadDetails leadDetail, Map<String, String> valuesMapJson) {
        Map<String, String> formatJson = formatJson(valuesMapJson);

        formatJson.keySet()
                .forEach(value -> Assert.assertEquals(leadDetail.getStrategyAssertLead(valuesMapJson).get(value).getText(),
                        valuesMapJson.get(value)));
    }

    /**
     * Method to give a format the Json, according this new Json is built according the details Page.
     *
     * @param valuesMapJson Original Json.
     * @return the new Json that was formatted.
     */
    public Map<String, String> formatJson(Map<String, String> valuesMapJson) {
        String fullName = valuesMapJson.get("nameSalutation") + " " + valuesMapJson.get("firstName") + " " + valuesMapJson.get("lastName");
        String address = valuesMapJson.get("street") + "\n" + valuesMapJson.get("city") + ", " + valuesMapJson.get("stateProvince") + " " + valuesMapJson.get("zipCode") + "\n" + valuesMapJson.get("country");
        valuesMapJson.put("fullName", fullName);
        valuesMapJson.put("address", address);

        valuesMapJson.remove("nameSalutation");
        valuesMapJson.remove("firstName");
        valuesMapJson.remove("lastName");
        valuesMapJson.remove("campaignLookup");

        valuesMapJson.remove("street");
        valuesMapJson.remove("city");
        valuesMapJson.remove("stateProvince");
        valuesMapJson.remove("zipCode");
        valuesMapJson.remove("country");

        valuesMapJson.remove("annualRevenue");
        valuesMapJson.remove("assignRule");
        return valuesMapJson;
    }
}
