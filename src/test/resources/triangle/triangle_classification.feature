Feature: Triangle Type Classification by Side
  After inserting values to the sizes of the sides of the triangle,
  the app should return which type of triangle it consists of.

  Scenario Outline: Triangle Classification
    Given open app on Chrome browser
    When insert values <side1>, <side2> and <side3>
    Then the app should show message <type>

  Examples:
    | side1 | side2 | side3 | type |
    | 1 | 1 | 1 | Triângulo Equilátero |
    | 1 | 1 | 2 | Triângulo Isósceles |
    | 1 | 2 | 3 | Triângulo Escaleno |
    | '' | '' | '' | Preencha todos os lados |
    | -1 | -1 | -1 | Triângulo Inexistente |
    | 3 | 4 | 8 | Triângulo Inexistente |
    | - | 1 | 1 |  |

    # Last 2 test fails because the app doesn't check for triangle existence rule nor
    # distinguish positive from negative values