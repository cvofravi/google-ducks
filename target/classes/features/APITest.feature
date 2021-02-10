Feature: APITest

  @RunTests
  Scenario: Verify Status Code is 200
    Given I Hit Get Request and verify
      | URL                                        |
      | https://jsonplaceholder.typicode.com/posts |

  @RunTests
  Scenario: Verify response with Number of ID's
    Given I Hit Get Request and verify
      | URL                                        |
      | https://jsonplaceholder.typicode.com/posts |
    Then Verify Total Number of ID
      | ExpectedIDs |
      |         100 |
