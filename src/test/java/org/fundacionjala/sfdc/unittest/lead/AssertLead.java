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
     * @param valuesMap Original Json.
     * @return the new Json that was formatted.
     */
    public Map<String, String> formatJson(Map<String, String> valuesMap) {
        String fullName = valuesMap.get("nameSalutation")+" "
                + valuesMap.get("firstName") + " "
                + valuesMap.get("lastName");
        fullName = formatString(fullName);

        String address =
                valuesMap.get("street") + "\n"
                        + valuesMap.get("city")
                        + ", " + valuesMap.get("stateProvince")
                        + " " + valuesMap.get("zipCode")
                        + "\n" + valuesMap.get("country");
        address = formatString(address);

        valuesMap.put("fullName", fullName);
        //valuesMap.put("address", address);

        valuesMap.remove("nameSalutation");
        valuesMap.remove("firstName");
        valuesMap.remove("lastName");
        valuesMap.remove("campaignLookup");

        valuesMap.remove("street");
        valuesMap.remove("city");
        valuesMap.remove("stateProvince");
        valuesMap.remove("zipCode");
        valuesMap.remove("country");

        valuesMap.remove("annualRevenue");
        valuesMap.remove("assignRule");

        return valuesMap;
    }
    private String formatString(String value){
        String result = value.replaceAll("null", "").trim();
        if(result.startsWith(",")){
            result = result.replaceAll(",","").trim();
        }
        return result.trim();
    }

}
