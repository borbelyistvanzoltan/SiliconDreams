Feature: Partners

  @TC05
  Scenario: Open edit from list view by clicking on the actions menu
    Given Navigate to the partners module and click the all partners
    Then Create new partner
    Then Create partner - get the text from message - successful or unsuccessful
    Then Edit the partner from actions menu
    Then Editing check
    Then Edit the company id
    Then Check the edited partner company id
    Then Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete