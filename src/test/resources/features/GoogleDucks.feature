Feature: GoogleDucks

  @RunTests
  Scenario: Search for Google Ducks and Verify Anaheim NHL Ducks
    Given I am on Google WebSite
      | URL                   |
      | http://www.google.com |
    And Search for Ducks
      | Search |
      | Ducks  |
    When results are Displayed
    Then verify Anaheim NHL Ducks is in the result

  @RunTests
  Scenario: Search for Google Ducks and Verify Ducks By Shapes
    Given I am on Google WebSite
      | URL                   |
      | http://www.google.com |
    And Search for Ducks
      | Search |
      | Ducks  |
    When results are Displayed
    Then verify Ducks By Shapes in the result

  @RunTests
  Scenario: Search for Google Ducks and Verify Ducks Wiki
    Given I am on Google WebSite
      | URL                   |
      | http://www.google.com |
    And Search for Ducks
      | Search |
      | Ducks  |
    When results are Displayed
    Then verify Ducks Wiki in the result

  @RunTests
  Scenario: Search for Google Ducks and Verify Ducks Types
    Given I am on Google WebSite
      | URL                   |
      | http://www.google.com |
    And Search for Ducks
      | Search |
      | Ducks  |
    When results are Displayed
    Then verify Ducks Types in the result
