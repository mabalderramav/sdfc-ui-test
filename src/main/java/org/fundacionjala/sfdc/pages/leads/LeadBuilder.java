package org.fundacionjala.sfdc.pages.leads;

/**
 * Created by LuLy on 23/10/2016.
 */
public class LeadBuilder {

    private LeadForm leadForm;

    public LeadBuilder(String lastName,String companyName){
        leadForm = new LeadForm();
    }
    public LeadDetails build(){
        return new LeadDetails();
    }
    public LeadBuilder setFirstName(String firstName){
        leadForm.setFirstNameField(firstName);
        return this;
    }
    public LeadBuilder setLastName(String lastName){
        leadForm.setLastNameField(lastName);
        return this;
    }
    public  LeadBuilder setCompany(String company){
        leadForm.setCompanyField(company);
        return this;
    }
}
