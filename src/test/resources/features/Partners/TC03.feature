Feature: Partners

  @TC03
  Scenario: Create new private partner from list view (validation for save it empty)
    Given Navigate to the new private partner from list view
    Then Validation the error list
    Then Entering the personal data
    Then Create partner - get the text from message - successful or unsuccessful
    Then Created new private partner validation
    Then Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete