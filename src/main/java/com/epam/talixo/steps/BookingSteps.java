package com.epam.talixo.steps;

import com.epam.talixo.framework.data.Options;
import com.epam.talixo.framework.data.entities.Order;
import com.epam.talixo.pages.BookingStep2Page;
import com.epam.talixo.pages.BookingStep3Page;
import com.epam.talixo.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * The class includes methods which are needed for booking a taxi
 */
public class BookingSteps {

    private HomePage homePage = new HomePage();
    private BookingStep2Page bookingStep2Page = new BookingStep2Page();
    private BookingStep3Page bookingStep3Page = new BookingStep3Page();

    /**
     * Method which opens Home page
     */
    @Given("^the user opens Talixo homepage$")
    public void openHomePage() {
        homePage.openHomePage();
    }

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param pickUpAddress      is the address to be picked up from
     * @param destinationAddress is the the address of destination
     * @param time               is the time of arriving the taxi
     */
    @When("^the user starts booking a taxi for tomorrow with \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" on the Home page$")
    public void startBookingForTomorrow(String pickUpAddress, String destinationAddress, String time) {
        homePage.setPickUpField(pickUpAddress);
        homePage.setDestinationField(destinationAddress);
        homePage.clickTomorrowButton();
        homePage.setTime(time);
    }

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param order Booking data
     */
    public void startBookingForTomorrow(Order order) {
        homePage.setPickUpField(order.getPickUpAddress());
        homePage.setDestinationField(order.getDestinationAddress());
        homePage.clickTomorrowButton();
        homePage.setTime(order.getTime());
    }

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param pickUpAddress      is the address to be picked up from
     * @param flightNumber       is a number that specifies the flight
     * @param departureCity      is the city from which user flies by plane
     * @param destinationAddress is the the address of destination
     * @param time               is the time of arriving the taxi
     */
    public void startBookingForToday(String pickUpAddress, String flightNumber, String departureCity,
                                     String destinationAddress, String time) {
        homePage.setPickUpField(pickUpAddress);
        homePage.setFlightNumberField(flightNumber);
        homePage.setDepartureField(departureCity);
        homePage.setDestinationField(destinationAddress);
        homePage.clickTodayButton();
        homePage.setTime(time);
    }

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param data map with data for filling fields
     */
    @When("^the user starts booking a taxi for today on the Home page$")
    public void startBookingForToday(Map<String, String> data) {
        homePage.setPickUpField(data.get(Options.PICK_UP_ADDRESS.getOption()));
        homePage.setFlightNumberField(data.get(Options.FLIGHT_NUMBER.getOption()));
        homePage.setDepartureField(data.get(Options.DEPARTURE_CITY.getOption()));
        homePage.setDestinationField(data.get(Options.DESTINATION_ADDRESS.getOption()));
        homePage.clickTodayButton();
        homePage.setTime(data.get(Options.TIME.getOption()));
    }

    /**
     * Method for entering all the needed data for booking a taxi for 2 people with 2 bags
     *
     * @param pickUpAddress      is the address to be picked up from
     * @param destinationAddress is the the address of destination
     * @param time               is the time of arriving the taxi
     */
    @When("^the user starts booking a taxi for 2 people with 2 bags for today with \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" on the Home page$")
    public void startBookingForToday(String pickUpAddress, String destinationAddress, String time) {
        homePage.setPickUpField(pickUpAddress);
        homePage.setDestinationField(destinationAddress);
        homePage.clickTodayButton();
        homePage.setTime(time);
    }

    /**
     * Method for entering all the needed data in the 'more option' form
     *
     * @param options map of data (adults, bags, sport luggage, animals and children)
     */
    @When("^the user fills options for booking a taxi on the Home page$")
    public void fillOptions(Map<String, String> options) {
        homePage.clickMoreOptionsButton();
        homePage.setNumberOfPassengers(options.get(Options.ADULTS.getOption()));
        homePage.setNumberOfBags(options.get(Options.BAGS.getOption()));
        homePage.setNumberOfSportEquipment(options.get(Options.SPORT_LUGGAGE.getOption()));
        homePage.setNumberOfAnimals(options.get(Options.ANIMALS.getOption()));
        setNumberOfChildren(options.get(Options.CHILD3_6.getOption()), options.get(Options.CHILD6_12.getOption()));
    }

    /**
     * Method for entering all the needed data in the 'more option' form
     *
     * @param numAdults        is the number of passengers
     * @param numBags          is the number of bags
     * @param numSportLuggage  is the number of sport equipment
     * @param numAnimals       is the number of animals
     * @param numChild3_6yo    is the number of children at the age of 3-6years
     * @param numOfChild6_12yo is the number of children at the age of 6-12years
     */
    public void fillOptions(String numAdults, String numBags, String numSportLuggage, String numAnimals, String numChild3_6yo, String numOfChild6_12yo) {
        homePage.clickMoreOptionsButton();
        homePage.setNumberOfPassengers(numAdults);
        homePage.setNumberOfBags(numBags);
        homePage.setNumberOfSportEquipment(numSportLuggage);
        homePage.setNumberOfAnimals(numAnimals);
        setNumberOfChildren(numChild3_6yo, numOfChild6_12yo);
    }

    /**
     * Method for entering all the needed data in the 'more option' form
     *
     * @param options options data (adults, bags, sport luggage, animals and children)
     */
    public void fillOptions(Order options) {
        homePage.clickMoreOptionsButton();
        homePage.setNumberOfPassengers(options.getNumAdults());
        homePage.setNumberOfBags(options.getNumBags());
        homePage.setNumberOfSportEquipment(options.getNumSportLuggage());
        homePage.setNumberOfAnimals(options.getNumAnimals());
        setNumberOfChildren(options.getNumChild3_6yo(), options.getNumChild6_12yo());
    }

    /**
     * Method allows to set the number of children at the age of 3-6yo and 6-12yo at the same time
     *
     * @param numChild3_6yo  is the number of children at the age of 3-6yo
     * @param numChild6_12yo is the number of children at the age of 6-12yo
     */
    private void setNumberOfChildren(String numChild3_6yo, String numChild6_12yo) {
        homePage.openSelectingChildrenWindow();
        homePage.setNumberOfChildren_3_6(numChild3_6yo);
        homePage.setNumberOfChildren_6_12(numChild6_12yo);
        homePage.clickSubmitNumberOfChildrenButton();
    }

    /**
     * Method for closing infoBox
     */
    @When("^the user closes infobox on the Home page$")
    public void closeInfoBox() {
        homePage.closeInfoBox();
    }

    /**
     * Method for selecting 'per-hour booking' checkbox
     */
    @When("^the user selects per-hour booking on the Home page$")
    public void selectPerhourBooking() {
        homePage.selectPerhourBooking();
    }

    /**
     * Method for clicking "Start Booking" button
     */
    @When("^the user clicks on 'Start booking' button on the Home page$")
    public void clickStartBooking() {
        homePage.clickStartBookingButton();
    }

    /**
     * Method for choosing an Economy+ car
     */
    @When("^the user chooses an Economy car on the second Booking page$")
    public void chooseEconomyCar() {
        bookingStep2Page.clickBookEconomyButton();
    }

    /**
     * Method for choosing an EconomyVAN car
     */
    @When("^the user chooses an Economy VAN car on the second Booking page$")
    public void chooseEconomyVANCar() {
        bookingStep2Page.clickBookEconomyVan();
    }

    /**
     * Method for entering payment details
     *
     * @param cardNumber is the number of the card
     * @param holderName is the name of the holder
     * @param month      is the expire month
     * @param year       is the expire year
     * @param cvc        is card`s CVC
     */
    public void setPaymentDetails(String cardNumber, String holderName, String month, String year, String cvc) {
        bookingStep3Page.setCardNumberField(cardNumber);
        bookingStep3Page.setHolderNameField(holderName);
        bookingStep3Page.setMonthField(month);
        bookingStep3Page.setYearField(year);
        bookingStep3Page.setCvcField(cvc);
    }

    /**
     * Method for entering payment details
     *
     * @param order Order
     */
    public void setPaymentDetails(Order order) {
        bookingStep3Page.setCardNumberField(order.getCardNumber());
        bookingStep3Page.setHolderNameField(order.getHolderName());
        bookingStep3Page.setMonthField(order.getMonth());
        bookingStep3Page.setYearField(order.getYear());
        bookingStep3Page.setCvcField(order.getCvc());
    }

    /**
     * Method for entering payment details
     *
     * @param info map with data for filling fields
     */
    @When("^the user sets payment details on the third Booking page$")
    public void setPaymentDetails(Map<String, String> info) {
        bookingStep3Page.setCardNumberField(info.get(Options.CARD_NUMBER.getOption()));
        bookingStep3Page.setHolderNameField(info.get(Options.HOLDER_NAME.getOption()));
        bookingStep3Page.setMonthField(info.get(Options.MONTH.getOption()));
        bookingStep3Page.setYearField(info.get(Options.YEAR.getOption()));
        bookingStep3Page.setCvcField(info.get(Options.CVC.getOption()));
    }

    /**
     * Method enters user`s personal information
     *
     * @param firstName   is the first name
     * @param lastName    is the last name
     * @param prefixPhone is the phone prefix
     * @param phoneNumber is the phone number
     * @param email       is the e-mail
     */
    public void setPersonalInformation(String firstName, String lastName, String prefixPhone, String phoneNumber, String email) {
        bookingStep3Page.setFirstNameField(firstName);
        bookingStep3Page.setLastNameField(lastName);
        bookingStep3Page.setPhonePrefix(prefixPhone);
        bookingStep3Page.setMobilePhoneField(phoneNumber);
        bookingStep3Page.setEmailField(email);
    }

    /**
     * Method enters user`s personal information
     *
     * @param info map with data for filling fields
     */
    @When("^the user fills personal information fields on the third Booking page$")
    public void setPersonalInformation(Map<String, String> info) {
        bookingStep3Page.setFirstNameField(info.get(Options.FIRST_NAME.getOption()));
        bookingStep3Page.setLastNameField(info.get(Options.LAST_NAME.getOption()));
        bookingStep3Page.setPhonePrefix(info.get(Options.PREFIX_PHONE.getOption()));
        bookingStep3Page.setMobilePhoneField(info.get(Options.PHONE_NUMBER.getOption()));
        bookingStep3Page.setEmailField(info.get(Options.EMAIL.getOption()));
    }

    /**
     * Method for selecting the checkbox 'I accept conditions of transport'
     */
    @When("^the user should select 'I accept conditions of transport' check box on the third Booking page$")
    public void selectCheckBox() {
        bookingStep3Page.selectCheckboxIAcceptConditions();
    }

    /**
     * Method which selects the checkbox "I acknowledge and accept Data Protection Declaration"
     */
    @When("^the user should select 'I acknowledge and accept Data Protection Declaration' checkbox on the third Booking page$")
    public void selectCheckboxAcceptDPD() {
        bookingStep3Page.selectCheckboxAcceptDPD();
    }

    /**
     * Method which selects the checkbox "I accept and acknowledge General Terms and Conditions"
     */
    @When("^the user should select 'I accept and acknowledge General Terms and Conditions' checkbox on the third Booking page$")
    public void selectCheckboxAcceptGTC() {
        bookingStep3Page.selectCheckboxAcceptGTC();
    }

    /**
     * Method which allows to select the checkbox 'I am a new customer'
     */
    @When("^the user selects 'I am a new customer' checkbox on the third Booking page$")
    public void selectCheckboxNewCustomer() {
        bookingStep3Page.selectCheckboxNewCustomer();
    }

    /**
     * Method for clicking "Book" button for finishing booking
     */
    @When("^the user clicks on 'Book' button on the third Booking page$")
    public void finishBooking() {
        bookingStep3Page.clickBookButton();
    }

    /**
     * Method which checks whether the message "Booking has to be at least 60 minutes in the future" is displayed
     */
    @Then("^the 'Booking Sixty Minutes In Future' message should be displayed on the Home page$")
    public void isMessageBookingSixtyMinutesInFutureDisplayed() {
        assertTrue("The 'Booking Sixty Minutes In Future' message is not displayed'",
                homePage.isMessageBookingSixtyMinutesInFutureDisplayed());
    }

    /**
     * Method which checks whether the message "Cannot find route between addresses provided" is displayed
     */
    @Then("^the 'No Route' message should be displayed on the Home page$")
    public void isMessageCannotFindRouteBtwnAddressesDisplayed() {
        assertTrue("The 'No Route' message is not displayed",
                homePage.isMessageCannotFindRouteBtwnAddressesDisplayed());
    }

    /**
     * Method which checks whether the message "Invalid card number" is displayed
     */
    @Then("^the 'Invalid card number' message should be displayed on the third Booking page$")
    public void isMessageInvalidCardNumberDisplayed() {
        assertTrue("The 'Invalid card number' message is not displayed'", bookingStep3Page.isMessageInvalidCardNumberDisplayed());
    }

    /**
     * Method which checks whether the message "No available cars" is displayed
     */
    @Then("^the 'No Needed Car' message should be displayed on the second Booking page$")
    public void isMessageNoCarsDisplayed() {
        assertTrue("The 'No Needed Car' message is not displayed'", bookingStep2Page.isMessageNoCarsDisplayed());
    }

    /**
     * Method which shows whether the message "Maximum capacity of our vehicles is 8" is displayed
     */
    @Then("^the 'Maximum capacity' message should be displayed on the Home page$")
    public void isMessageMaximumCapacityDisplayed() {
        assertTrue("The 'Maximum capacity' message is not displayed'",
                homePage.isMessageMaximumCapacityDisplayed());
    }

    /**
     * Method shows whether the message 'Sorry, our system indicates that the route will take longer than 7h...' is displayed
     */
    @Then("^the 'Longer than seven hours' message should be displayed on the Home page$")
    public void isMessageLongerThan7hDisplayed() {
        assertTrue("The 'Longer than seven hours' message is not displayed'",
                homePage.isMessageLongerThan7hDisplayed());
    }

    /**
     * Method shows whether the message 'No available cars" is displayed
     */
    @Then("^the 'No available cars' message should be displayed on the Home page$")
    public void isMessageNoAvailableCarsDisplayed() {
        assertTrue("The'No available cars' message is not displayed'", homePage.isMessageNoAvailableCarsDisplayed());
    }

    /**
     * Method which checks whether the message "Maximum distance for 1h is 25 km" os displayed
     */
    @Then("^the 'Maximum distance for one hour' message should be displayed on the Home page$")
    public void isMessageMaximumDistanceDisplayed() {
        assertTrue("The 'Maximum distance for one hour' message is not displayed'", homePage.isMessageMaximumDistanceDisplayed());
    }

}