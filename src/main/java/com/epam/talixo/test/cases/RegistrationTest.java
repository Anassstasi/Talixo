package com.epam.talixo.test.cases;

import com.epam.jira.JIRATestKey;
import com.epam.talixo.framework.data.RegistrationDataStorage;
import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.steps.LoginSteps;
import com.epam.talixo.steps.RegistrationSteps;
import com.epam.talixo.test.BaseTest;
import com.epam.talixo.test.report.ReportManager;
import com.epam.talixo.test.rules.ReportRule;
import com.epam.talixo.test.suites.RegressionTest;
import com.epam.talixo.test.suites.SmokeTest;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.assertj.core.util.Arrays.asList;

/**
 * Class for testing Registration function.
 */
@RunWith(DataProviderRunner.class)
public class RegistrationTest extends BaseTest {

    @ClassRule
    public static ReportRule reportRule = new ReportRule("Registration Test");
    private static String testName, testDescription;
    private static String dataFile;
    private static User user;

    @DataProvider
    public static Object[][] dataProvider() {
        dataFile = "invalidFirstName.json";
        User[] user = RegistrationDataStorage.getUsers(dataFile);
        return asList(user)
                .stream()
                .map(name -> new Object[]{name})
                .toArray(Object[][]::new);
    }

    /**
     * [EPMFARMATS-4050] Registration with valid data
     */
    @Test
    @Category(SmokeTest.class)
    @JIRATestKey(key = "EPMFARMATS-4050")
    public void testRegistrationWithValidData() {
        testName = "EPMFARMATS-4050";
        testDescription = "Registration with valid data";
        ReportManager.createInstance(testDescription, testName);
        dataFile = "valid.json";
        String firstName = "Ivan";
        user = RegistrationDataStorage.getUserByFirstName(dataFile, firstName);
        RegistrationSteps registrationSteps = new RegistrationSteps();
        registrationSteps.openRegistrationPage();
        registrationSteps.register(user);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.isUserLoggedIn();
    }

    /**
     * [EPMFARMATS-4051,4054] Registration with invalid data
     */
    @Test
    @Category(RegressionTest.class)
    @UseDataProvider("dataProvider")
    @JIRATestKey(key = "EPMFARMATS-4051")
    public void testRegistrationWithInvalidName(User user) {
        testName = "EPMFARMATS-4051-4054";
        testDescription = "Registration with invalid data";
        ReportManager.createInstance(testDescription, testName);
        RegistrationSteps registrationSteps = new RegistrationSteps();
        registrationSteps.openRegistrationPage();
        registrationSteps.register(user);
        registrationSteps.isFormatErrorAppears();
    }

}