package com.epam.talixo.framework.runner.config;

import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.mobile.test.suites.RegressionTestMobileSuite;
import com.epam.talixo.mobile.test.suites.SmokeTestMobileSuite;
import com.epam.talixo.test.suites.RegressionTestSuite;
import com.epam.talixo.test.suites.SmokeTestSuite;

/**
 * Configuration for [suite] params.
 */
public class TestSuiteConfig {

    /**
     * Configuration for [suite] params
     *
     * @param suite Test Suite to testing.
     */
    public static Class<?> setConfig(String suite, String type) throws TypeIsUnsupportedException {
        switch (type) {
            case "ui": {
                switch (suite) {
                    case "smoke":
                        return SmokeTestSuite.class;
                    case "regression":
                        return RegressionTestSuite.class;
                    default:
                        throw new TypeIsUnsupportedException("Set test suite (regression, smoke), please.");
                }
            }
            case "mobile": {
                switch (suite) {
                    case "smoke":
                        return SmokeTestMobileSuite.class;
                    case "regression":
                        return RegressionTestMobileSuite.class;
                    default:
                        throw new TypeIsUnsupportedException("Set test suite (regression, smoke), please.");
                }
            }
            default:
                throw new TypeIsUnsupportedException("Set test suite (regression, smoke), please.");
        }
    }

}