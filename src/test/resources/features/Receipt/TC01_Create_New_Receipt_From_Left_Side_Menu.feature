Feature: Receipt

  Scenario: Create receipt from left side menu with mandatory fields, assert successfull response message

    Given user is on login page
    Given login with email and password
    Given Wait for loading main page
    Then Click on Sale on the left menu
    Then Click on New customer receipt
    Then Wait for loading data sheet chooser
    Then Select "Teszt Vevőszámla Adatlap" from dropdown list
    Then Click Ok button
    Then Wait for loading Receipt page
    Then Select "Teszt számla" bizonylattomb
    Then Type "Prozenda" into customer field
    Then Type "Késztermék teszt" into item field
    Then Select "Központi raktár"
    Then Save form
    Then Assert form saved successfully
    Then Navigate back to list view
    Then Click on three dots and delete newly created receipt
    Then Assert receipt deleted successfully