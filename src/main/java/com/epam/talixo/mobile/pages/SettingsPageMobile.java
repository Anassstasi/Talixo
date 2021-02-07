package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SettingsPageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    @AndroidFindBy(id = "com.talixo.client:id/first_name_edit_text")
    private MobileElement firstNameField;

    @AndroidFindBy(id = "com.talixo.client:id/check_settings")
    private MobileElement saveChangesButton;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.talixo.client:id/snackbar_text']")
    private MobileElement changesSavedLabel;

    @AndroidFindBy(id = "com.talixo.client:id/change_password")
    private MobileElement changePasswordButton;

    @AndroidFindBy(id = "com.talixo.client:id/actual_password_edit_text")
    private MobileElement oldPasswordField;

    @AndroidFindBy(id = "com.talixo.client:id/new_password_edit_text")
    private MobileElement newPasswordField;

    @AndroidFindBy(id = "com.talixo.client:id/repeat_password_edit_text")
    private MobileElement repeatNewPasswordField;

    @AndroidFindBy(id = "com.talixo.client:id/pb_text")
    private MobileElement savePasswordButton;

    @AndroidFindBy(id = "com.talixo.client:id/last_name_edit_text")
    private MobileElement lastNameField;

    @AndroidFindBy(id = "com.talixo.client:id/email_edit_text")
    private MobileElement emailField;

    @AndroidFindBy(id = "com.talixo.client:id/phone_edit_text")
    private MobileElement phoneNumberField;

    @AndroidFindBy(id = "com.talixo.client:id/textinput_error")
    private MobileElement incorrectOldPasswordMessage;

    @AndroidFindBy(id = "com.talixo.client:id/textinput_error")
    private MobileElement incorrectRepeatPasswordMessage;

    @AndroidFindBy(id = "Navigate up")
    private MobileElement exitSettings;

    /**
     * This method allows to change first name in the account settings
     *
     * @param newData is the data you put into parameter
     */
    public void changeLatsName(String newData) {
        lastNameField.clear();
        lastNameField.setValue(newData);
        logger.info("New last name is " + newData);
    }

    /**
     * This method allows to change first name in the account settings
     *
     * @param newData is the data you put into parameter
     */
    public void changeFirstName(String newData) {
        firstNameField.clear();
        firstNameField.setValue(newData);
        logger.info("New name is " + newData);
    }

    /**
     * Method allows to leave Settings Page
     */
    public void clickExitSettings() {
        exitSettings.click();
        logger.info("Click 'EXIT SETTINGS PAGE' button");
    }

    /**
     * Method allows to change user`s phone number
     *
     * @param newData is new phone number
     */
    public void changePhoneNumber(String newData) {
        phoneNumberField.clear();
        phoneNumberField.setValue(newData);
        logger.info("New phone number is " + newData);
    }

    /**
     * Method allows to change user`s e-mail
     *
     * @param newData is new e-mail
     */
    public void changeEmail(String newData) {
        emailField.clear();
        emailField.setValue(newData);
        logger.info("New email is " + newData);
    }

    /**
     * Method allows to click the burron 'Save Changes' on Settings Page
     */
    public void clickSaveChangesButton() {
        saveChangesButton.click();
        logger.info("Click 'SAVE CHANGES' button");
    }

    /**
     * Method allows to check whether the message 'User profile has been updated' is displayed
     *
     * @return true if it is and false if not
     */
    public boolean isChangesSavedLabelDisplayed() {
        logger.info("the message 'User profile has been updated' has appeared");
        return changesSavedLabel.isDisplayed();
    }

    /**
     * Method allows to enter old password on Settings Page(Changing password)
     *
     * @param oldPassword is old password
     */
    public void enterOldPassword(String oldPassword) {
        oldPasswordField.sendKeys(oldPassword);
        logger.info(String.format("Old Password: %s", oldPassword));
    }

    /**
     * Method allows to enter new password on Settings Page(Changing password)
     *
     * @param newPassword is new password
     */
    public void enterNewPassword(String newPassword) {
        newPasswordField.sendKeys(newPassword);
        logger.info(String.format("New Password: %s", newPassword));
    }

    /**
     * Method allows to repeat new password on Settings Page(Changing password)
     *
     * @param repeatNewPassword is the repeat of new password
     */
    public void repeatNewPassword(String repeatNewPassword) {
        repeatNewPasswordField.sendKeys(repeatNewPassword);
        logger.info(String.format("Repeat New Password: %s", repeatNewPassword));
    }

    /**
     * Method allows to click on the button 'Change Password'
     */
    public void clickChangePasswordButton() {
        WaitUtilsMobile.waitForVisibility(changePasswordButton, 50);
        changePasswordButton.click();
        logger.info("Click 'SAVE CHANGES' button");
    }

    /**
     * Method allows to click on the button 'Save Password'
     */
    public void clickSavePasswordButton() {
        savePasswordButton.click();
        logger.info("Click 'SAVE PASSWORD' button");
    }

    /**
     * Method allows to check whether the password has been changed
     *
     * @return true if ir is and false if not
     */
    public boolean isPasswordChanged() {
        logger.info("Password has been changed");
        return changesSavedLabel.isDisplayed();
    }

    /**
     * Method allows to check whether the message 'Incorrect old password' has appeared
     *
     * @return true if it is and false if nor
     */
    public boolean isIncorrectOldPasswordMessageDisplayed() {
        logger.info("The message 'Incorrect old password' has appeared");
        return incorrectOldPasswordMessage.isDisplayed();
    }

    /**
     * Method allows to check whether the message 'Passwords don`t match' has appeared
     *
     * @return true if it is and false if not
     */
    public boolean isIncorrectRepeatPasswordDisplayed() {
        logger.info("The message 'Passwords don`t match' has appeared");
        return incorrectRepeatPasswordMessage.isDisplayed();
    }

}