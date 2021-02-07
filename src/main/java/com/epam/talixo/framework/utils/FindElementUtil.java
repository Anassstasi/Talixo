package com.epam.talixo.framework.utils;

import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.element.CustomWebElementImpl;
import com.epam.talixo.framework.webdriver.DriverManager;
import org.openqa.selenium.By;

/**
 * The class allows to find CustomWebElement by id/className and etc
 */
public class FindElementUtil {

    /**
     * The method allows to find CustomWebElement by id/className and etc
     *
     * @param by is the locator of CustomWebElement
     * @return CustomWebElement
     */
    public static CustomWebElement findElement(By by) {
        return new CustomWebElementImpl(DriverManager.getDriver().findElement(by));
    }

}