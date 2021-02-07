package com.epam.talixo.steps;

import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.framework.utils.RandomUtils;
import com.epam.talixo.pages.HomePage;
import com.epam.talixo.pages.LoginPage;
import com.epam.talixo.pages.SettingsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertTrue;

/**
 * The class includes methods which are needed for editing an account
 */
public class SettingsSteps {

    private static final Logger logger = LogManager.getLogger();
    private static final String LOGIN_DATA = "/testData/loginData/valid.json";
    private static final String NEW_VALID_DATA_FILE = "/testData/editingAccountData/newValid.json";
    private static final String INVALID_DATA_FILE = "/testData/editingAccountData/invalid.json";
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private SettingsPage settingsPage = new SettingsPage();
    private String randomString = RandomStringUtils.randomAlphabetic(8);
    private String randomNumber = RandomStringUtils.randomNumeric(6);
    private String randomCountryName = RandomUtils.getRandomCountry();

    /**
     * Click on settings link
     */
    @When("^the user clicks on 'MY SETTINGS' on the Home page$")
    public void clickOnLinkMySettings() {
        homePage.clickOnMySettings();
    }

    /**
     * This method allows to change first name in the account settings
     */
    @When("^the user changes first name in the input 'First Name' in the Contact Details Table on the Setting page$")
    public void changeFirstName() {
        settingsPage.changeFirstName(randomString);
    }

    /**
     * This method allows to change last name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeLastName(String newData) {
        settingsPage.changeLastName(newData);
    }

    /**
     * This method allows to change last name in the account settings
     */
    @When("^the user changes last name on the Setting page$")
    public void changeLastName() {
        changeLastName(randomString);
    }

    /**
     * This method allows to change email in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeEmail(String newData) {
        settingsPage.changeEmail(newData);
    }

    /**
     * This method allows to change email in the account settings
     */
    @When("^the user changes email in the input 'E-mail' in the Contact Details Table on the Setting page$")
    public void changeEmail() {
        changeEmail(randomString + "@example.com");
    }

    /**
     * This method allows to cancel changing email in the account settings
     */
    @When("^return old e-mail")
    public void cancelChangingEmail() {
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        changeEmail(user.getEmail());
    }

    /**
     * This method allows to change company name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeCompanyName(String newData) {
        settingsPage.changeCompanyName(newData);
    }

    /**
     * This method allows to change company name in the account settings
     */
    @When("^the user changes company name in the input 'Company name' in the Contact Details Table on the Setting page$")
    public void changeCompanyName() {
        changeCompanyName(randomString);
    }

    /**
     * This method allows to change street name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeStreet(String newData) {
        settingsPage.changeStreet(newData);
    }

    /**
     * This method allows to change street name in the account settings
     */
    @When("^the user changes street in the input 'Street' in the Contact Details Table on the Setting page$")
    public void changeStreet() {
        changeStreet(randomString);
    }

    /**
     * This method allows to change town name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeTown(String newData) {
        settingsPage.changeTown(newData);
    }

    /**
     * This method allows to change town name in the account settings
     */
    @When("^the user changes town in the input 'Town' in the Contact Details Table on the Setting page$")
    public void changeTown() {
        changeTown(randomString);
    }

    /**
     * This method allows to change ZIP code in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeZipCode(String newData) {
        settingsPage.changeZipCode(newData);
    }

    /**
     * This method allows to change ZIP code in the account settings
     */
    @When("^the user changes zip code in the input 'Zip code' in the Contact Details Table on the Setting page$")
    public void changeZipCode() {
        changeZipCode(randomNumber);
    }

    /**
     * This method allows to change country name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeCountry(String newData) {
        settingsPage.changeCountry(newData);
    }

    /**
     * This method allows to change country name in the account settings
     */
    @When("^the user changes country in the input 'Country' in the Contact Details Table on the Setting page$")
    public void changeCountry() {
        changeCountry(randomCountryName);
    }

    /**
     * This method allows to change mobile number in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeMobileNumber(String newData) {
        try {
            settingsPage.changeMobileNumber(newData);
        } catch (TypeIsUnsupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method allows to change mobile number in the account settings
     */
    @When("^the user changes mobile number in the input 'Mobile' in the Contact Details Table on the Setting page$")
    public void changeMobileNumber() {
        changeMobileNumber(randomCountryName);
    }

    /**
     * This method allows to check whether the parameter has changed
     */
    @Then("^the (?:first name|last name|email|company name|street|town|zip code|country|mobile number) " +
            "should be changed in the Contact Details Table on the Setting page$")
    public void areTheChangesSuccessfullySaved() {
        if (settingsPage.isLabelOkDisplayed()) {
            settingsPage.clickOnLabelOk();
        } else {
            logger.info("The label 'Changes were successfully saved' has not appeard");
        }
        assertTrue("The label 'Changes were successfully saved' has not appeard", settingsPage.isLabelOkDisplayed());
    }

    /**
     * This method allows to cancel changing password
     */
    @When("^return old password$")
    public void cancelChangingPassword() {
        User user = JsonUtils.readJsonSingleObject(LOGIN_DATA, User.class);
        User newUser = JsonUtils.readJsonSingleObject(NEW_VALID_DATA_FILE, User.class);
        changePassword(newUser.getPassword(), user.getPassword(), user.getPassword());
    }

    /**
     * This method allows to check whether the password has changed
     */
    @Then("^the user can login using old e-mail \"([^\"]*)\" and new password \"([^\"]*)\" on the Login page$")
    public void isPasswordChangedSuccessfully(String login, String newPassword) {
        loginPage.login(login, newPassword);
        assertTrue("The user has not changed password ", settingsPage.isPasswordChanged());
    }

    /**
     * This method allows to add an address
     *
     * @param address is an address you add
     */
    @When("^the user adds a new address \"([^\"]*)\" to Favourite addresses Table on the Setting page$")
    public void addAddress(String address) {
        settingsPage.clickOnLinkFavouriteAddress();
        settingsPage.addAddress(address);
    }

    @Then("^the error message 'Old password is incorrect' should be displayed near old password field " +
            "in the Change Password Table on the Setting page$")
    public void isThereNoChangedPasswordWithFalseOldPassword() {
        assertTrue("The user can't change password with false old one", settingsPage.isNoChangedPasswordWithFalseOldPassword());
    }

    /**
     * This method allows to check whether the not matching password has changed
     */
    @Then("^the error message 'Password does not match' should be displayed near 'Repeat new password' field " +
            "in the Change Password Table on the Setting page$")
    public void isThereNoChangedPasswordWithNotMatchNewPassword() {
        assertTrue("Verify that user can't change password with not matching new one",
                settingsPage.isNoChangedPasswordWithNotMatchNewPassword());
    }

    /**
     * This method allows to change a password without clicking on the button "SAVE"
     *
     * @param password       is a password you change
     * @param newPassword    is a new password
     * @param repeatPassword is a new password you repeat
     */
    @When("^the user enters (?:incorrect old password|the password) \"([^\"]*)\" to change it to \"([^\"]*)\" and enters \"([^\"]*)\" " +
            "to repeat the password$")
    public void changePasswordWithoutClickOnSaveButton(String password, String newPassword, String repeatPassword) {
        settingsPage.clickOnLinkChangePassword();
        settingsPage.editOldPass(password);
        settingsPage.editNewPass(newPassword);
        settingsPage.repeatNewPass(repeatPassword);
    }

    /**
     * This method allows to change password
     *
     * @param password          is a password you change
     * @param newPassword       is a new password
     * @param newRepeatPassword is a new password you repeat
     */
    @When("^the user changes password\"([^\"]*)\" to \"([^\"]*)\" and repeats new password entering \"([^\"]*)\"$")
    public void changePassword(String password, String newPassword, String newRepeatPassword) {
        settingsPage.clickOnLinkChangePassword();
        settingsPage.editOldPass(password);
        settingsPage.editNewPass(newPassword);
        settingsPage.repeatNewPass(newRepeatPassword);
        settingsPage.clickOnSavePassButton();
    }

    /**
     * This method allows to search an address
     *
     * @param string is an address you search
     */
    @When("^the user searches the address \"([^\"]*)\" in the field 'Address' in the Favourite addresses Table on the Setting page$")
    public void searchAddress(String string) {
        settingsPage.clickOnLinkFavouriteAddress();
        settingsPage.searchAddress(string);
    }

    /**
     * Method allows to check whether the favourite address is displayed on the page
     */
    @Then("^the address \"([^\"]*)\" should be (?:added|displayed) (?:to|in) the Favourite addresses Table on the Setting page$")
    public void isFavouriteAddressReallyDisplayed(String address) {
        assertTrue("The user has not added thr address to favourites",
                settingsPage.isFavouriteAddressDisplayed(address));
    }

}