Feature: Login Functionality

  @Smoke
  Scenario: Login with valid username and password
    Given Navigate to Enuygun.com
    When Enter username and password and click login button
    Then User should login successfully