Feature: Partners

  @TC06
  Scenario: Cloning from list view
    Given Navigate to the partners module and click the all partners
    Then Create new partner
    Then Create partner - get the text from message - successful or unsuccessful
    Then Click on clone from actions menu
    Then Create new partner by clone
    Then Check the cloned partner
    Then Delete the cloned partner
    Then Delete partner