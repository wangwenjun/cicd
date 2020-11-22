@cicd @v1.0.0
Feature: example for the Data Table(Complex data type)

  @data_table
  Scenario: Data Table example
    Given The full name as below
      | Alex Wang         |
      | Alex              |
      | Alex Wen Jun Wang |
      | sir Alex Wang     |
    When invoke the full name split method
    Then the split result as below
      | firstName | lastName     |
      | Alex      | Wang         |
      | Alex      |              |
      | Alex      | Wen Jun Wang |
      | Alex      | Wang         |