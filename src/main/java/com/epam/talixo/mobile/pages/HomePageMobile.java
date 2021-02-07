package com.epam.talixo.mobile.pages;

import com.epam.talixo.mobile.utils.ScrollUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.talixo.mobile.utils.WaitUtilsMobile.waitForVisibility;

/**
 * Class for describing the homepage of the app
 */
public class HomePageMobile extends AbstractPageMobile {

    private final Logger logger = LogManager.getLogger();

    @AndroidFindBy(id = "com.talixo.client:id/tv_start_point")
    private MobileElement pickUpLayout;

    @AndroidFindBy(id = "com.talixo.client:id/location_chooser_edit_text")
    private MobileElement neededLocationTextEdit;

    @AndroidFindBy(id = "com.talixo.client:id/location_address_text_view")
    private MobileElement neededTextView;

    @AndroidFindBy(id = "com.talixo.client:id/tv_end_point")
    private MobileElement destinationLayout;

    @AndroidFindBy(id = "com.talixo.client:id/date_control_date_picker")
    private MobileElement datePicker;

    @AndroidFindBy(id = "com.talixo.client:id/mdtp_ok")
    private MobileElement confirmPick;

    @AndroidFindBy(id = "com.talixo.client:id/date_control_time_picker")
    private MobileElement timePicker;

    @AndroidFindBy(id = "com.talixo.client:id/btn_select_car")
    private MobileElement selectCarButton;

    @AndroidFindBy(id = "com.talixo.client:id/btn_skip_flight_number")
    private MobileElement skipFlightNumberButton;

    @AndroidFindBy(id = "com.talixo.client:id/passenger_count")
    private MobileElement passengersTextEdit;

    @AndroidFindBy(id = "com.talixo.client:id/luggage_count")
    private MobileElement luggageTextEdit;

    @AndroidFindBy(id = "com.talixo.client:id/sport_luggage_count")
    private MobileElement numberOfSportEquipmentTextEdit;

    @AndroidFindBy(id = "com.talixo.client:id/animals_count")
    private MobileElement numberofAnimalsTextEdit;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.talixo.client:id/snackbar_text']")
    private MobileElement messageCannotFindRouteBtwnAddresses;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.talixo.client:id/menu_button']")
    private MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.view.View[@selected = 'true']/following-sibling::android.view.View[1]")
    private MobileElement tomorrowAndroidCalendar;

    /**
     * Method for entering the pickup address
     *
     * @param pickUp is the address where a taxi should arrive for a user
     */
    public void setPickUpLocation(String pickUp) {
        pickUpLayout.click();
        neededLocationTextEdit.sendKeys(pickUp);
        neededTextView.click();
        logger.info(String.format("Pick up address: %s", pickUp));
    }

    /**
     * Method for entering the destination address
     *
     * @param destination is the address where a taxi should take a user
     */
    public void setDestinationLocation(String destination) {
        destinationLayout.click();
        neededLocationTextEdit.sendKeys(destination);
        neededTextView.click();
        logger.info(String.format("Destination address: %s", destination));
    }

    /**
     * Method for entering the date of arriving a taxi
     */
    public void setTomorrow() {
        datePicker.click();
        tomorrowAndroidCalendar.click();
        confirmPick.click();
        logger.info("Set date for tomorrow");
    }

    /**
     * Method for entering the time of arriving a taxi
     */
    public void setTime(String time) {
        timePicker.setValue(time);
        confirmPick.click();
        logger.info(String.format("The time of arriving the taxi: %s", time));
    }

    /**
     * Method allows to set the number of adult passengers/animals/bags/children and etc
     *
     * @param numberOfPassengers is the end of the locator of the custom web element you need to locate:0 means 1 passenger
     */
    public void setNumberOfPassengers(String numberOfPassengers) {
        passengersTextEdit.sendKeys(numberOfPassengers);
        logger.info(String.format("Number of passengers: %s", numberOfPassengers));
    }

    /**
     * Method allows to set the number of bags
     *
     * @param numberOfBags is the number of bags
     */
    public void setNumberOfBags(String numberOfBags) {
        luggageTextEdit.sendKeys(numberOfBags);
        logger.info(String.format("Number of bags: %s", numberOfBags));
    }

    /**
     * Method allows to set the number of sport luggage
     *
     * @param numberOfSportEquipment is the number of sport equipment
     */
    public void setNumberOfSportEquipment(String numberOfSportEquipment) {
        numberOfSportEquipmentTextEdit.sendKeys(numberOfSportEquipment);
        logger.info(String.format("Number of sport equipment: %s", numberOfSportEquipment));
    }

    /**
     * Method allows to set the number of animals
     *
     * @param numberOfAnimals is the number of animals
     */
    public void setNumberOfAnimals(String numberOfAnimals) {
        numberofAnimalsTextEdit.sendKeys(numberOfAnimals);
        logger.info(String.format("Number of animals: %s", numberOfAnimals));
    }

    /**
     * Allows to swipe up to see more option
     */
    public void swipeToBottomOfThePage() {
        ScrollUtils.swipeUp();
    }

    /**
     * Method for click on button "Select a car"
     */
    public void clickStartBookingButton() {
        waitForVisibility(selectCarButton);
        selectCarButton.click();
    }

    /**
     * Method for click on button "Select a car"
     */
    public void ClickOnSkipFlightNumberButton() {
        skipFlightNumberButton.click();
    }

    /**
     * Check if there's a "Cannot find route between addresses provided" message
     *
     * @return true if message is displayed, false if there isn't
     */
    public boolean isMessageCannotFindRouteBtwnAddressesDisplayed() {
        logger.info("Message 'Cannot find route between addresses provided' is displayed");
        return messageCannotFindRouteBtwnAddresses.isDisplayed();
    }

    /**
     * Method for click on button "Menu"
     */
    public void clickMenuButton() {
        waitForVisibility(menuButton);
        menuButton.click();
        logger.info("Menu is opened.");
    }

    /**
     * Click on the 'Menu' button
     */
    public void openMenu() {
        waitForVisibility(menuButton);
        menuButton.click();
        logger.info("Menu is opened.");
    }

    /**
     * Check is 'Menu' button displayed on the page.
     *
     * @return true if 'Menu' button is displyed, false – if not.
     */
    public boolean isMenuButtonDisplayed() {
        waitForVisibility(menuButton);
        logger.info("'Menu' button is displayed.");
        return menuButton.isDisplayed();
    }

}