Feature: Product

  @PRODUCT_TC07
  Scenario: Attach a file successfully
    Given user is on login page
    Then login with email and password
    Then navigate to New Product page
    Then fill required fields with Title: "ProzendaTermek1", Type: "NORMAL", Amount units: "HOUR"
    Then Navigate to attach tab
    Then Upload a file successfully
    Then save new product
    Then navigate back to All Products page
    Then filter "ProzendaTermek1" on "TITLE" column filter
    Then check "ProzendaTermek1" product is exist: "true"
    Then Click on first product name
    Then Navigate to attach tab
    Then Check "product-file-upload" file is attached
    Then navigate to All Products page
    Then delete created products