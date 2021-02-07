package com.epam.talixo.pages;

import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.properties.UrlsStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

/**
 * Registration page
 */
public class RegistrationPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger();
    private String url = UrlsStorage.getRegistrationPageUrl();

    /**
     * 'First name' field.
     */
    @FindBy(id = "id_first_name")
    private CustomWebElement inputFirstName;

    /**
     * 'Last name' field.
     */
    @FindBy(id = "id_last_name")
    private CustomWebElement inputLastName;

    /**
     * 'Prefix' field.
     */
    @FindBy(id = "id_mobile_0")
    private CustomWebElement inputPrefixPhone;

    /**
     * 'Mobile number' field.
     */
    @FindBy(id = "id_mobile_1")
    private CustomWebElement inputMobilePhone;

    /**
     * 'E-mail' field.
     */
    @FindBy(id = "id_email_auth")
    private CustomWebElement inputEmail;

    /**
     * 'Password' field.
     */
    @FindBy(id = "id_password")
    private CustomWebElement inputPassword;

    /**
     * 'I acknowledge and accept the Data Protection Declaration' checkbox.
     */
    @FindBy(xpath = "//*[@id='id_terms_1']")
    private CustomWebElement checkboxDataProtection;

    /**
     * 'I acknowledge and accept the General Terms and Conditions' checkbox.
     */
    @FindBy(xpath = "//*[@id='id_terms_2']")
    private CustomWebElement checkboxTerms;

    /**
     * 'Create new user' button.
     */
    @FindBy(xpath = "//*[@value = 'Create Account ']")
    private CustomWebElement submitRegistration;

    /**
     * Error message 'Invalid format: can only accept letters,
     * spaces, dots, apostrophe and "-" sign.'
     */
    @FindBy(xpath = "//*[@for='id_first_name']/following-sibling::*[@data-tooltip-errors]")
    private CustomWebElement invalidFirstNameFormatMessage;

    public RegistrationPage() {
        super();
    }

    /**
     * Open Registration page
     */
    public void openPage() {
        driver.navigate().to(url);
        logger.info(String.format("Registration page opened: %s", url));
    }

    /**
     * Return opened page title
     *
     * @return title of the current page
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Fill 'First name:' field.
     *
     * @param text user's first name
     */
    public void fillFirstName(String text) {
        inputFirstName.sendKeys(text);
        logger.info("First name: " + text);
    }

    /**
     * Fill 'Last name:' field.
     *
     * @param text user's last name
     */
    public void fillLastName(String text) {
        inputLastName.sendKeys(text);
        logger.info("Last name: " + text);
    }

    /**
     * Fill 'Prefix' field.
     *
     * @param text phone number's prefix
     */
    public void fillPrefixPhone(String text) {
        inputPrefixPhone.sendKeys(text);
        logger.info("Prefix: " + text);
    }

    /**
     * Fill 'Mobile number' field.
     *
     * @param text user's mobile number
     */
    public void fillMobilePhone(String text) {
        inputMobilePhone.sendKeys(text);
        logger.info("Mobile number: " + text);
    }

    /**
     * Fill 'Email:' field.
     *
     * @param text user's EMAIL
     */
    public void fillEmail(String text) {
        inputEmail.sendKeys(text);
        logger.info("Email: " + text);
    }

    /**
     * Fill 'Password:' field.
     *
     * @param text user's password
     */
    public void fillPassword(String text) {
        inputPassword.sendKeys(text);
        logger.info("Password: " + text);
    }

    /**
     * Check all the required checkboxes.
     */
    public void checkRequiredCheckboxes() {
        checkCheckboxDataProtection();
        checkCheckboxTerms();
    }

    /**
     * Check 'Data Protection Declaration' checkbox.
     */
    public void checkCheckboxDataProtection() {
        checkboxDataProtection.moveToElementAndClick();
        logger.info("Check 'Data Protection' checkbox.");
    }

    /**
     * Check 'General Terms and Conditions' checkbox.
     */
    public void checkCheckboxTerms() {
        checkboxTerms.moveToElementAndClick();
        logger.info("Check 'General Terms and Conditions' checkbox.");
    }

    /**
     * Submit registration.
     */
    public void submitRegistration() {
        submitRegistration.click();
        logger.info("Submit registration.");
    }

    /**
     * Check 'Invalid format' error message is displayed on the page.
     *
     * @return true if 'Invalid format' error message is displayed, false if there isn't
     */
    public boolean isInvalidFormatErrorDisplayed() {
        logger.info("'Invalid format' error message is displayed");
        return invalidFirstNameFormatMessage.isDisplayed();
    }

}