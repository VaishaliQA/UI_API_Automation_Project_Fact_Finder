Feature: LandingPage Tests  
  Scenario: Verify the page title is displayed  
    Given I am on the TopCashBack landing page
    When I fetch the page title of landing page
    Then I verify the page title is "TopCashback.com: Highest Cash Back Guaranteed" visible on the page 

  Scenario: Verify user can sign up using "Join for Free"
    Given I am on the TopCashBack landing page
    When I enter valid sign-up details
      | Field        | Value               |
      | Email        | tlk67@gmail.com   |
      | Password     | Xyz@1234            |
      | HowDidYouHear| Search Engine       |
    And I click on the Join for Free button
    Then I verify the user is successfully registered
    And I verify title of header

  
    