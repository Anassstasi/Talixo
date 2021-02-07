package com.epam.talixo.mobile.data;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MobileFarmDevice {

    private static final String API_KEY = "caa4f287-5246-4f65-8109-a51c1351b1d3";
    private static final String API_BASE = "http://mobilefarm.minsk.epam.com:7100/automation/api";
    private static final String INSTALL_APP_POST = API_BASE + "/storage/install/";
    private static final String FIND_DEVICE_POST = API_BASE + "/device";
    private static final String APK_PATH = "./src/main/resources/mobile/talixo.apk";
    private static final String BODY_JSON = "./src/main/resources/mobile/farmDevice.json";
    private static final String PLATFORM_NAME_JSON_PATH = "desiredCapabilities.platformName";
    private static final String PLATFORM_VERSION_JSON_PATH = "desiredCapabilities.platformVersion";
    private static final String DEVICE_NAME_JSON_PATH = "desiredCapabilities.deviceName";
    private static final String UDID_JSON_PATH = "desiredCapabilities.udid";

    private static final Logger logger = LogManager.getLogger();

    private String udid;
    private String platformName;
    private String platformVersion;
    private String deviceName;

    public MobileFarmDevice() {
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        return "MobileFarmDevice{" +
                "udid='" + udid + '\'' +
                ", platformName='" + platformName + '\'' +
                ", platformVersion='" + platformVersion + '\'' +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }

    /**
     * Find available device on the farm and get device data (capabilities)
     */
    public void findAvailableDevice() {
        File jsonBodyFile = new File(BODY_JSON);
        RequestSpecification requestFind = RestAssured.given()
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .body(jsonBodyFile);
        Response responseFindDevice = requestFind.post(FIND_DEVICE_POST);

        udid = responseFindDevice.jsonPath().getString(UDID_JSON_PATH);
        platformName = responseFindDevice.jsonPath().getString(PLATFORM_NAME_JSON_PATH);
        platformVersion = responseFindDevice.jsonPath().getString(PLATFORM_VERSION_JSON_PATH);
        deviceName = responseFindDevice.jsonPath().getString(DEVICE_NAME_JSON_PATH);
        logger.info("platformName: " + platformName);
        logger.info("platformVersion: " + platformVersion);
        logger.info("deviceName: " + deviceName);
        logger.info("udid: " + udid);
    }

    /**
     * Install app using API. App installing on the device with udid, that specified in capabilities in the DriverFactoryMobile.
     */
    public void installApp() {
        File file = new File(APK_PATH);
        RequestSpecification request = RestAssured.given().header("Authorization", "Bearer " + API_KEY).multiPart("file", file.getAbsoluteFile());
        Response responseInstallApp = request.post(INSTALL_APP_POST + udid);
        logger.info("'Install App' status code: " + responseInstallApp.getStatusCode());
    }

}
