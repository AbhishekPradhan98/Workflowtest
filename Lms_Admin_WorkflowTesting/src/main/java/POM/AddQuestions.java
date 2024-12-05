package POM;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class AddQuestions 
{
	private ElementUtils elementUtils;
	WebDriver driver;
	 private WebDriverWait wait;
	  // Constructor to initialize the WebDriver
	 private JavascriptExecutor js;
    public AddQuestions(WebDriver driver) 
    {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver; // Initialize JavaScript Executor
        elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver,this);
        
    }
    // XPaths
    private By stageElement = By.xpath("(//div[@class='mat-list-item-content'])[20]");
    private By questionsTab = By.xpath("//span[normalize-space()='Question Bank']");
    private By questionTitle = By.xpath("//h1[normalize-space()='Question Bank']");
    private By addQuestionIcon = By.xpath("(//span[@class='mat-button-wrapper'])[6]");
    private By addQuestionPageText = By.xpath("//*[contains(text(),'Add Question')]");
    private By questionTitleInput = By.xpath("//div[@id='title']//div[@class='fr-wrapper show-placeholder']//p");
    private By singleChoiceRadioButton = By.xpath("(//input[@type='radio'])[1]");
    private By firstOptionInput = By.xpath("(//div[@class='fr-element fr-view'])[3]");
    private By secondOptionInput = By.xpath("(//div[@class='fr-element fr-view'])[4]"); //done hai yha tk working
    private By thirdOptionInput = By.xpath("(//div[@class='fr-element fr-view'])[5]");
    private By fourthOptionInput = By.xpath("(//div[@class='fr-element fr-view'])[6]");
    private By correctAnswerOuterCircle = By.xpath("(//div[@class='mat-radio-outer-circle'])[3]");
    private By correctAnswerRadioButton = By.xpath("(//input[@type='radio'])[3]");
    private By explanationInput = By.xpath("(//div[@class='fr-element fr-view'])[2]");
    private By subjectInput = By.xpath("//input[@placeholder='Enter Subject']");
    private By topicInput = By.xpath("//input[@placeholder='Enter Topic']");
    private By englishCheckbox = By.xpath("(//input[@type='checkbox'])[1]");
    private By hindiCheckboxInput = By.xpath("(//input[@type='checkbox'])[2]");
    private By saveListBtn = By.xpath("//span[normalize-space()='Save & List']");
    private By checkboxesLocator = By.xpath("//input[@type='checkbox' and @class='pointer']");
    private By viewQuestionBtn = By.xpath("//mat-icon[normalize-space()='visibility']");
    private By clickApproveBtnXpath = By.xpath("//span[normalize-space()='Approve']");
    private By clickRejectBtnXpath = By.xpath("//span[normalize-space()='Reject']");
    
    private By clickSaveBtn = By.xpath("//span[normalize-space()='Save']");
    private By clickHindiBtn = By.xpath("(//span[contains(text(),'हिंदी')])[1]");
    private By hindiQuestionTitleField = By.xpath("//div[@id='title']//div[@class='fr-element fr-view']");
    private By firstOptionField = By.xpath("(//div[@class='fr-element fr-view'])[3]");
    private By secondOptionField = By.xpath("(//div[@class='fr-element fr-view'])[4]");
    private By thirdOptionField = By.xpath("(//div[@class='fr-element fr-view'])[5]");
    private By fourthOptionField = By.xpath("(//div[@class='fr-element fr-view'])[6]");
    private By hindiCheckbox = By.xpath("(//div[@class='mat-checkbox-inner-container'])[2]");
    private By questionCheckbox = By.xpath("(//input[@type='checkbox' and @class='pointer'])");
    private By editQuestionIcon = By.xpath("//mat-icon[@role='img'][normalize-space()='edit']");
    private By questionTitleField = By.xpath("//div[@id='title']//div[@class='fr-element fr-view']");
    

 // Navigate to the question page
    public void navigateToQuestionPage() 
    {
        // Wait for and click the stage element
        wait.until(ExpectedConditions.elementToBeClickable(stageElement)).click();
        
        // Wait for and click the Questions tab
        wait.until(ExpectedConditions.elementToBeClickable(questionsTab)).click();
        
        // Wait for the question title to be visible
        WebElement questionTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTitle));
        
        // Get and verify the question title
        String questionTitleText = questionTitleElement.getText();
        System.out.println("Question title is: " + questionTitleText);
        
        String expectedTitle = "Questions";  // Replace with the expected question title
        if (questionTitleText.equals(expectedTitle)) {
            System.out.println("Question title verified successfully.");
        }
        else 
        {
            System.out.println("Verification failed. Expected title: '" + expectedTitle + "', but got: '" + questionTitleText + "'");
        }
	}
	
  //-------------------------------------------------------------------------------     
    // Method to click the "Add Question" icon and verify the page is displayed
    public void clickAddQuestionIcon() 
    {
        // Wait for and click the "Add" icon
        wait.until(ExpectedConditions.elementToBeClickable(addQuestionIcon)).click();
        
        // Verify that the "Add Question" page is displayed by checking for the expected text
        boolean isAddQuestionPageDisplayed = wait.until(ExpectedConditions.textToBePresentInElementLocated(addQuestionPageText, "Add Question"));

        if (isAddQuestionPageDisplayed) 
        {
            System.out.println("Add Question Page is displayed: Test Pass");
        } else 
        {
            System.out.println("Add Question Page is not displayed: Test Fail");
        }
    }	
	
    // Method to enter the question title with explicit wait
    public void enterQuestionTitle(String questionTitle) 
    {
        // Wait for the Question Title input field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionTitleInput)).sendKeys(questionTitle);
    }

    // Method to check if Single Choice is selected by default
    public void selectSingleChoice() {
        // Wait for the Single Choice radio button to be visible
        WebElement singleChoice = wait.until(ExpectedConditions.visibilityOfElementLocated(singleChoiceRadioButton));
        
        // Check if the Single Choice radio button is selected
        if (singleChoice.isSelected()) 
        {
            System.out.println("By default, Single Choice Radio Button is Selected: Test Pass");
        } else 
        {
            System.out.println("By default, Single Choice Radio Button is Not Selected: Test Fail");
        }
    }


    // Method to enter quiz options
    public void enterQuizInput(String firstOption, String secondOption, String thirdOption, String fourthOption) {
        // Wait for each input field to be visible before sending keys
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstOptionInput)).sendKeys(firstOption);
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondOptionInput)).sendKeys(secondOption);
        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdOptionInput)).sendKeys(thirdOption);
        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fourthOptionInput)).sendKeys(fourthOption);
    }

    

    // Method to select the correct answer
    public void clickCorrectAnswer() {
        // Wait for the correct answer radio button's outer circle to be clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(correctAnswerOuterCircle));
        
        // Use JavaScript to click the element
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

        // Verify if the correct answer radio button is selected
        WebElement singleChoice = wait.until(ExpectedConditions.visibilityOfElementLocated(correctAnswerRadioButton));
        
        if (singleChoice.isSelected()) {
            System.out.println("Correct answer Radio Button is Selected: Test Pass");
        } else {
            System.out.println("Correct answer Radio Button is not Selected: Test Fail");
        }
    }
	
    // Method to enter the explanation
    public void enterExplanation(String explanation) 
    {
        // Wait for the explanation input field to be visible
        WebElement explanationField = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationInput));
        
        // Send keys to the explanation input field
        explanationField.sendKeys(explanation);
    }
    
    // Method to enter subject
    public void enterSubject(String subject) throws Throwable 
    {
        // Wait for the subject input field to be clickable and enter the subject
        WebElement subjectField = wait.until(ExpectedConditions.elementToBeClickable(subjectInput));
        subjectField.sendKeys(subject);
        
        // Perform actions to select the subject from suggestions
        wait.until(ExpectedConditions.attributeToBeNotEmpty(subjectField, "value")); // Wait for input to have a value
        Thread.sleep(1000);
        subjectField.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        subjectField.sendKeys(Keys.ENTER);
    }

    // Method to enter topic
    public void enterTopic(String topic) throws Throwable 
    {
        // Wait for the topic input field to be clickable and enter the topic
        WebElement topicField = wait.until(ExpectedConditions.elementToBeClickable(topicInput));
        topicField.sendKeys(topic);
        
        // Perform actions to select the topic from suggestions
        wait.until(ExpectedConditions.attributeToBeNotEmpty(topicField, "value")); // Wait for input to have a value
        Thread.sleep(1000);
        topicField.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        topicField.sendKeys(Keys.ENTER);
    }


    // Method to verify if English checkbox is checked
    public void verifyEnglishCheckBox() 
    {
    	WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

		// Verify if the checkbox is selected
		if (checkbox.isSelected()) 
		{
		    System.out.println("The English checkbox is checked : Test Pass");
		} else 
		{
		    System.out.println("The English checkbox is Unchecked : Test Fail");
		}

    }
    // Method to verify if Hindi checkbox is disabled
    public void verifyHindiLanguageCheckboxisDisable() 
    {
        // Wait for the Hindi checkbox container to be visible
        WebElement checkboxInput = wait.until(ExpectedConditions.visibilityOfElementLocated(hindiCheckboxInput));
        
        // Check if the checkbox is disabled by verifying the 'disabled' attribute
        boolean isDisabled = !checkboxInput.isEnabled();
        
        if (isDisabled) 
        {
            System.out.println("The Hindi checkbox is disabled: Test Pass");
        } else 
        {
            System.out.println("The Hindi checkbox is enabled: Test Fail");
        }
    }
    
    // Method to click the Save & List button
    public void clickSaveListBtn() 
    {
        // Wait for the Save & List button to be clickable
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(saveListBtn));
        // Click the Save & List button
        submitBtn.click();
    }
    
    
    //Approve Scenario - user Navigate to Approve Question
    // Method to select up to 5 checkboxes
    public void selectQuestionCheckboxes() {
        // Find all checkboxes matching the given criteria
        List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkboxesLocator));
        System.out.println("Total checkboxes: " + checkboxes.size());

        // Track the number of checkboxes selected
        int selectedCount = 0;

        // Iterate through the checkboxes and select up to 5
        for (WebElement checkbox : checkboxes) 
        {
            if (selectedCount >= 5) 
            {
                break; // Stop if 5 checkboxes have been selected
            }
            // Wait until the checkbox is clickable
            wait.until(ExpectedConditions.elementToBeClickable(checkbox));

            // Select the checkbox if it's not already selected
            if (!checkbox.isSelected()) 
            {
                checkbox.click();
                selectedCount++;
            }
        }
        System.out.println("Total selected checkboxes: " + selectedCount);
    }

    // Method to click the "View Questions" button
    public void clickViewQuestionButton() 
    {
        // Wait until the "View Questions" button is clickable
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(viewQuestionBtn));
        // Click the button
        button.click();
    }  
    
    // Method to click all "Approve" buttons until none remain
    public void clickApproveBtn() 
    {
        int maxIterations = 100; // Maximum iterations to prevent infinite loops
        for (int i = 0; i < maxIterations; i++) 
        {
            try 
            {
                // Wait for the approve button to be clickable
                WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(clickApproveBtnXpath));
                // Click the button
                approveButton.click();
                // Wait until the page updates or elements change after the click
                wait.until(ExpectedConditions.stalenessOf(approveButton));

            } catch (Exception e) 
            {
                // Break the loop if no more "Approve" buttons are found or an exception occurs
                System.out.println("No more 'Approve' buttons found or clickable. Exiting loop.");
                break;
            }
        }
    }
    
    public void clickRejectBtn()
	{
		int maxIterations = 100; // A high number to handle the maximum possible questions
        for (int i = 0; i < maxIterations; i++) 
        {
            try 
            {
                // Wait for the approve button to be clickable and click it
            	WebElement approveButton = driver.findElement(clickRejectBtnXpath);
                approveButton.click();
                Thread.sleep(1000);
            }
            catch (Exception e) 
            {
                // If the approve button is not found or clickable, break the loop
                break;
            }	
        }
	}
    
	//click save Btn
	public void clickSaveBtn() throws Throwable
	{
	    driver.findElement(clickSaveBtn).click();
	    Thread.sleep(2000);

	}
	
	//create hindi Question
	public void clickHindiBtn()
	{
		driver.findElement(clickHindiBtn).click();
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Page Url is :"+currentUrl);
	}
	
    // Method to clear the text and enter Hindi question title using JavaScript
    public void enterHindiQuestion(String Hindi_Question_Title) throws Throwable 
    {
        // Wait for the Hindi question title field to be visible
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(hindiQuestionTitleField));
        // Clear the content using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML = '';", titleField);  // Clear the content
        // Enter the new Hindi question title using JavaScript
        js.executeScript("arguments[0].innerHTML = arguments[1];", titleField, Hindi_Question_Title);  // Set new content
        // Optionally, you can wait to ensure the action was performed correctly
        Thread.sleep(1000); // Wait to see changes reflect in the UI
    }

    // Method to enter quiz options using JavascriptExecutor
    public void EnterQuizOptions(String Hindi_FirstOption, String Hindi_SecondOption, String Hindi_ThirdOption, String Hindi_FourthOption) 
    {
        
        // Wait for each option field to be visible before interacting
        WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(firstOptionField));
        WebElement secondOption = wait.until(ExpectedConditions.visibilityOfElementLocated(secondOptionField));
//        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]")).click();
        WebElement thirdOption = wait.until(ExpectedConditions.visibilityOfElementLocated(thirdOptionField));
//        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]")).click();
        WebElement fourthOption = wait.until(ExpectedConditions.visibilityOfElementLocated(fourthOptionField));

        // Use JavascriptExecutor to clear and set the values for each option
        clearAndSetText(firstOption, Hindi_FirstOption);
        clearAndSetText(secondOption, Hindi_SecondOption);
        clearAndSetText(thirdOption, Hindi_ThirdOption);
        clearAndSetText(fourthOption, Hindi_FourthOption);
    }
    // Helper method to clear and set text using JavascriptExecutor
    private void clearAndSetText(WebElement element, String text) 
    {
        // Clear the content of the element
        js.executeScript("arguments[0].innerHTML = '';", element);
        // Set the new text content
        js.executeScript("arguments[0].innerHTML = arguments[1];", element, text);
    }
	
    // Method to click on the Hindi checkbox
    public void clickHindiCheckbox() 
    {
        // Wait for the Hindi checkbox to be clickable
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(hindiCheckbox));
        checkbox.click();
    }
    
    // Method to select the question by clicking the checkbox
    public void selectQuestion() 
    {
        // Wait for the checkbox to be clickable
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(questionCheckbox));
        // Click the checkbox to select the question
        checkbox.click();
    }
    
    // Method to click the edit question icon and switch to the new window
    public void clickeditQuestionIcon() throws InterruptedException {
        // Wait for the edit icon to be clickable and click it
        WebElement editIconElement = wait.until(ExpectedConditions.elementToBeClickable(editQuestionIcon));
        editIconElement.click();

        String defaultwindow= driver.getWindowHandle();
	    Set<String>allwindow=driver.getWindowHandles();
	    //using iterator
	    Iterator<String>itr=allwindow.iterator();
	    itr.next(); //it handle first window
	    String childwindow= itr.next(); //for second window handling
	    driver.switchTo().window(childwindow); //user switch to anather open window
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();	    
    }
    
    // Method to update the question title using JavascriptExecutor
    public void updateQuestion(String QuestionTitle) 
    {
        // Wait for the question title element to be visible using WebDriverWait
        WebElement questionTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTitleField));
        // Clear the existing content using JavascriptExecutor
        js.executeScript("arguments[0].innerHTML = '';", questionTitleElement);
        // Set the new question title using JavascriptExecutor
        js.executeScript("arguments[0].innerHTML = arguments[1];", questionTitleElement, QuestionTitle);
        // Optionally, trigger the necessary events (e.g., blur, change)
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", questionTitleElement);
    } 
}
