package org.fundacionjala.sfdc.pages.products;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private ProductBuilder productBuilder;

    private  Map<String, String> valuesMap;

    public Product(ProductBuilder productBuilder) {
        valuesMap = new HashMap<>();
        this.productBuilder = productBuilder;
    }

    public ProductDetail createProduct() {
        ProductForm productForm = new ProductForm();
        valuesMap = productBuilder.getStrategyMap();
        productForm.fillTheForm(valuesMap);
        return productForm.clickSaveButton();
    }

    public Map<String, String> getValuesMap() {
        return valuesMap;
    }


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

        public ProductBuilder(final String name) {
            strategyMap = new HashMap<>();
            strategyMap.put("productName", name);
            this.name = name;
        }

        public ProductBuilder setCode(String code) {
            strategyMap.put("productCode", code);
            this.code = code;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            strategyMap.put("descriptionProduct", description);
            this.description = description;
            return this;
        }

        public ProductBuilder setActive(Boolean active) {
            strategyMap.put("isActive", String.valueOf(active));
            this.active = active;
            return this;
        }

        public ProductBuilder setFamily(String family) {
            strategyMap.put("productFamily", family);
            this.family = family;
            return this;
        }

        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }
}
