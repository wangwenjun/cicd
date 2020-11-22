@jenkins
Feature: automation testing login jenkins application

  Scenario: login the jenkins application
    Given use the jenkins url "http://127.0.0.1:8080/jenkins/"
    When open the jenkins home page
    Then the login button and jenkins logo will be display
    Given use account "admin" with password "admin"
    When click the login button
    Then the login jenkins action successful