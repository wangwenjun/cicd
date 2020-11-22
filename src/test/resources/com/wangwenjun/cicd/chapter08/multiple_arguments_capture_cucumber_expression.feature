@cicd @v1.0.0
Feature:capture multiple arguments by cucumber expression

  @multiple_arguments_capture
  Scenario: the example capture multiple arguments by cucumber expression
    Given name is Alex, age is 35 and weight is 71.5 KG
    Given In my wallet have 1 coin
    Given In my wallet have 3 coins
    Given deposit of 100 yuan in the bank
    Given withdraw of 100 yuan in the bank

  @multiple_arguments_capture
  Scenario: more data type
    Given BigInteger:123, BigDecimal:123.45,Boolean:false,Byte:12,Short:64,Integer:100,Long:1000,Float:10.0,Double:100.0 and String: 'i like cucumber'.

  @multiple_arguments_capture
  Scenario: example of capture multiple arguments into Java Object
    Given my name is Alex, age more than 30 and weight is 71.5KG
