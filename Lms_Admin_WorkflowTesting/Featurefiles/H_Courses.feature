#Author: your.email@your.domain.com

@sanity
Feature: Add a new course

 Scenario Outline: Add a new course
 
    Given I am on the Course page
    When I click course Icon and landed to Add course page
    When I enter Course Name as "<CourseName>"
    When I open the start date picker, set the month to "<StartmonthYear>", and Select current date.
    And I open the End date picker, set the month to "<EndmonthYear>", and Select the date "<EndDay>"
    And I enter "<Subject>" in the Subject Field.
    And I enable Certificate toggle button
    And I enable Live Class toggle button
    And I select language says "<Language1>" and "<Language2>"
    And I enter Description as "<Description>"
    And I upload an image file of type "<FileType>"
    Then I click the Save&List button.
    And the new course should be added successfully validation message should Appear
    When I search for the course by Course Name "<CourseName>"
    Then the course "<CourseName>" should be displayed in the search results

  Examples:
    |    CourseName            |StartmonthYear  | EndmonthYear | EndDay|    Subject        | Language1 | Language2 |       Description                               |     FileType              |
    | Core Java                | OCT 2024       | OCT 2024     | 30    |    Cyber Security | English   | Hindi     | This is a beginner course for AI.               | /images/LearnifyImage.png |
    #| Machine Learning Basics  | OCT 2024       | OCT 2024     | 20    | Cyber Security   | English   | Hindi      | Learn the basics of machine learning techniques.| /images/LearnifyImage.png |
    
  Scenario Outline: Verifying Admin can successfully add Data in course

    Given I am on the Course page
    When I click Add Section icon then system display a Add course section Page
    And I click the section button, a popup appears to create English and Hindi section names
    And I enter english section name and Hindi section name as "<EngQuizName>" and "<HindiQuizName>"
    And I click save button then section created successfully
    And I choose video and choose pdf and choose Quiz
    And I Add Live class and and Evaluation Test 
    Then I click the Save&List button.
    Then I should see validation message
    When I enable Course toggle and see validation message
    
    Examples:
    |  EngQuizName  |  HindiQuizName |
    |  Quiz1        |   प्रश्नोत्तरी                 |
  
  
  

  
  
  
  
  
  
  
  
  