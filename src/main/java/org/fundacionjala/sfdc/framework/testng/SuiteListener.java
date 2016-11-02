package org.fundacionjala.sfdc.framework.testng;

import org.fundacionjala.sfdc.framework.browser.DriverManager;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Class to manage the login and close the driver for each suite.
 */
public class SuiteListener implements ISuiteListener {

    /**
     * Method that login before each test suite.
     *
     * @param suite ISuite info.
     */
    @Override
    public void onStart(final ISuite suite) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsPrimaryUser();
    }

    /**
     * Method that quits the driver.
     *
     * @param suite ISuite info.
     */
    @Override
    public void onFinish(final ISuite suite) {
        DriverManager.getInstance().getDriver().quit();
    }
}
