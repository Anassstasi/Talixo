package com.epam.talixo.mobile.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for describing the 2nd step of booking a taxi
 */
public class BookingStep2PageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    @AndroidFindBy(id = "com.talixo.client:id/add_payment_method_for_booking_button")
    private MobileElement proceedToPaymentButton;

    @AndroidFindBy(id = "com.talixo.client:id/tv_error")
    private MobileElement noNeededCarMessage;

    @AndroidFindBy(id = "com.talixo.client:id/tv_error")
    private MobileElement shortTripMessage;

    /**
     * This method allows to click on proceed to payment button
     */
    public void clickOnProceedToPaymentButton() {
        proceedToPaymentButton.click();
        logger.info("Proceed to payment button is clicked");
    }

    /**
     * Method which shows whether the message "Fully booked!"
     * is displayed
     *
     * @return true if it is displayed and false if not
     */
    public boolean isMessageNoCarsDisplayed() {
        logger.info("Message 'Fully booked!' is displayed");
        return noNeededCarMessage.isDisplayed();
    }

}