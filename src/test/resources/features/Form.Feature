Feature: Practice Form Submission

  Scenario: Submit the practice form
    Given I am on "https://demoqa.com/"
    When I select "Forms" and click "Practice Form"
    And I fill the form with random values
    And I upload a .txt file
    And I submit the form
    Then a popup should appear
    And I close the popup
