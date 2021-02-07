package com.epam.talixo.mobile.data;

import com.epam.talixo.framework.properties.PropertyReader;

import java.util.Map;

public class MobileStorage {

    private static final String APP_PROPERTIES = "mobile/mobileApp.properties";

    public static Map<String, String> getDataFromAndroidProperty() {
        return PropertyReader.getInstance().getProperties(APP_PROPERTIES);
    }

}