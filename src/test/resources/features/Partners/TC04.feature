Feature: Open edit form by clicking partner name

  @TC04
  Scenario: Open edit from list view by clicking name
    Given Navigate to the partners module and click the all partners
    Given Create new partner
    Then Create partner - get the text from message - successful or unsuccessful
    Given Click on created partner name
    Then Editing check
    Given Edit the company id
    Then Check the edited partner company id
    Given Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete