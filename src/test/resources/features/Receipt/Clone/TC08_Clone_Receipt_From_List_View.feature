Feature: Receipt

  Scenario: Clone Customer receipt

    Given user is on login page
    Given login with email and password
    Given Wait for loading main page
    Given Navigate to list view
    When Click on three dots and clone on first receipt
    Then Wait for loading Receipt page
    Then Save form
    Then Assert form saved successfully