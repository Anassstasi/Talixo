package com.epam.talixo.mobile.steps;

import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.mobile.pages.LegalPageMobile;
import com.epam.talixo.mobile.pages.LoginPageMobile;
import com.epam.talixo.mobile.pages.RegisterPageMobile;
import com.epam.talixo.mobile.pages.StartPageMobile;
import com.epam.talixo.mobile.utils.KeyboardUtilsMobile;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterStepMobile {

    private String randomEmail = RandomStringUtils.randomAlphabetic(6) + "@gmail.com";
    private RegisterPageMobile registrationPage = new RegisterPageMobile();
    private LegalPageMobile legalPage = new LegalPageMobile();
    private StartPageMobile startPage = new StartPageMobile();
    private LoginPageMobile loginPage = new LoginPageMobile();

    /**
     * Open registration page from Start page.
     */
    public void openRegistrationPageFromStartPage() {
        startPage.openRegisterPage();
    }

    /**
     * Open registration page from Login page.
     */
    public void openRegistrationPageFromLoginPage() {
        loginPage.clickRegisterLink();
    }

    /**
     * Full registration: fill all the required fields, submit registration.
     *
     * @param user a specific user entity
     */
    public void register(User user) {
        fillRequiredFields(user.getFirstName(), user.getLastName(), user.getPhoneNumber(),
                user.getEmail() + randomEmail);
        registrationPage.submitRegistration();
    }

    /**
     * Fill all the required fields.
     *
     * @param firstName   user's first name
     * @param lastName    user's last name
     * @param phoneNumber user's phone number
     * @param email       user's EMAIL
     */
    public void fillRequiredFields(String firstName, String lastName, String phoneNumber, String email) {
        registrationPage.fillFirstName(firstName);
        KeyboardUtilsMobile.hideKeyboard();
        registrationPage.fillLastName(lastName);
        KeyboardUtilsMobile.hideKeyboard();
        registrationPage.fillMobilePhone(phoneNumber);
        KeyboardUtilsMobile.hideKeyboard();
        registrationPage.fillEmail(email);
        KeyboardUtilsMobile.hideKeyboard();
    }

    /**
     * Fill First name.
     *
     * @param firstName user's first name
     */
    public void fillFirstName(String firstName) {
        registrationPage.fillFirstName(firstName);
        KeyboardUtilsMobile.hideKeyboard();
    }

    /**
     * Submit registration.
     */
    public void submitRegistration() {
        registrationPage.submitRegistration();
    }

    /**
     * Select all the required checkboxes.
     */
    public void selectRequiredCheckboxes() {
        legalPage.checkCheckboxTerms();
        legalPage.checkCheckboxDataProtection();
    }

    /**
     * Submit registration.
     */
    public void saveChanges() {
        legalPage.clickSaveChangesButton();
    }

    /**
     * Check 'Invalid format' error message is displayed on the page.
     */
    public boolean isInvalidFirstNameFormatErrorDisplayed() {
        return registrationPage.isInvalidFirstNameFormatErrorDisplayed();
    }

}