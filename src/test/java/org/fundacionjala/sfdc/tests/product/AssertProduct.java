package org.fundacionjala.sfdc.tests.product;

import java.util.Map;

import org.fundacionjala.sfdc.pages.products.ProductDetail;

import static org.testng.Assert.assertEquals;

/**
 * This class handle the assert product.
 */
final class AssertProduct {
    /**
     * Constructor private.
     */
    private AssertProduct() {
    }

    /**
     * This method doing the assertion.
     *
     * @param productDetail {@inheritDoc}
     * @param valuesMapJson Map the fields with values.
     */
    static void assertDetailValues(final ProductDetail productDetail, final Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> assertEquals(productDetail.getStrategyAssertMap().get(value.toUpperCase()).getText(),
                        valuesMapJson.get(value.toUpperCase())));
    }
}
