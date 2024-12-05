package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.DatePicker;
import POM.login;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;

public class F_Quiz 
{
	WebDriver driver;
	private login lp;
    private DatePicker date;
    private ElementUtils utils;
	
	@Given("I am on the Dashboard page")
	public void i_am_on_the_dashboard_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();
	}
	@When("I navigate to the course content Quiz page")
	public void i_navigate_to_the_course_content_quiz_page() 
	{
		utils=new ElementUtils(driver);
		utils.clickCourseContent();
		//click Quiz link
		driver.findElement(By.xpath("//a[@href='/quiz']//div[@class='mat-list-item-content']")).click();
	}
	@Then("I should see the Quiz page")
	public void i_should_see_the_quiz_page() 
	{
		if(driver.getPageSource().contains("Quiz's"))
		   {
			   System.out.println("Quizzes Page Is Display : Test Pass");
		   }
		   else 
		   {
			System.out.println("Quizzes Page is not display : Test Fail");
		}
	}
	@When("I click Add Quiz icon and navigate to Add Quiz Page")
	public void i_click_add_quiz_icon_and_navigate_to_add_quiz_page() 
	{
		 driver.findElement(By.xpath("//mat-icon[normalize-space()='add']")).click();
		   //verify Add Quiz page
		   if(driver.getPageSource().contains("Add Quiz"))
		   {
			   System.out.println("Add Quiz Page Is Display : Test Pass");
		   }
		   else 
		   {
			System.out.println("Add Quiz Page is not display : Test Fail");
		   }
	}
	@When("I enter {string} in the Quiz Name field")
	public void i_enter_in_the_quiz_name_field(String QuizName) 
	{
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(QuizName);

	}
	

	@When("I select {string} as the quiz mode and select timer says {string}")
	public void i_select_as_the_quiz_mode_and_select_timer_says(String QuizMode, String Timer) 
	{
		WebElement element= driver.findElement(By.xpath("//mat-select[starts-with(@id, 'mat-select')]"));
		element.click();
		element.sendKeys(Keys.ENTER);
		
		//user select Quiz timer
		WebElement element1 = driver.findElement(By.xpath("//mat-select[@placeholder='Select Timer']"));
		element1.click();
		element1.sendKeys(Keys.ENTER);

	}



	@When("I select Language checkbox")
	public void i_select_language_checkbox() throws Throwable 
	{
	    List<WebElement>checkbox= driver.findElements(By.xpath("//div[@class='mat-checkbox-inner-container']"));
	    System.out.println(checkbox.size());
	    
	    for(int i=0;i<checkbox.size();i++)
	    {
	    	checkbox.get(i).click();
	    	
	    }
	    	
	}
	@When("I enter {string} in the Mark for Single Question field")
	public void i_enter_in_the_mark_for_single_question_field(String Marks) 
	{
	    
		// Find the input element
        WebElement inputElement = driver.findElement(By.xpath("//input[@name='mark' and @placeholder='Mark for Single Question']"));
        inputElement.sendKeys(Marks);
       
	}
	@When("I enter {string} in the Negative mark field")
	public void i_enter_in_the_negative_mark_field(String NegativeMark) 
	{
	    driver.findElement(By.xpath("//input[@name='negative_mark']")).sendKeys(NegativeMark);

	}
	@When("I enter {string} in the Questions \\(In Numbers) field")
	public void i_enter_in_the_questions_in_numbers_field(String totalQuestions) 
	{
	    driver.findElement(By.xpath("//input[@name='totalQuestions']")).sendKeys(totalQuestions);

	}
	@When("I enter {string} in the Duration \\(In Minutes) field")
	public void i_enter_in_the_duration_in_minutes_field(String Duration) 
	{
	    driver.findElement(By.xpath("//input[@name='duration']")).sendKeys(Duration);

	}


	@When("I open the start date picker, set the month to {string}, and Select current date")
	public void i_open_the_start_date_picker_set_the_month_to_and_select_current_date(String StartmonthYear) 
	{
		date=new DatePicker(driver);
		date.setStartDate(StartmonthYear);

       //set start time
		date.setStartTime();
	}



	
	@When("I open the End date picker, set the month to {string}, and Select the day {string}")
	public void i_open_the_end_date_picker_set_the_month_to_and_select_the_day(String EndmonthYear, String EndDay) 
	{
		date.setEndDate(EndmonthYear, EndDay);
		date.setEndTime();
	     
	}



	@When("I set Certified Percentage says {string} and Evaluation Test Percentage says {string}")
	public void i_set_certified_percentage_says_and_evaluation_test_percentage_says(String CertifiedPercentage, String EvaluationPercentage) 
	{
		driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys(CertifiedPercentage);
		driver.findElement(By.xpath("//input[@name='evaluationTestPercentage']")).sendKeys(EvaluationPercentage);

	}
	
	@When("I enter {string} in the Subject Field")
	public void i_enter_in_the_subject_field(String Subject) throws Throwable 
	{
		utils.enterSubject(Subject);

	}
	@When("I enter {string} in the Topic Field")
	public void i_enter_in_the_topic_field(String topic) throws Throwable 
	{
		utils.enterTopic(topic);
	}
	@When("I click the Save&List button")
	public void i_click_the_save_list_button() throws Throwable 
	{
		utils.clickSaveAndListBtn();

	}
	
	@Then("I should see a success Message Quiz added successfully")
	public void i_should_see_a_success_message_quiz_added_successfully() 
	{		
		// Validate confirmation message  
		utils.validationMessage();
	}

//scenario testcases 2 if course is already exist
	
	@Then("I should see an error message Quiz with this name already exists")
	public void i_should_see_an_error_message_quiz_with_this_name_already_exists() 
	{
		// Validate confirmation message  
		utils=new ElementUtils(driver);
		utils.validationMessage();


	}
//----------------------------------------------------------------------------------
//verifying admin is able to add Question in Quiz add Question section or not
	
	@When("I click Add Question icon then system display a Add Quiz Questions Page")
	public void i_click_add_question_icon_then_system_display_a_add_quiz_questions_page() 
	{
	    driver.findElement(By.xpath("//mat-icon[@mattooltip='Add Questions']")).click();

	}
	@When("I click the section button, a popup appears to create English and Hindi section names.")
	public void i_click_the_section_button_a_popup_appears_to_create_english_and_hindi_section_names() 
	{
	    driver.findElement(By.xpath("//button[@type='button']")).click();

	}
	@When("I enter english section name and Hindi section name says {string} and {string}")
	public void i_enter_english_section_name_and_hindi_section_name_says_and(String english, String Hindi) 
	{
	    driver.findElement(By.xpath("//input[@placeholder='English Section Name']")).sendKeys(english);
	    driver.findElement(By.xpath("//input[@placeholder='Hindi Section Name']")).sendKeys(Hindi);

	}
	@When("I click save button then section created successfully and i click section")
	public void i_click_save_button_then_section_created_successfully_and_i_click_section() 
	{ 
//	    driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-button mat-button-base mat-primary']//span[@class='mat-button-wrapper'][normalize-space()='Save']")).click();
       WebElement element= driver.findElement(By.xpath("//*[contains(@class, 'action-btn') and contains(@class, 'mat-focus-indicator') and contains(@class, 'mat-button') and contains(@class, 'mat-button-base') and contains(@class, 'mat-primary')]\n"+ ""));
       element.click();
		// user click section link
	    driver.findElement(By.xpath("//div[@class='group-section-heading-manage']")).click();
	}
	@Then("choose Question and Add Question Button display")
	public void choose_question_and_add_question_button_display() 
	{
	   System.out.println("choose Question and Add Question Button display as expected : Test Pass");
	}
	@When("I click choose Question and i select required Questions and click save button")
	public void i_click_choose_question_and_i_select_required_questions_and_click_save_button() throws Throwable 
	{
		driver.findElement(By.xpath("//div[@class='component-property']//button[1]")).click(); 
		//select Question
		// Locate the elements
		List<WebElement> chooseQuestion = driver.findElements(By.xpath("//td[@class='quiz-name-status']"));
		System.out.println("Total Questions: " + chooseQuestion.size());

		// Iterate over the first 5 questions and click them
		int limit = Math.min(5, chooseQuestion.size()); // Ensure not to exceed available elements

		for (int i = 0; i < limit; i++) {
		    chooseQuestion.get(i).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	}
	@Then("Question Added successfully in Section")
	public void question_added_successfully_in_section() throws Throwable 
	{
		 driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		System.out.println("Question Added successfully in Section : Test Pass");
	}
	@Then("I should see a success message Question updated successfully")
	public void i_should_see_a_success_message_question_updated_successfully() 
	{
		// Validate confirmation message  
        WebElement success = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
	    System.out.println("success Message is : " + success.getText());
	}


	@When("I enable Add Question toggle and see validation message")
	public void i_enable_add_question_toggle_and_see_validation_message() 
	{
	    driver.findElement(By.xpath("//div[@class='mat-slide-toggle-thumb-container']")).click();
	 // Validate confirmation message  
        WebElement success = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
	    System.out.println("Validation Message is : " + success.getText());
	}

//----------------------------------------------------------------------------------
	//verify admin is able to edit Quiz or not


	@When("I click Edit Quiz icon and navigate to edit Quiz Page")
	public void i_click_edit_quiz_icon_and_navigate_to_edit_quiz_page() 
	{
		driver.findElement(By.xpath("//mat-icon[normalize-space()='edit']")).click();
		if(driver.getPageSource().contains("Edit Quiz"))
		{
			System.out.println("Edit Quiz Page is displayed : Test Pass");
		}else 
		{
			System.out.println("Edit Quiz Page is not displayed : Test Fail");

		}

	}

	
	@When("I edit the required fields in the edit page like Quiz Name says {string}")
	public void i_edit_the_required_fields_in_the_edit_page_like_quiz_name_says(String QuizName) throws Throwable 
	{
		WebElement editname= driver.findElement(By.xpath("//input[@name='name']"));
		editname.clear();
		Thread.sleep(1000);
		editname.sendKeys(QuizName);

	}
	@Then("I should see a success message Quiz updated successfully")
	public void i_should_see_a_success_message_quiz_updated_successfully() 
	{
		// Validate confirmation message  
				utils=new ElementUtils(driver);
				utils.validationMessage();
	}




	

	
}
