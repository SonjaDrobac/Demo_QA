Feature: Verify different functionality on Elements Tab

  @Test02 @Test02-1
  Scenario: Check TextBox form on the Elements page
    Given User navigates to the demoQA website
    When User clicks on the Elements tab
    When User clicks on the TextBox list element
    Then User verifies that a TextBox page is opened
    And User enters the name
    And User enters the email
    And User enters the current address
    And User enters the permanent address
    When User clicks the submit button
    Then User verifies that the message is displayed in correct form

  @Test02 @Test02-2
  Scenario: The user checks that no data is displayed when there is no input
    Given User navigates to the demoQA website
    When User clicks on the Elements tab
    When User clicks on the TextBox list element
    Then User verifies that a TextBox page is opened
    When User clicks the submit button
    Then User verifies that the message is not displayed

  @Test03
  Scenario: The user checks that no data is displayed when there is no input
    Given User navigates to the demoQA website
    When User clicks on the Elements tab
    When User clicks on the CheckBox list element
    Then User verifies that a CheckBox page is opened
    When User click on expand all button
    Then User verifies that all check boxes are opened
    When User selects one check boxes
    Then User verifies message
    When User click on home check box
    Then User verifies message
    When User deselects the checkbox
    Then User verifies message
    When User click on collapse all button
    Then User verifies that all check boxes are closed

  @Test04
  Scenario: Verify Radio buttons
    Given User navigates to the demoQA website
    When User clicks on the Elements tab
    When User clicks on the Radio buttons list element
    Then User verifies that a Radio buttons page is opened
    And User verifies that expected elements are disabled
    When User click on YES radio buttons
    Then User verifies message on radio button page
    When User click on IMPRESSIVE radio buttons
    Then User verifies message on radio button page











