Feature: Login

  Scenario: Logging into website
    Given I open the browser
    Then Open automation website
    Then Login Button should be present
    Then I input the username
    Then I input the password
    Then I click on the login button
