package com.epam.talixo.framework.data.entities;

public class Order {

    private String cardNumber;
    private String holderName;
    private String month;
    private String year;
    private String cvc;
    private String numAdults;
    private String numBags;
    private String numSportLuggage;
    private String numAnimals;
    private String numChild3_6yo;
    private String numChild6_12yo;
    private String pickUpAddress;
    private String destinationAddress;
    private String time;
    private String flightNumber;
    private String departureCity;

    public Order(String cardNumber, String holderName, String month, String year, String cvc, String numAdults, String numBags,
                 String numAnimals, String numSportLuggage, String numChild3_6yo, String numChild6_12yo, String pickUpAddress,
                 String destinationAddress, String time, String flightNumber, String departureCity) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.month = month;
        this.year = year;
        this.cvc = cvc;
        this.numAdults = numAdults;
        this.numBags = numBags;
        this.numAnimals = numAnimals;
        this.numSportLuggage = numSportLuggage;
        this.numChild3_6yo = numChild3_6yo;
        this.numChild6_12yo = numChild6_12yo;
        this.pickUpAddress = pickUpAddress;
        this.destinationAddress = destinationAddress;
        this.time = time;
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getNumAdults() {
        return numAdults;
    }

    public void setNumAdults(String numAdults) {
        this.numAdults = numAdults;
    }

    public String getNumBags() {
        return numBags;
    }

    public void setNumBags(String numBags) {
        this.numBags = numBags;
    }

    public String getNumAnimals() {
        return numAnimals;
    }

    public void setNumAnimals(String numAnimals) {
        this.numAnimals = numAnimals;
    }

    public String getNumSportLuggage() {
        return numSportLuggage;
    }

    public void setNumSportLuggage(String numSportLuggage) {
        this.numSportLuggage = numSportLuggage;
    }

    public String getNumChild3_6yo() {
        return numChild3_6yo;
    }

    public void setNumChild3_6yo(String numChild3_6yo) {
        this.numChild3_6yo = numChild3_6yo;
    }

    public String getNumChild6_12yo() {
        return numChild6_12yo;
    }

    public void setNumChild6_12yo(String numChild6_12yo) {
        this.numChild6_12yo = numChild6_12yo;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

}