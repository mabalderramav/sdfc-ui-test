package org.fundacionjala.sfdc.unittest.product;

import java.util.Map;

import org.testng.Assert;

import org.fundacionjala.sfdc.pages.products.ProductDetail;

/**
 * This class handle the assert product.
 */
final class AssertProduct {
    /**
     * Constructor private.
     */
    private AssertProduct() {
    }

    static void assertDetailValues(ProductDetail productDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(productDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
