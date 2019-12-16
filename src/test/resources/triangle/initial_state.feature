Feature: System Initial State
  First time access should provide system fully loaded with title, triangle side inputs and 'Calcular' button

  Scenario: Initial State
    Given open app on Chrome browser
    When check what is displayed
    Then should see title, inputs and button