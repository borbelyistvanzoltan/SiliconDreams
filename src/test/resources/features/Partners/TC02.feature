Feature: Click new private partner from New button and save without data then create new partner

  @TC02
  Scenario: Create new private partner from New button
    Given Navigate to the new private partner from New button
    Then Validation the error list
    Given Entering the personal data
    Then Create partner - get the text from message - successful or unsuccessful
    Then Created new private partner validation
    Given Delete partner
    Then Delete partner - get the text from message - successful or unsuccessful
    Then Check the delete
