#Author: your.email@your.domain.com

Feature: Add Role in the System
  
  Background:
  Given I am dashboard page
  When I navigate to the Users Roles page
  

  @sanity
  Scenario Outline: Verifying Admin Add a new user and assign permissions
    And I click the Add Role link then I should see Add Roles Page
    And I fill in the "<Name>" field with New Role
    And I fill in the "<Key>" field with new_role_key
    And I enable the Admin toggle
    And I click the Add Permission button
    Then I should see the permission interface
    When I select the appropriate checkboxes for permissions
    And I click the Save & List button
    Then I should see a confirmation message
    Then I should see the new role New Role says "<Name>" with the correct permissions in the roles list

    Examples:
    |    Name       |    Key      |
    |Test Admin13   |  Demo Test  |
    
    
    
    
    
    
    
    
    
    
    
    
