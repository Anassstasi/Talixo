package com.epam.talixo.test.report;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReportManager {
    private static final String DELIMITER = " ";
    private static final Logger logger = LogManager.getLogger();
    private static ThreadLocal<Reporter> threadLocalReporter = new ThreadLocal<>();

    public static Reporter getInstance() {
        return threadLocalReporter.get();
    }

    /**
     * Method allows to create a report instance for one test method
     *
     * @param testDescription is the description of the test
     * @param testName        is the name of the test
     */
    public static void createInstance(String testDescription, String testName) {
        logger.info(testName + DELIMITER + testDescription);
        threadLocalReporter.set(new Reporter(testDescription, testName));
    }

}