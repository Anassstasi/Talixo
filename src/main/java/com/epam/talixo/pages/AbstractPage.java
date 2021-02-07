package com.epam.talixo.pages;

import com.epam.talixo.framework.element.CustomFieldDecorator;
import com.epam.talixo.framework.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

}