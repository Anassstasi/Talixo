package com.epam.talixo.mobile.test.suites;

import com.epam.talixo.mobile.test.cases.BookATaxiTestMobile;
import com.epam.talixo.mobile.test.cases.EditingAnAccountMobileTest;
import com.epam.talixo.mobile.test.cases.LoginTestMobile;
import com.epam.talixo.mobile.test.cases.RegisterTestMobile;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite for running tests with annotation @Category(RegressionTestMobile.class)
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(RegressionTestMobile.class)
@Suite.SuiteClasses({
        RegisterTestMobile.class,
        LoginTestMobile.class,
        BookATaxiTestMobile.class,
        EditingAnAccountMobileTest.class
})
public class RegressionTestMobileSuite extends MobileSuite {
}