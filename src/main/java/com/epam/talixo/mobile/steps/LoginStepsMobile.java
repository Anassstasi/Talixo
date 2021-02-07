package com.epam.talixo.mobile.steps;

import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.mobile.pages.HomePageMobile;
import com.epam.talixo.mobile.pages.LoginPageMobile;
import com.epam.talixo.mobile.pages.MenuPageMobile;
import com.epam.talixo.mobile.pages.StartPageMobile;
import org.openqa.selenium.TimeoutException;

public class LoginStepsMobile {

    private static final String VALID_DATA_FILE = "/testData/loginData/valid.json";

    private LoginPageMobile loginPage = new LoginPageMobile();
    private StartPageMobile startPage = new StartPageMobile();
    private MenuPageMobile menuPage = new MenuPageMobile();
    private HomePageMobile homePage = new HomePageMobile();

    /**
     * Open Login page from Start page.
     */
    public void openLoginPage() {
        startPage.openLoginPage();
    }

    /**
     * Login with valid data.
     */
    public void login() {
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();
    }

    /**
     * Login.
     *
     * @param email    user's email
     * @param password user's password
     */
    public void login(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    /**
     * Logout from the user's profile
     */
    public void logout() {
        homePage.openMenu();
        menuPage.clickHeaderDetailsButton();
        menuPage.clickLogoutButton();
    }

    /**
     * Check is user logged in.
     *
     * @return true if user logged in, false – if not.
     */
    public boolean isUserLoggedIn() {
        try {
            homePage.isMenuButtonDisplayed();
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    /**
     * Check is user logged out.
     *
     * @return true if user logged out, false – if not.
     */
    public boolean isUserLoggedOut() {
        return loginPage.isConfirmLoginButtonDisplayed();
    }

    /**
     * Check is 'Invalid email format' message displayed.
     *
     * @return true if 'Invalid email format' message displayed, false – if not.
     */
    public boolean isInvalidEmailMessageDisplayed() {
        return loginPage.isInvalidEmailMessageDisplayed();
    }

    /**
     * Check is 'Incorrect username or password' message displayed.
     *
     * @return true if 'Incorrect username or password' message displayed, false – if not.
     */
    public boolean isInvalidPasswordMessageDisplayed() {
        return loginPage.isInvalidPasswordMessageDisplayed();
    }

}