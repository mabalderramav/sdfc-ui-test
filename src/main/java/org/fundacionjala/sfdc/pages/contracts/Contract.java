package org.fundacionjala.sfdc.pages.contracts;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to manage the builder Pattern for Contract.
 */
public class Contract {

    private ContractBuilder contractBuilder;

    /**
     * Constructor.
     *
     * @param contractBuilder contract to build.
     */
    public Contract(final ContractBuilder contractBuilder) {
        this.contractBuilder = contractBuilder;
    }

    /**
     * Method to create the contract.
     *
     * @return {@link ContractDetail}
     */
    public ContractDetail createContract() {
        ContractForm opportunityForm = new ContractForm();
        opportunityForm.fillTheForm(contractBuilder.getStrategyMap());
        return opportunityForm.clickSaveBtn();
    }

    /**
     * Inner class that manage the values to be built.
     */
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

        /**
         * Constructor that built contract with the default value.
         *
         * @param accountName        String with the account name data.
         * @param status             String with the status info.
         * @param contractStartDate  String with the start date data.
         * @param contractTermMonths String with the contract term months info.
         */
        public ContractBuilder(final String accountName, final String status,
                               final String contractStartDate, final String contractTermMonths) {
            strategyMap = new HashMap<>();
            this.accountName = accountName;
            this.status = status;
            this.contractStartDate = contractStartDate;
            this.contractTermMonths = contractTermMonths;
            //this.ownerExpirationNotice = "--None--";
        }

        /**
         * Method that sets the Account name.
         *
         * @param accountName String with the account name.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setAccountName(final String accountName) {
            this.accountName = accountName;
            strategyMap.put("accountName", accountName);
            return this;
        }

        /**
         * Method that get the customer signed by info.
         *
         * @return String with the customer signed by data.
         */
        public String getCustomerSignedBy() {
            return customerSignedBy;
        }

        /**
         * Method that sets the customer signed by.
         *
         * @param customerSignedBy String with the customer signed by info.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedBy(final String customerSignedBy) {
            this.customerSignedBy = customerSignedBy;
            strategyMap.put("customerSignedBy", accountName);
            return this;
        }

        /**
         * Method that get the customer signed title.
         *
         * @return a String with the customer signed title.
         */
        public String getCustomerSignedTitle() {
            return customerSignedTitle;
        }

        /**
         * Method that sets the customer signed title.
         *
         * @param customerSignedTitle String with the customer signed title.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedTitle(final String customerSignedTitle) {
            this.customerSignedTitle = customerSignedTitle;
            strategyMap.put("customerSignedTitle", accountName);
            return this;
        }

        /**
         * Method that gets the customer signed date.
         *
         * @return a String with the customer signed date.
         */
        public String getCustomerSignedDate() {
            return customerSignedDate;
        }

        /**
         * Method that sets the customer signed date.
         *
         * @param customerSignedDate String with the customer signed date.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedDate(final String customerSignedDate) {
            this.customerSignedDate = customerSignedDate;
            strategyMap.put("customerSignedDate", accountName);
            return this;
        }

        /**
         * Method that get the price of the book.
         *
         * @return a String with the price book.
         */
        public String getPriceBook() {
            return priceBook;
        }

        /**
         * Method that sets the price book.
         *
         * @param priceBook String with the price book info.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setPriceBook(final String priceBook) {
            this.priceBook = priceBook;
            strategyMap.put("priceBook", accountName);
            return this;
        }

        /**
         * Method that gets the status.
         *
         * @return a String with the status info.
         */
        public String getStatus() {
            return status;
        }

        /**
         * Method that sets the status.
         *
         * @param status String with the status info.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setStatus(final String status) {
            this.status = status;
            strategyMap.put("status", accountName);
            return this;
        }

        /**
         * Method that gets the contract start date.
         *
         * @return a String with the contract start date.
         */
        public String getContractStartDate() {
            return contractStartDate;
        }

        /**
         * Method that sets the contract start date.
         *
         * @param contractStartDate String with the contract start date.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractStartDate(final String contractStartDate) {
            this.contractStartDate = contractStartDate;
            strategyMap.put("contractStartDate", accountName);
            return this;
        }

        /**
         * Method that gets the contract term months.
         *
         * @return String with the Contract Term Months.
         */
        public String getContractTermMonths() {
            return contractTermMonths;
        }

        /**
         * Method that set the Contract term months.
         *
         * @param contractTermMonths String with the contract term months.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractTermMonths(final String contractTermMonths) {
            this.contractTermMonths = contractTermMonths;
            strategyMap.put("contractTermMonths", accountName);
            return this;
        }

        /**
         * Method that sets the owner expiration notice.
         *
         * @return a String with the owner expiration notice data.
         */
        public String getOwnerExpirationNotice() {
            return ownerExpirationNotice;
        }

        /**
         * Method that sets the owner expiration notice.
         *
         * @param ownerExpirationNotice String with the owner expiration notice info.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setOwnerExpirationNotice(final String ownerExpirationNotice) {
            this.ownerExpirationNotice = ownerExpirationNotice;
            strategyMap.put("ownerExpirationNotice", accountName);
            return this;
        }

        /**
         * Method that gets the company signed by.
         *
         * @return a String with the company signed by info.
         */
        public String getCompanySignedBy() {
            return companySignedBy;
        }

        /**
         * Method that sets the company signed by.
         *
         * @param companySignedBy String with the company signed by.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedBy(final String companySignedBy) {
            this.companySignedBy = companySignedBy;
            strategyMap.put("companySignedBy", accountName);
            return this;
        }

        /**
         * Method that gets the company signed date info.
         *
         * @return a String with the company signed date info.
         */
        public String getCompanySignedDate() {
            return companySignedDate;
        }

        /**
         * Method that sets the company signed date.
         * @param companySignedDate String with the company signed date.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedDate(final String companySignedDate) {
            this.companySignedDate = companySignedDate;
            strategyMap.put("companySignedDate", accountName);
            return this;
        }

        /**
         * Method that gets the Map with the set values.
         * @return a Map with the filled data.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        /**
         * Method that build the contract form.
         * @return {@link Contract}
         */
        public Contract build() {
            //Process data
            return new Contract(this);
        }

    }

}
