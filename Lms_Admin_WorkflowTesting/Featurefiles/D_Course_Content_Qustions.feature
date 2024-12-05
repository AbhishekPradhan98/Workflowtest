#Author: your.email@your.domain.com

Feature: Course Content Questions 

#@Sanity @Add_Question_English_Hindi
#Scenario Outline: Verifying Admin can successfully add a new question in English and Hindi 
  #Given I am on the dashboard page
    #When I navigate to Course Content Question Page
    #And I click Add Question icon then i navigate to Add Question page
    #And I enter Question Title in the Title field says "<Question_Tittle>"
    #And I select Single Choice as the question type
    #And I enter the options "<firstOption>", "<SecOption>", "<thirdOption>", and "<FourthOption>"
    #And I choose the correct answer
    #And I enter "This is an explanation" in the Explanation field
    #And I enter "Cyber" in the Subject field
    #And I enter "malware" in the Topic field
    #And I verify English language checkbox is checked or not
    #And verify Hindi language checkbox should be disable
    #And I click the Save button
    #And I click the Hindi button which is present on the same Question page
    #And I enter the Hindi version of the question "<Hindi_Question_Title>"
    #And I enter the Hindi options "<Hindi_FirstOption>", "<Hindi_SecondOption>", "<Hindi_ThirdOption>", and "<Hindi_FourthOption>"
    #And I checked Hindi language checkbox
    #And I click the Save&list button
    #Then I should see a success message Question added successfully
    #
      #Examples:
  #| Question_Tittle                                      | firstOption                 | SecOption                    | thirdOption               | FourthOption              | Hindi_Question_Title                  | Hindi_FirstOption          | Hindi_SecondOption         | Hindi_ThirdOption             | Hindi_FourthOption          |
  #| What is a lever used fors ?                            | Transmitting force          | Increasing speed              | Changing direction        | Reducing friction     | उत्तोलक का उपयोग किस लिए किया जाता है?| बल को संचारित करने के लिए | गति बढ़ाने के लिए           | दिशा बदलने के लिए           | घर्षण कम करने के लिए        |
  #| What is the main purpose of a gearbox?               | Increase torque             | Reduce noise                  | Store energy              | Reduce weight           | गियरबॉक्स का मुख्य उद्देश्य क्या है?     | टॉर्क बढ़ाने के लिए        | शोर कम करने के लिए          | ऊर्जा संग्रहीत करने के लिए  | वजन कम करने के लिए         |
  #| What does a ca mechanism dod.?                        | Converts rotary to linear   | Stores mechanical energy      | Increases speed           | Changes rotational axis | कैम तंत्र क्या करता है?               | घूर्णन को रैखिक गति में बदलता है | यांत्रिक ऊर्जा संग्रहीत करता है | गति बढ़ाता है                | घूर्णन अक्ष को बदलता है     |
  #| What is a bearing used for in a machine?             | Reduce friction             | Store energy                  | Change motion direction   | Increase speed           | मशीन में बेयरिंग का उपयोग किस लिए किया जाता है? | घर्षण कम करने के लिए     | ऊर्जा संग्रहीत करने के लिए  | गति की दिशा बदलने के लिए    | गति बढ़ाने के लिए           |
  #| What is the functions of a spring in a machine.?       | Absorb shock                | Transmit force                | Increase weight           | Reduce speed            | मशीन में स्प्रिंग का कार्य क्या है?    | झटका अवशोषित करने के लिए    | बल संचारित करने के लिए     | वजन बढ़ाने के लिए            | गति कम करने के लिए         |
  

 @sanity 
 Scenario: Verifying Whether the Admin Can Approve Questions
    Given I am on the dashboard page
    When I Navigate to Add Question page
    And I select the Question Radio Button that I want to approve or reject
    And I click the View Question button to see the Approve or Reject buttons
    When I click the Approve button
    Then I should see a success message Question approved successfully
     
    
    

    
    
    
    
    
    
    
    
    
    
                         
    
