Feature: User Register
  Scenario: Register user with valid details
    Given User opens browser and navigate to register page.
    When User enters First Name,Last Name,User Name,Password
    And Click on Register Button.
    Then User should register successfully
