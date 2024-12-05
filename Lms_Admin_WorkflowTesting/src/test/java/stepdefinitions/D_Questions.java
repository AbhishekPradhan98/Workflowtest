package stepdefinitions;

import org.openqa.selenium.WebDriver;

import POM.AddQuestions;
import POM.login;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;

public class D_Questions 
{
	private static final java.time.Duration Duration = null;
	WebDriver driver;
	private login lp;
	private ElementUtils Eleutils;
	private String defaultWindow; // Declare at the class level
	private AddQuestions Aq;
	
	@Given("I am on the dashboard page")
	public void i_am_on_the_dashboard_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();
	}
	@When("I navigate to Course Content Question Page")
	public void i_navigate_to_course_content_question_page() 
	{
		Aq=new AddQuestions(driver);
		Aq.navigateToQuestionPage();
	}
	@When("I click Add Question icon then i navigate to Add Question page")
	public void i_click_add_question_icon_then_i_navigate_to_add_question_page() 
	{
		Aq.clickAddQuestionIcon();
	}
	@When("I enter Question Title in the Title field says {string}")
	public void i_enter_question_title_in_the_title_field_says(String Question_Tittle) 
	{
		Aq.enterQuestionTitle(Question_Tittle);

	}
	@When("I select Single Choice as the question type")
	public void i_select_single_choice_as_the_question_type() 
	{
		Aq.selectSingleChoice();
	}
	@When("I enter the options {string}, {string}, {string}, and {string}")
	public void i_enter_the_options_and(String firstOption, String SecOption , String thirdOption, String FourthOption) throws Throwable 
	{
		Aq.enterQuizInput(firstOption, thirdOption, thirdOption, FourthOption);
	}

	@When("I choose the correct answer")
	public void i_choose_the_correct_answer() 
	{
		Aq.clickCorrectAnswer();
	}

	@When("I enter {string} in the Explanation field")
	public void i_enter_in_the_explanation_field(String explaination) 
	{
	    Aq.enterExplanation(explaination);
	}
	@When("I enter {string} in the Subject field")
	public void i_enter_in_the_subject_field(String Subject) throws Throwable
	{
		Aq.enterSubject(Subject);
	}
	
	@When("I enter {string} in the Topic field")
	public void i_enter_in_the_topic_field(String Topic) throws Throwable 
	{
		Aq.enterTopic(Topic);
	}

	@When("I verify English language checkbox is checked or not")
	public void i_verify_english_language_checkbox_is_checked_or_not() 
	{
		Aq.verifyEnglishCheckBox();
	}
	@When("verify Hindi language checkbox should be disable")
	public void verify_hindi_language_checkbox_should_be_disable() 
	{
		Aq.verifyHindiLanguageCheckboxisDisable();
	}
	
	@When("I click the Save&list button")
	public void i_click_the_save_list_button() throws Throwable 
	{
		Aq.clickSaveListBtn();
	}
	@Then("I should see a success message Question added successfully")
	public void i_should_see_a_success_message_question_added_successfully() 
	{
		 // Validate confirmation message  
		Eleutils=new ElementUtils(driver);
		Eleutils.validationMessage();
	}
//-----------------------------------------------------------------------------
//verify admin approve Question or not

	@When("I Navigate to Add Question page")
	public void i_navigate_to_add_question_page() 
	{
		Aq=new AddQuestions(driver);
		Aq.navigateToQuestionPage();
	}

	@Given("I select the Question Radio Button that I want to approve or reject")
	public void i_select_the_question_radio_button_that_i_want_to_approve_or_reject() 
	{
		Aq.selectQuestionCheckboxes();	
	}
	@Given("I click the View Question button to see the Approve or Reject buttons")
	public void i_click_the_view_question_button_to_see_the_approve_or_reject_buttons() 
	{
		Aq.clickViewQuestionButton();
	}
	@When("I click the Approve button")
	public void i_click_the_approve_button() throws Throwable 
	{
		Aq=new AddQuestions(driver);
		Aq.clickApproveBtn();    
	}
	
	@Then("I should see a success message Question approved successfully")
	public void i_should_see_a_success_message_question_approved_successfully() 
	{
        System.out.println("Question Approved Successfull Message display : Test Pass");
	}

//create hindi Question
	
	@When("I click the Save button")
	public void i_click_the_save_button() throws Throwable 
	{
		Aq.clickSaveBtn();
	}
	@When("I click the Hindi button which is present on the same Question page")
	public void i_click_the_hindi_button_which_is_present_on_the_same_question_page() 
	{
	    Aq.clickHindiBtn();
	}
	@When("I enter the Hindi version of the question {string}")
	public void i_enter_the_hindi_version_of_the_question(String Hindi_Question_Title) throws Throwable 
	{
		Aq.enterHindiQuestion(Hindi_Question_Title);
	}
	@When("I enter the Hindi options {string}, {string}, {string}, and {string}")
	public void i_enter_the_hindi_options_and(String Hindi_FirstOption, String Hindi_SecondOption, String Hindi_ThirdOption, String Hindi_FourthOption) 
	{
		Aq.EnterQuizOptions(Hindi_FirstOption, Hindi_SecondOption, Hindi_ThirdOption, Hindi_FourthOption);
	}

	@When("I checked Hindi language checkbox")
	public void i_checked_hindi_language_checkbox() 
	{
		Aq.clickHindiCheckbox();
	}
	
}
