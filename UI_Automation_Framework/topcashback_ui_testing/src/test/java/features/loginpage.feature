 Feature: LoginPage Tests  
  Scenario: Verify user can log in using "Log In"
    Given I am on the TopCashback page
    When I click on the "Log In" link
    Then I should be redirected to the Logon page
    And the page title of the Logon page should be "TopCashback USA: Log in to get today’s best cash back deals" visible
    And the Salutation Message should be visible

    When I enter the following valid login details:
      | Field    | Value               |
      | Email    | zzzz1234@gmail.com  |
      | Password | Zzzz@1234           |

    And I click on the "Log In" button
    Then I verify the user is successfully logged in
    And the page title of the home page should be "TopCashback Official Site - The USA's Most Generous Cash Back Site." visible
    