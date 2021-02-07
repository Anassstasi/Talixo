package com.epam.talixo.framework.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

/**
 * Class for creating custom Web element.
 */
public class DefaultElementFactory implements ElementFactory {

    private final Logger logger = LogManager.getLogger();

    @Override
    public <E extends CustomWebElement> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            logger.info("Error with exception: InstantiationException");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            logger.info("Error with exception: IllegalAccessException");
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            logger.info("Error with exception: InvocationTargetException");
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            logger.info("Error with exception: NoSuchMethodException");
            throw new RuntimeException(e);
        }
    }

    /**
     * Find implementation for creating custom Web element.
     *
     * @param elementClass Element class (e.g. CustomWebElement, Button, Table).
     * @return New custom Web element.
     */
    private <E extends CustomWebElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            logger.info("Error with exception: ClassNotFoundException");
            throw new RuntimeException(e);
        }
    }

}