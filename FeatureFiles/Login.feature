Feature: All login page scenarios.

  Scenario: To test login functionality with valid username and password.

    Given user is on loginpage
    #When user enters valid username and password
    When user enters "admin" and "admin"
    And clicks on login button
    Then  user should be redirected to Home page.

  Scenario: To test login functionality with invalid username and password.

    Given user is on loginpage
    #When user enters invalid username and password
    When user enters "ddefrs" and "klopiu"
    And clicks on login button
    Then  user should get error.

  Scenario: To test login functionality with blank inputs.

    Given user is on loginpage
    #When user enters blank username and password
    When user enters "" and ""
    And clicks on login button
    Then  user should get error on the page.

    @UserReg
    Scenario: To test user registration form

      Given user is in registration page
       When user enters below data
         | Shobithjl123@gmail.com | Santosh789# | Santosh789# |
      And clicks on Register button
      Then user should be added



