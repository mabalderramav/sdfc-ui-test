package org.fundacionjala.sfdc.unittest.product;

import java.util.Map;

import org.testng.Assert;

import org.fundacionjala.sfdc.pages.products.ProductDetail;

/**
 * This class handle the assert product.
 */
public class AssertProduct {
    public void assertDetailValues(ProductDetail productDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(productDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
