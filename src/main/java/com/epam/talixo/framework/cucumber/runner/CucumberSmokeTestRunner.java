package com.epam.talixo.framework.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
        snippets = SnippetType.CAMELCASE,
        glue = "com.epam.talixo",
        tags = "@SmokeTest",
        monochrome = true,
        features = "src/main/resources/features")
public class CucumberSmokeTestRunner {
}