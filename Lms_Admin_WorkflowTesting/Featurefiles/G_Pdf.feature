#Author: your.email@your.domain.com

#@tag
Feature: verifying PDF Functionality

Scenario: Add Pdf
Given I am on the PDF's Page
When I click Add pdf icon 
Then I Naviagte to Add PDF page
When I Enter title says "TestPdfs" and Pdf name"QAPDFTESTs"
 And I Enter "Cyber Security" in the Subject Field.
 And I Enter "Malware" in the Topic Field.
 And I Upload Pdf and click save&list Button

