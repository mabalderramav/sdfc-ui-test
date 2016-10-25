package org.fundacionjala.sfdc.pages.contracts;

import java.util.HashMap;
import java.util.Map;

public class Contract {

    private ContractBuilder contractBuilder;

    public Contract(ContractBuilder opportunityBuilder) {
        this.contractBuilder = opportunityBuilder;
    }

    public ContractDetail createOpportunity() {
        ContractForm opportunityForm = new ContractForm();
        opportunityForm.fillTheForm(contractBuilder.getStrategyMap());
        return opportunityForm.clickSaveBtn();
    }

    public static class ContractBuilder {

        private String accountName;

        private String customerSignedBy;

        private String customerSignedTitle;

        private String customerSignedDate;

        private String priceBook;

        private String status;

        private String contractStartDate;

        private String contractTermMonths;

        private String ownerExpirationNotice;

        private String companySignedBy;

        private String companySignedDate;

        private Map<String, String> strategyMap;

        public ContractBuilder(String accountName, String status, String contractStartDate, String contractTermMonths) {
            strategyMap = new HashMap<>();
            this.accountName = accountName;
            this.status=status;
            this.contractStartDate=contractStartDate;
            this.contractTermMonths = contractTermMonths;
            //this.ownerExpirationNotice = "--None--";
        }

        public ContractBuilder setAccountName(String accountName) {
            this.accountName = accountName;
            strategyMap.put("accountName", accountName);
            return this;
        }

        public String getCustomerSignedBy() {
            return customerSignedBy;
        }

        public ContractBuilder setCustomerSignedBy(String customerSignedBy) {
            this.customerSignedBy = customerSignedBy;
            strategyMap.put("customerSignedBy", accountName);
            return this;
        }

        public String getCustomerSignedTitle() {
            return customerSignedTitle;
        }

        public ContractBuilder setCustomerSignedTitle(String customerSignedTitle) {
            this.customerSignedTitle = customerSignedTitle;
            strategyMap.put("customerSignedTitle", accountName);
            return this;
        }

        public String getCustomerSignedDate() {
            return customerSignedDate;
        }

        public ContractBuilder setCustomerSignedDate(String customerSignedDate) {
            this.customerSignedDate = customerSignedDate;
            strategyMap.put("customerSignedDate", accountName);
            return this;
        }

        public String getPriceBook() {
            return priceBook;
        }

        public ContractBuilder setPriceBook(String priceBook) {
            this.priceBook = priceBook;
            strategyMap.put("priceBook", accountName);
            return this;
        }

        public String getStatus() {
            return status;
        }

        public ContractBuilder setStatus(String status) {
            this.status = status;
            strategyMap.put("status", accountName);
            return this;
        }

        public String getContractStartDate() {
            return contractStartDate;
        }

        public ContractBuilder setContractStartDate(String contractStartDate) {
            this.contractStartDate = contractStartDate;
            strategyMap.put("contractStartDate", accountName);
            return this;
        }

        public String getContractTermMonths() {
            return contractTermMonths;
        }

        public ContractBuilder setContractTermMonths(String contractTermMonths) {
            this.contractTermMonths = contractTermMonths;
            strategyMap.put("contractTermMonths", accountName);
            return this;
        }

        public String getOwnerExpirationNotice() {
            return ownerExpirationNotice;
        }

        public ContractBuilder setOwnerExpirationNotice(String ownerExpirationNotice) {
            this.ownerExpirationNotice = ownerExpirationNotice;
            strategyMap.put("ownerExpirationNotice", accountName);
            return this;
        }

        public String getCompanySignedBy() {
            return companySignedBy;
        }

        public ContractBuilder setCompanySignedBy(String companySignedBy) {
            this.companySignedBy = companySignedBy;
            strategyMap.put("companySignedBy", accountName);
            return this;
        }

        public String getCompanySignedDate() {
            return companySignedDate;
        }

        public ContractBuilder setCompanySignedDate(String companySignedDate) {
            this.companySignedDate = companySignedDate;
            strategyMap.put("companySignedDate", accountName);
            return this;
        }

        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        public Contract build() {
            //Process data
            return new Contract(this);
        }

    }

}
