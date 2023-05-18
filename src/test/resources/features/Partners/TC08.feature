Feature: Partners

  @TC08
  Scenario: Create a new customer from the left menu (validation - save as empty), required fields check.
    Given Navigate to new customer from left menu
    Then Check error message
    Then Check required fields - partner name
    Then Check required fields - partner id
    Then Check required fields - membership, domestic
    Then Check required fields - membership, EU
    Then Check required fields - membership, non EU
    Then Check required fields - type
    Then Check the delete