package com.epam.talixo.mobile.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.talixo.mobile.utils.WaitUtilsMobile.waitForVisibility;

public class StartPageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    @AndroidFindBy(id = "com.talixo.client:id/btn_splash_screen_login")
    private MobileElement loginButton;
    
    @AndroidFindBy(id = "com.talixo.client:id/btn_splash_screen_register")
    private MobileElement registerButton;

    /**
     * Check is 'LOG IN' button is displayed.
     *
     * @return true if 'LOG IN' button is displayed, false – if not.
     */
    public boolean isLogInButtonDisplayed() {
        waitForVisibility(loginButton);
        logger.info("'LOG IN' button is displayed.");
        return loginButton.isDisplayed();
    }

    /**
     * Check is 'REGISTER' button is displayed.
     *
     * @return true if 'REGISTER' button is displayed, false – if not.
     */
    public boolean isRegisterButtonDisplayed() {
        waitForVisibility(registerButton);
        logger.info("'REGISTER' button is displayed.");
        return registerButton.isDisplayed();
    }

    /**
     * Open Login page (click on 'LOG IN' button).
     */
    public void openLoginPage() {
        waitForVisibility(loginButton);
        loginButton.click();
        logger.info("Click on 'LOG IN' button");
    }

    /**
     * Open Register page (click on 'REGISTER' button).
     */
    public void openRegisterPage() {
        waitForVisibility(registerButton);
        registerButton.click();
        logger.info("Click on 'REGISTER' button");
    }

}