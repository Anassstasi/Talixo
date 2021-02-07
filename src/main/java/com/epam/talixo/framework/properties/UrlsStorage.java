package com.epam.talixo.framework.properties;

public class UrlsStorage {

    private static final String PROP_URL_REGISTRATION_PAGE = "BASE_URL_REGISTRATION_PAGE";
    private static final String PROP_URL_LOGIN_PAGE = "BASE_URL_LOGIN_PAGE";
    private static final String HUB_ADDRESS = "HUB_ADDRESS";
    private static final String ANDROID_HUB_ADDRESS = "ANDROID_HUB_ADDRESS";
    private static final String FILE_NAME = "config.properties";

    /**
     * Method allows to get the URL of registration page
     *
     * @return is the URL of registration page
     */
    public static String getRegistrationPageUrl() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, PROP_URL_REGISTRATION_PAGE);
    }

    /**
     * Method allows to get the URL of login page
     *
     * @return is  the URL of login page
     */
    public static String getLoginPageUrl() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, PROP_URL_LOGIN_PAGE);
    }

    /**
     * Method allows to get the address of the hub
     *
     * @return is the URL of registration page
     */
    public static String getHubAddress() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, HUB_ADDRESS);
    }

    /**
     * Method allows to get the address of the android hub
     *
     * @return is the URL of registration page
     */
    public static String getAndroidHubAddress() {
        return PropertyReader.getInstance().getProperty(FILE_NAME, ANDROID_HUB_ADDRESS);
    }

}