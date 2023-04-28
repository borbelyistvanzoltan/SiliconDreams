Feature: Create a new corporate customer partner

  @TC_02
  Scenario: Create new partner, who is corporate and customer
    Given Navigate to the partners module and click the all partners
    Given Create new partner
    Then Create partner - get the text from message - successful or unsuccessful
    Then Check the created partner
    Given Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete