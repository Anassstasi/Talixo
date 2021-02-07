Feature: Http Client

  Scenario: Create a gist
    When the user create new gist
    Then the status code should be 201 Created

  Scenario: Edit a gist
    When the user edits a gist
    Then the status code should be 200 OK

  Scenario: Star a gist
    When the user stars a gist
    Then the status code should be 204 No Content

  Scenario: Unstar a gist
    When the user unstars a gist
    Then the status code should be 204 No Content

  Scenario: Delete a gist
    When the user deletes a gist
    Then the status code should be 204 No Content