Feature: Product

  @PRODUCT_TC10
  Scenario: Cloning from list view
    Given user is on login page
    Then login with email and password
    Then navigate to New Product page
    Then Create new product with Title: "ProzendaTermek1", Type: "NORMAL", Amount units: "HOUR"
    Then navigate back to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product is exist: "true"
    Then Clone the product from actions menu with Title: "ProzendaTermek1Cloned", Product code: "TC10"
    Then navigate back to All Products page
    Then filter "ProzendaTermek1Cloned" on "TITLE" column filter
    Then check "ProzendaTermek1" product is exist: "true"
    Then delete created products