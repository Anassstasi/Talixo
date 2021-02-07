Feature: Registration

  @SmokeTest
  Scenario: [EPMFARMATS-4050] Registration with valid data
    Given the user opens Registration page
    When the user registers as "Ivan" from "valid.json" file on Registration Page
    Then the notification that the user is logged in should appear on Login Page

  @RegressionTest
  Scenario Outline: [EPMFARMATS-4051,4064] Registration with invalid data
    Given the user opens Registration page
    When the user registers as "<FirstName>" from "invalidFirstName.json" file on Registration Page
    Then the message 'Invalid format' should appear on Registration Page
    Examples:
      | FirstName |
      | 123       |
      | !@#$%     |
      | abc123    |