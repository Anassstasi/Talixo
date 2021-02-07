Feature: Rest Assured

  Background:
    Given the user creates a request and authenticates his account

  Scenario: Add a gist
    When the user creates a gist
    Then he expects status code 201

  Scenario: Star a gist
    When the user wants to star his gist
    Then he expects status code 204

  Scenario: Patch a gist
    When the user wants to edit his gist
    Then he expects status code 200

  Scenario: Delete a gist
    When the user deletes the gist
    Then he expects status code 204