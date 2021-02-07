package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Registration page
 */
public class RegisterPageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    /**
     * 'First name' field.
     */
    @AndroidFindBy(id = "com.talixo.client:id/first_name_edit_text")
    private MobileElement inputFirstName;

    /**
     * 'Last name' field.
     */
    @AndroidFindBy(id = "com.talixo.client:id/last_name_edit_text")
    private MobileElement inputLastName;

    /**
     * 'Prefix' field.
     */
    @AndroidFindBy(id = "com.talixo.client:id/tv_prefix")
    private MobileElement inputPrefixPhone;

    /**
     * 'Mobile number' field.
     */
    @AndroidFindBy(id = "com.talixo.client:id/mobile_1_edit_text")
    private MobileElement inputMobilePhone;

    /**
     * 'E-mail' field.
     */
    @AndroidFindBy(id = "com.talixo.client:id/email_text_input_layout")
    private MobileElement inputEmail;

    /**
     * 'REGISTER' button.
     */
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.talixo.client:id/register_btn']")
    private MobileElement submitRegisterButton;

    /**
     * Error message 'Invalid format: can only accept letters, spaces, dots, apostrophe and "-" sign.'.
     * Error message 'First name is required'.
     */
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.talixo.client:id/first_name_text_input_layout']" +
            "//*[@resource-id = 'com.talixo.client:id/textinput_error']")
    private MobileElement invalidFirstNameMessage;

    /**
     * Fill 'First name:' field.
     *
     * @param text user's first name
     */
    public void fillFirstName(String text) {
        WaitUtilsMobile.waitForVisibility(inputFirstName);
        inputFirstName.sendKeys(text);
        logger.info("First name: " + text);
    }

    /**
     * Fill 'Last name:' field.
     *
     * @param text user's last name
     */
    public void fillLastName(String text) {
        WaitUtilsMobile.waitForVisibility(inputLastName);
        inputLastName.sendKeys(text);
        logger.info("Last name: " + text);
    }

    /**
     * Fill 'Prefix' field.
     *
     * @param text phone number's prefix
     */
    public void fillPrefixPhone(String text) {
        WaitUtilsMobile.waitForVisibility(inputPrefixPhone);
        inputPrefixPhone.sendKeys(text);
        logger.info("Prefix: " + text);
    }

    /**
     * Fill 'Mobile number' field.
     *
     * @param text user's mobile number
     */
    public void fillMobilePhone(String text) {
        WaitUtilsMobile.waitForVisibility(inputMobilePhone);
        inputMobilePhone.setValue(text);
        logger.info("Mobile number: " + text);
    }

    /**
     * Fill 'Email:' field.
     *
     * @param text user's EMAIL
     */
    public void fillEmail(String text) {
        WaitUtilsMobile.waitForVisibility(inputEmail);
        inputEmail.sendKeys(text);
        logger.info("Email: " + text);
    }

    /**
     * Submit registration.
     */
    public void submitRegistration() {
        WaitUtilsMobile.waitForVisibility(submitRegisterButton);
        submitRegisterButton.click();
        logger.info("Submit registration.");
    }

    /**
     * Check 'Invalid [First Name] format' error message is displayed on the page.
     *
     * @return true if 'Invalid [First Name] format' error message is displayed, false if there isn't
     */
    public boolean isInvalidFirstNameFormatErrorDisplayed() {
        WaitUtilsMobile.waitForVisibility(invalidFirstNameMessage);
        if (invalidFirstNameMessage.getText().contains("Invalid format")) {
            logger.info("'Invalid [First Name] format' error message is displayed.");
            return invalidFirstNameMessage.isDisplayed();
        }
        logger.info("'Invalid [First Name] format' error message is NOT displayed.");
        return false;
    }

    /**
     * Check 'First name is required' error message is displayed on the page.
     *
     * @return true if 'First name is required' error message is displayed, false if there isn't
     */
    public boolean isFirstNameIsRequiredErrorDisplayed() {
        WaitUtilsMobile.waitForVisibility(invalidFirstNameMessage);
        if (invalidFirstNameMessage.getText().contains("First name is required")) {
            logger.info("'First name is required' error message is displayed.");
            return invalidFirstNameMessage.isDisplayed();
        }
        logger.info("'First name is required' error message is NOT displayed.");
        return false;
    }

}