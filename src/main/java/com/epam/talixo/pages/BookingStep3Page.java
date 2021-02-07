package com.epam.talixo.pages;

import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.utils.ScrollUtils;
import com.epam.talixo.framework.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

/**
 * Class for describing the 2nd step of booking a taxi
 */
public class BookingStep3Page extends AbstractPage {

    private final Logger logger = LogManager.getLogger();

    /**
     * Field for entering user`s first name
     */
    @FindBy(id = "id_first_name")
    private CustomWebElement firstNameField;

    /**
     * Field for entering user`s mobile phone number
     */
    @FindBy(id = "id_mobile_1")
    private CustomWebElement mobilePhoneField;

    /**
     * Field for entering phone prefix
     */
    @FindBy(id = "id_mobile_0")
    private CustomWebElement phonePrefix;

    /**
     * Field for entering e-mail
     */
    @FindBy(id = "id_email_auth")
    private CustomWebElement emailField;

    /**
     * Field for entering user`s last name
     */
    @FindBy(id = "id_last_name")
    private CustomWebElement lastNameField;

    /**
     * Field for entering card number
     */
    @FindBy(id = "adyen-encrypted-form-number")
    private CustomWebElement cardNumberField;

    /**
     * Field for entering holder name
     */
    @FindBy(id = "adyen-encrypted-form-name")
    private CustomWebElement holderNameField;

    /**
     * Field for entering month
     */
    @FindBy(id = "adyen-encrypted-form-expiry-month")
    private CustomWebElement monthField;

    /**
     * Field for entering year
     */
    @FindBy(id = "adyen-encrypted-form-expiry-year")
    private CustomWebElement yearField;

    /**
     * Field for entering CVC
     */
    @FindBy(id = "adyen-encrypted-form-cvc")
    private CustomWebElement cvcField;

    /**
     * Checkbox which user chooses if accepts conditions
     */
    @FindBy(id = "id_terms_cot")
    private CustomWebElement checkBoxIAcceptConditions;

    /**
     * Button which you press to finish booking a taxi
     */
    @FindBy(xpath = "//*[contains(@class, 'booking-confirm-book-button')]")
    private CustomWebElement bookButton;

    /**
     * Message which appears when booking is finished
     */
    @FindBy(id = "adyen-encrypted-form-fields")
    private CustomWebElement messageInvalidCardNumber;

    /**
     * Checkbox "I acknowledge and accept Data Protection Declaration"
     */
    @FindBy(id = "id_terms_1")
    private CustomWebElement checkboxAcceptDPD;

    /**
     * Checkbox "I accept and acknowledge General Terms and Conditions"
     */
    @FindBy(id = "id_terms_2")
    private CustomWebElement checkboxAcceptGTC;

    /**
     * Checkbox 'I am a new customer'
     */
    @FindBy(id = "id_sign_in_up_up")
    private CustomWebElement checkboxNewCustomer;

    /**
     * Constructor for BookingStep3Page class
     */
    public BookingStep3Page() {
        super();
    }

    /**
     * Method for entering user`s first name
     *
     * @param firstName is user`s first name
     */
    public void setFirstNameField(String firstName) {
        WaitUtils.waitForVisibility(firstNameField);
        firstNameField.sendKeys(firstName);
        logger.info(String.format("First name: %s", firstName));
    }

    /**
     * Method which allows to select the checkbox 'I am a new customer'
     */
    public void selectCheckboxNewCustomer() {
        checkboxNewCustomer.moveToElementAndClick();
        logger.info("Check 'I am a new customer' checkbox.");
    }

    /**
     * Method for entering user`s last name
     *
     * @param lastName is user`s last name
     */
    public void setLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
        logger.info(String.format("Last name: %s", lastName));
    }

    /**
     * Method for entering user`s card number
     *
     * @param cardNumber is user`s card number
     */
    public void setCardNumberField(String cardNumber) {
        WaitUtils.waitForVisibility(cardNumberField);
        cardNumberField.sendKeys(cardNumber);
        logger.info(String.format("Card number: %s", cardNumber));
    }

    /**
     * Method which selects the checkbox "I acknowledge and accept Data Protection Declaration"
     */
    public void selectCheckboxAcceptDPD() {
        checkboxAcceptDPD.moveToElementAndClick();
        logger.info("Check 'Data Protection Declaration' checkbox.");
    }

    /**
     * Method for entering e-mail
     *
     * @param email is the e-mail
     */
    public void setEmailField(String email) {
        emailField.sendKeys(email);
        logger.info(String.format("Email: %s", email));
    }

    /**
     * Method which selects checkbox "I accept and acknowledge General Terms and Conditions"
     */
    public void selectCheckboxAcceptGTC() {
        checkboxAcceptGTC.moveToElementAndClick();
        logger.info("Check 'General Terms and Conditions' checkbox.");
    }

    /**
     * Method for entering holder name
     *
     * @param holdername is holder name
     */
    public void setHolderNameField(String holdername) {
        holderNameField.sendKeys(holdername);
        logger.info(String.format("Holder name: %s", holdername));
    }

    /**
     * Method for entering expiration month
     *
     * @param month is the month
     */
    public void setMonthField(String month) {
        monthField.sendKeys(month);
        monthField.sendKeys(String.valueOf(Keys.ENTER));
        logger.info(String.format("Valid till month: %s", month));
    }

    /**
     * Method for entering expiration year
     *
     * @param year is the year
     */
    public void setYearField(String year) {
        yearField.sendKeys(year);
        yearField.sendKeys(String.valueOf(Keys.ENTER));
        logger.info(String.format("Valid till year: %s", year));
    }

    /**
     * Method for entering card`s CVC
     *
     * @param cvc is the CVC
     */
    public void setCvcField(String cvc) {
        cvcField.sendKeys(cvc);
        logger.info(String.format("CVC: %s", cvc));
    }

    /**
     * Method for entering mobile phone number
     *
     * @param mobilePhone is the phone number
     */
    public void setMobilePhoneField(String mobilePhone) {
        mobilePhoneField.sendKeys(mobilePhone);
        logger.info(String.format("Mobile phone: %s", mobilePhone));
    }

    /**
     * Method for entering phone prefix
     *
     * @param prefix is the prefix
     */
    public void setPhonePrefix(String prefix) {
        phonePrefix.sendKeys(prefix);
        logger.info(String.format("Phone prefix: %s", prefix));
    }

    /**
     * Method for choosing the checkbox "I accept Conditions of transport"
     */
    public void selectCheckboxIAcceptConditions() {
        ScrollUtils.scrollToBottomOfAPage();
        checkBoxIAcceptConditions.moveToElementAndClick();
        logger.info("Check 'Conditions of transport' checkbox.");
    }

    /**
     * Method for clicking on the button "Book"
     */
    public void clickBookButton() {
        ScrollUtils.scrollToBottomOfAPage();
        bookButton.moveToElementAndClick();
        logger.info("Click 'Book' button");
    }

    /**
     * Method which shows whether the message "Invalid card number" is displayed
     *
     * @return true if it is displayed and false if not
     */
    public boolean isMessageInvalidCardNumberDisplayed() {
        WaitUtils.waitForVisibility(messageInvalidCardNumber);
        logger.info("Message 'Invalid card number' is displayed");
        return messageInvalidCardNumber.isDisplayed();
    }

}