Feature: Partners

  @TC07
  Scenario: Delete from list view
    Given Navigate to the partners module and click the all partners
    Then Create new partner
    Then Create partner - get the text from message - successful or unsuccessful
    Then Filter by name and click delete from actions menu
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete