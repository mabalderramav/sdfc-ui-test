package org.fundacionjala.sfdc.pages.campaigns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AlvaroDaza on 10/25/2016.
 */
public class Campaigns {

    private Campaigns.ProductBuilder productBuilder;

    private Map<String, String> valuesMap;

    public Campaigns(Campaigns.ProductBuilder productBuilder) {
        valuesMap = new HashMap<>();
        this.productBuilder = productBuilder;
    }

    public CampaignDetail createCampaign() {
        CampaignForm campaignForm = new CampaignForm();
        valuesMap = productBuilder.getStrategyMap();
        campaignForm.fillTheForm(valuesMap);
        return campaignForm.clickSaveButton();
    }

    public Map<String, String> getValuesMap() {
        return valuesMap;
    }


    public static class ProductBuilder {
        private String name;
        private String revenue;
     //   private String description;
     //   private Boolean active;
      //  private String family;

        private Map<String, String> strategyMap;

        public Campaigns build() {
            return new Campaigns(this);
        }

        public ProductBuilder(final String name) {
            strategyMap = new HashMap<>();
            strategyMap.put("campaignName", name);
            this.name = name;
        }

        public Campaigns.ProductBuilder setRevenue(String revenue) {
            strategyMap.put("revenue", revenue);
            this.revenue = revenue;
            return this;
        }

//        public Product.ProductBuilder setDescription(String description) {
//            strategyMap.put("descriptionProduct", description);
//            this.description = description;
//            return this;
//        }
//
//        public Product.ProductBuilder setActive(Boolean active) {
//            strategyMap.put("isActive", String.valueOf(active));
//            this.active = active;
//            return this;
//        }
//
//        public Product.ProductBuilder setFamily(String family) {
//            strategyMap.put("productFamily", family);
//            this.family = family;
//            return this;
//        }
//
        public Map<String, String> getStrategyMap() {
        return strategyMap;
       }
    }



}
