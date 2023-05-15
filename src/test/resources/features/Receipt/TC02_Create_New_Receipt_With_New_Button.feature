Feature: Receipt

  Scenario: Create receipt with New button with mandatory fields, assert successfully response message

    Given user is on login page
    Given login with email and password
    Given Wait for loading main page
    When Move over New button
    When Move over Sale in New button sub menu
    When Click on New customer receipt in New button sub menu
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