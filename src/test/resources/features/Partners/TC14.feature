Feature: Partners

  @TC14
  Scenario: Add the same related partner multiple times with the same type
    Given Navigate to the partners module and click the all partners
    Then Create new private partner and related partner
    Then Add created related partner to created private partner
    Then Add second related partner - same related partner
    Then The same related partner save - warning message validation
    Then Delete created partner and related partner