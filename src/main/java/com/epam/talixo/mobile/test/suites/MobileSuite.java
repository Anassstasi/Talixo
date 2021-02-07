package com.epam.talixo.mobile.test.suites;

import com.epam.talixo.mobile.data.MobileFarmDevice;
import com.epam.talixo.mobile.driver.DriverManagerMobile;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        RegressionTestMobileSuite.class,
        SmokeTestMobileSuite.class
})
public class MobileSuite {

    private static MobileFarmDevice device = new MobileFarmDevice();

    @BeforeClass
    public static void setUp() {
        device.findAvailableDevice();
        device.installApp();
    }

    @AfterClass
    public static void tearDown() {
        DriverManagerMobile.quitDriver();
    }

    public static MobileFarmDevice getDevice() {
        return device;
    }

}