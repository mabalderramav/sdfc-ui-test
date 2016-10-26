package org.fundacionjala.sfdc.pages.opportunities;

/**
 * This enum is the fields of a opportunity.
 */
public enum OpportunityFields {
    TYPE("type"),
    LEAD_SOURCE("leadSource"),
    AMOUNT("amount"),
    NEXT_STEP("nextStep"),
    STAGE("stage"),
    ORDER_NUMBER("orderNumber"),
    DELIVERY_INSTALL_STATUS("deliveryInstallStatus"),
    ACCOUNT_NAME("accountName"),
    CURRENT_CLOSE_DATE("currentCloseDate"),
    PRIVATE_FLAG("privateFlag"),
    OPPORTUNITY_NAME("opportunityName");

    public final String VALUE;

    /**
     * This construct sets a string to the enums.
     *
     * @param VALUE is a string of the enum.
     */
    OpportunityFields(final String VALUE) {
        this.VALUE = VALUE;
    }

}
