package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.driver.DriverManagerMobile;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractPageMobile {

    protected WebDriver driver;

    public AbstractPageMobile() {
        this.driver = DriverManagerMobile.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(DriverManagerMobile.getDriver(), Duration.ofSeconds(20)), this);
    }

}