Feature: user should be able to login to the system
  Background: user go to login page
    Given user go to login page

    #Valid Data Login Scenario
  Scenario: user login with valid email and password
    When When user enter "leqaahani@example.com" and "123456"
    And User click on login button
    Then User could login successfully and navigate to home page

    #Invalid Data Login Scenario
  Scenario: user login with invalid email and password
    When When user enter "user@examples.com" and "123456"
    And User click on login button
    Then User couldn't login successfully
