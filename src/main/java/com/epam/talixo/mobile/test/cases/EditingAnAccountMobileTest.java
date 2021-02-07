package com.epam.talixo.mobile.test.cases;

import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.mobile.steps.SettingsMobileSteps;
import com.epam.talixo.mobile.test.BaseTestMobile;
import com.epam.talixo.mobile.test.suites.RegressionTestMobile;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(RegressionTestMobile.class)
public class EditingAnAccountMobileTest extends BaseTestMobile {

    private static final String NEW_VALID_DATA_FILE = "/testData/editingAccountData/newValid.json";
    private static final String INVALID_DATA_FILE = "/testData/editingAccountData/invalid.json";
    private static final String LOGIN_DATA = "/testData/loginData/valid.json";
    private String randomString = RandomStringUtils.randomAlphabetic(8);
    private String randomNumber = RandomStringUtils.randomNumeric(7);

    /**
     * [EPMFARMATS-3919]: Edit contact details (first name)
     */
    @Test
    public void oneCanEditFirstName() {
        SettingsMobileSteps settingsMobileSteps = new SettingsMobileSteps();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        settingsMobileSteps.changeFirstName(randomString);
        settingsMobileSteps.clickSaveChangesButton();
        settingsMobileSteps.isChanged();
    }

    /**
     * [EPMFARMATS-3920]: Edit password
     */
    @Test
    public void oneCanPositiveEditPassword() {
        SettingsMobileSteps settingsMobileSteps = new SettingsMobileSteps();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        settingsMobileSteps.clickChangePasswordButton();
        settingsMobileSteps.changePassword(user.getPassword(), newUser.getPassword(), newUser.getPassword());
        settingsMobileSteps.clickSavePasswordButton();
        settingsMobileSteps.isPasswordChanged();
        settingsMobileSteps.clickExitSettings();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        settingsMobileSteps.clickChangePasswordButton();
        settingsMobileSteps.changePassword(newUser.getPassword(), user.getPassword(), user.getPassword());
        settingsMobileSteps.clickSavePasswordButton();
        settingsMobileSteps.isPasswordChanged();
    }

    /**
     * [EPMFARMATS-4020]: Edit contact details (last name)
     */
    @Test
    public void oneCanEditLastName() {
        SettingsMobileSteps settingsMobileSteps = new SettingsMobileSteps();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        settingsMobileSteps.changeLastName(randomString);
        settingsMobileSteps.clickSaveChangesButton();
        settingsMobileSteps.isChanged();
    }

    /**
     * [EPMFARMATS-4021]: Edit contact details (E-mail)
     */
    @Test
    public void oneCanEditEmail() {
        SettingsMobileSteps settingsMobileSteps = new SettingsMobileSteps();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        settingsMobileSteps.changeEmail(randomString + "@example.com");
        settingsMobileSteps.clickSaveChangesButton();
        settingsMobileSteps.isChanged();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        settingsMobileSteps.changeEmail(user.getEmail());
        settingsMobileSteps.clickSaveChangesButton();
        settingsMobileSteps.isChanged();
    }

    /**
     * [EPMFARMATS-4027]: Edit contact details (mobile number)
     */
    @Test
    public void oneCanEditMobileNumber() {
        String zipCode = "+37529";
        SettingsMobileSteps settingsMobileSteps = new SettingsMobileSteps();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        settingsMobileSteps.changePhoneNumber(zipCode + randomNumber);
        settingsMobileSteps.clickSaveChangesButton();
        settingsMobileSteps.isChanged();
    }

    /**
     * [EPMFARMATS-4037]: Edit password with false old password
     */
    @Test
    public void oneCanNotEditPasswordWithFalseOldPassword() {
        SettingsMobileSteps settingsMobileSteps = new SettingsMobileSteps();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        settingsMobileSteps.clickChangePasswordButton();
        settingsMobileSteps.changePassword(invalidUser.getPassword(), newUser.getPassword(), newUser.getPassword());
        settingsMobileSteps.clickSavePasswordButton();
        settingsMobileSteps.isIncorrectOldPasswordmessageDisplayed();
    }

    /**
     * [EPMFARMATS-4038]: Edit password with not match new password
     */
    @Test
    public void oneCanNotEditPasswordWithNotMatchNewPassword() {
        SettingsMobileSteps settingsMobileSteps = new SettingsMobileSteps();
        settingsMobileSteps.clickMenuButton();
        settingsMobileSteps.clickHeaderDetailsButton();
        settingsMobileSteps.clickSettingsButton();
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        settingsMobileSteps.clickChangePasswordButton();
        settingsMobileSteps.changePassword(user.getPassword(), newUser.getPassword(), invalidUser.getPassword());
        settingsMobileSteps.clickSavePasswordButton();
        settingsMobileSteps.isIncorrectRepeatPasswordmessageDisplayed();
    }

}