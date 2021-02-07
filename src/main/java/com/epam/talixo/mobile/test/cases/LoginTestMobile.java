package com.epam.talixo.mobile.test.cases;

import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.mobile.steps.LoginStepsMobile;
import com.epam.talixo.mobile.test.BaseTestMobile;
import com.epam.talixo.mobile.test.suites.RegressionTestMobile;
import com.epam.talixo.mobile.test.suites.SmokeTestMobile;
import com.epam.talixo.mobile.utils.KeyboardUtilsMobile;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTestMobile extends BaseTestMobile {

    private static final String VALID_DATA_FILE = "/testData/loginData/valid.json";
    private static final String INVALID_DATA_FILE = "/testData/loginData/invalid.json";

    /**
     * Login test with checking is user logged in.
     * If user logged in, he should: 1) log out; 2) back to Start Page; 3) open Login Page; 4) log in.
     * If user is NOT logged in, he should: 1) open Login Page; 2) log in.
     */
    @Test
    @Category({SmokeTestMobile.class})
    public void test1_Login() {
        LoginStepsMobile loginSteps = new LoginStepsMobile();
        boolean isUserLoggedIn = loginSteps.isUserLoggedIn();
        if (isUserLoggedIn) {
            loginSteps.logout();
            KeyboardUtilsMobile.clickBackButton();
            loginSteps.openLoginPage();
            loginSteps.login();
        } else {
            loginSteps.openLoginPage();
            loginSteps.login();
        }
        assertTrue("User is NOT logged in.", loginSteps.isUserLoggedIn());
    }

    @Test
    @Category({RegressionTestMobile.class})
    public void test2_LoginWithInvalidEmail() {
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        LoginStepsMobile loginSteps = new LoginStepsMobile();
        loginSteps.openLoginPage();
        loginSteps.login(invalidUser.getEmail(), validUser.getPassword());
        assertTrue("'Invalid Email' message is NOT displayed", loginSteps.isInvalidEmailMessageDisplayed());
    }

    @Test
    @Category(RegressionTestMobile.class)
    public void test3_LoginWithInvalidPassword() {
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        LoginStepsMobile loginSteps = new LoginStepsMobile();
        loginSteps.openLoginPage();
        loginSteps.login(validUser.getEmail(), invalidUser.getPassword());
        assertTrue("'Invalid Password' message is NOT displayed", loginSteps.isInvalidPasswordMessageDisplayed());
        loginSteps.login(); // precondition for the next test in the Regression Suite (should be logged in)
        assertTrue("User is NOT logged in.", loginSteps.isUserLoggedIn());

    }

    @Test
    @Category({SmokeTestMobile.class})
    public void test4_Logout() {
        LoginStepsMobile loginSteps = new LoginStepsMobile();
        loginSteps.logout();
        assertTrue("User is NOT logged out", loginSteps.isUserLoggedOut());
        loginSteps.login(); // precondition for the next test in the Smoke Suite (should be logged in)
        assertTrue("User is NOT logged in.", loginSteps.isUserLoggedIn());
    }

}