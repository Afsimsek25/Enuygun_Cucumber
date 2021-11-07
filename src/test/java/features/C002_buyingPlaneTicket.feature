Feature: Buying a plane ticket

  @Regression
  Scenario: Buying a plane ticket
    Given Navigate to Enuygun.com
    When User Find a Flights
    Then The user should be able to choose the plane they want
    Then User must be able to buy tickets