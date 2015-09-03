package Framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import Framework.Objects.Account;
import Framework.Objects.Lead;
import Framework.Objects.Opportunity;
import java.io.File;
import java.io.IOException;

/**
 * Created by Pablo Zubieta on 01/09/2015.
 */
public class JSONMapper {

    public static Opportunity getOpportunityData(String jsonFile){
        Opportunity opportunity = new Opportunity();
        try {
            ObjectMapper mapper = new ObjectMapper();
            opportunity = mapper.readValue(new File(jsonFile), Opportunity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return opportunity;
    }

    public static Lead getLeadData(){
        Lead lead = new Lead();
        try {
            ObjectMapper mapper = new ObjectMapper();
            lead = mapper.readValue(new File("src\\test\\resources\\CreateLeadData.json"), Lead.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lead;
    }

    public static Account getAccountData(){
        Account account = new Account();
        try {
            ObjectMapper mapper = new ObjectMapper();
            account = mapper.readValue(new File("src\\test\\resources\\CreateAccountData.json"), Account.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }


}
