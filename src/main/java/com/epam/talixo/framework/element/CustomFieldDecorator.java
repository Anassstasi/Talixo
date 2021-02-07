package com.epam.talixo.framework.element;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

/**
 * Custom FieldDecorator for creating custom Web elements.
 */
public class CustomFieldDecorator extends DefaultFieldDecorator {

    /**
     * ElementFactory object for decorating custom Web element.
     */
    private ElementFactory elementFactory = new DefaultElementFactory();

    public CustomFieldDecorator(final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    /**
     * This method is called by PageFactory on all fields to decide how to decorate the field.
     *
     * @param loader The class loader that was used for the page object
     * @param field  The field that may be decorated.
     * @return Value to decorate the field with or null if it shouldn't be decorated.
     * If non-null, must be assignable to the field.
     */
    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (CustomWebElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    /**
     * Decorate custom Web element.
     *
     * @param loader The class loader that was used for the page object
     * @param field  The field that may be decorated.
     * @return Value to decorate the field with or null if it shouldn't be decorated.
     * If non-null, must be assignable to the field.
     */
    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends CustomWebElement>) field.getType(), wrappedElement);
    }

    /**
     * When a field on a class needs to be decorated with an ElementLocator this method will be called.
     *
     * @param field The field that may be decorated.
     * @return An ElementLocator object.
     */
    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }

}