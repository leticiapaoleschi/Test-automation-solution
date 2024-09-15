Feature: Web Tables Management

  Scenario: Manage records in Web Tables
    Given I am on "https://demoqa.com/"
    When I select "Elements" and click "Web Tables"
    And I create a new record
    And I edit the newly created record
    And I delete the newly created record