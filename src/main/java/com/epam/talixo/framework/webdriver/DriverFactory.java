package com.epam.talixo.framework.webdriver;

import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.framework.properties.UrlsStorage;
import com.epam.talixo.framework.runner.config.EnvironmentConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger();
    private static final String GECKODRIVER_EXE_PATH = ".\\src\\main\\resources\\webdrivers\\geckodriver\\geckodriver.exe";
    private static final String CHROMEDRIVER_EXE_PATH = ".\\src\\main\\resources\\webdrivers\\chromedriver\\chromedriver.exe";
    private static final String MICROSOFTWEBDRIVER_EXE_PATH = ".\\src\\main\\resources\\webdrivers\\microsoftwebdriver\\MicrosoftWebDriver.exe";
    private static final String IEDRIVERSERVER_EXE_PATH = ".\\src\\main\\resources\\webdrivers\\iedriverserver\\IEDriverServer.exe";
    private static final String OPERADRIVER_EXE_PATH = ".\\src\\main\\resources\\webdrivers\\operadriver\\operadriver.exe";
    private static final String CHROME_EXE_PATH = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

    public static WebDriver getDriver(BrowserType type, EnvironmentConfig.EnvironmentType environment) throws TypeIsUnsupportedException {
        WebDriver driver = null;
        switch (environment) {
            case GRID:
                driver = getGridDriver(type);
                break;
            case LOCAL:
                driver = getLocalDriver(type);
                break;
        }
        logger.info(environment + " environment is chosen.");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        logger.info(type + " browser started!");
        return driver;
    }

    private static WebDriver getLocalDriver(BrowserType type) {
        WebDriver driver = null;
        switch (type) {
            case FIREFOX:
                driver = getGeckoDriver();
                break;
            case CHROME:
                driver = getChromeDriver();
                break;
            case EDGE:
                driver = getEdgeDriver();
                break;
            case IE:
                driver = getIeDriver();
                break;
            case OPERA:
                driver = getOperaDriver();
                break;
        }
        return driver;
    }

    private static WebDriver getGridDriver(BrowserType type) throws TypeIsUnsupportedException {
        WebDriver driver;
        switch (type) {
            case FIREFOX:
                driver = getRemoteGeckoDriver();
                break;
            case CHROME:
                driver = getRemoteChromeDriver();
                break;
            case EDGE:
                driver = getRemoteEdgeDriver();
                break;
            case IE:
                driver = getRemoteIeDriver();
                break;
            case OPERA:
                driver = getRemoteOperaDriver();
                break;
            default:
                logger.error("Set correct browser (firefox, chrome, edge, ie), please");
                throw new TypeIsUnsupportedException("Not correct browser name");
        }
        return driver;
    }

    private static RemoteWebDriver getRemoteGeckoDriver() {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, GECKODRIVER_EXE_PATH);
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        RemoteWebDriver remoteWebDriver;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(UrlsStorage.getHubAddress()), options);
        } catch (MalformedURLException m) {
            logger.error("Remote geckodriver isn`t created");
            throw new RuntimeException(m);
        }
        return remoteWebDriver;
    }

    private static RemoteWebDriver getRemoteChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver remoteWebDriver;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(UrlsStorage.getHubAddress()), options);
        } catch (MalformedURLException m) {
            logger.error("Remote chromedriver isn`t created");
            throw new RuntimeException(m);
        }
        return remoteWebDriver;
    }

    private static RemoteWebDriver getRemoteEdgeDriver() {
        System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, MICROSOFTWEBDRIVER_EXE_PATH);
        EdgeOptions options = new EdgeOptions();
        RemoteWebDriver remoteWebDriver;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(UrlsStorage.getHubAddress()), options);
        } catch (MalformedURLException m) {
            logger.error("Remote edgedriver isn`t created");
            throw new RuntimeException(m);
        }
        return remoteWebDriver;
    }

    private static RemoteWebDriver getRemoteIeDriver() {
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, IEDRIVERSERVER_EXE_PATH);
        InternetExplorerOptions options = new InternetExplorerOptions();
        RemoteWebDriver remoteWebDriver;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(UrlsStorage.getHubAddress()), options);
        } catch (MalformedURLException m) {
            logger.error("Remote iedriver isn`t created");
            throw new RuntimeException(m);
        }
        return remoteWebDriver;
    }

    private static RemoteWebDriver getRemoteOperaDriver() {
        System.setProperty(OperaDriverService.OPERA_DRIVER_EXE_PROPERTY, OPERADRIVER_EXE_PATH);
        OperaOptions options = new OperaOptions();
        options.setBinary(new File(CHROME_EXE_PATH));
        RemoteWebDriver remoteWebDriver;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(UrlsStorage.getHubAddress()), options);
        } catch (MalformedURLException m) {
            logger.error("Remote operadriver isn`t created");
            throw new RuntimeException(m);
        }
        return remoteWebDriver;
    }

    private static FirefoxDriver getGeckoDriver() {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, GECKODRIVER_EXE_PATH);
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        return new FirefoxDriver();
    }

    private static ChromeDriver getChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
        return new ChromeDriver();
    }

    private static EdgeDriver getEdgeDriver() {
        System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, MICROSOFTWEBDRIVER_EXE_PATH);
        return new EdgeDriver();
    }

    private static InternetExplorerDriver getIeDriver() {
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, IEDRIVERSERVER_EXE_PATH);
        return new InternetExplorerDriver();
    }

    private static OperaDriver getOperaDriver() {
        System.setProperty(OperaDriverService.OPERA_DRIVER_EXE_PROPERTY, OPERADRIVER_EXE_PATH);
        OperaOptions options = new OperaOptions();
        options.setBinary(new File(CHROME_EXE_PATH));
        return new OperaDriver(options);
    }

    public enum BrowserType {FIREFOX, CHROME, EDGE, IE, OPERA}
}