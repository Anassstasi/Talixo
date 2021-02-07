package com.epam.talixo.spring.webdriver;

import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.framework.runner.config.BrowserConfig;
import com.epam.talixo.framework.runner.config.EnvironmentConfig;
import com.epam.talixo.framework.webdriver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootConfiguration
public class DriverFactorySpring extends DriverFactory {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static WebDriver getDriverBean() throws TypeIsUnsupportedException {
        return DriverFactorySpring.getDriver(BrowserConfig.getType(), EnvironmentConfig.getType());
    }

}