package org.fundacionjala.sfdc.framework.testng;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsPrimaryUser();
    }

    @Override
    public void onFinish(ISuite suite) {

    }
}
