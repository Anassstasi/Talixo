package com.epam.talixo.framework.data;

public enum Options {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    PREFIX_PHONE("prefixPhone"),
    PHONE_NUMBER("phoneNumber"),
    EMAIL("email"),
    PICK_UP_ADDRESS("pickUpAddress"),
    FLIGHT_NUMBER("flightNumber"),
    DEPARTURE_CITY("departureCity"),
    DESTINATION_ADDRESS("destinationAddress"),
    TIME("time"),
    CARD_NUMBER("cardNumber"),
    HOLDER_NAME("holderName"),
    MONTH("month"),
    YEAR("year"),
    CVC("cvc"),
    ADULTS("adults"),
    BAGS("bags"),
    SPORT_LUGGAGE("sportLuggage"),
    ANIMALS("animals"),
    CHILD3_6("child3_6yo"),
    CHILD6_12("child6_12yo");

    private final String option;

    Options(String s) {
        option = s;
    }

    public String getOption() {
        return this.option;
    }

}