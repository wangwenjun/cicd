@cicd @v1.0.0
Feature: other flexibility arguments capture

  @flexibility
  Scenario: use question mark modifier
    Given I have 1 coin in my wallet.
    Given I have 3 coins in my wallet.

  @flexibility
  Scenario: the ignore group example
    Given I have a deposit of 100 yuan in the bank.
    Given I have a withdraw of 100 yuan in the bank.
