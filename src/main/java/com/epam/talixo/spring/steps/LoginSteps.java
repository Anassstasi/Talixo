package com.epam.talixo.spring.steps;

import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.spring.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The class includes methods which are needed for login and logout
 */
public class LoginSteps {

    private static final String VALID_DATA_FILE = "/testData/loginData/valid.json";
    private LoginPage loginPage = new LoginPage();

    /**
     * This method allows to logout from your account.
     */
    @Given("^the user opens Login page$")
    public void openLoginPage() {
        loginPage.openPage();
    }

    /**
     * This method allows to log in to Talixo with valid data.
     */
    @When("^the user performs login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginTalixoWithoutOpenPage(String username, String password) {
        loginPage.login(username, password);
    }

    /**
     * This method allows to log in to Talixo.
     */
    @Given("^(?:the user|I) logs? in to Talixo on Login Page$")
    public void loginTalixo() {
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        loginPage.openPage();
        loginPage.login(validUser.getEmail(), validUser.getPassword());
    }

    /**
     * This method allows to logout from your account.
     */
    @When("^the user logs out talixo on Login Page$")
    public void logoutTalixo() {
        loginPage.logout();
    }

    /**
     * This method checks if user is logged in.
     */
    @Then("^the notification that the user is logged in should appear on Login Page$")
    public void isUserLoggedIn() {
        assertTrue("Login isn't performed", loginPage.isLoggedInNotification());
    }

    /**
     * This method checks if user is logged in.
     */
    @Then("^the user sees login form$")
    public void isLoginFormAppears() {
        assertTrue("Login form isn't displayed", loginPage.isLoginFormDisplayed());
    }

    /**
     * This method checks if there's Sign in link
     *
     * @return true if Sign in link is on the page, false if there isn't
     */
    public boolean isSignInHrefAppears() {
        return loginPage.isSignInHrefDisplayed();
    }

    /**
     * This method checks if the user enter wrong credential.
     */
    @Then("^\"([^\"]*)\" error should appear on Login Page$")
    public void isIncorrectCredentialErrorAppears(String credential) {
        assertTrue(String.format("Unexpected credential: %s", credential), loginPage.isIncorrectCredentialErrorDisplayed());
    }

    /**
     * This method checks whether the user is logged out
     */
    @Then("^the title \"([^\"]*)\" appears on the Home page$")
    public void isUserLoggedOut(String title) {
        assertEquals(String.format("Unexpected page title: %s", title), title, loginPage.getTitle());

    }
}