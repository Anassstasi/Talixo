package com.epam.talixo.mobile.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverManagerMobile {

    private static ThreadLocal<AppiumDriver<MobileElement>> threadLocalDriver = new ThreadLocal<>();

    public static AppiumDriver<MobileElement> getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(AppiumDriver<MobileElement> driver) {
        threadLocalDriver.set(driver);
    }

    public static void quitDriver() {
        if (DriverManagerMobile.getDriver() != null) {
            DriverManagerMobile.getDriver().quit();
            threadLocalDriver.remove();
        }
    }

}