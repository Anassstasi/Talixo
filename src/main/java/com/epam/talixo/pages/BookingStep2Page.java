package com.epam.talixo.pages;

import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

/**
 * Class for describing the 2nd step of booking a taxi
 */
public class BookingStep2Page extends AbstractPage {

    private final Logger logger = LogManager.getLogger();
    /**
     * Button to book the "Economy+" car
     */
    @FindBy(xpath = "//*[@value='Book Economy+']")
    private CustomWebElement bookEconomyButton;
    /**
     * Button to book the "Economy+" car
     */
    @FindBy(xpath = "//*[@value='Book Economy VAN']")
    private CustomWebElement bookEconomyVANButton;

    /**
     * The message which appears when there is no appropriate car
     */
    @FindBy(css = ".booking-class-vehicle-inner .booking-class-header")
    private CustomWebElement noNeededCarMessage;

    /**
     * Constructor of BookingStep2Page class
     */
    public BookingStep2Page() {
        super();
    }

    /**
     * Method which shows whether the message "We are sorry, but at the moment all of our fleets are fully booked..."
     * is displayed
     *
     * @return true if it is displayed and false if not
     */
    public boolean isMessageNoCarsDisplayed() {
        WaitUtils.waitForVisibility(noNeededCarMessage);
        logger.info("Message 'NoCars' is displayed");
        return noNeededCarMessage.isDisplayed();
    }

    /**
     * Method for clicking on the button "Book Economy+"
     */
    public void clickBookEconomyButton() {
        bookEconomyButton.click();
        logger.info("Click 'Book Economy+' button.");
    }

    /**
     * Method for clicking on the button "Book Economy VAN"
     */
    public void clickBookEconomyVan() {
        bookEconomyVANButton.moveToElementAndClick();
        logger.info("Click 'Book Economy VAN' button.");
    }

}