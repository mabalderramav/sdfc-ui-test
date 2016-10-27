package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;

import static org.testng.Assert.assertEquals;

/**
 * This class is to assert of opportunities.
 */
public final class AssertContact {
    /**
     * Private constructor.
     */
    private AssertContact() {

    }

    /**
     * This method verify the values in opportunity detail.
     *
     * @param contactsDetail is a object.
     * @param valuesMapJson  is a map with values of a json file.
     */
    public static void assertDetailValues(final ContactsDetail contactsDetail,
                                          final Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> assertEquals(contactsDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
