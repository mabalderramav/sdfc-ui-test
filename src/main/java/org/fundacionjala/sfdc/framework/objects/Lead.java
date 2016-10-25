package org.fundacionjala.sfdc.framework.objects;

/**
 * Created by Pablo Zubieta on 01/09/2015.
 * Object that represents a LeadHome, holding all regarding information to create a new lead.
 * It will be filled by the JsonMapper object.
 */

public class Lead extends ElementBase {

    /*LeadHome Information*/
    public String nameSalutation;
    public String firstName;
    public String lastName;
    public String company;
    public String title;
    public String leadSource;
    public String campaign;
    public String campaignLookup;
    public String industry;
    public String annualRevenue;
    public String phone;
    public String mobile;
    public String fax;
    public String email;
    public String website;
    public String leadStatus;
    public String rating;
    public String numEmployees;

    /*Address Information*/
    public String street;
    public String city;
    public String stateProvince;
    public String zipCode;
    public String country;

    /*additional information*/
    public String productInterest;
    public String SICCode;
    public String numberLocations;
    public String currentGenerators;
    public String primary;

    /*Others*/
    //public String description;
    public String assignRule;

    public Lead() {
    }

}
