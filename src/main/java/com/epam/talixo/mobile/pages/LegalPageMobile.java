package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LegalPageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    /**
     * 'I acknowledge and accept the General Terms and Conditions' checkbox.
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'accept the General Terms and Conditions')]")
    private MobileElement checkboxTerms;

    /**
     * 'I acknowledge and accept the Data Protection Declaration' checkbox.
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'accept the Data Protection Declaration')]")
    private MobileElement checkboxDataProtection;

    /**
     * 'Save Changes' button.
     */
    @AndroidFindBy(id = "com.talixo.client:id/pb_text")
    private MobileElement saveChangesButton;

    /**
     * Select 'Data Protection Declaration' checkbox.
     */
    public void checkCheckboxDataProtection() {
        WaitUtilsMobile.waitForVisibility(checkboxDataProtection);
        checkboxDataProtection.click();
        logger.info("'Data Protection' checkbox is selected.");
    }

    /**
     * Select 'General Terms and Conditions' checkbox.
     */
    public void checkCheckboxTerms() {
        WaitUtilsMobile.waitForVisibility(checkboxTerms);
        checkboxTerms.click();
        logger.info("'General Terms and Conditions' checkbox is selected.");
    }

    /**
     * Submit registration.
     */
    public void clickSaveChangesButton() {
        WaitUtilsMobile.waitForVisibility(saveChangesButton);
        saveChangesButton.click();
        logger.info("Changes saved. Registration successful.");
    }

}