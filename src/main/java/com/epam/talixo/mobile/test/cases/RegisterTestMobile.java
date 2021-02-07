package com.epam.talixo.mobile.test.cases;

import com.epam.talixo.framework.data.RegistrationDataStorage;
import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.mobile.steps.LoginStepsMobile;
import com.epam.talixo.mobile.steps.RegisterStepMobile;
import com.epam.talixo.mobile.test.BaseTestMobile;
import com.epam.talixo.mobile.test.suites.RegressionTestMobile;
import com.epam.talixo.mobile.test.suites.SmokeTestMobile;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.assertj.core.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class RegisterTestMobile extends BaseTestMobile {

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

    @Test
    @Category(SmokeTestMobile.class)
    public void testRegistrationWithValidData() {
        dataFile = "valid.json";
        String firstName = "Ivan";
        user = RegistrationDataStorage.getUserByFirstName(dataFile, firstName);
        LoginStepsMobile loginSteps = new LoginStepsMobile();
        RegisterStepMobile registrationSteps = new RegisterStepMobile();
        registrationSteps.openRegistrationPageFromStartPage();
        registrationSteps.register(user);
        registrationSteps.selectRequiredCheckboxes();
        registrationSteps.saveChanges();
        assertTrue("User is NOT logged in. Registration is FAILED", loginSteps.isUserLoggedIn());
        loginSteps.logout();
    }

    @Test
    @UseDataProvider("dataProvider")
    @Category(RegressionTestMobile.class)
    public void testRegistrationWithInvalidName(User user) {
        RegisterStepMobile registrationSteps = new RegisterStepMobile();
        registrationSteps.openRegistrationPageFromStartPage();
        registrationSteps.fillFirstName(user.getFirstName());
        registrationSteps.submitRegistration();
        assertTrue("'Invalid First Name format' message is NOT displayed", registrationSteps.isInvalidFirstNameFormatErrorDisplayed());
    }

}