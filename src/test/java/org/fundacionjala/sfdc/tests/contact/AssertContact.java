package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.testng.Assert;

/**
 * This class is to assert of opportunities.
 */
public class AssertContact {
    /**
     * This method verify the values in opportunity detail.
     *
     * @param contactsDetail is a object.
     * @param valuesMapJson  is a map with values of a json file.
     */
    public void assertDetailValues(final ContactsDetail contactsDetail, final Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(contactsDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
