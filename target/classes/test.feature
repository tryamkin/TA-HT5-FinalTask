
Feature: Site overwiev
  As a user
  I want to see importance of site functionality
  I want be sure what all necessary work well
  Scenario Outline: Check correct open page
    Given User open '<Page>' site
    When ok
    Then ob
    Examples:
      | Page                |
      |https://www.ebay.com/|


