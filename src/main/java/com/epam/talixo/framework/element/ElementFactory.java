package com.epam.talixo.framework.element;

import org.openqa.selenium.WebElement;

/**
 * Interface for creating custom Web element.
 */
public interface ElementFactory {

    /**
     * Create new custom Web element.
     *
     * @param elementClass   Element class (e.g. CustomWebElement, Button, Table)
     * @param wrappedElement Web element.
     * @return New custom Web element.
     */
    <E extends CustomWebElement> E create(Class<E> elementClass, WebElement wrappedElement);
}