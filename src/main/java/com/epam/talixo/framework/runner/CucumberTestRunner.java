package com.epam.talixo.framework.runner;

import com.epam.jira.junit.ExecutionListener;
import com.epam.talixo.framework.exceptions.TypeIsUnsupportedException;
import com.epam.talixo.framework.runner.config.BrowserConfig;
import com.epam.talixo.framework.runner.config.EnvironmentConfig;
import com.epam.talixo.framework.runner.config.Settings;
import com.epam.talixo.framework.runner.config.TestSuiteCucumberConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class CucumberTestRunner {

    private static final Logger logger = LogManager.getLogger();
    private Class testClass;

    /**
     * Parse arguments for config from command line.
     *
     * @param args Command line arguments
     */
    private CucumberTestRunner(String[] args) throws CmdLineException, TypeIsUnsupportedException {
        Settings settings = new Settings();
        CmdLineParser parser = new CmdLineParser(settings);
        parser.parseArgument(args);
        EnvironmentConfig.setConfig(settings.environment);
        BrowserConfig.setConfig(settings.browser);
        testClass = TestSuiteCucumberConfig.setConfig(settings.testSuite);
    }

    public static void main(String[] args) {
        try {
            new CucumberTestRunner(args).run();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Set test suite, browser and environment, please. (--suite smoke --browser chrome " +
                    "--environment grid, e.g.)");
        }
    }

    /**
     * Run tests.
     * Example: mvn clean install exec:java -Dexec.args="--suite smoke --browser chrome --type ui --environment local"
     */
    private void run() {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new ExecutionListener());
        jUnitCore.run(testClass);
        Result result = jUnitCore.run(testClass);
        int runTestsCount = result.getRunCount();
        int failureTestsCount = result.getFailureCount();
        int ignoreTestsCount = result.getIgnoreCount();
        logger.info(String.format("\n" +
                "  _______ ______  _____ _______   _____  ______  _____ _    _ _   _______ \n" +
                " |__ CUCU|MBER__|/ CUCU|MBER __| |  __ \\|  ____|/ ____| |  | | | |__   __|\n" +
                "    | |  | |__  | (___    | |    | |__) | |__  | (___ | |  | | |    | |   \n" +
                "    | |  |  __|  \\___ \\   | |    |  _  /|  __|  \\___ \\| |  | | |    | |   \n" +
                "    | |  | |____ ____) |  | |    | | \\ \\| |____ ____) | |__| | |____| |   \n" +
                "    |_|  |__CUCU|MBER_/   |_|    |_|  \\_\\__CUCU|MBER_/ \\____/|______|_|  \n" +
                "                  Tests run: %s, Failures: %s, Skipped: %s", runTestsCount, failureTestsCount, ignoreTestsCount));
    }

}