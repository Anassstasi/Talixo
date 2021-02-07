package com.epam.talixo.framework.utils;

import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;

import java.util.Arrays;
import java.util.Random;

/**
 * This class allows to generate words, numbers, countries to edit account contact details, etc.
 */
public class RandomUtils {

    /**
     * Field that we need to generate random words or numbers
     */
    private static final Random RANDOM = new Random();

    /**
     * This method allows to pick random country from the ENUM
     *
     * @return random country
     */
    public static String getRandomCountry() {
        return Countries.values()[(RANDOM.nextInt(Countries.values().length))].countryName;
    }

    /**
     * Special data type that enables for a variable to be a set of predefined constants
     */
    public enum Countries {
        ALBANIA("Albania", "698726688"),
        BELARUS("Belarus", "296633566"),
        GERMANY("Germany", "15224730470"),
        DENMARK("Denmark", "601234567"),
        ESTONIA("Estonia", "5054401"),
        FRANCE("France", "755881784"),
        IRAN("Iran", "9111234567"),
        JAPAN("Japan", "756062121"),
        KENYA("Kenya", "711123456"),
        NIGERIA("Nigeria", "8112458683"),
        PERU("Peru", "942123456"),
        RUSSIA("Russia", "9259249124"),
        SERBIA("Serbia", "111234567"),
        YEMEN("Yemen", "1312345"),
        ZIMBABWE("Zimbabwe", "1312345"),
        NEPAL("Nepal", "14412345");

        private String countryName;
        private String mobileNumber;

        /**
         * Constructor that initialize instance fields
         *
         * @param countryName  is a country from the list
         * @param mobileNumber is a number from the list
         */
        Countries(String countryName, String mobileNumber) {
            this.countryName = countryName;
            this.mobileNumber = mobileNumber;
        }

        /**
         * Returns number depending on country received
         *
         * @param country is a country you enter
         * @return number from the ENUM if country is in the list
         * @throws TypeIsUnsupportedException that prevents using of unsupported types
         */
        public static String getMobilePhoneByCountryName(String country) throws TypeIsUnsupportedException {
            return Arrays.stream(Countries.values())
                    .filter(e -> e.countryName.equals(country))
                    .findAny()
                    .orElseThrow(() -> new TypeIsUnsupportedException(String.format("Unsupported type %s", country)))
                    .mobileNumber;
        }

        /**
         * Method that returns country name
         *
         * @return country name of the current country
         */
        public String getCountryName() {
            return countryName;
        }

        /**
         * Method that returns mobile number
         *
         * @return mobile number of the current country
         */
        public String getMobileNumber() {
            return mobileNumber;
        }
    }

}