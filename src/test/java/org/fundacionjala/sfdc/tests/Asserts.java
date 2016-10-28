package org.fundacionjala.sfdc.tests;

import java.util.Map;

import org.fundacionjala.sfdc.pages.base.DetailBase;

import static org.testng.Assert.assertEquals;

/**
 * Class to makes the assertions for all Details classes.
 */
public final class Asserts {

    /**
     * Private constructor.
     */
    private Asserts() {

    }

    /**
     * Method verifies the values for Details forms.
     *
     * @param detail        {@link DetailBase}
     * @param valuesMapJson is a map with values of a json file.
     */
    public static void assertDetailValues(final DetailBase detail, final Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> assertEquals(detail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
