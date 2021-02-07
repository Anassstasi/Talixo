package com.epam.talixo.steps;

import com.epam.talixo.framework.data.RegistrationDataStorage;
import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.pages.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import static junit.framework.TestCase.assertTrue;

/**
 * Steps for registration.
 */
public class RegistrationSteps {

    private String randomEmail = RandomStringUtils.randomAlphabetic(3) + "@gmail.com";
    private RegistrationPage registrationPage = new RegistrationPage();

    /**
     * Open registration page.
     */
    @Given("^the user opens Registration page$")
    public void openRegistrationPage() {
        registrationPage.openPage();
    }

    /**
     * Full registration: fill(check) all the required fields(checkboxes), submit registration.
     *
     * @param user a specific user entity
     */
    public void register(User user) {
        fillRequiredFields(user.getFirstName(), user.getLastName(), user.getPrefixPhone(), user.getPhoneNumber(),
                user.getEmail() + randomEmail, user.getPassword());
        registrationPage.checkRequiredCheckboxes();
        registrationPage.submitRegistration();
    }

    /**
     * Full registration: fill(check) all the required fields(checkboxes), submit registration.
     *
     * @param userName a specific user entity
     */
    @When("^the user registers as \"([^\"]*)\" from \"([^\"]*)\" file on Registration Page$")
    public void register(String userName, String dataFile) {
        User newUser = RegistrationDataStorage.getUserByFirstName(dataFile, userName);
        register(newUser);
    }

    /**
     * Fill all the required fields.
     *
     * @param firstName   user's first name
     * @param lastName    user's last name
     * @param phonePrefix phone number's prefix
     * @param phoneNumber user's phone number
     * @param email       user's EMAIL
     * @param password    user's password
     */
    public void fillRequiredFields(String firstName, String lastName, String phonePrefix,
                                   String phoneNumber, String email, String password) {
        registrationPage.fillFirstName(firstName);
        registrationPage.fillLastName(lastName);
        registrationPage.fillPrefixPhone(phonePrefix);
        registrationPage.fillMobilePhone(phoneNumber);
        registrationPage.fillEmail(email);
        registrationPage.fillPassword(password);
    }

    /**
     * Check 'Invalid format' error message is displayed on the page.
     */
    @Then("^the message 'Invalid format' should appear on Registration Page$")
    public void isFormatErrorAppears() {
        assertTrue("There's no format error", registrationPage.isInvalidFormatErrorDisplayed());
    }
}