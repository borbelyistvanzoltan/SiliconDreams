Feature: Product

  @PRODUCT_TC02
  Scenario: Check that a user can create normal product from new button
    Given user is on login page
    Then login with email and password
    Then navigate to New Product page from New button
    Then fill required fields with Title: "ProzendaTermek1", Type: "NORMAL", Amount units: "HOUR"
    Then save new product
    Then navigate back to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product created
    Then delete created products