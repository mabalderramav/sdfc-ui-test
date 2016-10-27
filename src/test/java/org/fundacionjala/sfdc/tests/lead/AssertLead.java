package org.fundacionjala.sfdc.tests.lead;

import java.util.Map;

import org.testng.Assert;

import org.fundacionjala.sfdc.pages.leads.LeadDetails;

import static org.fundacionjala.sfdc.pages.leads.LeadFields.ADDRESS;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ANNUAL_REVENUE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ASSIGN_RULE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.CAMPAIGN;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.CITY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.COUNTRY;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FIRST_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.FULL_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.LAST_NAME;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.NAME_SALUTATION;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.STATE_PROVINCE;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.STREET;
import static org.fundacionjala.sfdc.pages.leads.LeadFields.ZIP_CODE;

/**
 * Class to manage the assertions for LeadFields Page.
 */
public class AssertLead {

    /**
     * Method to make the assertions.
     *
     * @param leadDetail    {@link LeadDetails}
     * @param valuesMapJson Json values to be asserts.
     */
    public void assertDetailValues(final LeadDetails leadDetail, final Map<String, String> valuesMapJson) {
        Map<String, String> formatJson = formatJson(valuesMapJson);

        formatJson.keySet()
                .forEach(value -> Assert.assertEquals(leadDetail.getStrategyAssertLead().get(value).getText(),
                        valuesMapJson.get(value)));
    }

    /**
     * Method to give a format the Json, according this new Json is built according the details Page.
     *
     * @param valuesMap Original Json.
     * @return the new Json that was formatted.
     */
    public Map<String, String> formatJson(final Map<String, String> valuesMap) {
        String fullName = valuesMap.get(NAME_SALUTATION.toString()) + " "
                + valuesMap.get(FIRST_NAME.toString()) + " "
                + valuesMap.get(LAST_NAME.toString());
        fullName = formatString(fullName);

        String address =
                valuesMap.get(STREET.toString()) + "\n"
                        + valuesMap.get(CITY.toString())
                        + ", " + valuesMap.get(STATE_PROVINCE.toString())
                        + " " + valuesMap.get(ZIP_CODE.toString())
                        + "\n" + valuesMap.get(COUNTRY.toString());
        address = formatString(address);

        valuesMap.put(FULL_NAME.toString(), fullName);
        valuesMap.put(ADDRESS.toString(), address);

        valuesMap.remove(NAME_SALUTATION.toString());
        valuesMap.remove(FIRST_NAME.toString());
        valuesMap.remove(LAST_NAME.toString());
        valuesMap.remove(CAMPAIGN.toString());

        valuesMap.remove(STREET.toString());
        valuesMap.remove(CITY.toString());
        valuesMap.remove(STATE_PROVINCE.toString());
        valuesMap.remove(ZIP_CODE.toString());
        valuesMap.remove(COUNTRY.toString());

        valuesMap.remove(ANNUAL_REVENUE.toString());
        valuesMap.remove(ASSIGN_RULE.toString());

        return valuesMap;
    }

    /**
     * Method that give a format to a string.
     *
     * @param value String with the value data.
     * @return the string formatted.
     */
    private String formatString(final String value) {
        String result = value.replaceAll("null", "").trim();
        if (result.startsWith(",")) {
            result = result.replaceAll(",", "").trim();
        }
        return result.trim();
    }
}
