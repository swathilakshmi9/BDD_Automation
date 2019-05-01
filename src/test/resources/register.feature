@register
Feature: Register
  As a end user
  I want to register for site
  So that i can login into site

  @smoke @wip
  Scenario: Valid register
    Given I am on home page
    When I navigate to register page
    And I fill the user registeration for:
      | email                    | title | first_Name | last  | post_code |
      | djkfkfhkjjkdsf@gmail.com | Mr    | rakesh     | reddy | e22pd     |


