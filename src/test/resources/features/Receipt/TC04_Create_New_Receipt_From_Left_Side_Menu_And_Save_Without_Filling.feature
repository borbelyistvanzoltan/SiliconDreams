Feature: Receipt

  Scenario: Create receipt from left side menu and try to save without any data, expecting alert message/form

    Given user is on login page
    Given login with email and password
    Given Wait for loading main page
    Given Wait for loading main page
    Then Click on Sale on the left menu
    Then Click on New customer receipt
    Then Select default data sheet
    Then Wait for loading Receipt page
    Then Save form
    Then Asserting alert form