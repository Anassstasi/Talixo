package com.epam.talixo.mobile.steps;

import com.epam.talixo.framework.data.entities.Order;
import com.epam.talixo.mobile.pages.BookingStep2PageMobile;
import com.epam.talixo.mobile.pages.BookingStep3PageMobile;
import com.epam.talixo.mobile.pages.BookingStep4PageMobile;
import com.epam.talixo.mobile.pages.HomePageMobile;

import static org.junit.Assert.assertTrue;

/**
 * The class includes methods which are needed for booking a taxi
 */
public class BookingStepsMobile {

    private HomePageMobile homePageMobile = new HomePageMobile();
    private BookingStep2PageMobile bookingStep2PageMobile = new BookingStep2PageMobile();
    private BookingStep3PageMobile bookingStep3PageMobile = new BookingStep3PageMobile();
    private BookingStep4PageMobile bookingStep4PageMobile = new BookingStep4PageMobile();

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param order Booking data
     */
    public void startBookingForTomorrow(Order order) {
        homePageMobile.setPickUpLocation(order.getPickUpAddress());
        homePageMobile.setDestinationLocation(order.getDestinationAddress());
        homePageMobile.setTomorrow();
        homePageMobile.setTime(order.getTime());
    }

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param pickUpAddress      is the address to be picked up from
     * @param destinationAddress is the the address of destination
     * @param time               is the time of arriving the taxi
     */
    public void startBookingForTomorrow(String pickUpAddress, String destinationAddress, String time) {
        homePageMobile.setPickUpLocation(pickUpAddress);
        homePageMobile.setDestinationLocation(destinationAddress);
        homePageMobile.setTomorrow();
        homePageMobile.setTime(time);
    }

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param pickUpAddress      is the address to be picked up from
     * @param destinationAddress is the the address of destination
     */
    public void startBookingForToday(String pickUpAddress, String destinationAddress) {
        homePageMobile.setPickUpLocation(pickUpAddress);
        homePageMobile.setDestinationLocation(destinationAddress);
    }

    /**
     * Method for entering all the needed data in the 'more option' form
     *
     * @param options options data (adults, bags, sport luggage, animals and children)
     */
    public void fillOptions(Order options) {
        homePageMobile.swipeToBottomOfThePage();
        homePageMobile.setNumberOfPassengers(options.getNumAdults());
        homePageMobile.setNumberOfBags(options.getNumBags());
        homePageMobile.setNumberOfAnimals(options.getNumAnimals());
        homePageMobile.setNumberOfSportEquipment(options.getNumSportLuggage());
    }

    /**
     * Method for clicking "Select a car" button
     */
    public void clickStartBooking() {
        homePageMobile.clickStartBookingButton();
    }

    /**
     * Method for choosing an Economy+ car
     */
    public void proceedToPayment() {
        bookingStep2PageMobile.clickOnProceedToPaymentButton();
    }

    /**
     * Method for choosing a payment card
     */
    public void chooseACard() {
        bookingStep3PageMobile.clickOnCardButton();
    }

    /**
     * Method for entering payment details
     *
     * @param order Order
     */
    public void setPaymentDetails(Order order) {
        bookingStep4PageMobile.setCardNumberField(order.getCardNumber());
        bookingStep4PageMobile.setHolderNameField(order.getHolderName());
        bookingStep4PageMobile.setCvcField(order.getCvc());
    }

    /**
     * Method for clicking "Book" button for finishing booking
     */
    public void finishBooking() {
        bookingStep4PageMobile.clickBookButton();
    }

    /**
     * Method for skipping layout for flight number input
     */
    public void skipFlightNumberInput() {
        homePageMobile.ClickOnSkipFlightNumberButton();
    }

    /**
     * This method checks whether the message "Invalid card number" is displayed
     */
    public void isMessageInvalidCardNumberDisplayed() {
        assertTrue("The 'Invalid card number' message is not displayed'", bookingStep4PageMobile.isMessageInvalidCardNumberDisplayed());
    }

    /**
     * Method which checks whether the message "Fully booked!" is displayed
     */
    public void isMessageNoCarsDisplayed() {
        assertTrue("The 'Fully booked!' message is not displayed'", bookingStep2PageMobile.isMessageNoCarsDisplayed());
    }

    /**
     * Method which checks whether the message "Cannot find route between addresses provided" is displayed
     */
    public void isMessageCannotFindRouteBtwnAddressesDisplayed() {
        assertTrue("The 'No Route' message is not displayed",
                homePageMobile.isMessageCannotFindRouteBtwnAddressesDisplayed());
    }

}