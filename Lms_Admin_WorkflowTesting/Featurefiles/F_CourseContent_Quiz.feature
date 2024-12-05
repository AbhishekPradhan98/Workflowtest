#Author: your.email@your.domain.com

 Feature: Add Quiz in LMS

  Scenario Outline: Verifying Admin can successfully create a new Evaluation test quiz with all required fields filled
    Given I am on the Dashboard page
    When I navigate to the course content Quiz page
    Then I should see the Quiz page
    When I click Add Quiz icon and navigate to Add Quiz Page
    And I enter "<Quiz Name>" in the Quiz Name field
    And I select "<Quiz Mode>" as the quiz mode and select timer says "<Timer>"
    And I select Language checkbox
    And I enter "<Marks>" in the Mark for Single Question field
    And I enter "<Negative Mark>" in the Negative mark field
    And I enter "<Questions>" in the Questions (In Numbers) field
    And I enter "<Duration>" in the Duration (In Minutes) field
    When I open the start date picker, set the month to "<StartmonthYear>", and Select current date
    And I open the End date picker, set the month to "<EndmonthYear>", and Select the day "<EndDay>"
    And I set Certified Percentage says "70" and Evaluation Test Percentage says "70"
    And I enter "<Subject>" in the Subject Field
    And I enter "<Topic>" in the Topic Field
    And I click the Save&List button
    Then I should see a success Message Quiz added successfully

  Examples:
    | Quiz Name          | Quiz Mode | Timer     | Marks | Negative Mark| Questions| Duration|StartmonthYear| EndmonthYear | EndDay|Subject | Topic  |
    | Core Java Demo Quizs| Mock Test |Quiz Timer |  2    | 0.5          | 5        | 5       | NOV 2024     | DEC 2024     | 30    | Cyber     | Malware|      


 Scenario Outline: Verifying Admin can successfully add questions to a quiz

    Given I am on the Dashboard page
    When I navigate to the course content Quiz page
    Then I should see the Quiz page
    When I click Add Question icon then system display a Add Quiz Questions Page
    And I click the section button, a popup appears to create English and Hindi section names. 
    And I enter english section name and Hindi section name says "<EngQuizName>" and "<HindiQuizName>"
    And I click save button then section created successfully and i click section
    Then choose Question and Add Question Button display
    When I click choose Question and i select required Questions and click save button
    Then Question Added successfully in Section
    And I click the Save&List button
    Then I should see a success message Question updated successfully
    When I enable Add Question toggle and see validation message
    
    Examples:
    |  EngQuizName  |  HindiQuizName |
    |  Quiz1        |   प्रश्नोत्तरी                 |
    
    
    
    
    
    
    
        
  