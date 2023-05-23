Feature: Partners

  @TC10
  Scenario: Create new customer from list view with required field validation
    Given Navigate to the partners module and click the all partners
    Then Create new customer from list view
    Then Check error message
    Then Check required fields - partner name
    Then Check required fields - partner id
    Then Check required fields - membership, domestic
    Then Check required fields - membership, EU
    Then Check required fields - membership, non EU
    Then Check required fields - type
    Then Check created new customer
    Then Check the delete