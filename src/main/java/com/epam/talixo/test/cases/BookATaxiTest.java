package com.epam.talixo.test.cases;

import com.epam.jira.JIRATestKey;
import com.epam.jira.junit.TestRunner;
import com.epam.talixo.framework.data.BookingDataStorage;
import com.epam.talixo.framework.data.entities.Order;
import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.steps.BookingSteps;
import com.epam.talixo.steps.LoginSteps;
import com.epam.talixo.test.BaseTest;
import com.epam.talixo.test.report.ReportManager;
import com.epam.talixo.test.rules.ReportRule;
import com.epam.talixo.test.suites.RegressionTest;
import com.epam.talixo.test.suites.SmokeTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(TestRunner.class)
public class BookATaxiTest extends BaseTest {

    private static final String WHERE_WHEN_DATA = "whereWhen/normal.json";
    private static final String PAYMENT_DETAILS_DATA = "paymentDetails.json";
    @ClassRule
    public static ReportRule reportRule = new ReportRule("Book a taxi Test");
    private static String testName, testDescription;
    private String moreOptionData, whereWhenData;

    /**
     * [EPMFARMATS-3972]: Booking a taxi after logging in for 2 people with 2 bags for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3972")
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTmrw() {
        testName = "EPMFARMATS-3972";
        testDescription = "Booking a taxi after logging in for 2 people with 2 bags for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyCar();
        bookingSteps.setPaymentDetails(payment);
        bookingSteps.selectCheckBox();
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3991]: Booking a taxi after logging in for 2 people with 2 bags for tomorrow when
     * checkbox isn`t selected
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3991")
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTmrwWithoutSelectingCheckbox() {
        testName = "EPMFARMATS-3991";
        testDescription = "Booking a taxi after logging in for 2 people with 2 bags for " +
                "tomorrow when checkbox isn`t selected";
        ReportManager.createInstance(testDescription, testName);
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyCar();
        bookingSteps.setPaymentDetails(payment);
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3992]: Booking a taxi after logging in for 2 people with 2 bags without entering any
     * payment details for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3992")
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTmrwWithoutEnteringPaymentDetails() {
        testName = "EPMFARMATS-3992";
        testDescription = "Booking a taxi after logging in for 2 people with 2 bags without" +
                " entering any payment details for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyCar();
        bookingSteps.selectCheckBox();
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3973]: Booking a taxi after logging in for 8 adult people with 8 bags, 2 children,
     * 4 animals for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3973")
    public void bookingATaxiAfterLoggingInFor8pplWith8Bags2Children4AnimalsForTmrw() {
        testName = "EPMFARMATS-3973";
        testDescription = "Booking a taxi after logging in for 8 adult people with 8 bags," +
                " 2 children,4 animals for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptions/8ppl_8bgs_2chld_4anml.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingSteps.fillOptions(options);
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageNoCarsDisplayed();
    }

    /**
     * [EPMFARMATS-3974]: Booking a taxi after logging in for 4 adult people with 8 bags and 3 sport
     * equipment for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3974")
    public void bookingATaxiAfterLoggingInFor4pplWith8Bags3SportEquipmentForTmrw() {
        testName = "EPMFARMATS-3974";
        testDescription = "Booking a taxi after logging in for 4 adult people with 8 bags" +
                " and 3 sport equipment for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptions/4ppl_8bgs_3eqwp.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingSteps.fillOptions(options);
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageMaximumCapacityDisplayed();
    }

    /**
     * [EPMFARMATS-3996]: Booking a taxi after logging in for 2 adults with 2 bags for today but for the past
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3996")
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTodayForThePast() {
        testName = "EPMFARMATS-3996";
        testDescription = "Booking a taxi after logging in for 2 adults with 2 bags " +
                "for today but for the past";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhen/forThePast.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        LoginSteps loginSteps = new LoginSteps();
        BookingSteps bookingSteps = new BookingSteps();
        loginSteps.loginTalixo();
        bookingSteps.startBookingForToday(order.getPickUpAddress(), order.getFlightNumber(), order.getDepartureCity(),
                order.getDestinationAddress(), order.getTime());
        bookingSteps.isMessageBookingSixtyMinutesInFutureDisplayed();
    }

    /**
     * [EPMFARMATS-3997]: Booking a taxi after loging in for 2 adults with 2 bags for tomorrow
     * for the route between 2 different countries
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3997")
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTomorrowWith2DifferentCountries() {
        testName = "EPMFARMATS-3997";
        testDescription = "Booking a taxi after loging in for 2 adults with 2 bags" +
                " for tomorrow for the route between 2 different countries";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhen/differentCountries.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        LoginSteps loginSteps = new LoginSteps();
        BookingSteps bookingSteps = new BookingSteps();
        loginSteps.loginTalixo();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageCannotFindRouteBtwnAddressesDisplayed();
    }

    /**
     * [EPMFARMATS-3977]: Booking a taxi after logging in for 1 person with an animal for tomorrow
     */
    @Test
    @Category(SmokeTest.class)
    @JIRATestKey(key = "EPMFARMATS-3977")
    public void bookingATaxiAfterLoggingInFor1PersonWith1AnimalForTmrw() {
        testName = "EPMFARMATS-3977";
        testDescription = "Booking a taxi after logging in for 1 person with an animal for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptions/1ppl_1anml.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingSteps.fillOptions(options);
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageNoCarsDisplayed();
    }

    /**
     * [EPMFARMATS-3978]: Booking a taxi after logging in for 2 adults with 2 children for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3978")
    public void bookingATaxiAfterLoggingInFor2pplWith2ChildrenForTmrw() {
        testName = "EPMFARMATS-3978";
        testDescription = "Booking a taxi after logging in for 2 adults with 2 children for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptions/2ppl_2chld.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingSteps.fillOptions(options);
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyCar();
        bookingSteps.setPaymentDetails(payment);
        bookingSteps.selectCheckBox();
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3979]: Booking a taxi after logging in for 2 adults with 3 equipments for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3979")
    public void bookingATaxiAfterLoggingInFor2pplWith3SportEquipmentForTmrw() {
        testName = "EPMFARMATS-3979";
        testDescription = "Booking a taxi after logging in for 2 adults with 3 equipments for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptions/2ppl_3eqwp.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingSteps.fillOptions(options);
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageNoCarsDisplayed();
    }

    /**
     * [EPMFARMATS-3980]: Booking a taxi after logging in for 2 adults with 1 equipments for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3980")
    public void bookingATaxiAfterLoggingInFor2pplWith1SportEquipmentForTmrw() {
        testName = "EPMFARMATS-3980";
        testDescription = "Booking a taxi after logging in for 2 adults with 1 equipments for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        moreOptionData = "moreOptions/2ppl_1eqwp.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        Order options = BookingDataStorage.getOrderData(moreOptionData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingSteps.fillOptions(options);
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyVANCar();
        bookingSteps.setPaymentDetails(payment);
        bookingSteps.selectCheckBox();
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3993]: Booking a taxi after logging in for 2 people with 2 bags using expire card for tomorrow
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-3993")
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTmrwWithExpireCard() {
        testName = "EPMFARMATS-3993";
        testDescription = "Booking a taxi after logging in for 2 people with 2 bags using" +
                " expire card for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        String paymentData = "invalidPaymentDetails.json";
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(paymentData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyCar();
        bookingSteps.setPaymentDetails(payment);
        bookingSteps.selectCheckBox();
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-3998]: Per-hour booking a taxi after logging in for 2 adults with 2 bags from one country
     * to another
     */
    @Test
    @Category(SmokeTest.class)
    @JIRATestKey(key = "EPMFARMATS-3998")
    public void perhourBookingATaxiAfterLoggingInFor2pplWith2BagsForTmrwFromOneCountryToAnother() {
        testName = "EPMFARMATS-3998";
        testDescription = "Per-hour booking a taxi after logging in for 2 adults" +
                " with 2 bags from one country to another";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhen/differentCountries.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.selectPerhourBooking();
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageLongerThan7hDisplayed();
    }

    /**
     * [EPMFARMATS-4004]: Per-hour booking a taxi after logging in for 2 adults with 2 bags for the
     * distance less than 25km
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-4004")
    public void perhourBookingATaxiAfterLoggingInFor2pplWith2BagsForTmrwForTheDistanceLessThan25km() {
        testName = "EPMFARMATS-4004";
        testDescription = "Per-hour booking a taxi after logging in for 2 adults with 2 bags " +
                "for the distance less than 25km";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhen/lessThan25km.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.selectPerhourBooking();
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyCar();
        bookingSteps.setPaymentDetails(payment);
        bookingSteps.selectCheckBox();
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

    /**
     * [EPMFARMATS-4003]: Per-hour booking a taxi after logging in for 2 adults with 2 bags for the
     * distance more than 25km
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-4003")
    public void perhourBookingATaxiAfterLoggingInFor2pplWith2BagsForTmrwForTheDistanceMoreThan25km() {
        testName = "EPMFARMATS-4003";
        testDescription = "Per-hour booking a taxi after logging in for 2 adults with 2 bags " +
                "for the distance more than 25km";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhen/moreThan25km.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loginTalixo();
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.selectPerhourBooking();
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageMaximumDistanceDisplayed();
    }

    /**
     * [EPMFARMATS-3994]: Booking a taxi after logging in for 2 adults with 2 bags for today for now
     */
    @Test
    @Category(SmokeTest.class)
    @JIRATestKey(key = "EPMFARMATS-3994")
    public void bookingATaxiAfterLoggingInFor2pplWith2BagsForTodayForNow() {
        testName = "EPMFARMATS-3994";
        testDescription = "Booking a taxi after logging in for 2 adults with 2 bags for today for now";
        ReportManager.createInstance(testDescription, testName);
        whereWhenData = "whereWhen/forNow.json";
        Order order = BookingDataStorage.getOrderData(whereWhenData);
        LoginSteps loginSteps = new LoginSteps();
        BookingSteps bookingSteps = new BookingSteps();
        loginSteps.loginTalixo();
        bookingSteps.startBookingForToday(order.getPickUpAddress(), order.getDestinationAddress(), order.getTime());
        bookingSteps.clickStartBooking();
        bookingSteps.isMessageNoAvailableCarsDisplayed();
    }

    /**
     * [EPMFARMATS-4005]: Booking a taxi without logging in for 2 adults with 2 bags for tomorrow
     */
    @Test
    @Category(SmokeTest.class)
    @JIRATestKey(key = "EPMFARMATS-4005")
    public void bookingATaxiWithoutLoggingInFor2pplWith2BagsForTmrw() {
        testName = "EPMFARMATS-4005";
        testDescription = "Booking a taxi without logging in for 2 adults with 2 bags for tomorrow";
        ReportManager.createInstance(testDescription, testName);
        String userData = "/testData/bookingData/userData.json";
        User user = JsonUtils.readJsonSingleObject(userData, User.class);
        Order order = BookingDataStorage.getOrderData(WHERE_WHEN_DATA);
        Order payment = BookingDataStorage.getOrderData(PAYMENT_DETAILS_DATA);
        BookingSteps bookingSteps = new BookingSteps();
        bookingSteps.openHomePage();
        bookingSteps.startBookingForTomorrow(order);
        bookingSteps.closeInfoBox();
        bookingSteps.clickStartBooking();
        bookingSteps.chooseEconomyCar();
        bookingSteps.setPersonalInformation(user.getFirstName(), user.getLastName(), user.getPrefixPhone(),
                user.getPhoneNumber(), user.getEmail());
        bookingSteps.selectCheckboxNewCustomer();
        bookingSteps.setPaymentDetails(payment);
        bookingSteps.selectCheckBox();
        bookingSteps.selectCheckboxAcceptDPD();
        bookingSteps.selectCheckboxAcceptGTC();
        bookingSteps.finishBooking();
        bookingSteps.isMessageInvalidCardNumberDisplayed();
    }

}