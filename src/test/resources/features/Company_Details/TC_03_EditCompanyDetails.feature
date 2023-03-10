Feature: Company details

  Scenario: TC_03
    Given user is on login page
    Given login with email and password
    Given Wait for loading main page
    Then Navigate to Settings-Company details
    Then Click on Addresses
    Then Create a new address with mandatory fields: "8660", "Lulla", "Dózsa", "utca"
    Then Click save button
    Then Check new address created: "8660", "Lulla", "Dózsa"
    Then Delete newly created address