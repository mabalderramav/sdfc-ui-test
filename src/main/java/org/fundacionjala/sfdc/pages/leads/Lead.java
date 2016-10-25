package org.fundacionjala.sfdc.pages.leads;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuLy on 23/10/2016.
 */
public class Lead {

    private LeadBuilder leadBuilder;

    public Lead(LeadBuilder leadBuilder) {
        this.leadBuilder = leadBuilder;
    }

    public LeadDetails createLead() {
        LeadForm leadForm = new LeadForm();
        leadForm.fillTheForm(leadBuilder.getStrategyMap());
        return leadForm.clickSaveButton();
    }

    public static class LeadBuilder {
        /*LeadHome Information*/
        private String nameSalutation;
        private String firstName;
        private String lastName;
        private String company;
        private String title;
        private String leadSource;
        private String campaign;
        private String campaignLookup;
        private String industry;
        private String annualRevenue;
        private String phone;
        private String mobile;
        private String fax;
        private String email;
        private String website;
        private String leadStatus;
        private String rating;
        private String numEmployees;

        /*Address Information*/
        private String street;
        private String city;
        private String stateProvince;
        private String zipCode;
        private String country;

        /*additional information*/
        private String productInterest;
        private String SICCode;
        private String numberLocations;
        private String currentGenerators;
        private String primary;

        /*Others*/
        //public String description;
        private String assignRule;

        private Map<String, String> strategyMap;


        public LeadBuilder(final String lastName, final String company) {
            strategyMap = new HashMap<>();
            this.lastName = lastName;
            this.company = company;
        }

        public LeadBuilder setNameSalutation(String nameSalutation) {
            this.nameSalutation = nameSalutation;
            strategyMap.put("nameSalutation", nameSalutation);
            return this;
        }

        public LeadBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            strategyMap.put("firstName", firstName);
            return this;
        }

        public LeadBuilder setLastName(String lastName) {
            this.lastName = lastName;
            strategyMap.put("lastName", lastName);
            return this;
        }

        public LeadBuilder setCompany(String company) {
            this.company = company;
            strategyMap.put("company", company);
            return this;
        }

        public LeadBuilder setTitle(String title) {
            this.title = title;
            strategyMap.put("title", title);
            return this;
        }

        public LeadBuilder setLeadSource(String leadSource) {
            this.leadSource = leadSource;
            strategyMap.put("leadSource", leadSource);
            return this;
        }

       /* public LeadBuilder setCampaign(String campaign) {
            this.campaign = campaign;
            strategyMap.put("campaign",campaign);
            return this;
        }*/

        public LeadBuilder setCampaignLookup(String campaignLookup) {
            this.campaignLookup = campaignLookup;
            strategyMap.put("campaignLookup", campaignLookup);
            return this;
        }

        public LeadBuilder setIndustry(String industry) {
            this.industry = industry;
            strategyMap.put("industry", industry);
            return this;
        }

        public LeadBuilder setAnnualRevenue(String annualRevenue) {
            this.annualRevenue = annualRevenue;
            strategyMap.put("annualRevenue", annualRevenue);
            return this;
        }

        public LeadBuilder setPhone(String phone) {
            this.phone = phone;
            strategyMap.put("phone", phone);
            return this;
        }

        public LeadBuilder setMobile(String mobile) {
            this.mobile = mobile;
            strategyMap.put("mobile", mobile);
            return this;
        }

        public LeadBuilder setFax(String fax) {
            this.fax = fax;
            strategyMap.put("fax", fax);
            return this;
        }

        public LeadBuilder setEmail(String email) {
            this.email = email;
            strategyMap.put("email", email);
            return this;
        }

        public LeadBuilder setWebsite(String website) {
            this.website = website;
            strategyMap.put("website", website);
            return this;
        }

        public LeadBuilder setLeadStatus(String leadStatus) {
            this.leadStatus = leadStatus;
            strategyMap.put("leadStatus", leadStatus);
            return this;
        }

        public LeadBuilder setRating(String rating) {
            this.rating = rating;
            strategyMap.put("rating", rating);
            return this;
        }

        public LeadBuilder setNumEmployees(String numEmployees) {
            this.numEmployees = numEmployees;
            strategyMap.put("numEmployees", numEmployees);
            return this;
        }

        public LeadBuilder setStreet(String street) {
            this.street = street;
            strategyMap.put("street", street);
            return this;
        }

        public LeadBuilder setCity(String city) {
            this.city = city;
            strategyMap.put("city", city);
            return this;
        }

        public LeadBuilder setStateProvince(String stateProvince) {
            this.stateProvince = stateProvince;
            strategyMap.put("stateProvince", stateProvince);
            return this;
        }

        public LeadBuilder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            strategyMap.put("zipCode", zipCode);
            return this;
        }

        public LeadBuilder setCountry(String country) {
            this.country = country;
            strategyMap.put("country", country);
            return this;
        }

        public LeadBuilder setProductInterest(String productInterest) {
            this.productInterest = productInterest;
            strategyMap.put("productInterest", productInterest);
            return this;
        }

        public LeadBuilder setSICCode(String SICCode) {
            this.SICCode = SICCode;
            strategyMap.put("SICCode", SICCode);
            return this;
        }

        public LeadBuilder setNumberLocations(String numberLocations) {
            this.numberLocations = numberLocations;
            strategyMap.put("numberLocations", numberLocations);
            return this;
        }

        public LeadBuilder setCurrentGenerators(String currentGenerators) {
            this.currentGenerators = currentGenerators;
            strategyMap.put("currentGenerators", currentGenerators);
            return this;
        }

        public LeadBuilder setPrimary(String primary) {
            this.primary = primary;
            strategyMap.put("primary", primary);
            return this;
        }

        public LeadBuilder setAssignRule(String assignRule) {
            this.assignRule = assignRule;
            strategyMap.put("assignRule", assignRule);
            return this;
        }

        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        public Lead build() {
            return new Lead(this);
        }
    }

}
