package org.fundacionjala.saleforceuitest.unittest;

import org.fundacionjala.saleforceuitest.pages.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TemplateScript {

    @Test
    public void scriptName() {
        //DriverManager.getInstance().goStartPage("https://login.salesforce.com/");
        new LoginPage()
                .setUserNameField("automationqa@autom.com")
                .setPasswordField("Control123")
                .clickLogInToSalesforceButton();
    }

    @BeforeTest
    public void BeforeTest() {

    }

    @AfterTest
    public void afterTest() {

    }

}
