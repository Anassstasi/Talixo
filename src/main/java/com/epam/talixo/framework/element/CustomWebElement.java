package com.epam.talixo.framework.element;

/**
 * Interface for custom Web elements with custom methods.
 */
public interface CustomWebElement {

    /**
     * Click on this element.
     */
    void click();

    /**
     * For text fields.
     * Clear and type text.
     *
     * @param text Text for type.
     */
    void clearAndType(String text);

    /**
     * If this element is a text entry element, this will clear the value.
     */
    void clear();

    /**
     * Use this method to simulate typing into an element, which may set its value.
     *
     * @param text String to send to the element.
     */
    void sendKeys(String text);

    /**
     * Moves the mouse to the specified element.
     */
    void moveToElement();

    /**
     * Moves the mouse to the specified element and click on it.
     */
    void moveToElementAndClick();

    /**
     * Is this element displayed or not? This method avoids the problem of having to parse an element's "style" attribute.
     *
     * @return Whether or not the element is displayed
     */
    boolean isDisplayed();

    /**
     * Allows to get element's text
     */
    String getText();

}