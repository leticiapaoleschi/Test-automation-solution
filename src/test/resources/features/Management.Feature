Feature: Progress Bar Management

  Scenario: Manage Progress Bar
    Given I am on "https://demoqa.com/"
    When I navigate to "Widgets" > "Progress Bar"
    And I start and stop before 25%
    Then progress should be ≤ 25%
    When I start again and wait for 100%
    And I reset the progress bar
