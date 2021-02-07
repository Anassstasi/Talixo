package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.utils.KeyboardUtilsMobile;
import com.epam.talixo.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for describing the 4th step of booking a taxi
 */
public class BookingStep4PageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    @AndroidFindBy(id = "input-card-number")
    private MobileElement cardNumberField;

    @AndroidFindBy(id = "input-card-holder-name")
    private MobileElement holderNameField;

    @AndroidFindBy(id = "input-expiry-month")
    private MobileElement monthField;

    @AndroidFindBy(id = "input-expiry-year")
    private MobileElement yearField;

    @AndroidFindBy(id = "android:id/custom")
    private MobileElement listView;

    @AndroidFindBy(id = "input-card-cvc")
    private MobileElement cvcField;

    @AndroidFindBy(id = "input-pay")
    private MobileElement bookButton;

    @AndroidFindBy(id = "validation-errors")
    private MobileElement messageInvalidCardNumber;

    /**
     * Method for entering user`s card number
     *
     * @param cardNumber is user`s card number
     */
    public void setCardNumberField(String cardNumber) {
        WaitUtilsMobile.waitForVisibility(cardNumberField);
        cardNumberField.sendKeys(cardNumber);
        KeyboardUtilsMobile.hideKeyboard();
        logger.info(String.format("Card number: %s", cardNumber));
    }


    /**
     * Method for entering holder name
     *
     * @param holderName is holder name
     */
    public void setHolderNameField(String holderName) {
        holderNameField.sendKeys(holderName);
        KeyboardUtilsMobile.hideKeyboard();
        logger.info(String.format("Holder name: %s", holderName));
    }

    /**
     * Method for entering expiration month
     */
    public void setMonthField() {
        monthField.click();
        listView.click();
        logger.info("Month span is filled");
    }

    /**
     * Method for entering expiration year
     */
    public void setYearField() {
        yearField.click();
        listView.click();
        logger.info("Year span is filled");
    }

    /**
     * Method for entering card`s CVC
     *
     * @param cvc is the CVC
     */
    public void setCvcField(String cvc) {
        cvcField.sendKeys(cvc);
        KeyboardUtilsMobile.hideKeyboard();
        logger.info(String.format("CVC: %s", cvc));
    }

    /**
     * Method for clicking on the button "Book"
     */
    public void clickBookButton() {
        bookButton.click();
        logger.info("Click 'Book' button");
    }

    /**
     * Method which shows whether the message "Invalid card number" is displayed
     *
     * @return true if it is displayed and false if not
     */
    public boolean isMessageInvalidCardNumberDisplayed() {
        WaitUtilsMobile.waitForVisibility(messageInvalidCardNumber);
        logger.info("Message 'Invalid card number' is displayed");
        return messageInvalidCardNumber.isDisplayed();
    }

}