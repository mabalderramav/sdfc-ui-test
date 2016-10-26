package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;

public class Opportunity {

    private OpportunityBuilder opportunityBuilder;
    private  Map<String, String> valuesMap;

    public Opportunity(OpportunityBuilder opportunityBuilder) {
        valuesMap = new HashMap<>();
        this.opportunityBuilder = opportunityBuilder;
    }

    public OpportunityDetail createOpportunity() {
        OpportunityForm opportunityForm = new OpportunityForm();
        valuesMap = opportunityBuilder.getStrategyMap();
        opportunityForm.fillTheForm(valuesMap);
        return opportunityForm.clickSaveButton();
    }
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    public static class OpportunityBuilder {
        private String accountName;
        private String type;
        private int quantity;
        private int amount;
        private String opportunityName;
        private String closeDate;
        private String stage;

        private Map<String, String> strategyMap;

        public Opportunity build() {
            return new Opportunity(this);
        }

        public OpportunityBuilder(String opportunityName, String currentCloseDate, String stage) {
            strategyMap = new HashMap<>();
            strategyMap.put("opportunityName", opportunityName);
            strategyMap.put("currentCloseDate", currentCloseDate);
            strategyMap.put("stage", stage);
            this.opportunityName = opportunityName;
            this.closeDate = currentCloseDate;
            this.stage = stage;
//            this.type = "--None--";
        }

        public OpportunityBuilder setAccountName(String accountName) {
            this.accountName = accountName;
            strategyMap.put("accountName", accountName);
            return this;
        }

        public OpportunityBuilder setType(String type) {
            this.type = type;
            strategyMap.put("type", type);
            return this;
        }

        public OpportunityBuilder setOpportunityName(String opportunityName) {
            this.opportunityName = opportunityName;
            strategyMap.put("opportunityName", opportunityName);
            return this;
        }

        public OpportunityBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public OpportunityBuilder setCloseDate(String currentCloseDate) {
            this.closeDate = currentCloseDate;
            strategyMap.put("currentCloseDate", currentCloseDate);
            return this;
        }

        public OpportunityBuilder setStage(String stage) {
            this.stage = stage;
            strategyMap.put("stage", stage);
            return this;
        }

        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }

}
