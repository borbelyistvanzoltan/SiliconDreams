Feature: Partners

  @TC12
  Scenario: Second type - supplier, active switch on-off check, comment field check.
    Given Navigate to the partners module and click the all partners
    Then Create supplier
    Then Second type: check active switch on-off status in Receipt module
    Then Second type: back to edit partner
    Then Add new related partner and save without comment
    Then Fill the comment field
    Then Create partner - get the text from message - successful or unsuccessful
    Then Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful