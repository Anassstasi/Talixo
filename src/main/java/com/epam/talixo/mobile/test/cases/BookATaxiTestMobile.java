package com.epam.talixo.mobile.test.cases;

import com.epam.talixo.framework.data.BookingDataStorage;
import com.epam.talixo.framework.data.entities.Order;
import com.epam.talixo.mobile.steps.BookingStepsMobile;
import com.epam.talixo.mobile.test.BaseTestMobile;
import com.epam.talixo.mobile.test.suites.RegressionTestMobile;
import com.epam.talixo.mobile.test.suites.SmokeTestMobile;
import com.epam.talixo.test.report.ReportManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BookATaxiTestMobile extends BaseTestMobile {

    private static final String WHERE_WHEN_DATA = "whereWhenMobile/normal.json";
    private static final String PAYMENT_DETAILS_DATA = "paymentDetails.json";
    private static String testName, testDescription;
    private String moreOptionData, whereWhenData;

    /**
     * [EPMFARMATS-3972]: Booking a taxi after logging in for 2 people with 2 bags for tomorrow
     */
    @Test
    @Category(RegressionTestMobile.class)
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTmrw() {
        testName = "EPMFARMATS-3972";
        testDescription = "Booking a taxi after logging in for 2 people with 2 bags for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForTomorrow(order);
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.proceedToPayment();
        bookingStepsMobile.chooseACard();
        bookingStepsMobile.setPaymentDetails(payment);
        bookingStepsMobile.finishBooking();
        bookingStepsMobile.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3992]: Booking a taxi after logging in for 2 people with 2 bags without entering any
     * payment details for tomorrow
     */
    @Test
    @Category(RegressionTestMobile.class)
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTmrwWithoutEnteringPaymentDetails() {
        testName = "EPMFARMATS-3992";
        testDescription = "Booking a taxi after logging in for 2 people with 2 bags without" +
                " entering any payment details for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForTomorrow(order);
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.proceedToPayment();
        bookingStepsMobile.chooseACard();
        bookingStepsMobile.finishBooking();
        bookingStepsMobile.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3973]: Booking a taxi after logging in for 8 adult people with 8 bags, 2 children,
     * 4 animals for tomorrow
     */
    @Test
    @Category(RegressionTestMobile.class)
    public void bookingATaxiAfterLoggingInFor8pplWith8Bags2Children4AnimalsForTmrw() {
        testName = "EPMFARMATS-3973";
        testDescription = "Booking a taxi after logging in for 8 adult people with 8 bags," +
                " 2 children,4 animals for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptionsMobile/8ppl_8bgs_4anml.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingStepsMobile.fillOptions(options);
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.isMessageNoCarsDisplayed();
    }

    /**
     * [EPMFARMATS-3978]: Booking a taxi after logging in for 2 adults with 2 children for tomorrow
     */
    @Test
    @Category(RegressionTestMobile.class)
    public void bookingATaxiAfterLoggingInFor2pplWith2ChildrenForTmrw() {
        testName = "EPMFARMATS-3978";
        testDescription = "Booking a taxi after logging in for 2 adults with 2 children for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptionsMobile/2ppl_2chld.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingStepsMobile.fillOptions(options);
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.proceedToPayment();
        bookingStepsMobile.chooseACard();
        bookingStepsMobile.setPaymentDetails(payment);
        bookingStepsMobile.finishBooking();
        bookingStepsMobile.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3979]: Booking a taxi after logging in for 2 adults with 3 equipments for tomorrow
     */
    @Test
    @Category(RegressionTestMobile.class)
    public void bookingATaxiAfterLoggingInFor2pplWith3SportEquipmentForTmrw() {
        testName = "EPMFARMATS-3979";
        testDescription = "Booking a taxi after logging in for 2 adults with 3 equipments for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptionsMobile/2ppl_3eqwp.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingStepsMobile.fillOptions(options);
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.isMessageNoCarsDisplayed();
    }

    /**
     * [EPMFARMATS-3977]: Booking a taxi after logging in for 1 person with an animal for tomorrow
     */
    @Test
    @Category(SmokeTestMobile.class)
    public void bookingATaxiAfterLoggingInFor1PersonWith1AnimalForTmrw() {
        testName = "EPMFARMATS-3977";
        testDescription = "Booking a taxi after logging in for 1 person with an animal for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptionsMobile/1ppl_1anml.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingStepsMobile.fillOptions(options);
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.isMessageNoCarsDisplayed();
    }

    /**
     * [EPMFARMATS-3994]: Booking a taxi after logging in for 2 adults with 2 bags for today for now
     */
    @Test
    @Category(SmokeTestMobile.class)
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTodayForNow() {
        testName = "EPMFARMATS-3994";
        testDescription = "Booking a taxi after logging in for 2 adults with 2 bags for today for now";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhenMobile/forNow.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForToday(order.getPickUpAddress(), order.getDestinationAddress());
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.isMessageNoCarsDisplayed();
    }

    /**
     * [EPMFARMATS-3997]: Booking a taxi after loging in for 2 adults with 2 bags for tomorrow
     * for the route between 2 different countries
     */
    @Test
    @Category(RegressionTestMobile.class)
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTomorrowWith2DifferentCountries() {
        testName = "EPMFARMATS-3997";
        testDescription = "Booking a taxi after loging in for 2 adults with 2 bags" +
                " for tomorrow for the route between 2 different countries";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhenMobile/differentCountries.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        BookingStepsMobile bookingStepsMobile = new BookingStepsMobile();
        bookingStepsMobile.startBookingForTomorrow(order);
        bookingStepsMobile.clickStartBooking();
        bookingStepsMobile.isMessageCannotFindRouteBtwnAddressesDisplayed();
    }

}