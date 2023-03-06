Feature: Login negative

  Scenario: Check that a user can not login to the platform with invalid creadentials

    Given user is on login page
    Then login with email and password, invalid credentials