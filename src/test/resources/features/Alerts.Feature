Feature: Browser Windows

  Scenario: Handle new browser window
    Given I am on "https://demoqa.com/"
    When I select "Alerts, Frame & Windows" and click "Browser Windows"
    And I click on the "New Window" button
    Then a new window should open
    And I validate the message "This is a sample page"
    And I close the new window