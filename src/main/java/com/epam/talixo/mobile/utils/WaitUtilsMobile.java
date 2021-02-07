package com.epam.talixo.mobile.utils;

import com.epam.talixo.mobile.driver.DriverManagerMobile;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class allows to wait until an element shows up.
 */
public class WaitUtilsMobile {

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
        return new WebDriverWait(DriverManagerMobile.getDriver(), timeOut);
    }

    /**
     * Overload waitForVisibility method
     *
     * @param mobileElement is a field that doesn't changes when method overloads
     */
    public static void waitForVisibility(MobileElement mobileElement) {
        waitForVisibility(mobileElement, DEFAULT_TIMEOUT);
    }

    /**
     * Allows to wait until an element appears
     *
     * @param mobileElement is a field that doesn't changes when method overloads
     * @param wantedTimeOut is a value of timeout that you want to set up
     */
    public static void waitForVisibility(MobileElement mobileElement, int wantedTimeOut) {
        createWait(wantedTimeOut).until(ExpectedConditions.visibilityOf(mobileElement));
    }

}