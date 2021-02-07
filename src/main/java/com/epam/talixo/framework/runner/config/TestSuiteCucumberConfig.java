package com.epam.talixo.framework.runner.config;

import com.epam.talixo.framework.cucumber.runner.CucumberRegressionTestRunner;
import com.epam.talixo.framework.cucumber.runner.CucumberSmokeTestRunner;
import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;

public class TestSuiteCucumberConfig {

    /**
     * Configuration for [suite] params
     *
     * @param suite Test Suite to testing.
     */
    public static Class<?> setConfig(String suite) throws TypeIsUnsupportedException {
        switch (suite) {
            case "smoke":
                return CucumberSmokeTestRunner.class;
            case "regression":
                return CucumberRegressionTestRunner.class;
            default:
                throw new TypeIsUnsupportedException("Set test suite (regression, smoke), please.");
        }
    }
}
