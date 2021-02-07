package com.epam.talixo.framework.utils;

import com.epam.talixo.framework.element.CustomExpectedConditions;
import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.webdriver.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class allows to wait until an element shows up.
 */
public class WaitUtils {

    /**
     * Default timeout value
     */
    private static final int DEFAULT_TIMEOUT = 20;

    /**
     * This method create WebDriverWait object
     *
     * @param timeOut is a value of timeout that you want to set up
     * @return WebDriverWait object with certain timeout
     */
    private static WebDriverWait createWait(int timeOut) {
        return new WebDriverWait(DriverManager.getDriver(), timeOut);
    }

    /**
     * Overload waitForVisibility method
     *
     * @param customWebElement is a field that doesn't changes when method overloads
     */
    public static void waitForVisibility(CustomWebElement customWebElement) {
        waitForVisibility(customWebElement, DEFAULT_TIMEOUT);
    }

    /**
     * Allows to wait until an element appears
     *
     * @param customWebElement is a field that doesn't changes when method overloads
     * @param wantedTimeOut    is a value of timeout that you want to set up
     */
    public static void waitForVisibility(CustomWebElement customWebElement, int wantedTimeOut) {
        createWait(wantedTimeOut).until(CustomExpectedConditions.visibilityOf(customWebElement));
    }

}