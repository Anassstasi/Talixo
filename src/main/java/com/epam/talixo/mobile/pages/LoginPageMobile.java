package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.utils.KeyboardUtilsMobile;
import com.epam.talixo.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;

import static com.epam.talixo.mobile.utils.WaitUtilsMobile.waitForVisibility;

public class LoginPageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    /**
     * 'Email' input.
     */
    @AndroidFindBy(id = "com.talixo.client:id/email_edit_text")
    private MobileElement emailInput;

    /**
     * 'Password' input.
     */
    @AndroidFindBy(id = "com.talixo.client:id/password_edit_text")
    private MobileElement passwordInput;

    /**
     * 'LOG IN' button.
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LOG IN']")
    private MobileElement logInButton;

    /**
     * 'or... register a new account' link.
     */
    @AndroidFindBy(id = "com.talixo.client:id/register_linear_layout")
    private MobileElement registerLink;

    /**
     * Error message 'Invalid format: can only accept letters, spaces, dots, apostrophe and "-" sign.'
     */
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.talixo.client:id/email_text_input_layout']" +
            "//*[@resource-id = 'com.talixo.client:id/textinput_error']")
    private MobileElement invalidEmailMessage;

    /**
     * Error message 'Incorrect username or password'
     */
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.talixo.client:id/snackbar_text']")
    private MobileElement invalidPasswordMessage;

    @AndroidFindBy(id = "com.google.android.gms:id/credential_save_reject")
    private MobileElement androidCredentialSaveRejectMessage;

    /**
     * Enter email.
     *
     * @param email user's email.
     */
    public void enterEmail(String email) {
        waitForVisibility(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        KeyboardUtilsMobile.hideKeyboard();
        logger.info(String.format("Email: %s", email));
    }

    /**
     * Enter password.
     *
     * @param password user's password.
     */
    public void enterPassword(String password) {
        waitForVisibility(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        KeyboardUtilsMobile.hideKeyboard();
        logger.info(String.format("Password: %s", password));
    }

    /**
     * Click 'LOG IN' button.
     */
    public void clickLoginButton() {
        waitForVisibility(logInButton);
        logInButton.click();
        logger.info("Confirm login.");
    }

    /**
     * Close android 'Credential Save Reject' message.
     */
    public void closeAndroidCredentialSaveRejectMessage() {
        try {
            waitForVisibility(androidCredentialSaveRejectMessage);
            androidCredentialSaveRejectMessage.click();
            logger.info("Android 'Credential Save Reject' message closed.");
        } catch (TimeoutException ignored) {
            logger.info("There is no Android 'Credential Save Reject' message");
        }
    }

    /**
     * Click 'or... register a new account' link
     */
    public void clickRegisterLink() {
        waitForVisibility(registerLink);
        registerLink.click();
        logger.info("Registration a new account.");
    }

    /**
     * Check is 'Invalid email format' message displayed.
     *
     * @return true if 'Invalid email format' message displayed, false – if not.
     */
    public boolean isInvalidEmailMessageDisplayed() {
        WaitUtilsMobile.waitForVisibility(invalidEmailMessage);
        logger.info("'Invalid email format' error message is displayed");
        return invalidEmailMessage.isDisplayed();

    }

    /**
     * Check is 'Incorrect username or password' message displayed.
     *
     * @return true if 'Incorrect username or password' message displayed, false – if not.
     */
    public boolean isInvalidPasswordMessageDisplayed() {
        WaitUtilsMobile.waitForVisibility(invalidPasswordMessage);
        logger.info("'Incorrect username or password' error message is displayed");
        return invalidPasswordMessage.isDisplayed();
    }

    /**
     * Check is 'Log In' button is displayed. Use it for checking logout.
     *
     * @return true if 'Log In' button is displayed, false – if not.
     */
    public boolean isConfirmLoginButtonDisplayed() {
        WaitUtilsMobile.waitForVisibility(logInButton);
        logger.info("User is NOT logged in.");
        return logInButton.isDisplayed();
    }

}