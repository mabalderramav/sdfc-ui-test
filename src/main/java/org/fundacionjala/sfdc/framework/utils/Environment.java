package org.fundacionjala.sfdc.framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is in charge to set the default  parameters to
 * establishes the connection with pivotal tracker.
 */
public final class Environment {

    private static final Logger LOGGER = LogManager.getLogger(Environment.class);

    private static final String CONFIG = "gradle.properties";

    private static final String PRIMARY_USER_NAME = "primaryUserName";

    private static final String PRIMARY_USER_PASS = "primaryUserPassword";

    private static final String BROWSER = "browser";

    private static final String TIMEOUT = "timeout";

    private static final String AUTHENTICATION_BASE_URL = "authentication.baseURL";

    private static Environment environment;

    private Properties properties;

    /**
     * This method read the config property file.
     */
    private Environment() {
        File file = new File(CONFIG);
        try (FileReader fileReader = new FileReader(file)) {
            properties = new Properties();
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            LOGGER.warn(e.getMessage(), e);

        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    /**
     * This method Instance the environment if this does not exist.
     *
     * @return the instanced Environment.
     */
    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    /**
     * Get the properties of the file.
     *
     * @param key string name of property setting.
     * @return String that is a property.
     */
    private String getEnv(final String key) {
        String env = System.getProperty(key);
        if (env == null) {
            env = properties.getProperty(key);
        }
        return env;
    }

    /**
     * Return the user name.
     *
     * @return String whit the name user.
     */
    public String getPrimaryUser() {
        return getEnv(PRIMARY_USER_NAME);
    }

    /**
     * return the password.
     *
     * @return String whit the password.
     */
    public String getPrimaryPassword() {
        return getEnv(PRIMARY_USER_PASS);
    }

    /**
     * Get the browser.
     *
     * @return String with the configure browser.
     */
    public String getBrowser() {
        return getEnv(BROWSER);
    }

    /**
     * Get the base url of pivotal tracker.
     *
     * @return String url.
     */
    public String getBaseUrl() {
        return getEnv(AUTHENTICATION_BASE_URL);
    }

    /**
     * Get the timeout.
     *
     * @return String with the configure timeout.
     */
    public int getTimeout() {
        return Integer.parseInt(getEnv(TIMEOUT));
    }
}
