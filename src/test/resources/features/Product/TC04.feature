Feature: Product

  @PRODUCT_TC04
  Scenario: Validate require fields while creating a new product
    Given user is on login page
    Then login with email and password
    Then navigate to All Products page
    Then navigate to New Product page from list view
    Then save new product
    Then Validation the error list while missing all fields
    Then fill required fields with Title: "ProzendaTermek1", Type: "", Amount units: ""
    Then save new product
    Then Validation the error list while missing type and amount units fields
    Then navigate to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product is exist: "false"
