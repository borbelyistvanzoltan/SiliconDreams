Feature: Partners

  @TC04
  Scenario: Open edit from list view by clicking name
    Given Navigate to the partners module and click the all partners
    Then Create new partner
    Then Create partner - get the text from message - successful or unsuccessful
    Then Click on created partner name
    Then Editing check
    Then Edit the company id
    Then Check the edited partner company id
    Then Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete