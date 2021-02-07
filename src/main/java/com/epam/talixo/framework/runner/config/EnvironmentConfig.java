package com.epam.talixo.framework.runner.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.talixo.framework.runner.config.EnvironmentConfig.EnvironmentType.LOCAL;


public class EnvironmentConfig {

    private static final Logger logger = LogManager.getLogger();
    private static EnvironmentType type = LOCAL;

    /**
     * Configuration for environment params
     *
     * @param environmentType The type of environment to use.
     */
    public static void setConfig(String environmentType) {
        try {
            type = EnvironmentType.valueOf(environmentType.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("Set correct browser (firefox, chrome, edge, ie), please");
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the type of environment to use.
     *
     * @return the type of environment
     */
    public static EnvironmentType getType() {
        return type;
    }

    public enum EnvironmentType {GRID, LOCAL}

}