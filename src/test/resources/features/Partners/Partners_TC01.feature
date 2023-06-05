Feature: Partners

  @Partners_TC01
  Scenario: View the partners, create partner, edit, delete the partner
    Given Version number from JSON
    Then Compare the version number from JSON with the version number from the application
    Then Version number validation
    Then Navigate the users permission
    Then Give the user all permission
    Given Navigate to the partners module and click the all partners
    Then View the partners list
    Then Create new partner
    Then Create partner - get the text from message - successful or unsuccessful
    Then Edit the partner
    Then Edit partner - get the text from message - successful or unsuccessful
    Then Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete