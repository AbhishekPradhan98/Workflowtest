package stepdefinitions;

import org.openqa.selenium.WebDriver;

import POM.DatePicker;
import POM.VideoPage;
import POM.login;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;

public class E_Video 
{
	WebDriver driver;
	private login lp;
    private DatePicker date;
    private ElementUtils utils;
    private VideoPage videoPage;
	
	@Given("I am on the dashboard page.")
	public void i_am_on_the_dashboard_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp = new login(driver);
		lp.AdminLogin();
	}

	@When("I navigate to the course content Video page")
	public void i_navigate_to_the_course_content_video_page() 
	{
		utils=new ElementUtils(driver);
		utils.clickCourseContent();
		//click video link
		videoPage=new VideoPage(driver);
		videoPage.clickVideoLink();
	}

	@Then("I should see video page")
	public void i_should_see_video_page() 
	{
		videoPage.videoPageTextVerification();
	}

	@When("I click Add video icon then i should see Add Video Page")
	public void i_click_add_video_icon_then_i_should_see_add_video_page() 
	{
		videoPage.clickAddVideoIcon();
	}

	@When("I enter {string} in the Video Title field")
	public void i_enter_in_the_video_title_field(String vdoTitle) 
	{
		videoPage.enterVideoTitle(vdoTitle);

	}

	@When("I enter {string} in the Description field")
	public void i_enter_in_the_description_field(String Description) 
	{
		videoPage.enterDescription(Description);

	}

	@When("I select Recorded as the video type")
	public void i_select_recorded_as_the_video_type() 
	{
		System.out.println("By Default Recorded video is Selected");
	}

	@When("I enter {string} in the Url field")
	public void i_enter_in_the_url_field(String Url) 
	{
		videoPage.enterUrl(Url);

	}

	@When("I enter {string} in the subject field")
	public void i_enter_in_the_subject_field(String subject) throws Throwable 
	{
		utils.enterSubject(subject);

	}

	@When("I enter {string} in the topic field")
	public void i_enter_in_the_topic_field(String topic) throws Throwable 
	{
		utils.enterTopic(topic);

	}

	@When("I click the Save&list button.")
	public void i_click_the_save_list_button() throws Throwable 
	{
		utils.clickSaveAndListBtn();
		
	}


	@Then("I should see a Validation message")
	public void i_should_see_a_validation_message() 
	{
	// Validate confirmation message
		utils.validationMessage();

	}



//-------------------------------------------------------------------------------------------------------	
//verifying live video

	@When("I select Live as the video type")
	public void i_select_live_as_the_video_type() 
	{
		videoPage=new VideoPage(driver);
		videoPage.selectLiveVideo();

	}

	@When("I open the start date picker set the month to {string}, and select current date.")
	public void i_open_the_start_date_picker_set_the_month_to_and_select_current_date(String StartmonthYear) throws Throwable 
	{
		date=new DatePicker(driver);
		date.setStartDate(StartmonthYear);
		Thread.sleep(1000);
		// set setStartTime
		date.setStartTime();
	}
	
	@When("I open the End date picker set the month to {string}, and select the day {string}")
	public void i_open_the_end_date_picker_set_the_month_to_and_select_the_day(String EndmonthYear, String EndDay)throws Throwable 
	{
		date.setEndDate(EndmonthYear, EndDay);
		Thread.sleep(1000);
		date.setEndTime();
	}

}
