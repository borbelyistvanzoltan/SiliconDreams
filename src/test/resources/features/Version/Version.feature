Feature: Version

  Scenario: Check version number

    Given Version number from JSON
    Then Compare the version number from JSON with the version number from the application
    Then Version number validation