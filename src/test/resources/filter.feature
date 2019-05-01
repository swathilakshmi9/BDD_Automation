@filter
Feature: Filter
  As an end user
  I want to apply filter on the results
  So that i can view results of my filter choice

  @regression
  Scenario: Filter By Rating
    Given I am on home page
    When I search for a product "nike"
    And I apply filter "4or more" on search result
    Then I should see all products "review" are filtered "4.0"

  @regression
  Scenario: Filter by Price range
    Given I am on home page
    When I search for a product "nike"
    And I apply filter "£10 - £15" on search result
    Then I should see all products "range" are filtered "10-15"




