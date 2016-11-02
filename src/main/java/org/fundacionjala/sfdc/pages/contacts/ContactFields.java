package org.fundacionjala.sfdc.pages.contacts;

/**
 * This enum is to contact fields.
 */
public enum ContactFields {
    FIRST_NAME_CATEGORY("firstNameCategory"),
    CONTACT_NAME("contactName"),
    LAST_NAME("lastName"),
    TITLE("title"),
    DEPARTMENT("department"),
    BIRTH_DATE("birthDate"),
    LEAD_SOURCE("leadSource"),
    MAIL("mail"),
    MAILING_STREET("mailingStreet"),
    OTHER_STREET("otherStreet");

    private final String value;

    /**
     * This construct sets a string to the enums.
     *
     * @param value is a string of the enum.
     */
    ContactFields(final String value) {
        this.value = value;
    }

    /**
     * Method that return the value.
     *
     * @return the corresponding value.
     */
    public String getValue() {
        return value;
    }
}
