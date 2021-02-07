package com.epam.talixo.mobile.utils;

import com.epam.talixo.mobile.driver.DriverManagerMobile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;

public class KeyboardUtilsMobile {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Use this method to hide keyboard
     */
    public static void hideKeyboard() {
        try {
            DriverManagerMobile.getDriver().hideKeyboard();
        } catch (WebDriverException ignored) {
            logger.info("Keyboard is not opened.");
        }
    }

    /**
     * Use this method for navigate to back.
     */
    public static void clickBackButton() {
        DriverManagerMobile.getDriver().navigate().back();
    }

}