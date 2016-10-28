package org.fundacionjala.sfdc.pages.accounts;

/**
 * Enum that contain all parameters of the AccountFields Form.
 */
public enum AccountFields {

    //account information
    ACCOUNT_NAME,
    PARENT_ACCOUNT,
    ACCOUNT_NUMBER,
    ACCOUNT_SITE,
    TYPE,
    INDUSTRY,
    ANNUAL_REVENUE,
    RATING,
    PHONE ,
    FAX,
    WEBSITE,
    TICKER_SYMBOL,
    OWNERSHIP,
    EMPLOYEES,
    SIC_CODE,

    //address information
    BILLING_STREET,
    BILLING_CITY,
    BILLING_STATE,
    BILLING_ZIP,
    BILLING_COUNTRY,
    SHIPPING_STREET,
    SHIPPING_CITY,
    SHIPPING_STATE,
    SHIPPING_ZIP,
    SHIPPING_COUNTRY,

    //additional information
    CUSTOMER_PRIORITY,
    SLA_EXPIRATION_DATE,
    NUMBER_LOCATIONS,
    ACTIVE,
    SLA,
    SLA_SERIAL,
    UPSELL_OPPORTUNITY,

    //description information
    DESCRIPTION
}
