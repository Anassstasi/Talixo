Feature: Login

  @SmokeTest
  Scenario Outline: [EPMFARMATS-3976] Sign in to Talixo
    Given the user opens Login page
    Then the user sees login form
    When the user performs login with "<username>" and "<password>"
    Then the notification that the user is logged in should appear on Login Page
    Examples:
      | username             | password |
      | helloworld@gmail.com | 1qazxsw2 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-4014] Sign in to Talixo with incorrect EMAIL
    Given the user opens Login page
    Then the user sees login form
    When the user performs login with "<username>" and "<password>"
    Then "<username>" error should appear on Login Page
    Examples:
      | username   | password |
      | helloworld | 1qazxsw2 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-4015] Sign in to Talixo with incorrect password
    Given the user opens Login page
    Then the user sees login form
    When the user performs login with "<username>" and "<password>"
    Then "<password>" error should appear on Login Page
    Examples:
      | username             | password |
      | helloworld@gmail.com | 12345    |

  @SmokeTest
  Scenario: [EPMFARMATS-3975] Sign out from Talixo
    Given the user logs in to Talixo on Login Page
    When the user logs out talixo on Login Page
    Then the title "Book Taxis and Limousines Online - Talixo" appears on the Home page