package com.epam.talixo.test.cases;

import com.epam.jira.JIRATestKey;
import com.epam.jira.junit.TestRunner;
import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.pages.LoginPage;
import com.epam.talixo.steps.LoginSteps;
import com.epam.talixo.test.BaseTest;
import com.epam.talixo.test.report.ReportManager;
import com.epam.talixo.test.rules.ReportRule;
import com.epam.talixo.test.suites.RegressionTest;
import com.epam.talixo.test.suites.SmokeTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(TestRunner.class)
public class LoginTest extends BaseTest {

    private static final String VALID_DATA_FILE = "/testData/loginData/valid.json";
    private static final String INVALID_DATA_FILE = "/testData/loginData/invalid.json";
    @ClassRule
    public static ReportRule reportRule = new ReportRule("Login Test");
    private static String testName, testDescription;

    /**
     * [EPMFARMATS-3976] Sign in to Talixo
     */
    @Test
    @Category(SmokeTest.class)
    @JIRATestKey(key = "EPMFARMATS-3976")
    public void oneCanLoginTalixo() {
        testName = "EPMFARMATS-3976";
        testDescription = "Sign in to Talixo";
        ReportManager.createInstance(testDescription, testName);
        User user = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(user.getEmail(), user.getPassword());
        loginSteps.isUserLoggedIn();
    }

    /**
     * [EPMFARMATS-4014] Sign in to Talixo with incorrect EMAIL
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-4014")
    public void oneCanEnterIncorrectEmailForLoginTalixo() {
        testName = "EPMFARMATS-4014";
        testDescription = "Sign in to Talixo with incorrect EMAIL";
        ReportManager.createInstance(testDescription, testName);
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(invalidUser.getEmail(), validUser.getPassword());
        loginSteps.isIncorrectCredentialErrorAppears(invalidUser.getEmail());
    }

    /**
     * [EPMFARMATS-4015] Sign in to Talixo with incorrect password
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-4015")
    public void oneCanEnterIncorrectPasswordForLoginTalixo() {
        testName = "EPMFARMATS-4015";
        testDescription = "Sign in to Talixo with incorrect password";
        ReportManager.createInstance(testDescription, testName);
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(validUser.getEmail(), invalidUser.getPassword());
        loginSteps.isIncorrectCredentialErrorAppears(invalidUser.getPassword());
    }

    /**
     * [EPMFARMATS-3975] Sign out from Talixo
     */
    @Test
    @Category(SmokeTest.class)
    @JIRATestKey(key = "EPMFARMATS-3975")
    public void oneCanLogoutTalixo() {
        testName = "EPMFARMATS-3975";
        testDescription = "Sign out from Talixo";
        ReportManager.createInstance(testDescription, testName);
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        LoginSteps loginSteps = new LoginSteps();
        LoginPage loginPage = new LoginPage();
        SoftAssertions softly = new SoftAssertions();
        loginSteps.loginTalixo();
        loginSteps.isUserLoggedIn();
        loginSteps.logoutTalixo();
        softly.assertThat(loginSteps.isSignInHrefAppears())
                .overridingErrorMessage("Sign in link is not displayed").isTrue();
        softly.assertThat(loginPage.getTitle())
                .as("The user %s has not been successfully logged out",
                        validUser.getEmail()).isEqualTo("Book Taxis and Limousines Online - Talixo");
        softly.assertAll();
    }

}