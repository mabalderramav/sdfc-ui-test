package org.fundacionjala.sfdc.pages.products;

import java.util.HashMap;
import java.util.Map;

/**
 * This class handle the product whit builder pattern
 */
public class Product {

    private ProductBuilder productBuilder;

    private Map<String, String> valuesMap;

    /**
     * Private constructor.
     *
     * @param productBuilder ProductBuilder class.
     */
    private Product(final ProductBuilder productBuilder) {
        valuesMap = new HashMap<>();
        this.productBuilder = productBuilder;
    }

    /**
     * This method created a new product on "Product" form.
     *
     * @return {@link ProductDetail}
     */
    public ProductDetail createProduct() {
        ProductForm productForm = new ProductForm();
        valuesMap = productBuilder.getStrategyMap();
        productForm.fillTheForm(valuesMap);
        return productForm.clickSaveButton();
    }

    /**
     * This method obtains values the Map set.
     *
     * @return A map with values set on "product" form.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }


    /**
     * This class handle the builder pattern.
     */
    public static class ProductBuilder {

        private String name;
        private String code;
        private String description;
        private Boolean active;
        private String family;

        private Map<String, String> strategyMap;

        public Product build() {
            return new Product(this);
        }

        /**
         * Constructor the ProductBuilder class.
         *
         * @param name Name required by the class.
         */
        public ProductBuilder(final String name) {
            strategyMap = new HashMap<>();
            strategyMap.put("productName", name);
            this.name = name;
        }

        /**
         * This method set the code product.
         *
         * @param code String with code.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setCode(final String code) {
            strategyMap.put("productCode", code);
            this.code = code;
            return this;
        }

        /**
         * This method set the description product.
         *
         * @param description String with description.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setDescription(final String description) {
            strategyMap.put("descriptionProduct", description);
            this.description = description;
            return this;
        }

        /**
         * This method set the active product.
         *
         * @param active Boolean with active.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setActive(final Boolean active) {
            strategyMap.put("isActive", String.valueOf(active));
            this.active = active;
            return this;
        }

        /**
         * This method set the family product.
         *
         * @param family String with family.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setFamily(final String family) {
            strategyMap.put("productFamily", family);
            this.family = family;
            return this;
        }

        /**
         * This method set the strategyMap product.
         *
         * @return A map with values set on "product" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }
}
