Feature: Product

  @PRODUCT_import
  Scenario: Check that a user can import products
    Given user is on login page
    Then login with email and password
    Then navigate to All Products page
    Then import products
    Then check successfully imported "5" product
    Then jump to products list
    Then check "ProzendaTermek1" product created: "true"
    Then check "ProzendaTermek2" product created: "true"
    Then check "ProzendaTermek3" product created: "true"
    Then check "ProzendaTermek4" product created: "true"
    Then check "ProzendaTermek5" product created: "true"
    Then delete created products