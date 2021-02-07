package com.epam.talixo.mobile.driver;

import com.epam.talixo.framework.properties.UrlsStorage;
import com.epam.talixo.mobile.data.MobileFarmDevice;
import com.epam.talixo.mobile.data.MobileStorage;
import com.epam.talixo.mobile.test.suites.MobileSuite;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class DriverFactoryMobile {

    private static MobileFarmDevice device = MobileSuite.getDevice();

    public static AppiumDriver<MobileElement> getDriver() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        MobileStorage.getDataFromAndroidProperty().forEach(capabilities::setCapability);
        capabilities.setCapability("platformName", device.getPlatformName());
        capabilities.setCapability("platformVersion", device.getPlatformVersion());
        capabilities.setCapability("deviceName", device.getDeviceName());
        capabilities.setCapability("udid", device.getUdid());
        return new AndroidDriver<>(new URL(UrlsStorage.getAndroidHubAddress()), capabilities);
    }

}