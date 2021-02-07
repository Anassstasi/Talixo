package com.epam.talixo.framework.runner.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.kohsuke.args4j.Option;


/**
 * Settings for commandline
 */
public class Settings {

    @Option(name = "--browser", usage = "Set browser type (chrome, firefox, edge)")
    public String browser = "chrome";

    @Option(name = "--suite", usage = "Set test suite (regression, smoke)", required = true)
    public String testSuite;

    @Option(name = "--environment", usage = "Set environment type (grid, local)")
    public String environment = "local";

    @Option(name = "--type", usage = "Set test type (ui, mobile)", required = true)
    public String type = "ui";

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

}