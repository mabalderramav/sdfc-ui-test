package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;

public class Opportunity {

    private OpportunityBuilder opportunityBuilder;

    public Opportunity(OpportunityBuilder opportunityBuilder) {
        this.opportunityBuilder = opportunityBuilder;
    }

    public OpportunityDetail createOpportunity() {
        OpportunityForm opportunityForm = new OpportunityForm();
        opportunityForm.fillTheForm(opportunityBuilder.getStrategyMap());
        return opportunityForm.clickSaveBtn();
    }

    public static class OpportunityBuilder {

        private String name;

        private String accountName;

        private String opportunityType;

        private int quantity;

        private int price;

        private Map<String, String> strategyMap;

        public OpportunityBuilder(String name, String newField) {
            strategyMap = new HashMap<>();
            this.name = name;
            this.opportunityType = "--None--";
        }

        public OpportunityBuilder setAccountName(String accountName) {
            this.accountName = accountName;
            strategyMap.put("accountName", accountName);
            return this;
        }

        public OpportunityBuilder setOpportunityType(String opportunityType) {
            this.opportunityType = opportunityType;
            strategyMap.put("OpportunityType", accountName);
            return this;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public OpportunityBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public String getName() {
            return name;
        }

        public String getAccountName() {
            return accountName;
        }

        public int calculateTotal() {
            return quantity * price;
        }

        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        public Opportunity build() {
            //Process data
            return new Opportunity(this);
        }

    }

}
