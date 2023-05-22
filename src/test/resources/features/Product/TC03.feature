Feature: Product

  @PRODUCT_TC03
  Scenario: Check that a user can create normal product from list view
    Given user is on login page
    Then login with email and password
    Then navigate to All Products page
    Then navigate to New Product page from list view
    Then fill required fields with Title: "ProzendaTermek1", Type: "NORMAL", Amount units: "HOUR"
    Then save new product
    Then navigate back to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product is exist: "true"
    Then delete created products