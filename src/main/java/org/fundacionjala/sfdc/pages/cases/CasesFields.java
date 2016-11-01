package org.fundacionjala.sfdc.pages.cases;

/**
 * Enum class.
 */
public enum CasesFields {

    STATUS_DROOPDOWNLIST("status"),
    CASES_ORIGIN_DROOPDOWNLIST("caseOrigin"),
    PRIORITY_VALUE("priority"),
    TYPE_VALUE("type"),
    CASE_REASON("caseReason"),
    PRODUCT_VALUE("product"),
    POTENTIAL_LIABILITY("potentialLiability"),
    ENGINEERING_NUMBER("engineeringNumber"),
    SLA_VIOLATION("slaViolation"),
    SUBJECT_TEXT("subject"),
    DESCRIPTION_TEXT("description"),
    COMMENT_TEXT("commentText");

    private final String value;

    /**
     * This construct sets a string to the enums.
     *
     * @param value is a string of the enum.
     */
    CasesFields(final String value) {
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
