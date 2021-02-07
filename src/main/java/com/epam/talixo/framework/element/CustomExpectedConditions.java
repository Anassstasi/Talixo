package com.epam.talixo.framework.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Custom class for ExpectedConditions cass.
 */
public class CustomExpectedConditions {

    /**
     * An expectation for checking that an element,
     * known to be present on the DOM of a page, is visible.
     *
     * @param element custom web element
     * @return the (same) WebElement once it is visible
     */
    public static ExpectedCondition<CustomWebElement> visibilityOf(final CustomWebElement element) {
        return new ExpectedCondition<CustomWebElement>() {
            public CustomWebElement apply(WebDriver driver) {
                return CustomExpectedConditions.elementIfVisible(element);
            }

            public String toString() {
                return "visibility of " + element;
            }
        };
    }

    /**
     * Checking the visibility of Web element.
     *
     * @param element Custom Web element.
     * @return WebElement if it visible. If not, return null.
     */
    private static CustomWebElement elementIfVisible(CustomWebElement element) {
        return element.isDisplayed() ? element : null;
    }
}