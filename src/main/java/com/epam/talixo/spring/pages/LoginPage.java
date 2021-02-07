package com.epam.talixo.spring.pages;

import com.epam.talixo.framework.element.CustomWebElement;
import com.epam.talixo.framework.properties.UrlsStorage;
import com.epam.talixo.framework.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

/**
 * Class for describing the login page of the website
 */
public class LoginPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger();
    private String url = UrlsStorage.getLoginPageUrl();

    /**
     * Login field
     */
    @FindBy(id = "id_email_auth")
    private CustomWebElement inputLogin;

    /**
     * Password field
     */
    @FindBy(id = "id_password")
    private CustomWebElement inputPassword;

    /**
     * Sign in button
     */
    @FindBy(xpath = "//input[@name='sign-in']")
    private CustomWebElement buttonSignIn;

    /**
     * Sign in href
     */
    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    private CustomWebElement signInHref;

    /**
     * "Logged in as" message
     */
    @FindBy(xpath = "//span[contains(text(), 'Logged in as')]")
    private CustomWebElement linkLoggedInNotification;

    /**
     * Sign out href
     */
    @FindBy(xpath = "//a[contains(text(), 'Sign-out')]")
    private CustomWebElement signOutHref;

    /**
     * Error message for wrong credential
     */
    @FindBy(xpath = "//*[@class='booking-mask-field clearfix']/*[@data-tooltip-errors]")
    private CustomWebElement incorrectCredentialError;

    /**
     * Login form
     */
    @FindBy(css = ".auth-login-form")
    private CustomWebElement loginForm;

    /**
     * Constructor of LoginPageMobile class
     */
    public LoginPage() {
        super();
    }

    /**
     * This method opens Login page
     */
    public void openPage() {
        driver.navigate().to(url);
        signInHref.click();
        logger.info("Login page opened: " + url);
    }

    /**
     * This method returns opened page title
     *
     * @return title of the current page
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Full login implementation
     *
     * @param username user EMAIL
     * @param password user password
     */
    public void login(String username, String password) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        logger.info(String.format("Log in with username [%s] and psw [%s]", username, password));
    }

    /**
     * Logout from the user profile
     */
    public void logout() {
        linkLoggedInNotification.moveToElement();
        signOutHref.click();
        logger.info("Log out");
    }

    /**
     * Check if there's Login form
     *
     * @return true if Login form is here, false if there isn't
     */
    public boolean isLoginFormDisplayed() {
        logger.info("Login form is on the page: " + url);
        return loginForm.isDisplayed();
    }

    /**
     * Check if there's Sign in href
     *
     * @return true if Sign in href is here, false if there isn't
     */
    public boolean isSignInHrefDisplayed() {
        logger.info("'Sign in' link is on the page");
        return signInHref.isDisplayed();
    }

    /**
     * Check if there's incorrect credential message
     *
     * @return true if message about incorrect credential is on the page, false if there isn't
     */
    public boolean isIncorrectCredentialErrorDisplayed() {
        logger.info("Credential error is displayed");
        return incorrectCredentialError.isDisplayed();
    }

    /**
     * Check if there's a "logged in as" notification
     *
     * @return true if "logged in as" notification is displayed, false if there isn't
     */
    public boolean isLoggedInNotification() {
        WaitUtils.waitForVisibility(linkLoggedInNotification);
        logger.info("'Logged in as' message is displayed");
        return linkLoggedInNotification.isDisplayed();
    }
}