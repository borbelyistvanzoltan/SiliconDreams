Feature: Product

  @PRODUCT_TC05
  Scenario: Open edit from list view by clicking name
    Given user is on login page
    Then login with email and password
    Then navigate to New Product page
    Then Create new product with Title: "ProzendaTermek1", Type: "NORMAL", Amount units: "HOUR"
    Then navigate back to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product is exist: "true"
    Then Click on first product name
    Then edit product name to "ProzendaTermekEdited"
    Then navigate back to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product is exist: "false"
    Then filter "ProzendaTermekEdited" on "TITLE" column filter
    Then check "ProzendaTermekEdited" product is exist: "true"
    Then delete created products