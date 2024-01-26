Feature: Ability to open DemoQa page

  @Test01
  Scenario: The user can open the DemoQA webpage and access all the elements on it
    Given User navigates to the demoQA website
    Then User verifies that the page is open
    And User verifies the ability to open the Elements tab
    And User verifies the ability to open the Forms tab
    And User verifies the ability to open the Alerts, Frame & Windows tab
    And User verifies the ability to open the Widgets tab
    And User verifies the ability to open the Interactions tab
    And User verifies the ability to open the Book Store tab
    When User clicks on the banner
    Then User verifies that a page in a new browser tab has opened


