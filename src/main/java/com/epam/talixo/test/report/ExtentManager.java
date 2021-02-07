package com.epam.talixo.test.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class ExtentManager {
    private final static String PATH = "target\\test-output\\";
    private final static Logger LOGGER = LogManager.getRootLogger();
    private static ExtentReports extent;
    private static ExtentTest parenTest;
    private static ExtentTest nodeTest;
    private static int numberOfSymbolsOfThePathToFeature = 28;
    private static String testName = "src/main/resources/features/Default.feature:65";

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance("report");
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        try {
            FileUtils.forceMkdir(new File(PATH));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(PATH + fileName + ".html");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

    public static ExtentTest getTestInstance() {
        if (parenTest == null)
            createParentTestInstance("Default name");
        return parenTest;
    }

    /**
     * Method creates the parent instance (according to the class in which test methods are being run)
     *
     * @return the parent instance
     */
    public static ExtentTest createParentTestInstance(String name) {
        parenTest = ExtentManager.getInstance().createTest(name);
        return parenTest;
    }

    /**
     * Method creates the parent instance (according to the class in which test methods are being run)
     *
     * @return the parent instance
     */
    public static ExtentTest createParentCucumberTestInstance(String name) {
        if (!checkStrings(testName, name)) {
            parenTest = ExtentManager.getInstance().createTest(name.substring(numberOfSymbolsOfThePathToFeature, name.indexOf(":")));
            testName = name;
        } else {
            LOGGER.info("Current feature isn`t switched.");
            return parenTest;
        }
        return parenTest;
    }

    /**
     * Method compares the previous test class name to the current one
     *
     * @param previousName is the previous test class name
     * @param currentName  is the current test class name
     * @return true if they are equal and false if not
     */
    private static boolean checkStrings(String previousName, String currentName) {
        if (previousName.contains("/")) {
            previousName = previousName.substring(numberOfSymbolsOfThePathToFeature, previousName.indexOf(":"));
        }
        if (currentName.contains("/")) {
            currentName = currentName.substring(numberOfSymbolsOfThePathToFeature, currentName.indexOf(":"));
        }
        return previousName.equals(currentName);
    }

    public static ExtentTest getNodeTestInstance() {
        if (nodeTest == null)
            createNodeTestInstance("Default name");
        return nodeTest;
    }

    /**
     * Method creates the node instance (according to the test method which is being run)
     *
     * @return node instance
     */
    public static ExtentTest createNodeTestInstance(String name) {
        parenTest = ExtentManager.getTestInstance().createNode(name);
        return parenTest;
    }

}