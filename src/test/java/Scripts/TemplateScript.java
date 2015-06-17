package Scripts;

import Framework.BrowserManager;
import Pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TemplateScript {

    @Test
    public void scriptName()
    {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        new LoginPage()
                .setUserNameField("automationqa@autom.com")
                .setPasswordField("Control123")
                .clickLogInToSalesforceButton();
    }

    @BeforeTest
    public void BeforeTest()
    {

    }

    @AfterTest
    public void afterTest()
    {

    }

}
