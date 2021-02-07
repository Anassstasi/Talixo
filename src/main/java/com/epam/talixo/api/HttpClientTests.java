package com.epam.talixo.api;

import com.epam.talixo.api.steps.HttpClientSteps;
import org.junit.Test;

import java.io.IOException;

public class HttpClientTests {

    private HttpClientSteps steps = new HttpClientSteps();

    @Test
    public void createGistFromFile() throws IOException {
        steps.createGist();
        steps.isStatusCodeCREATED();
    }

    @Test
    public void editGistPatch() throws IOException {
        steps.editGist();
        steps.isStatusCodeOK();
    }

    @Test
    public void starGist() throws IOException {
        steps.starGist();
        steps.isStatusCodeNO_CONTENT();
    }

    @Test
    public void unstarGist() throws IOException {
        steps.unstarGist();
        steps.isStatusCodeNO_CONTENT();
    }

    @Test
    public void deleteGist() throws IOException {
        steps.deleteGist();
        steps.isStatusCodeNO_CONTENT();
    }

}