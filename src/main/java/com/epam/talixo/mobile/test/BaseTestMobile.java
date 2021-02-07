package com.epam.talixo.mobile.test;

import com.epam.talixo.mobile.driver.DriverFactoryMobile;
import com.epam.talixo.mobile.driver.DriverManagerMobile;
import org.junit.Before;

import java.io.IOException;

public class BaseTestMobile {

    @Before
    public void setupDriver() throws IOException {
        DriverManagerMobile.setDriver(DriverFactoryMobile.getDriver());
    }

}