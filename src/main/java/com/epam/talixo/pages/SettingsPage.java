package com.epam.talixo.pages;

import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.framework.utils.FindElementUtil;
import com.epam.talixo.framework.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

import static com.epam.talixo.framework.utils.RandomUtils.Countries.getMobilePhoneByCountryName;


/**
 * Class for describing the settings page of the website
 */
public class SettingsPage extends AbstractPage {

    private static final String FAVOURITE_ADDRESS_PATTERN = "//*[contains(text(),'%s')]";
    private final Logger logger = LogManager.getLogger();
    /**
     * First name field
     */
    @FindBy(name = "first_name")
    private CustomWebElement inputFirstName;

    /**
     * Last name field
     */
    @FindBy(name = "last_name")
    private CustomWebElement inputLastName;

    /**
     * Email field
     */
    @FindBy(name = "email")
    private CustomWebElement inputEmail;

    /**
     * Company name field
     */
    @FindBy(name = "company_name")
    private CustomWebElement inputCompanyName;

    /**
     * Street field
     */
    @FindBy(name = "street")
    private CustomWebElement inputStreet;

    /**
     * Town field
     */
    @FindBy(name = "town")
    private CustomWebElement inputTown;

    /**
     * ZIP code field
     */
    @FindBy(name = "zip_code")
    private CustomWebElement inputZipCode;

    /**
     * Country list
     */
    @FindBy(id = "id_country_chzn")
    private CustomWebElement listCountry;

    /**
     * Search field in country list
     */
    @FindBy(css = ".chzn-search input")
    private CustomWebElement inputCountry;

    /**
     * Selected country while search field isn't empty
     */
    @FindBy(css = ".chzn-drop .active-result")
    private CustomWebElement selectCountry;

    /**
     * Mobile code list
     */
    @FindBy(id = "id_mobile_0_chzn")
    private CustomWebElement listMobileCode;

    /**
     * Search field in mobile code list
     */
    @FindBy(css = "#id_mobile_0_chzn input")
    private CustomWebElement inputNumberCode;

    /**
     * Mobile number field
     */
    @FindBy(name = "mobile_1")
    private CustomWebElement inputMobileNumber;

    /**
     * SAVE button
     */
    @FindBy(css = ".account-details-buttons input")
    private CustomWebElement buttonSave;

    /**
     * Label with text: "Changes were successfully saved"
     */
    @FindBy(css = "#innerModalPopupDivContent .success")
    private CustomWebElement labelOk;

    /**
     * OK button
     */
    @FindBy(css = "#innerModalPopupDivContent .button-primary")
    private CustomWebElement buttonOK;

    /**
     * Error with text: "Invalid format: can only accept letters, spaces, dots, apostrophe and "-" sign."
     */
    @FindBy(css = ".booking-form-errors .errorlist")
    private CustomWebElement labelFirstNameError;

    /**
     * Error with text: "Invalid format: can only accept letters, spaces, dots, apostrophe and "-" sign."
     */
    @FindBy(css = ".booking-form-errors .errorlist")
    private CustomWebElement labelLastNameError;

    /**
     * Error with text: "Invalid format: can only accept letters, spaces, dots, apostrophe and "-" sign."
     */
    @FindBy(css = ".booking-form-errors .errorlist")
    private CustomWebElement labelEmailError;

    /**
     * Link with "Change password" text
     */
    @FindBy(css = "[href='/settings/change_password/'].is-visible")
    private CustomWebElement linkChangePassword;

    /**
     * Old password field
     */
    @FindBy(name = "old_password")
    private CustomWebElement inputOldPassword;

    /**
     * New password field
     */
    @FindBy(name = "new_password")
    private CustomWebElement inputNewPassword;

    /**
     * Field for repeating new password
     */
    @FindBy(name = "repeat_password")
    private CustomWebElement inputRepeatPassword;

    /**
     * SAVE button
     */
    @FindBy(xpath = "//*[@value = 'Save']")
    private CustomWebElement buttonSaveNewPassword;

    /**
     * Error that occurs when you enter wrong old password
     */
    @FindBy(id = "id_old_password_text")
    private CustomWebElement labelWithFalseOldPassword;

    /**
     * Error that occurs when fields with new password do not match
     */
    @FindBy(id = "id_repeat_password_text")
    private CustomWebElement labelWithNotMatchNewPassword;

    /**
     * Link with "Favourite addresses" text
     */
    @FindBy(css = "[href='/settings/favourite_locations/'].is-visible")
    private CustomWebElement linkFavouriteAddress;

    /**
     * Search for favourite addresses
     */
    @FindBy(id = "id_location")
    private CustomWebElement inputAddAddress;

    /**
     * Selected address while search field isn't empty
     */
    @FindBy(xpath = "//*[@class = 'fm__form__dropdown__item']")
    private CustomWebElement selectAddress;

    /**
     * ADD button
     */
    @FindBy(css = ".fm__button")
    private CustomWebElement buttonAddAddress;

    /**
     * Location of added favourite address
     */
    @FindBy(css = ".fm__job__location")
    private CustomWebElement labelAddress;

    /**
     * Search for added favourite addresses
     */
    @FindBy(xpath = "//*[@type = 'search']")
    private CustomWebElement inputSearchAddress;

    /**
     * Constructor of SettingsPage class
     */
    public SettingsPage() {
        super();
    }

    /**
     * Method allows to get the CustomWebElement connected with added favourite address
     *
     * @param favAddress is the address which is added to favourites
     * @return the CustomWebElement connected with added favourite address
     */
    public CustomWebElement findFavAddress(String favAddress) {
        String customWebElementLocator = String.format(FAVOURITE_ADDRESS_PATTERN, favAddress);
        logger.info(String.format("Favourite address: %s", favAddress));
        return FindElementUtil.findElement(By.xpath(customWebElementLocator));
    }

    /**
     * This method allows to change first name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeFirstName(String newData) {
        inputFirstName.clearAndType(newData);
        logger.info("New name is " + newData);
        buttonSave.click();
    }

    /**
     * This method allows to change last name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeLastName(String newData) {
        inputLastName.clearAndType(newData);
        logger.info("New last name is " + newData);
        buttonSave.click();
    }

    /**
     * This method allows to change email in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeEmail(String newData) {
        inputEmail.clearAndType(newData);
        logger.info("New email is " + newData);
        buttonSave.click();
    }

    /**
     * Method allows to check whether the address added to favourites is displayed
     *
     * @param address the address added to favourites
     * @return true if it`s displayed and false if not
     */
    public boolean isFavouriteAddressDisplayed(String address) {
        return findFavAddress(address).isDisplayed();
    }

    /**
     * This method allows to change company name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeCompanyName(String newData) {
        inputCompanyName.clearAndType(newData);
        logger.info("New company name is " + newData);
        buttonSave.click();
    }

    /**
     * This method allows to change street name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeStreet(String newData) {
        logger.info("New street is " + newData);
        inputStreet.clearAndType(newData);
        buttonSave.click();
    }

    /**
     * This method allows to change town name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeTown(String newData) {
        inputTown.clearAndType(newData);
        logger.info("New town is " + newData);
        buttonSave.click();
    }

    /**
     * This method allows to change ZIP code in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeZipCode(String newData) {
        inputZipCode.clearAndType(newData);
        logger.info("New ZIP code is " + newData);
        buttonSave.click();
    }

    /**
     * This method allows to change country name in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeCountry(String newData) {
        listCountry.click();
        inputCountry.clearAndType(newData);
        selectCountry.click();
        logger.info("New country is " + newData);
        buttonSave.click();
    }

    /**
     * This method allows to change mobile number in the account settings
     *
     * @param newData is a data you put into parameter
     */
    public void changeMobileNumber(String newData) throws TypeIsUnsupportedException {
        listMobileCode.click();
        inputNumberCode.sendKeys(newData);
        inputNumberCode.sendKeys(String.valueOf(Keys.ENTER));
        String newNumber = String.valueOf(getMobilePhoneByCountryName(newData));
        inputMobileNumber.clearAndType(newNumber);
        logger.info(String.format("Mobile number is changed: %s %s", newData, newNumber));
        buttonSave.click();
    }

    /**
     * This method allows to check whether the label has occurred
     *
     * @return false if not occurred, true if occurred
     */
    public boolean isLabelOkDisplayed() {
        WaitUtils.waitForVisibility(labelOk);
        logger.info("Label 'Changes were successfully saved' is displayed");
        return labelOk.isDisplayed();
    }

    /**
     * This method allows to click on OK button
     */
    public void clickOnLabelOk() {
        buttonOK.click();
    }

    /**
     * This method allows to change password
     *
     * @param password is a password you change
     */
    public void editOldPass(String password) {
        inputOldPassword.clear();
        inputOldPassword.sendKeys(password);
        logger.info(String.format("Old Password: %s", password));
    }

    /**
     * This method allows to change password
     *
     * @param newPassword is a new password
     */
    public void editNewPass(String newPassword) {
        inputNewPassword.clear();
        inputNewPassword.sendKeys(newPassword);
        logger.info(String.format("New Password: %s", newPassword));
    }

    /**
     * This method allows to change password
     *
     * @param newRepeatPassword is a new password you repeat
     */
    public void repeatNewPass(String newRepeatPassword) {
        inputRepeatPassword.clear();
        inputRepeatPassword.sendKeys(newRepeatPassword);
        logger.info(String.format("Repeat New Password: %s", newRepeatPassword));
    }

    /**
     * This method allows to check whether the password has changed
     *
     * @return true if changed, false if not changed
     */
    public boolean isPasswordChanged() {
        logger.info("Password has changed.");
        return buttonSaveNewPassword.isDisplayed();
    }

    /**
     * This method allows to add an address
     *
     * @param address is an address you add
     * @return added address name
     */
    public void addAddress(String address) {
        inputAddAddress.sendKeys(address);
        selectAddress.moveToElementAndClick();
        buttonAddAddress.click();
        logger.info(String.format("Add address: %s", address));
    }

    /**
     * This method allows to click on FAVOURITE ADDRESSES link
     */
    public void clickOnLinkFavouriteAddress() {
        linkFavouriteAddress.click();
        logger.info("Click 'FAVOURITE ADDRESSES' link.");
    }

    /**
     * This method allows to check whether the address has added
     *
     * @param string is an address you add
     * @return false if not added, true if added
     */
    public boolean isAddressAdded(String string) {
        String label = labelAddress.getText();
        String delimiter = " ";
        String[] labelArray = label.split(delimiter);
        String[] stringArray = string.split(delimiter);
        logger.info("Address is added.");
        return Arrays.equals(labelArray, stringArray);
    }

    /**
     * This method allows to check whether the old password has changed to the old one
     *
     * @return false if changed, true if not changed
     */
    public boolean isNoChangedPasswordWithFalseOldPassword() {
        logger.info("Error 'Wrong old password' is displayed.");
        return labelWithFalseOldPassword.isDisplayed();
    }

    /**
     * This method allows to check whether the not matching password has changed
     *
     * @return false if changed, true if not changed
     */
    public boolean isNoChangedPasswordWithNotMatchNewPassword() {
        logger.info("Error 'Not matching password' is displayed.");
        return labelWithNotMatchNewPassword.isDisplayed();
    }

    /**
     * This method allows to click on CHANGE PASSWORD link
     */
    public void clickOnLinkChangePassword() {
        linkChangePassword.click();
        logger.info("Click 'CHANGE PASSWORD' link.");
    }

    /**
     * This method allows to click on SAVE button
     */
    public void clickOnSavePassButton() {
        buttonSaveNewPassword.click();
        logger.info("Click 'SAVE' button.");
    }

    /**
     * This method allows to search an address
     *
     * @param string is an address you search
     */
    public void searchAddress(String string) {
        inputSearchAddress.clear();
        inputSearchAddress.sendKeys(string);
        logger.info(String.format("Search address: %s", string));
    }

}