package com.epam.talixo.framework.utils;

import com.epam.talixo.framework.webdriver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollUtils {

    /**
     * Use this method to simulate scrolling to web elements
     *
     * @param id is the id of the web element to which you need to scroll the page.
     */
    public static void scrollToElement(String id) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("document.getElementById('" + id + "').scrollIntoView()");
    }

    /**
     * Use this method to simulate scrolling to bottom of pages
     */
    public static void scrollToBottomOfAPage() {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}