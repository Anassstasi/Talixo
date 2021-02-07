package com.epam.talixo.framework.runner.config;

import com.epam.talixo.framework.webdriver.DriverFactory;
import com.epam.talixo.framework.webdriver.DriverFactory.BrowserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.talixo.framework.webdriver.DriverFactory.BrowserType.CHROME;

/**
 * Configuration for browser params.
 */
public class BrowserConfig {

    private static final Logger logger = LogManager.getLogger();
    private static BrowserType type = CHROME;

    /**
     * Configuration for browser params
     *
     * @param browser Type of browser to use.
     */
    public static void setConfig(String browser) {
        try {
            type = DriverFactory.BrowserType.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("Set correct browser (firefox, chrome, edge, ie, opera), please");
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the type of browser to use.
     *
     * @return the type of browser
     */
    public static DriverFactory.BrowserType getType() {
        return type;
    }

}