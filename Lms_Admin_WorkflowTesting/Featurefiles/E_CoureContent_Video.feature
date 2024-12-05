   #Author: your.email@your.domain.com

@tag
Feature: course content video Module
  
  Scenario Outline: Verifying Admin can successfully add a Recorded video or not
    Given I am on the dashboard page.
    When I navigate to the course content Video page
    Then I should see video page 
    When I click Add video icon then i should see Add Video Page
    And I enter "<Video Title>" in the Video Title field
    And I enter "This is a sample video description." in the Description field
    And I select Recorded as the video type
    And I enter "<Url>" in the Url field
    And I enter "<Subject>" in the subject field
    And I enter "<Topic>" in the topic field
    And I click the Save&list button.
    Then I should see a Validation message

  Examples:
  |    Video Title         |          Url                                      |  Subject      | Topic   |
  | Core Java              | https://www.youtube.com/watch?v=inWWhr5tnEA&t=1s  | Cyber         | malware |
 
  
  
  Scenario Outline: Verifying Admin can successfully add a Live video or not
    Given I am on the dashboard page.
    When I navigate to the course content Video page
    Then I should see video page 
    When I click Add video icon then i should see Add Video Page
    And I enter "<Video Title>" in the Video Title field
    And I enter "This is a sample video description." in the Description field
    And I select Live as the video type
    And I enter "<Url>" in the Url field
    When I open the start date picker set the month to "<StartMonthYear>", and select current date.
    And I open the End date picker set the month to "<EndMonthYear>", and select the day "<EndDay>"
    And  I click the Save&list button.
    Then I should see a Validation message


  Examples:
  |    Video Title            |            Url                                   |  StartMonthYear | EndMonthYear | EndDay   |
  | Core Java  Live video     |https://www.youtube.com/watch?v=inWWhr5tnEA&t=1s  |  NOV 2024       |  DEC 2024    |  30      |
  
  
  
  
 