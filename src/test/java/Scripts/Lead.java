package Scripts;

/**
 * Created by Ronald on 23/06/2015.
 */


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Lead {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://na24.salesforce.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("div.loginbox_container > div.identity.first")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("automationqa@autom.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Control123");
        driver.findElement(By.id("Login")).click();

        driver.findElement(By.linkText("Leads")).click();

        driver.findElement(By.name("new")).click();

        new Select(driver.findElement(By.id("name_salutationlea2"))).selectByVisibleText("Dr.");

        driver.findElement(By.id("name_firstlea2")).clear();
        driver.findElement(By.id("name_firstlea2")).sendKeys("Ronald");

        driver.findElement(By.id("name_middlelea2")).clear();
        driver.findElement(By.id("name_middlelea2")).sendKeys("Edson");

        driver.findElement(By.id("name_lastlea2")).clear();
        driver.findElement(By.id("name_lastlea2")).sendKeys("Sanchcez");

        driver.findElement(By.id("name_suffixlea2")).clear();
        driver.findElement(By.id("name_suffixlea2")).sendKeys("Lic.");

        driver.findElement(By.id("lea4")).clear();
        driver.findElement(By.id("lea4")).sendKeys("Doctor");

        driver.findElement(By.id("lea11")).clear();
        driver.findElement(By.id("lea11")).sendKeys("test@mail.com");

        driver.findElement(By.id("lea8")).clear();
        driver.findElement(By.id("lea8")).sendKeys("77712345");

        new Select(driver.findElement(By.id("lea13"))).selectByVisibleText("Qualified");

        driver.findElement(By.id("lea3")).clear();
        driver.findElement(By.id("lea3")).sendKeys("JALA");

        new Select(driver.findElement(By.id("lea6"))).selectByVisibleText("Shipping");

        driver.findElement(By.id("lea15")).clear();
        driver.findElement(By.id("lea15")).sendKeys("120");

        new Select(driver.findElement(By.id("lea5"))).selectByVisibleText("External Referral");

        driver.findElement(By.id("lea16street")).clear();
        driver.findElement(By.id("lea16street")).sendKeys("Street 1");

        driver.findElement(By.id("lea16city")).clear();
        driver.findElement(By.id("lea16city")).sendKeys("City");

        driver.findElement(By.id("lea16state")).clear();
        driver.findElement(By.id("lea16state")).sendKeys("State");

        driver.findElement(By.id("lea16zip")).clear();
        driver.findElement(By.id("lea16zip")).sendKeys("591");

        driver.findElement(By.id("lea16country")).clear();
        driver.findElement(By.id("lea16country")).sendKeys("Bolivia");

        driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            //fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

