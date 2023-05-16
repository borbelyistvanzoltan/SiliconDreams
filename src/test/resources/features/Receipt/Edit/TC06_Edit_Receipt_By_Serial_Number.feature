Feature: Receipt

  Scenario: Edit Customer receipt by click on serial number

    Given user is on login page
    Given login with email and password
    Given Wait for loading main page
    Given Navigate to list view
    When Click on first receipt serial number
    Then Wait for loading Receipt page
    Then Select "Teszt oktatási számla" bizonylattomb
    Then Type "Prozenda" into customer field
    Then Type "Késztermék teszt" into item field
    Then Select "Központi raktár"
    Then Save form
    Then Assert form saved successfully