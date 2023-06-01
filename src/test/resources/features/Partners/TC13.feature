Feature: Partners

  @TC13
  Scenario: Third type - private partner, active switch on-off check, comment field check.
    Given Navigate to the partners module and click the all partners
    Then Create private partner
    Then Third type: check active switch on-off status in Receipt module
    Then Third type: back to edit partner
    Then Add new related partner and save without comment
    Then Fill the comment field
    Then Create partner - get the text from message - successful or unsuccessful
    Then Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful