Feature: Spring RestTemplate

  Background:
    Given the user authorizes and creates a new gist

  Scenario: Delete a gist
    When  they delete the gist
    Then the status code 204 appears; the gist is deleted

  Scenario: Create a gist
    Then the status code 201 appears; the gist is created
    When they delete the gist

  Scenario: Edit  gist`s description
    When they change the description of the gist
    Then the status code 200 appears; the gist is updated
    When they delete the gist

  Scenario: Star a gist
    When they star a gist
    Then the status code 204 appears; the gist is stared
    When they delete the gist