package com.epam.talixo.framework.data;

import com.epam.talixo.framework.data.entities.Order;
import com.epam.talixo.framework.utils.JsonUtils;

public class BookingDataStorage {

    private static final String BOOKING_DATA_DIR = "/testData/bookingData/";
    private static final String BOOKING_DATA_MOBILE_DIR = "/testData/bookingDataMobile/";

    /**
     * This method return order data from JSON file.
     *
     * @param fileName the name of the file from which the data is to be returned
     * @return an Order object
     */
    public static Order getOrderData(String fileName) {
        return JsonUtils.readJsonSingleObject(BOOKING_DATA_DIR + fileName, Order.class);
    }

    /**
     * This method return order data from JSON file.
     *
     * @param fileName the name of the file from which the data is to be returned
     * @return an Order object
     */
    public static Order getOrderDataMobile(String fileName) {
        return JsonUtils.readJsonSingleObject(BOOKING_DATA_MOBILE_DIR + fileName, Order.class);
    }

}