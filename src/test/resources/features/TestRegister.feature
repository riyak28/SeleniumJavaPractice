@Register
Feature: User Register


  @WithTstData
  Scenario: Register user with valid more details
    Given User opens browser and navigate to register page
    When User enters First Name as "Riyay",Last Name as "KALE",User Name as "RIYYA",Password as "INDIA"
    And Click on Register Button
    Then User should register successfully
