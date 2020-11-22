@cicd @v1.0.0
Feature: multiple scenarios(same steps pattern)
  we can use scenario outline Gherkin keywords

#  Scenario: full name is :Alex Wen Jun Wang
#    Given my full name is: "Alex Wen Jun Wang"
#    When take the full name split function
#    Then the first name is "Alex" and second name is "Wen Jun Wang"
#
#
#  Scenario: full name is :Alex Wang
#    Given my full name is: "Alex Wang"
#    When take the full name split function
#    Then the first name is "Alex" and second name is "Wang"
  @scenario_outline
  Scenario Outline: full name split
    Given my full name is: "<fullName>"
    When take the full name split function
    Then the first name is "<firstName>" and second name is "<secondName>"
    Examples:
      | fullName          | firstName | secondName   |
      | Alex Wen Jun Wang | Alex      | Wen Jun Wang |
      | Alex Wang         | Alex      | Wang         |