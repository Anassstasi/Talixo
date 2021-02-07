package com.epam.talixo.api.steps;

import com.epam.talixo.api.entities.Gist;
import com.epam.talixo.api.entities.GitHubUser;
import com.epam.talixo.framework.utils.JsonUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class SpringRestTemplateSteps {

    private static final String API_BASE = "https://api.github.com/%s";
    private static final String GIST_DATA_PATH = "/testData/api/Gist.json";
    private static final String USER_DATA_PATH = "/testData/api/User.json";
    private static final String GIST_MODIFIED_DATA_PATH = "/testData/api/ModifiedGist.json";
    private static final String AUTHORIZATION = "Authorization";
    private static final String PATH_TO_STAR = "/star";
    private static final String AUTHORIZATION_TYPE = "Basic ";
    private static final String PATH_TO_GISTS = "gists";
    private static final String DELIMITER = "/";
    private static final String DELIMITER2 = ":";
    private static final String GIST_ID_PARAMETER = "id";

    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response;
    private ResponseEntity<String> starResponse;
    private String gistId;

    @Then("^the status code (\\d+) appears; the gist is (?:updated|deleted|created|stared)$")
    public void isStatusCodeCorrect(int statusCode) {
        assertEquals("The state of the gist isn`t changed", statusCode, response.getStatusCode().value());
    }

    /**
     * Method allows to authorize to gitHub with UserName and Password
     *
     * @return httpHeaders with authorization
     */
    public HttpHeaders authorize() {
        GitHubUser gitHubUser = JsonUtils.readJsonSingleObject(USER_DATA_PATH, GitHubUser.class);
        String notEncoded = gitHubUser.getUsername() + DELIMITER2 + gitHubUser.getPassword();
        String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, AUTHORIZATION_TYPE + encodedAuth);
        return headers;
    }

    /**
     * Method allows to delete a gist
     */
    @When("^they delete the gist$")
    public void deleteGist() {
        HttpHeaders headers = authorize();
        HttpEntity<Gist> entity = new HttpEntity<>(headers);
        response = restTemplate.exchange(String.format(API_BASE, PATH_TO_GISTS + DELIMITER + gistId),
                HttpMethod.DELETE, entity, String.class);
    }

    /**
     * Method allows to create a gist
     */
    @Given("^the user authorizes and creates a new gist$")
    public void createGist() {
        HttpHeaders headers = authorize();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Gist gist = JsonUtils.readJsonSingleObject(GIST_DATA_PATH, Gist.class);
        HttpEntity<Gist> request = new HttpEntity<>(gist, headers);
        response = restTemplate.postForEntity(String.format(API_BASE, PATH_TO_GISTS), request, String.class);
        JSONObject userJson = new JSONObject(Objects.requireNonNull(response.getBody()));
        gistId = (String) userJson.get(GIST_ID_PARAMETER);
    }

    /**
     * Method allows to edit the description of the gist
     */
    @When("^they change the description of the gist$")
    public void editGistDescription() {
        Gist gist = JsonUtils.readJsonSingleObject(GIST_MODIFIED_DATA_PATH, Gist.class);
        HttpClient httpClient = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
        List<MediaType> acceptTypes = new ArrayList<>();
        acceptTypes.add(MediaType.APPLICATION_JSON_UTF8);
        HttpHeaders reqHeaders = authorize();
        reqHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        reqHeaders.setAccept(acceptTypes);
        HttpEntity<Gist> httpEntity = new HttpEntity<>(gist, reqHeaders);
        response = restTemplate.exchange(String.format(API_BASE, PATH_TO_GISTS + DELIMITER + gistId),
                HttpMethod.PATCH, httpEntity, String.class);
    }

    /**
     * Method allows to star s gist
     */
    @When("^they star a gist$")
    public void starAGist() {
        HttpHeaders reqHeaders = authorize();
        reqHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Gist> requestEntity = new HttpEntity<>(reqHeaders);
        response = restTemplate.exchange(String.format(API_BASE, PATH_TO_GISTS + DELIMITER + gistId + PATH_TO_STAR),
                HttpMethod.PUT, requestEntity, String.class);
        starResponse = restTemplate.exchange(String.format(API_BASE, PATH_TO_GISTS + DELIMITER + gistId + PATH_TO_STAR),
                HttpMethod.GET, requestEntity, String.class);
        response = starResponse;
    }

}