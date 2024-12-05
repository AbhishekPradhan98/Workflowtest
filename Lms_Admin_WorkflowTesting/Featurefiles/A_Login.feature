#Author: your.email@your.domain.com


Feature: Admin Login functionality
  
  @sanity
  Scenario: verifying Admin can Successfully logging with email and password
    Given I am on the Login page
    When I enter "abhishekgaur138@gmail.com" in the Email/Mobile No. field
    And I enter "Gaur@123" in the Password field
    And I click the Login button
    Then I should see the dashboard page
    When i verify my Profile Name and click Logout button
      
@sanity
  Scenario: Successfully logging in with mobile number and password
    Given I am on the Login page
    When I enter "9598345731" in the Email/Mobile No. field
    And I enter "Gaur@123" in the Password field
    And I click the Login button
    Then I should see the dashboard page
     When i verify my Profile Name and click Logout button
