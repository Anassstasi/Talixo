package com.epam.talixo.api.steps;

import com.epam.talixo.api.entities.Gist;
import com.epam.talixo.api.entities.GitHubUser;
import com.epam.talixo.framework.utils.JsonUtils;
import com.gargoylesoftware.htmlunit.HttpHeader;
import com.google.gson.Gson;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.net.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpClientSteps {

    private final static String API_BASE = "https://api.github.com/gists";
    private final static String HTTP_GIST_ID = API_BASE + "/%s";
    private final static String HTTP_STAR_GIST = API_BASE + "/%s/star";
    private final static String COLON = ":";
    private final static String BASIC_ = "Basic ";
    private final static String APPLICATION_JSON_HEADER_VALUE = "application/json";
    private final static String GIST_DATA_FILE = "/testData/api/Gist.json";
    private final static String MODIFIED_GIST_DATA_FILE = "/testData/api/ModifiedGist.json";
    private final static String USER_DATA_FILE = "/testData/api/User.json";
    private static HttpResponse response;
    private final Logger logger = LogManager.getLogger();

    @When("^the user create new gist$")
    public void createGist() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(API_BASE);
        authorization(httpPost);
        String jsonStringGist = getJsonStringGist(GIST_DATA_FILE);
        StringEntity entity = new StringEntity(jsonStringGist);
        httpPost.setEntity(entity);
        httpPost.setHeader(HttpHeader.ACCEPT, APPLICATION_JSON_HEADER_VALUE);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE);
        response = httpClient.execute(httpPost);
    }

    @When("^the user edits a gist$")
    public void editGist() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String firstGistID = getFirstGistID(httpClient);
        HttpPatch httpPatch = new HttpPatch(String.format(HTTP_GIST_ID, firstGistID));
        authorization(httpPatch);
        String jsonStringGist = getJsonStringGist(MODIFIED_GIST_DATA_FILE);
        StringEntity entity = new StringEntity(jsonStringGist);
        httpPatch.setEntity(entity);
        httpPatch.setHeader(HttpHeader.ACCEPT, APPLICATION_JSON_HEADER_VALUE);
        httpPatch.setHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE);
        response = httpClient.execute(httpPatch);
    }

    @When("^the user stars a gist$")
    public void starGist() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String firstGistID = getFirstGistID(httpClient);
        HttpPut httpPut = new HttpPut(String.format(HTTP_STAR_GIST, firstGistID));
        authorization(httpPut);
        response = httpClient.execute(httpPut);
    }

    @When("^the user unstars a gist$")
    public void unstarGist() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String firstGistID = getFirstGistID(httpClient);
        HttpDelete httpDelete = new HttpDelete(String.format(HTTP_STAR_GIST, firstGistID));
        authorization(httpDelete);
        response = httpClient.execute(httpDelete);
    }

    @When("^the user deletes a gist$")
    public void deleteGist() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String firstGistID = getFirstGistID(httpClient);
        HttpDelete httpDelete = new HttpDelete(String.format(HTTP_GIST_ID, firstGistID));
        authorization(httpDelete);
        response = httpClient.execute(httpDelete);
    }

    @Then("^the status code should be 200 OK$")
    public void isStatusCodeOK() {
        Assert.assertEquals("Status Code is not [200 OK].", response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Then("^the status code should be 201 Created$")
    public void isStatusCodeCREATED() {
        Assert.assertEquals("Status Code is not [201 Created].", response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Then("^the status code should be 204 No Content$")
    public void isStatusCodeNO_CONTENT() {
        Assert.assertEquals("Status Code is not [204 No Content].", response.getStatusLine().getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    private void authorization(HttpUriRequest http) {
        GitHubUser user = JsonUtils.readJsonSingleObject(USER_DATA_FILE, GitHubUser.class);
        String userData = user.getUsername() + COLON + user.getPassword();
        byte[] encodedAuth = Base64.encodeBase64(userData.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = BASIC_ + new String(encodedAuth);
        http.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
    }

    private String getFirstGistID(CloseableHttpClient httpClient) throws IOException {
        HttpGet httpGet = new HttpGet(API_BASE);
        authorization(httpGet);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity gistEntity = response.getEntity();
        String json = EntityUtils.toString(gistEntity, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        Gist[] gists = gson.fromJson(json, Gist[].class);
        String firstGistID = null;
        try {
            firstGistID = gists[0].getId();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.info("No gists!");
            logger.error(e.getMessage());
        }

        return firstGistID;
    }

    private String getJsonStringGist(String dataFile) {
        Gist gist = JsonUtils.readJsonSingleObject(dataFile, Gist.class);
        Gson gson = new Gson();
        return gson.toJson(gist);
    }

}