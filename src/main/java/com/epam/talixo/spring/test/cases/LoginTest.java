package com.epam.talixo.spring.test.cases;

import com.epam.jira.JIRATestKey;
import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;
import com.epam.talixo.spring.steps.LoginSteps;
import com.epam.talixo.test.suites.RegressionTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoginTest {

    private static final String VALID_DATA_FILE = "/testData/loginData/valid.json";
    private static final String INVALID_DATA_FILE = "/testData/loginData/invalid.json";

    /**
     * [EPMFARMATS-4014] Sign in to Talixo with incorrect EMAIL
     */
    @Test
    @Category(RegressionTest.class)
    @JIRATestKey(key = "EPMFARMATS-4014")
    public void oneCanEnterIncorrectEmailForLoginTalixo() {
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
        User validUser = JsonUtils.readJsonSingleObject(VALID_DATA_FILE, User.class);
        User invalidUser = JsonUtils.readJsonSingleObject(INVALID_DATA_FILE, User.class);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.openLoginPage();
        loginSteps.loginTalixoWithoutOpenPage(validUser.getEmail(), invalidUser.getPassword());
        loginSteps.isIncorrectCredentialErrorAppears(invalidUser.getPassword());
    }
}