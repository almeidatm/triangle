Feature: Valid Inputs for Triangle Calculator
  Check which values the app allows to input as side size for the triangle

  Scenario: Special Char
    Given open app on Chrome browser
    When input "-" symbol in any input
    Then no triangle type message should be displayed

  Scenario: Negative Values
    Given open app on Chrome browser
    When negative values as triangle sides size
    Then no triangle type message should be displayed