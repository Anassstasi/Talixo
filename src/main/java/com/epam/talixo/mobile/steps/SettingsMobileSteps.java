package com.epam.talixo.mobile.steps;

import com.epam.talixo.mobile.pages.HomePageMobile;
import com.epam.talixo.mobile.pages.MenuPageMobile;
import com.epam.talixo.mobile.pages.SettingsPageMobile;

import static org.junit.Assert.assertTrue;

public class SettingsMobileSteps {

    private MenuPageMobile menuPageMobile = new MenuPageMobile();
    private SettingsPageMobile settingsPageMobile = new SettingsPageMobile();
    private HomePageMobile homePageMobile = new HomePageMobile();

    /**
     * Method allows to click on the button "Change Password" on the Settings Page
     */
    public void clickChangePasswordButton() {
        settingsPageMobile.clickChangePasswordButton();
    }

    /**
     * Method allows to change first name of a user
     *
     * @param firstName is new first name
     */
    public void changeFirstName(String firstName) {
        settingsPageMobile.changeFirstName(firstName);
    }

    /**
     * Method allows to change last name of a user
     *
     * @param lastName is new last name
     */
    public void changeLastName(String lastName) {
        settingsPageMobile.changeLatsName(lastName);
    }

    /**
     * Method allows to change the phone number of a user
     *
     * @param phoneNumber is new phone number
     */
    public void changePhoneNumber(String phoneNumber) {
        settingsPageMobile.changePhoneNumber(phoneNumber);
    }

    /**
     * Method allows to change the email of a user
     *
     * @param email is new email
     */
    public void changeEmail(String email) {
        settingsPageMobile.changeEmail(email);
    }

    /**
     * Method allows to click on the button "Menu" on Home Page
     */
    public void clickMenuButton() {
        homePageMobile.clickMenuButton();
    }

    /**
     * Method allows to click the button "Header Details" on Menu Page
     */
    public void clickHeaderDetailsButton() {
        menuPageMobile.clickHeaderDetailsButton();
    }

    /**
     * Method allows to click on the button "Settings" on Menu Page
     */
    public void clickSettingsButton() {
        menuPageMobile.clickSettingsButton();
    }

    /**
     * Method allows to click on the button "Save Changes" on SettingsPage
     */
    public void clickSaveChangesButton() {
        settingsPageMobile.clickSaveChangesButton();
    }

    /**
     * Method allows to change password of a user
     *
     * @param oldPassword       is old password
     * @param newPassword       is new Password
     * @param repeatNewPassword is the password to repeat
     */
    public void changePassword(String oldPassword, String newPassword, String repeatNewPassword) {
        settingsPageMobile.enterOldPassword(oldPassword);
        settingsPageMobile.enterNewPassword(newPassword);
        settingsPageMobile.repeatNewPassword(repeatNewPassword);
    }

    /**
     * Method allows to click on the button "Save Password" on Settings Page
     */
    public void clickSavePasswordButton() {
        settingsPageMobile.clickSavePasswordButton();
    }

    /**
     * Method allows to leave Settings Page
     */
    public void clickExitSettings() {
        settingsPageMobile.clickExitSettings();
    }

    /**
     * Method allows to check whether user`s profile has been successfully updated
     */
    public void isChanged() {
        assertTrue("User profile has not been successfully updated", settingsPageMobile.isChangesSavedLabelDisplayed());
    }

    /**
     * Method allows to check whether user`s password has been successfully changed
     */
    public void isPasswordChanged() {
        assertTrue("User has not successfully changed password", settingsPageMobile.isPasswordChanged());
    }

    /**
     * Method allows to check whether incorrect old password is entered while changing a password
     */
    public void isIncorrectOldPasswordmessageDisplayed() {
        assertTrue("The message 'Incorrect old password' has not appeared",
                settingsPageMobile.isIncorrectOldPasswordMessageDisplayed());
    }

    /**
     * Method allows to check whether the message 'Passwords do not match' has  appeared
     */
    public void isIncorrectRepeatPasswordmessageDisplayed() {
        assertTrue("The message 'Passwords do not match' has not appeared",
                settingsPageMobile.isIncorrectRepeatPasswordDisplayed());
    }

}