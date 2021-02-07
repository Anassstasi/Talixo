package com.epam.talixo.framework.cucumber.hook;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.framework.runner.config.BrowserConfig;
import com.epam.talixo.framework.runner.config.EnvironmentConfig;
import com.epam.talixo.framework.webdriver.DriverFactory;
import com.epam.talixo.framework.webdriver.DriverManager;
import com.epam.talixo.test.report.ExtentManager;
import com.epam.talixo.test.report.ReportManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CucumberHook {

    private static final String screenshotFormat = ".png";
    private static final String pathToCucumberScreenshots = "target/test-output/screenshots/cucumber/";
    private final Logger logger = LogManager.getLogger();
    private ExtentTest test;
    private String screenshotPath;
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
    private Status testStatus = Status.PASS;
    private String testStatusDetails = "Successfully passed";

    @Before
    public static void initBrowser() throws TypeIsUnsupportedException {
        DriverManager.setDriver(DriverFactory.getDriver(BrowserConfig.getType(), EnvironmentConfig.getType()));
    }

    @After
    public void stopBrowser(Scenario scenario) {
        ExtentManager.createParentCucumberTestInstance(scenario.getId());
        ReportManager.createInstance(scenario.getId(), scenario.getName());
        if (String.valueOf(scenario.getStatus()).equals("UNDEFINED")) {
            setStatusWarning();
        }
        if (scenario.isFailed()) {
            setStatusFail();
            try {
                String imagePath = pathToCucumberScreenshots + scenario.getName();
                TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                screenshotPath = imagePath + "/" + dateFormat.format(date) + screenshotFormat;
                FileUtils.copyFile(screenshot, new File(screenshotPath));
            } catch (IOException e) {
                logger.error("IOException appears when saving a screenshot ", e.getMessage());
            }
        }
        try {
            test = ExtentManager.getTestInstance().createNode(ReportManager.getInstance().getTestName());
            test.log(Status.INFO, ReportManager.getInstance().getDescription());
            test.log(Status.INFO, "Browser:" + BrowserConfig.getType() + "\nEnvironment:" + EnvironmentConfig.getType());
            test.log(testStatus, testStatusDetails);
            ExtentManager.getInstance().flush();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        DriverManager.quitDriver();
    }

    /**
     * Method sets test status as WARNING
     */
    private void setStatusWarning() {
        testStatus = Status.WARNING;
        testStatusDetails = "<ins style=\"color:#ff0000\",style=\"font-size:30px\">Something went wrong :(\n</ins>";
    }

    /**
     * Method sets test status as FAILED
     */
    private void setStatusFail() {
        testStatus = Status.FAIL;
        testStatusDetails = "Failed";
    }

}