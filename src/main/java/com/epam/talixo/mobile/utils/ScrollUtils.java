package com.epam.talixo.mobile.utils;

import com.epam.talixo.mobile.driver.DriverManagerMobile;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

public class ScrollUtils {

    /**
     * Use this method to simulate scroll to the element position
     *
     * @param value is a accessibilityId of the element
     */
    public static void scrollToAccessibilityId(String value) {
        while (DriverManagerMobile.getDriver().findElementsByAccessibilityId(value).isEmpty()) {
            new TouchAction(DriverManagerMobile.getDriver())
                    .press(new PointOption().withCoordinates(500, 1350))
                    .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(new PointOption().withCoordinates(500, 950))
                    .release()
                    .perform();
        }
    }

    /**
     * Use this method to simulate scroll to the element position
     *
     * @param value is a id of the element
     */
    public static void scrollToId(String value) {
        while (DriverManagerMobile.getDriver().findElements(By.id(value)).isEmpty()) {
            new TouchAction(DriverManagerMobile.getDriver())
                    .press(new PointOption().withCoordinates(500, 1350))
                    .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(new PointOption().withCoordinates(500, 950))
                    .release()
                    .perform();
        }
    }

    /**
     * Use this method to simulate swipe up
     */
    public static void swipeUp() {
        new TouchAction(DriverManagerMobile.getDriver())
                .press(new PointOption().withCoordinates(500, 1800))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(new PointOption().withCoordinates(500, 500))
                .release()
                .perform();
    }

}