package com.epam.talixo.spring.pages;

import com.epam.talixo.framework.element.CustomFieldDecorator;
import com.epam.talixo.spring.webdriver.DriverFactorySpring;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class AbstractPage {

    protected WebDriver driver;
    {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                driver.close();
                driver.quit();
            }
        });
    }

    public AbstractPage() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DriverFactorySpring.class);
        this.driver = (WebDriver) context.getBean("getDriverBean");
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }
}