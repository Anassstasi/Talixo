package com.epam.talixo.mobile.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for describing the 3rd step of booking a taxi
 */
public class BookingStep3PageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    @AndroidFindBy(id = "paymentMethods")
    private MobileElement cardButton;

    /**
     * This method allows to choose payment card
     */
    public void clickOnCardButton() {
        cardButton.click();
        logger.info("Payment card is selected");
    }

}