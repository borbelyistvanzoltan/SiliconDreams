Feature: Receipt

  Scenario: Create customer receipt without all mandatory fields

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
    Then Save form
    Then Asserting alert form