Feature: Receipt

  Scenario: Create new customer receipt from list view with plus button with mandatory fields, assert successfully response message

    Given user is on login page
    Given login with email and password
    Given Wait for loading main page
    Given Navigate to list view
    When Click on + button in list view
    Then Wait for loading data sheet chooser
    Then Select "Teszt Vevőszámla Adatlap" from dropdown list
    Then Click Ok button
    Then Wait for loading Receipt page
    Then Select "Teszt számla" bizonylattomb
    Then Type "Prozenda Hungary Kft." into customer field
    Then Type "Késztermék teszt" into item field
    Then Select "Központi raktár"
    Then Save form
    Then Assert form saved successfully
    Then Navigate back to list view
    Then Click on three dots and delete newly created receipt
    Then Assert receipt deleted successfully