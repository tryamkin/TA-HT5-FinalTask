
Feature: Smoke

  Scenario Outline: Open Page
    Given User open '<Page>' site
    When ok
    Then ob
    Examples:
      | Page |
      |https://www.ebay.com/|


