Feature: Product

  @TC01_service_product
  Scenario: Check that a user can create service product
    Given user is on login page
    Then login with email and password
    Then navigate to New Product page
    Then fill required fields with Title: "ProzendaTermek1", Type: "SERVICE", Amount units: "HOUR"
    Then save new product
    Then navigate back to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product created
    Then delete created products