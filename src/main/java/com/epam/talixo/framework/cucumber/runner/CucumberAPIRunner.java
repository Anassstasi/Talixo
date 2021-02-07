package com.epam.talixo.framework.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        snippets = SnippetType.CAMELCASE,
        glue = "com.epam.talixo.api",
        features = "src/main/resources/features/api")
public class CucumberAPIRunner {
}