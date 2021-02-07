package com.epam.talixo.framework.utils;

import com.epam.talixo.framework.webdriver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * This class allows to move the cursor and click on element or just only move the cursor
 */
public class ActionsUtils {

    /**
     * Create actions
     *
     * @return is create Actions object
     */
    private static Actions createAction() {
        return new Actions(DriverManager.getDriver());
    }

    /**
     * Create action that allows move the cursor.
     *
     * @param target move to the element.
     */
    public static void moveToElement(WebElement target) {
        createAction().moveToElement(target).perform();
    }

    /**
     * This method creates action that allows move the cursor and click on the element.
     *
     * @param target move to the element.
     */
    public static void moveToElementAndClick(WebElement target) {
        createAction().moveToElement(target).click().perform();
    }

}