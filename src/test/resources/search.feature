@search
Feature: Search
  As a end user
  I want to search for a product
  So that i can view respective products

  Background:
    Given I am on home page

    @smoke @live
  Scenario Outline: valid search
    When I search for a product "<searchTerm>"
    Then I should see all the product of "<searchTerm>"
    Examples:
      | searchTerm |
      | nike       |

