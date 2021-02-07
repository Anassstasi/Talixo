package com.epam.talixo.api.steps;

import com.epam.talixo.api.entities.Gist;
import com.epam.talixo.api.entities.GitHubUser;
import com.epam.talixo.framework.utils.JsonUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

/**
 * This class defines steps for cucumber tests
 */
public class AssuredSteps {

    private static final String DELIMITER = "/";
    private static final String PATH_TO_ID = "id";
    private static final String PATH_TO_STAR = "/star";
    private static final String EXISTING_GIST_ID = "8d402324f2b018a36dc5e73d07f45b42";
    private static final String CONTENT_TYPE = "application/json";
    private static final String BASE_URL = "https://api.github.com/gists";
    private static final String USER_DATA_PATH = "/testData/api/User.json";
    private static final String GIST_DATA_PATH = "/testData/api/Gist.json";
    private static final String GIST_MODIFIED_DATA_PATH = "/testData/api/ModifiedGist.json";
    private static RequestSpecification request;
    private static Response response;
    private static String id;

    /**
     * This method allows to create request and authenticate the account
     */
    @Given("^the user creates a request and authenticates his account$")
    public void createARequestAndAuth() {
        RestAssured.baseURI = BASE_URL;
        GitHubUser gitHubUser = JsonUtils.readJsonSingleObject(USER_DATA_PATH, GitHubUser.class);
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(gitHubUser.getUsername());
        authScheme.setPassword(gitHubUser.getPassword());
        RestAssured.authentication = authScheme;
    }

    /**
     * This method allows to create a gist
     */
    @When("^the user creates a gist$")
    public void createAGist() {
        Gist gist = JsonUtils.readJsonSingleObject(GIST_DATA_PATH, Gist.class);
        request = RestAssured.given();
        request.contentType(CONTENT_TYPE).
                body(gist);
        response = request.post();
        id = response.then().extract().path(PATH_TO_ID).toString();
    }

    /**
     * This method allows to delete a gist
     */
    @When("^the user deletes the gist$")
    public void deleteAGist() {
        response = request.delete(DELIMITER + id);
    }

    /**
     * This method allows to validate the response
     *
     * @param expectedStatusCode is status code that you expect
     */
    @Then("^he expects status code (\\d+)$")
    public void validateTheResponse(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        assertEquals(String.format("Unexpected status code: %s", statusCode), expectedStatusCode, statusCode);
    }

    /**
     * This method allows to star a gist
     */
    @When("^the user wants to star his gist$")
    public void starAGist() {
        response = request.put(DELIMITER + EXISTING_GIST_ID + PATH_TO_STAR);
    }

    /**
     * This method allows to edit a gist
     */
    @When("^the user wants to edit his gist$")
    public void editAGist() {
        Gist gist = JsonUtils.readJsonSingleObject(GIST_MODIFIED_DATA_PATH, Gist.class);
        request.contentType(CONTENT_TYPE).
                body(gist);
        response = request.patch(DELIMITER + EXISTING_GIST_ID);
    }

}