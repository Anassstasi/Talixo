package com.epam.talixo.mobile.utils;

import com.epam.talixo.mobile.driver.DriverManagerMobile;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class TouchUtilsMobile {

    /**
     * Use this method to simulate tap on the position
     *
     * @param x is a position on the axis of abscissae
     * @param y is a position on the axis of ordinates
     */
    public static void tapOnPosition(int x, int y) {
        TouchAction action = new TouchAction(DriverManagerMobile.getDriver());
        action.tap(new PointOption().withCoordinates(x, y)).perform();
    }

}