package com.epam.talixo.framework.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Class for getting variables from property file
 */
public final class PropertyReader {

    private final Logger logger = LogManager.getLogger();
    private HashMap<String, Properties> propertiesHashMap = new HashMap<>();
    private String propValue;

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        return LazyHolder.propertyReader;
    }

    /**
     * Method allows to read data from property file
     *
     * @param fileName is the key of the data in the property file
     */
    private void readPropertyFile(String fileName) {
        if (!propertiesHashMap.containsKey(fileName)) {
            Properties prop = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                logger.debug("Cannot read the file");
                throw new UncheckedIOException(e);
            }
            propertiesHashMap.put(fileName, prop);
        }
    }

    /**
     * Method allows to get data from property file
     *
     * @param propKey is the key of the data in the property file
     * @return the data
     */
    public String getProperty(String fileName, String propKey) {
        readPropertyFile(fileName);
        return propertiesHashMap.get(fileName).getProperty(propKey);
    }

    /**
     * Method allows to get data from property file
     *
     * @param fileName is a name of the property file
     * @return the data
     */
    public Map<String, String> getProperties(String fileName) {
        readPropertyFile(fileName);
        return propertiesHashMap.get(fileName).entrySet().stream().collect(
                Collectors.toMap(
                        e -> String.valueOf(e.getKey()),
                        e -> String.valueOf(e.getValue())
                )
        );
    }

    private static class LazyHolder {
        static final PropertyReader propertyReader = new PropertyReader();
    }

}