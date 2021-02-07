package com.epam.talixo.pages;

import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.properties.UrlsStorage;
import com.epam.talixo.framework.utils.FindElementUtil;
import com.epam.talixo.framework.utils.ScrollUtils;
import com.epam.talixo.framework.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

/**
 * Class for describing the homepage of the web-site
 */
public class HomePage extends AbstractPage {

    private static final String NUMBER_OF_PASSENGERS_PATTERN = "id_passengers_chzn_o_%s";
    private static final String NUMBER_OF_BAGS_PATTERN = "id_luggage_chzn_o_%s";
    private static final String NUMBER_OF_ANIMALS_PATTERN = "id_animals_chzn_o_%s";
    private static final String NUMBER_OF_SPORT_LUGGAGE_PATTERN = "id_sport_luggage_chzn_o_%s";
    private static final String NUMBER_OF_CHILDREN_3_6_PATTERN = "id_kids_1_chzn_o_%s";
    private static final String NUMBER_OF_CHILDREN_6_12_PATTERN = "id_kids_2_chzn_o_%s";
    private final Logger logger = LogManager.getLogger();
    private String url = UrlsStorage.getLoginPageUrl();
    /**
     * The field where you enter the address to be picked up from
     */
    @FindBy(id = "id_start_point_NEW")
    private CustomWebElement pickUpField;

    /**
     * The field where you enter the address of destination
     */
    @FindBy(id = "id_end_point_NEW")
    private CustomWebElement destinationField;

    /**
     * The button which you press for booking a taxi for tomorrow
     */
    @FindBy(xpath = "//label[@for='id_start_time_date_1']/*[@class='start-date-human']")
    private CustomWebElement tomorrowButton;

    /**
     * The field where you enter the time when a taxi should arrive
     */
    @FindBy(id = "id_start_time_time")
    private CustomWebElement time;

    /**
     * The button which you press when you need menu with the number of passengers, children, luggage and etc to drop-down
     */
    @FindBy(className = "more-options")
    private CustomWebElement moreOptionsButton;

    /**
     * The button which you press when uou have chosen all necessary options and want to book a taxi
     */
    @FindBy(xpath = "//*[@value='Start booking']")
    private CustomWebElement startBookingButton;

    /**
     * Opens the drop-down queue with the number of passengers when is pressed
     */
    @FindBy(id = "id_passengers_chzn")
    private CustomWebElement passengersFieldQueue;

    /**
     * Opens the drop-down queue with the number of luggage when is pressed
     */
    @FindBy(id = "id_luggage_chzn")
    private CustomWebElement luggageFieldQueue;

    /**
     * Opens the drop-down queue with the number of children when is pressed
     */
    @FindBy(id = "id_children_seats")
    private CustomWebElement numberOfChildrenQueue;

    /**
     * Opens the drop-down queue with the number of 3-6 yo children when is pressed
     */
    @FindBy(id = "id_kids_1_chzn")
    private CustomWebElement numberOf3_6yoChildrenQueue;

    /**
     * Opens the drop-down queue with the number of 6-12 yo children when is pressed
     */
    @FindBy(id = "id_kids_2_chzn")
    private CustomWebElement nummberOf6_12yoChildrenQueue;

    /**
     * Press when the number of children is selected
     */
    @FindBy(css = ".booking-mask-children-seats-ok")
    private CustomWebElement submitNumberOfChildrenButton;

    /**
     * The message which appears when the capacity of cars is exceeded
     */
    @FindBy(css = ".booking-mask-tooltip.booking-mask-luggage-tooltip")
    private CustomWebElement maximumCapacityMessage;

    /**
     * Opens the drop-down queue with the number of animals when is pressed
     */
    @FindBy(id = "id_animals_chzn")
    private CustomWebElement numberofAnimalsQueue;

    /**
     * The city from which user fly by plane
     */
    @FindBy(id = "id_departure_city")
    private CustomWebElement departureField;

    /**
     * User's flight number which user should enter to specify his flight
     */
    @FindBy(id = "id_flight_number")
    private CustomWebElement flightNumberField;

    /**
     * The button which user clicks for booking a taxi for today
     */
    @FindBy(xpath = "//label[@for='id_start_time_date_0']/*[@class='start-date-human']")
    private CustomWebElement todayButton;

    /**
     * Message that appears when user books a taxi for the past
     */
    @FindBy(xpath = "//*[contains(@class,'booking-mask-tooltip')][@data-tooltip-invalid]")
    private CustomWebElement messageBookingSixtyMinutesInFuture;

    /**
     * Message that appears when user enters unrelated addresses
     */
    @FindBy(xpath = "//*[@data-tooltip-errors]/*[@class='errorlist']")
    private CustomWebElement messageCannotFindRouteBtwnAddresses;

    /**
     * Opens the drop-down queue with the number of sport equipment when is pressed
     */
    @FindBy(id = "id_sport_luggage_chzn")
    private CustomWebElement numberOfSportEquipmentQueue;

    /**
     * The button is used for closing infobox
     */
    @FindBy(className = "TrackingInfoBox__CloseButton")
    private CustomWebElement trackingInfoBoxCloseButton;

    /**
     * The checkbox is used for selecting 'per-hour booking'
     */
    @FindBy(id = "id_time_based")
    private CustomWebElement perhourBookingButton;

    /**
     * The message which appears if the route takes longer than 7h
     */
    @FindBy(css = ".booking-mask-tooltip.booking-mask-errors-tooltip")
    private CustomWebElement longerThan7hMessage;

    /**
     * The message which appears when booking for NOW
     */
    @FindBy(css = ".booking-mask-tooltip.booking-mask-eta-tooltip.booking-mask-errors-tooltip")
    private CustomWebElement noAvailableCarsMessage;

    /**
     * The message "Maximum distance for 1h is 25 km"
     */
    @FindBy(css = ".booking-mask-tooltip.booking-mask-errors-tooltip")
    private CustomWebElement maximumDistanceMessage;

    /**
     * MY SETTINGS button
     */
    @FindBy(css = ".fa.fa-fw.fa-gears")
    private CustomWebElement buttonMySettings;

    /**
     * Constructor of HomePage class
     */
    public HomePage() {
        super();
    }

    /**
     * Method for entering an address in the field PICK UP
     *
     * @param pickUp is the address where a taxi should arrive for a user
     */
    public void setPickUpField(String pickUp) {
        pickUpField.sendKeys(pickUp);
        pickUpField.sendKeys(String.valueOf(Keys.ENTER));
        logger.info(String.format("Pick up address: %s", pickUp));
    }

    /**
     * Method which shows whether the message "Maximum distance for 1h is 25 km" is displayed
     *
     * @return true if it`s displayed and false if not
     */
    public boolean isMessageMaximumDistanceDisplayed() {
        WaitUtils.waitForVisibility(maximumDistanceMessage);
        logger.info("Message 'Maximum distance for 1h is 25 km' is displayed");
        return maximumDistanceMessage.isDisplayed();
    }

    /**
     * Method allows to select 'per-hour booking'
     */
    public void selectPerhourBooking() {
        perhourBookingButton.click();
        logger.info("Select 'per-hour booking'");
    }

    /**
     * Method for entering an address in the field DESTINATION
     *
     * @param destination is the address where a taxi should take a user
     */
    public void setDestinationField(String destination) {
        destinationField.sendKeys(destination);
        destinationField.sendKeys(String.valueOf(Keys.ENTER));
        logger.info(String.format("Destination address: %s", destination));
    }

    /**
     * Method for clicking on the button "tomorrow"
     */
    public void clickTomorrowButton() {
        tomorrowButton.moveToElementAndClick();
        logger.info("Click 'Tomorrow' button");
    }

    /**
     * Method for entering the time of arriving a taxi
     *
     * @param timeData is the time
     */
    public void setTime(String timeData) {
        time.clearAndType(timeData);
        time.sendKeys(String.valueOf(Keys.ENTER));
        logger.info(String.format("The time of arriving the taxi: %s", timeData));
    }

    /**
     * Method for clicking on the button "more options"
     */
    public void clickMoreOptionsButton() {
        moreOptionsButton.click();
        logger.info("Click 'more options' button");
    }

    /**
     * Method allows to set the number of adult passengers/animals/bags/children and etc
     *
     * @param numberOfPassengers is the end of the locator of the custom web element you need to locate:0 means 1 passenger
     */
    public void setNumberOfPassengers(String numberOfPassengers) {
        passengersFieldQueue.click();
        String customWebElementLocator = String.format(NUMBER_OF_PASSENGERS_PATTERN, numberOfPassengers);
        ScrollUtils.scrollToElement(customWebElementLocator);
        FindElementUtil.findElement(By.id(customWebElementLocator)).click();
        logger.info(String.format("Number of passengers: %s", numberOfPassengers));
    }

    /**
     * Method allows to set the number of bags
     *
     * @param numberOfBags is the number of bags
     */
    public void setNumberOfBags(String numberOfBags) {
        luggageFieldQueue.click();
        String customWebElementLocator = String.format(NUMBER_OF_BAGS_PATTERN, numberOfBags);
        ScrollUtils.scrollToElement(customWebElementLocator);
        FindElementUtil.findElement(By.id(customWebElementLocator)).click();
        logger.info(String.format("Number of bags: %s", numberOfBags));
    }

    /**
     * Method allows to set the number of sport luggage
     *
     * @param numberOfSportEquipment is the number of sport equipment
     */
    public void setNumberOfSportEquipment(String numberOfSportEquipment) {
        numberOfSportEquipmentQueue.click();
        String customWebElementLocator = String.format(NUMBER_OF_SPORT_LUGGAGE_PATTERN, numberOfSportEquipment);
        ScrollUtils.scrollToElement(customWebElementLocator);
        FindElementUtil.findElement(By.id(customWebElementLocator)).click();
        logger.info(String.format("Number of sport equipment: %s", numberOfSportEquipment));
    }

    /**
     * Method allows to set the number of animals
     *
     * @param numberOfAnimals is the number of animals
     */
    public void setNumberOfAnimals(String numberOfAnimals) {
        numberofAnimalsQueue.click();
        String customWebElementLocator = String.format(NUMBER_OF_ANIMALS_PATTERN, numberOfAnimals);
        ScrollUtils.scrollToElement(customWebElementLocator);
        FindElementUtil.findElement(By.id(customWebElementLocator)).click();
        logger.info(String.format("Number of animals: %s", numberOfAnimals));
    }

    /**
     * Method allows to set the number of children at the age of 3-6 yo and at the age of 6-12yo
     */
    public void openSelectingChildrenWindow() {
        numberOfChildrenQueue.click();
    }

    /**
     * Method allows to set the number of children at the age of 3-6 yo
     *
     * @param number_of_children_3_6 is the number of children at the age of 3-6yo
     */
    public void setNumberOfChildren_3_6(String number_of_children_3_6) {
        numberOf3_6yoChildrenQueue.click();
        String customWebElementLocator = String.format(NUMBER_OF_CHILDREN_3_6_PATTERN, number_of_children_3_6);
        FindElementUtil.findElement(By.id(customWebElementLocator)).click();
        logger.info(String.format("Number of children at the age of 3-6yo: %s", number_of_children_3_6));
    }

    /**
     * Method allows to set the number of children at the age of 6-12yo
     *
     * @param number_of_children_6_12 is the number of children at the age of 6-12yo
     */
    public void setNumberOfChildren_6_12(String number_of_children_6_12) {
        nummberOf6_12yoChildrenQueue.click();
        String customWebElementLocator = String.format(NUMBER_OF_CHILDREN_6_12_PATTERN, number_of_children_6_12);
        FindElementUtil.findElement(By.id(customWebElementLocator)).click();
        logger.info(String.format("Number of children at the age of 6-12yo: %s", number_of_children_6_12));
    }

    /**
     * Method allows to click on "OK" button after selecting the number of children
     */
    public void clickSubmitNumberOfChildrenButton() {
        submitNumberOfChildrenButton.click();
        logger.info("Submit the number of children.");
    }

    /**
     * Method closes infoBox. It`s needed because this box catches clicks on other buttons and
     * makes them not clickable
     */
    public void closeInfoBox() {
        trackingInfoBoxCloseButton.click();
        logger.info("Close InfoBox");
    }

    /**
     * Method which shows whether the message "Maximum capacity of our vehicles is 8" is displayed
     *
     * @return true if it`s displayed and false if not
     */
    public boolean isMessageMaximumCapacityDisplayed() {
        return maximumCapacityMessage.isDisplayed();
    }

    /**
     * Method for clicking on the button "Start Booking"
     */
    public void clickStartBookingButton() {
        startBookingButton.moveToElementAndClick();
        logger.info("Click 'Start Booking' button");
    }

    /**
     * Method for clicking on the button "today"
     */
    public void clickTodayButton() {
        todayButton.click();
    }

    /**
     * Check if there's a "Booking has to be at least 60 minutes in the future" message
     *
     * @return true if message is displayed, false if there isn't
     */
    public boolean isMessageBookingSixtyMinutesInFutureDisplayed() {
        WaitUtils.waitForVisibility(messageBookingSixtyMinutesInFuture);
        logger.info("Message 'Booking has to be at least 60 minutes in the future' is displayed");
        return messageBookingSixtyMinutesInFuture.isDisplayed();
    }

    /**
     * Check if there's a "Cannot find route between addresses provided" message
     *
     * @return true if message is displayed, false if there isn't
     */
    public boolean isMessageCannotFindRouteBtwnAddressesDisplayed() {
        WaitUtils.waitForVisibility(messageCannotFindRouteBtwnAddresses);
        logger.info("Message 'Cannot find route between addresses provided' is displayed");
        return messageCannotFindRouteBtwnAddresses.isDisplayed();
    }

    /**
     * Method for entering an address in the field FLIGHT NUMBER
     *
     * @param flightNumber is a number which user should enter to specify his flight
     */
    public void setFlightNumberField(String flightNumber) {
        WaitUtils.waitForVisibility(flightNumberField);
        flightNumberField.sendKeys(flightNumber);
        logger.info(String.format("Flight Number: %s", flightNumber));
    }

    /**
     * Method for entering an address in the field DEPARTURE CITY
     *
     * @param departure is the city from which user flies by plane
     */
    public void setDepartureField(String departure) {
        WaitUtils.waitForVisibility(departureField);
        departureField.sendKeys(departure);
        WaitUtils.waitForVisibility(startBookingButton);
        startBookingButton.click();
        logger.info(String.format("Departue City: %s", departure));
    }

    /**
     * Method shows whether the message 'Sorry, our system indicates that the route will take longer than 7h...'
     * is displayed
     *
     * @return true if it`s displayed and false if not
     */
    public boolean isMessageLongerThan7hDisplayed() {
        WaitUtils.waitForVisibility(longerThan7hMessage);
        logger.info("Message '...the route will take longer than 7h...' is displayed");
        return longerThan7hMessage.isDisplayed();
    }

    /**
     * Method shows whether the message 'No available cars' is displayed
     *
     * @return true if it`s displayed and false if not
     */
    public boolean isMessageNoAvailableCarsDisplayed() {
        logger.info("Message 'No available cars' is displayed");
        return noAvailableCarsMessage.isDisplayed();
    }

    /**
     * This method allows to click on MY SETTINGS button
     */
    public void clickOnMySettings() {
        WaitUtils.waitForVisibility(buttonMySettings);
        buttonMySettings.moveToElementAndClick();
        logger.info("Click 'MY SETTINGS' button");
    }

    /**
     * This method opens Login page
     */
    public void openHomePage() {
        driver.navigate().to(url);
        logger.info("Home page is opened: " + url);
    }

}