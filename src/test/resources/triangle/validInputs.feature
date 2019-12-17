Feature: Valid Inputs for Triangle Calculator
  Check which values the app allows to input as side size for the triangle

  Scenario: Special Char
    Given open app on Chrome browser
    When input - symbol in any input
    Then no triangle type message should be displayed

  # This test is failing because the app actually is handling negative numbers
  # as positive and still classifying the triangle
  Scenario: Negative Values
    Given open app on Chrome browser
    When negative values are set as triangle sides size
    Then no triangle type message should be displayed

  Scenario: Empty Values
    Given open app on Chrome browser
    When no values are set as triangle sides size
    Then fill all sides size message should be displayed