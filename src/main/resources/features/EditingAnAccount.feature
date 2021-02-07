@RegressionTest
Feature: Edit an account

  Background:
    Given the user logs in to Talixo on Login Page
    When the user clicks on 'MY SETTINGS' on the Home page

  Scenario: [EPMFARMATS-3919] Edit contact details (first name)
    And the user changes first name in the input 'First Name' in the Contact Details Table on the Setting page
    Then the first name should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-3920] Edit password
    And the user changes password"1qazxsw2" to "1qazxsw1" and repeats new password entering "1qazxsw1"
    Then the user can login using old e-mail "helloworld@gmail.com" and new password "1qazxsw1" on the Login page
    When return old password

  Scenario: [EPMFARMATS-3921] Add favourite addresses
    And the user adds a new address "Astana" to Favourite addresses Table on the Setting page
    Then the address "Astana" should be added to the Favourite addresses Table on the Setting page

  Scenario: [EPMFARMATS-3922] Search address in Favourite addresses
    And the user adds a new address "Astana" to Favourite addresses Table on the Setting page
    And the user searches the address "Astana" in the field 'Address' in the Favourite addresses Table on the Setting page
    Then the address "Astana" should be displayed in the Favourite addresses Table on the Setting page

  Scenario: [EPMFARMATS-4020] Edit contact details (last name)
    And the user changes last name on the Setting page
    Then the last name should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-4021] Edit contact details (E-mail)
    And the user changes email in the input 'E-mail' in the Contact Details Table on the Setting page
    Then the email should be changed in the Contact Details Table on the Setting page
    When return old e-mail

  Scenario: [EPMFARMATS-4022] Edit contact details (company name)
    And the user changes company name in the input 'Company name' in the Contact Details Table on the Setting page
    Then the company name should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-4023] Edit contact details (STREET)
    And the user changes street in the input 'Street' in the Contact Details Table on the Setting page
    Then the street should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-4024] Edit contact details (TOWN)
    And the user changes town in the input 'Town' in the Contact Details Table on the Setting page
    Then the town should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-4025] Edit contact details (zip code)
    And the user changes zip code in the input 'Zip code' in the Contact Details Table on the Setting page
    Then the zip code should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-4026] Edit contact details (COUNTRY)
    And the user changes country in the input 'Country' in the Contact Details Table on the Setting page
    Then the country should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-4027] Edit contact details (mobile number)
    And the user changes mobile number in the input 'Mobile' in the Contact Details Table on the Setting page
    Then the mobile number should be changed in the Contact Details Table on the Setting page

  Scenario: [EPMFARMATS-4037] Edit password with false old password
    And the user enters incorrect old password "12345" to change it to "1qazxsw1" and enters "1qazxsw1" to repeat the password
    Then the error message 'Old password is incorrect' should be displayed near old password field in the Change Password Table on the Setting page

  Scenario: [EPMFARMATS-4038] Edit password with not match new password
    And the user enters the password "1qazxsw2" to change it to "1qazxsw1" and enters "12345" to repeat the password
    Then the error message 'Password does not match' should be displayed near 'Repeat new password' field in the Change Password Table on the Setting page