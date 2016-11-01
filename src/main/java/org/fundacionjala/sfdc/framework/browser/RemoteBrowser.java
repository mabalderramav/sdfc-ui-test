package org.fundacionjala.sfdc.framework.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.sfdc.framework.utils.Environment;

/**
 * This class initialize the Remote Selenium Web Driver.
 */
class RemoteBrowser implements Driver {
    private static final Logger LOGGER = LogManager.getLogger(RemoteBrowser.class);

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static final String HTTPS_PROXY_HOST = "https.proxyHost";

    private static final String HTTPS_PROXY_PORT = "https.proxyPort";

    private static final String BROWSER = "browser";

    private static final String CHROME = "chrome";

    private static final String BROWSER_STACK_DEBUG = "browserstack.debug";

    private static final String VALUE = "true";

    private static final String FIRST_BUILD = "First build";

    private static final String BUILD = "build";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        final String url =
                "https://" + Environment.getInstance().getBrowserStackUser() + ":"
                        + Environment.getInstance().getBrowserStackKey()
                        + "@hub-cloud.browserstack.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        if (!ENVIRONMENT.getProxy().isEmpty()) {
            System.getProperties().put(HTTPS_PROXY_HOST, ENVIRONMENT.getProxy());
            System.getProperties().put(HTTPS_PROXY_PORT, ENVIRONMENT.getPort());
        }
        caps.setCapability(BROWSER, CHROME);
        caps.setCapability(BROWSER_STACK_DEBUG, VALUE);
        caps.setCapability(BUILD, FIRST_BUILD);
        try {
            return new RemoteWebDriver(new URL(url), caps);
        } catch (MalformedURLException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return null;
    }
}
