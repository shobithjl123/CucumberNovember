Feature: All add user related scenarios

  Background: login Scenario.

    Given user is on loginpage
    #When user enters valid username and password
    When user enters "admin" and "admin"
    And clicks on login button
    Then  user should be redirected to Home page.


  @AddClientParam
  Scenario Outline:To test the add button on add client page
    Given im on Add client page
    When i enter <name>, <address>,<contact1>,<contact2>
    And i click on Add button
    Then User should be added
    Examples:
      | name     | address    | contact1 | contact2 |
      | Revanth  | SouthKorea | 12232    | 334444   |
      | Kumar    | Bombay     | 56677    | 123344   |
      | Nagaraja | Karnataka  | 26373    | 131223   |