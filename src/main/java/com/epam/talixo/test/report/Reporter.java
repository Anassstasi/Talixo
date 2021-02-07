package com.epam.talixo.test.report;

public class Reporter {

    private String description;
    private String testName;
    private String parentTestName;

    public Reporter(String description, String testName) {
        this.description = description;
        this.testName = testName;
    }

    /**
     * Method allows to get the description of the test
     *
     * @return the description of the test
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method allows to set test description (the way it will be displayed in the report)
     *
     * @param description is the description of the test
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method allows to get the name of the test
     *
     * @return the name of the test
     */
    public String getTestName() {
        return testName;
    }

    /**
     * Method allows to set test name (the way it will be displayed in the report)
     *
     * @param testName is the name of the test
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * Method allows to get the name of the test class
     *
     * @return the name of the test class
     */
    public String getParentTestName() {
        return parentTestName;
    }

    /**
     * Method allows to set test class name (the way it will be displayed in the report)
     *
     * @param parentTestName is the name of the test class
     */
    public void setParentTestName(String parentTestName) {
        this.parentTestName = parentTestName;
    }

}