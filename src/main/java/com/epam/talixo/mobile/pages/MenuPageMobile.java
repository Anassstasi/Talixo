package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuPageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    @AndroidFindBy(id = "com.talixo.client:id/nav_header_email")
    private MobileElement headerDetails;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    private MobileElement settingsButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Favourite addresses']")
    private MobileElement favAddressesButton;

    /**
     * 'Logout' button.
     */
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Logout']")
    private MobileElement logoutButton;

    /**
     * Method for click on button "Header details"
     */
    public void clickHeaderDetailsButton() {
        WaitUtilsMobile.waitForVisibility(headerDetails);
        headerDetails.click();
        logger.info("Click 'HEADER DETAILS' button");
    }

    /**
     * Method for click on button "Settings"
     */
    public void clickSettingsButton() {
        settingsButton.click();
        logger.info("Click 'MY SETTINGS' button");
    }

    /**
     * Click 'Logout' button.
     */
    public void clickLogoutButton() {
        WaitUtilsMobile.waitForVisibility(logoutButton);
        logoutButton.click();
        logger.info("Click 'Logout' button.");
    }

}