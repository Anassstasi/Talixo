package com.epam.talixo.test.suites;

import com.epam.talixo.test.cases.BookATaxiTest;
import com.epam.talixo.test.cases.EditingAnAccountTest;
import com.epam.talixo.test.cases.LoginTest;
import com.epam.talixo.test.cases.RegistrationTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite for running tests with annotation @Category(RegressionTest.class)
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(RegressionTest.class)
@Suite.SuiteClasses({
        BookATaxiTest.class,
        EditingAnAccountTest.class,
        LoginTest.class,
        RegistrationTest.class
})
public class RegressionTestSuite {
}