@cicd @v1.0.0
Feature: this is the example for background key word
  contains several scenarios

  Background: the common steps
    Given login the www.weibo.com site
    And the author is Alex
    When edit the post message area

  @background
  Scenario: login the weibo post message
    And the content is "Cucumber is a great tools for function testing"
    Then i will see the new post message "Cucumber is a great tools for function testing"

  @background
  Scenario: login the weibo post message again
    And the content is "background key word"
    Then i will see the new post message "background key word"