package com.epam.talixo.framework.element;

import com.epam.talixo.framework.utils.ActionsUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Implementing custom methods for custom Web elements.
 */
public class CustomWebElementImpl implements CustomWebElement {

    private final WebElement wrappedElement;

    public CustomWebElementImpl(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public void click() {
        wrappedElement.click();
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public void moveToElement() {
        ActionsUtils.moveToElement(wrappedElement);
    }

    @Override
    public void moveToElementAndClick() {
        ActionsUtils.moveToElementAndClick(wrappedElement);
    }

    @Override
    public void sendKeys(String text) {
        wrappedElement.sendKeys(text);
    }

    /**
     * Is this element displayed or not? This method avoids the problem of having to parse an element's "style" attribute.
     *
     * @return true if element is displayed, false if not.
     */
    @Override
    public boolean isDisplayed() {
        try {
            return wrappedElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void clearAndType(final String text) {
        clear();
        sendKeys(text);
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }

}