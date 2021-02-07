package com.epam.talixo.test.cases;

import com.epam.jira.JIRATestKey;
import com.epam.jira.junit.TestRunner;
import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.framework.utils.RandomUtils;
import com.epam.talixo.steps.LoginSteps;
import com.epam.talixo.steps.SettingsSteps;
import com.epam.talixo.test.BaseTest;
import com.epam.talixo.test.report.ReportManager;
import com.epam.talixo.test.rules.ReportRule;
import com.epam.talixo.test.suites.RegressionTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;


@Category(RegressionTest.class)
@RunWith(TestRunner.class)
public class EditingAnAccountTest extends BaseTest {

    private static final String NEW_VALID_DATA_FILE = "/testData/editingAccountData/newValid.json";
    private static final String INVALID_DATA_FILE = "/testData/editingAccountData/invalid.json";
    private static final String LOGIN_DATA = "/testData/loginData/valid.json";
    @ClassRule
    public static ReportRule reportRule = new ReportRule("Edit an account Test");
    private static String testName, testDescription;
    private String randomString = RandomStringUtils.randomAlphabetic(8);
    private String randomNumber = RandomStringUtils.randomNumeric(6);
    private String randomCountryName = RandomUtils.getRandomCountry();

    /**
     * [EPMFARMATS-3919]: Edit contact details (first name)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-3919")
    public void oneCanEditFirstName() {
        testName = "EPMFARMATS-3919";
        testDescription = "Edit contact details (first name)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeFirstName();
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-3920]: Edit password
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-3920")
    public void oneCanPositiveEditPassword() {
        testName = "EPMFARMATS-3920";
        testDescription = "Edit password";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changePassword(user.getPassword(), newUser.getPassword(), newUser.getPassword());
        settingsSteps.isPasswordChangedSuccessfully(user.getEmail(), newUser.getPassword());
        settingsSteps.changePassword(newUser.getPassword(), user.getPassword(), user.getPassword());
    }

    /**
     * [EPMFARMATS-3921]: Add favourite addresses
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-3921")
    public void oneCanAddFavouriteAddress() {
        testName = "EPMFARMATS-3921";
        testDescription = "Add favourite addresses";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.addAddress(newUser.getAddress());
        settingsSteps.isFavouriteAddressReallyDisplayed(newUser.getAddress());
    }

    /**
     * [EPMFARMATS-3922]: Search address in Favourite addresses
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-3922")
    public void oneCanFindFavouriteAddress() {
        testName = "EPMFARMATS-3922";
        testDescription = "Search address in Favourite address";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.addAddress(newUser.getAddress());
        settingsSteps.searchAddress(newUser.getAddress());
        settingsSteps.isFavouriteAddressReallyDisplayed(newUser.getAddress());
    }

    /**
     * [EPMFARMATS-4020]: Edit contact details (last name)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4020")
    public void oneCanEditLastName() {
        testName = "EPMFARMATS-4020";
        testDescription = "Edit contact details (last name)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeLastName(randomString);
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-4021]: Edit contact details (E-mail)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4021")
    public void oneCanEditEmail() {
        testName = "EPMFARMATS-4021";
        testDescription = "Edit contact details (E-mail)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeEmail(randomString + "@example.com");
        settingsSteps.areTheChangesSuccessfullySaved();
        settingsSteps.changeEmail(user.getEmail());
    }

    /**
     * [EPMFARMATS-4022]: Edit contact details (company name)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4022")
    public void oneCanEditCompanyName() {
        testName = "EPMFARMATS-4022";
        testDescription = "Edit contact details (company name)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeCompanyName(randomString);
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-4023]: Edit contact details (STREET)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4023")
    public void oneCanEditStreet() {
        testName = "EPMFARMATS-4023";
        testDescription = "Edit contact details (STREET)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeStreet(randomString);
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-4024]: Edit contact details (TOWN)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4024")
    public void oneCanEditTown() {
        testName = "EPMFARMATS-4024";
        testDescription = "Edit contact details (TOWN)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeTown(randomString);
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-4025]: Edit contact details (zip code)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4025")
    public void oneCanEditZipCode() {
        testName = "EPMFARMATS-4025";
        testDescription = "Edit contact details (zip code)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeZipCode(randomNumber);
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-4026]: Edit contact details (COUNTRY)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4026")
    public void oneCanEditCountry() {
        testName = "EPMFARMATS-4026";
        testDescription = "Edit contact details (COUNTRY)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeCountry(randomCountryName);
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-4027]: Edit contact details (mobile number)
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4027")
    public void oneCanEditMobileNumber() {
        testName = "EPMFARMATS-4027";
        testDescription = "Edit contact details (mobile number)";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changeMobileNumber(randomCountryName);
        settingsSteps.areTheChangesSuccessfullySaved();
    }

    /**
     * [EPMFARMATS-4037]: Edit password with false old password
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4037")
    public void oneCanNotEditPasswordWithFalseOldPassword() {
        testName = "EPMFARMATS-4037";
        testDescription = "Edit password with false old password";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changePasswordWithoutClickOnSaveButton(
                invalidUser.getPassword(), newUser.getPassword(), newUser.getPassword());
        settingsSteps.isThereNoChangedPasswordWithFalseOldPassword();
    }

    /**
     * [EPMFARMATS-4038]: Edit password with not match new password
     */
    @Test
    @JIRATestKey(key = "EPMFARMATS-4038")
    public void oneCanNotEditPasswordWithNotMatchNewPassword() {
        testName = "Edit password with not match new password";
        testDescription = "EPMFARMATS-4038";
        ReportManager.createInstance(testDescription, testName);
        SettingsSteps settingsSteps = new SettingsSteps();
        LoginSteps loginSteps = new LoginSteps();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        settingsSteps.clickOnLinkMySettings();
        settingsSteps.changePasswordWithoutClickOnSaveButton(
                user.getPassword(), newUser.getPassword(), invalidUser.getPassword());
        settingsSteps.isThereNoChangedPasswordWithNotMatchNewPassword();
    }

}