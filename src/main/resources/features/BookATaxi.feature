Feature: Book a taxi

  Background:
    Given the user logs in to Talixo on Login Page

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3972] Booking a taxi after logging in for 2 people with 2 bags for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy car on the second Booking page
    And the user sets payment details on the third Booking page
      | cardNumber | 0000 0000 0000 0001 |
      | holderName | Test User           |
      | month      | 2                   |
      | year       | 2020                |
      | cvc        | 111                 |
    And the user should select 'I accept conditions of transport' check box on the third Booking page
    And the user clicks on 'Book' button on the third Booking page
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3991] Booking a taxi after logging in for 2 people with 2 bags for tomorrow when checkbox isn`t selected
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy car on the second Booking page
    And the user sets payment details on the third Booking page
      | cardNumber | 0000 0000 0000 0001 |
      | holderName | Test User           |
      | month      | 2                   |
      | year       | 2020                |
      | cvc        | 111                 |
    And the user clicks on 'Book' button on the third Booking page
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3992] Booking a taxi after logging in for 2 people with 2 bags without entering any payment details for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy car on the second Booking page
    And the user should select 'I accept conditions of transport' check box on the third Booking page
    And the user clicks on 'Book' button on the third Booking page
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3973] Booking a taxi after logging in for 8 adult people with 8 bags, 2 children, 4 animals for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user fills options for booking a taxi on the Home page
      | adults       | 7 |
      | bags         | 8 |
      | sportLuggage | 0 |
      | animals      | 4 |
      | child3_6yo   | 1 |
      | child6_12yo  | 1 |
    And the user clicks on 'Start booking' button on the Home page
    Then the 'No Needed Car' message should be displayed on the second Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3974] Booking a taxi after logging in for 4 adult people with 8 bags and 3 sport equipment for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user fills options for booking a taxi on the Home page
      | adults       | 3 |
      | bags         | 8 |
      | sportLuggage | 3 |
      | animals      | 0 |
      | child3_6yo   | 0 |
      | child6_12yo  | 0 |
    And the user clicks on 'Start booking' button on the Home page
    Then the 'Maximum capacity' message should be displayed on the Home page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario: [EPMFARMATS-3996] Booking a taxi after logging in for 2 adults with 2 bags for today but for the past
    When the user starts booking a taxi for today on the Home page
      | pickUpAddress      | Disneyland Paris Airport (DLP), All terminals, exit after baggage claim |
      | flightNumber       | AB 194                                                                  |
      | departureCity      | Berlin                                                                  |
      | destinationAddress | Paris, Disneyland Paris, Coupvray, France                               |
      | time               | 00:00                                                                   |
    Then the 'Booking Sixty Minutes In Future' message should be displayed on the Home page

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3997] Booking a taxi after loging in for 2 adults with 2 bags for tomorrow for the route between 2 different countries
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user clicks on 'Start booking' button on the Home page
    Then the 'No Route' message should be displayed on the Home page
    Examples:
      | pickUpAddress                                   | destinationAddress                                                       | time  |
      | Paris, Disneyland Paris, 77700 Coupvray, France | Walt Disney World Airport (DWS), All terminals, exit after baggage claim | 00:00 |

  @SmokeTest
  Scenario Outline: [EPMFARMATS-3977] Booking a taxi after logging in for 1 person with an animal for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user fills options for booking a taxi on the Home page
      | adults       | 0 |
      | bags         | 0 |
      | sportLuggage | 1 |
      | animals      | 1 |
      | child3_6yo   | 0 |
      | child6_12yo  | 0 |
    And the user clicks on 'Start booking' button on the Home page
    Then the 'No Needed Car' message should be displayed on the second Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3978] Booking a taxi after logging in for 2 adults with 2 children for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user fills options for booking a taxi on the Home page
      | adults       | 1 |
      | bags         | 0 |
      | sportLuggage | 0 |
      | animals      | 0 |
      | child3_6yo   | 1 |
      | child6_12yo  | 1 |
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy car on the second Booking page
    And the user sets payment details on the third Booking page
      | cardNumber | 0000 0000 0000 0001 |
      | holderName | Test User           |
      | month      | 2                   |
      | year       | 2020                |
      | cvc        | 111                 |
    And the user should select 'I accept conditions of transport' check box on the third Booking page
    And the user clicks on 'Book' button on the third Booking page
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3979] Booking a taxi after logging in for 2 adults with 3 equipments for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user fills options for booking a taxi on the Home page
      | adults       | 1 |
      | bags         | 0 |
      | sportLuggage | 3 |
      | animals      | 0 |
      | child3_6yo   | 0 |
      | child6_12yo  | 0 |
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    Then the 'No Needed Car' message should be displayed on the second Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3980] Booking a taxi after logging in for 2 adults with 1 equipments for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user fills options for booking a taxi on the Home page
      | adults       | 1 |
      | bags         | 0 |
      | sportLuggage | 1 |
      | animals      | 0 |
      | child3_6yo   | 0 |
      | child6_12yo  | 0 |
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy VAN car on the second Booking page
    And the user sets payment details on the third Booking page
      | cardNumber | 0000 0000 0000 0001 |
      | holderName | Test User           |
      | month      | 2                   |
      | year       | 2020                |
      | cvc        | 111                 |
    And the user should select 'I accept conditions of transport' check box on the third Booking page
    And the user clicks on 'Book' button on the third Booking page
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-3993] Booking a taxi after logging in for 2 people with 2 bags using expire card for tomorrow
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy car on the second Booking page
    And the user sets payment details on the third Booking page
      | cardNumber | 0000 0000 0000 0001 |
      | holderName | Test User           |
      | month      | 2                   |
      | year       | 2016                |
      | cvc        | 111                 |
    And the user should select 'I accept conditions of transport' check box on the third Booking page
    And the user clicks on 'Book' button on the third Booking page
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |

  @SmokeTest
  Scenario Outline: [EPMFARMATS-3998] Per-hour booking a taxi after logging in for 2 adults with 2 bags from one country
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user selects per-hour booking on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    Then the 'Longer than seven hours' message should be displayed on the Home page
    Examples:
      | pickUpAddress                                   | destinationAddress                                                       | time  |
      | Paris, Disneyland Paris, 77700 Coupvray, France | Walt Disney World Airport (DWS), All terminals, exit after baggage claim | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-4004] Per-hour booking a taxi after logging in for 2 adults with 2 bags for the distance less than 25km
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user selects per-hour booking on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy car on the second Booking page
    And the user sets payment details on the third Booking page
      | cardNumber | 0000 0000 0000 0001 |
      | holderName | Test User           |
      | month      | 2                   |
      | year       | 2016                |
      | cvc        | 111                 |
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                      | destinationAddress                              | time  |
      | 12 Rue Halévy, 75009 Paris, France | 28 Boulevard des Capucines, 75009 Paris, France | 10:00 |

  @RegressionTest
  Scenario Outline: [EPMFARMATS-4003] Per-hour booking a taxi after logging in for 2 adults with 2 bags for the distance more than 25km
    When the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user selects per-hour booking on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    Then the 'Maximum distance for one hour' message should be displayed on the Home page
    Examples:
      | pickUpAddress                         | destinationAddress            | time  |
      | 145 Rue Cardinet, 75017 Paris, France | 77777 Marne-la-Vallée, France | 10:00 |

  @SmokeTest
  Scenario Outline: [EPMFARMATS-3994] Booking a taxi after logging in for 2 adults with 2 bags for today for now
    When the user starts booking a taxi for 2 people with 2 bags for today with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user clicks on 'Start booking' button on the Home page
    Then the 'No available cars' message should be displayed on the Home page
    Examples:
      | pickUpAddress                      | destinationAddress                              | time |
      | 12 Rue Halévy, 75009 Paris, France | 28 Boulevard des Capucines, 75009 Paris, France | Now  |

  @SmokeTest
  Scenario Outline: [EPMFARMATS-4005] Booking a taxi without logging in for 2 adults with 2 bags for tomorrow
    When the user logs out talixo on Login Page
    And the user starts booking a taxi for tomorrow with "<pickUpAddress>", "<destinationAddress>" and "<time>" on the Home page
    And the user closes infobox on the Home page
    And the user clicks on 'Start booking' button on the Home page
    And the user chooses an Economy car on the second Booking page
    And the user fills personal information fields on the third Booking page
      | firstName   | Test           |
      | lastName    | User           |
      | prefixPhone | +49            |
      | phoneNumber | 35346456       |
      | email       | dg@example.com |
    And the user selects 'I am a new customer' checkbox on the third Booking page
    And the user sets payment details on the third Booking page
      | cardNumber | 0000 0000 0000 0001 |
      | holderName | Test User           |
      | month      | 2                   |
      | year       | 2020                |
      | cvc        | 111                 |
    And the user should select 'I accept conditions of transport' check box on the third Booking page
    And the user should select 'I acknowledge and accept Data Protection Declaration' checkbox on the third Booking page
    And the user should select 'I accept and acknowledge General Terms and Conditions' checkbox on the third Booking page
    And the user clicks on 'Book' button on the third Booking page
    Then the 'Invalid card number' message should be displayed on the third Booking page
    Examples:
      | pickUpAddress                                          | destinationAddress                        | time  |
      | Paris Bercy Station, Boulevard de Bercy, Paris, France | Paris, Disneyland Paris, Coupvray, France | 10:00 |