package org.fundacionjala.sfdc.unittest.contact;

import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by Pc- Bruno on 10/24/2016.
 */
public class AssertContact {
    public void assertDetailValues(ContactsDetail contactsDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(contactsDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
