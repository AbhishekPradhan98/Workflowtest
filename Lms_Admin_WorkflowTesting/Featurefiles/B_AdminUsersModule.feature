#Author: Abhishek Gaur

Feature: Admin Users Module
          
@sanity  
Scenario Outline: Verifying Admin or SuperAdmin Add a new user
    Given I am on the User page
    When i Navigate to Add User Page
    When I fill in the Name, Email, and Mobile No. fields with valid data
    And I enter "<Department>" in the department field and "<Location>" in the Location field
    And I select "<User Role>" from the User Role dropdown
    And I enter "<Activation Date>" in the Activation Date field
    And I enter "<Expiry Date>" in the Expiry Date field and select the EndDay "<EndDay>"
    Then I verify the Profile Expire (in days)
    And I check the Visibility features toggle
    And I attach "<UploadImagePath>" to the Upload Image field
    And I click the create user button
    Then I should see a confirmation message.

 Examples:
  |Department| Location | User Role  | Activation Date | Expiry Date |EndDay | UploadImagePath  |
  |  QA      | jaipur   | Admin      | DEC 2024        | JAN 2025    |  30   |/images/images.png|
   #|  QA      | jaipur   | Admin      | OCT 2024        | NOV 2024    |  30   |/images/images.png|
   #|  QA      | jaipur   | User      | OCT 2024        | NOV 2024    |  30   |/images/images.png|
 

  Scenario Outline: Bulk User Upload
      
      Given I am on the User page
      When I uploads an Excel sheet to create users in bulk
      Then I should see Preview User List page should be displayed
      And I enter "<Activation Date>" in the Activation Date field
      And I enter "<Expiry Date>" in the Expiry Date field and select the EndDay "<EndDay>"      
      Then I verify the Profile Expire (in days)
      And the uploaded users should be previewed in a table with columns for:
      | Name    | Email | Mobile Number | Department | Location | Actions |
      And each user in the table should have an option to delete them with an Actions icon
      And there should be "Save" and "Close" buttons at the bottom of the page
      And I click Save Button

    Examples:
   |Activation Date| Expiry Date|EndDay|
   |  DEC 2024     | JAN 2025    | 30  |



 
 
      
           
           
           
           
           