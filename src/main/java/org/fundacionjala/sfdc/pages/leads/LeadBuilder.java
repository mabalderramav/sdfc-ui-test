package org.fundacionjala.sfdc.pages.leads;

import org.fundacionjala.sfdc.framework.objects.Lead;

/**
 * Created by LuLy on 23/10/2016.
 */
public class LeadBuilder {

    private LeadForm leadForm;

    public LeadBuilder(){
        leadForm = new LeadForm();
    }
    public LeadForm build(){
        return leadForm;
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
