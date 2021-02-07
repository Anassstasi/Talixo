package com.epam.talixo.test.rules;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.framework.runner.config.BrowserConfig;
import com.epam.talixo.framework.runner.config.EnvironmentConfig;
import com.epam.talixo.framework.webdriver.DriverFactory;
import com.epam.talixo.framework.webdriver.DriverManager;
import com.epam.talixo.test.report.ExtentManager;
import com.epam.talixo.test.report.ReportManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class allows to initialize driver, close driver and take screenshots on failures
 */
public class CustomTestRule implements TestRule {

    private static final String screenshotFormat = ".png";
    private static final String pathToJUnitScreenshots = "target\\test-output\\screenshots\\junit\\";
    /**
     * This field allows to log errors
     */
    private final Logger logger = LogManager.getRootLogger();
    private ExtentTest test;
    private Status testStatus = Status.PASS;
    private String testStatusDetails = "Successfully passed";
    private String screenshotPath;
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");

    /**
     * Method allows to get test status(failed or passed)
     *
     * @return Status.PASS if the test is green and Status.FAILED if the test is red
     */
    public Status getStatus() {
        return testStatus;
    }

    public Statement apply(Statement statement, Description description) {
        return new ExpansiveExternalResourceStatement(statement);
    }

    /**
     * This method takes screenshot if an error occurs
     *
     * @param fileName is the screenshot name
     */
    private void captureScreenshot(String fileName) {
        String imagePath = pathToJUnitScreenshots + fileName;
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        screenshotPath = imagePath + "\\" + dateFormat.format(date) + screenshotFormat;
        try {
            FileUtils.copyFile(screenshot, new File(screenshotPath));
        } catch (IOException e) {
            logger.info("IOException appears when saving a screenshot");
        }
    }

    /**
     * This class is responsible for the initialization and closure of the driver
     */
    public class ExpansiveExternalResourceStatement extends Statement {
        private Statement baseStatement;

        private ExpansiveExternalResourceStatement(Statement b) {
            baseStatement = b;
        }

        /**
         * This is the call of after and before methods
         */
        @Override
        public void evaluate() throws Throwable {
            try {
                before();
                baseStatement.evaluate();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                setStatusWarning(e);
                throw e;
            } catch (Error e) {
                setStatusFail();
                captureScreenshot(ReportManager.getInstance().getTestName());
                throw e;
            } finally {
                after();
            }
        }

        private void setStatusWarning(Exception e) {
            testStatus = Status.WARNING;
            testStatusDetails = "<ins style=\"color:#ff0000\",style=\"font-size:30px\">Something went wrong :\n</ins>"
                    + e.getMessage();
        }

        private void setStatusFail() {
            testStatus = Status.FAIL;
            testStatusDetails = "Failed";
        }

        /**
         * This method closes the driver
         */
        private void after() {
            try {
                test = ExtentManager.getTestInstance().createNode(ReportManager.getInstance().getTestName());
                test.log(Status.INFO, ReportManager.getInstance().getDescription());
                test.log(Status.INFO, "Browser:" + BrowserConfig.getType() + "\nEnvironment:" + EnvironmentConfig.getType());
                test.log(testStatus, testStatusDetails);
                ExtentManager.getInstance().flush();
            } catch (Exception e) {
                logger.error("Problems with creating the report");
                logger.error(e.getMessage(), e);
            }
            DriverManager.quitDriver();
        }

        /**
         * This method initialize driver, you can choose browser type and enviroment type here
         *
         * @throws TypeIsUnsupportedException if type is unsupported
         */
        private void before() throws TypeIsUnsupportedException {
            DriverManager.setDriver(DriverFactory.getDriver(BrowserConfig.getType(),
                    EnvironmentConfig.getType()));
        }
    }

}