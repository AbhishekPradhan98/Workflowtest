package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.AddCourse;
import POM.DatePicker;
import POM.login;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;

public class G_Courses 
{

	WebDriver driver;
	private login lp;
	private ElementUtils Eleutils;
	private AddCourse coursePage;
	private DatePicker date;
	 

	@Given("I am on the Course page")
	public void i_am_on_the_course_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();
		
		//click course content link
		Eleutils=new ElementUtils(driver);
		Eleutils.clickCourseContent();
		//click course link
		 driver.findElement(By.xpath("//span[normalize-space()='Courses']")).click(); 
	}
	

	@When("I click course Icon and landed to Add course page")
	public void i_click_course_icon_and_landed_to_add_course_page() 
	{
		
		 driver.findElement(By.xpath("//mat-icon[normalize-space()='add']")).click();

	}

	@When("I enter Course Name as {string}")
	public void i_enter_course_name_as(String CourseName) 
	{ 
		 //user enter course name
		 driver.findElement(By.xpath("//input[@name='name']")).sendKeys(CourseName);
	}


	@When("I open the start date picker, set the month to {string}, and Select current date.")
	public void i_open_the_start_date_picker_set_the_month_to_and_select_current_date(String StartmonthYear) 
	{
		date=new DatePicker(driver);
		date.setStartDate(StartmonthYear);

	}
	@When("I open the End date picker, set the month to {string}, and Select the date {string}")
	public void i_open_the_end_date_picker_set_the_month_to_and_select_the_date(String EndmonthYear, String EndDay) 
	{
		date.setEndDate(EndmonthYear, EndDay);
		
	}


	@When("I enter {string} in the Subject Field.")
	public void i_enter_in_the_subject_field(String Subject) throws Throwable 
	{
//		Eleutils=new ElementUtils(driver);
//		Eleutils.enterSubject(Subject);
		
	}


	@When("I enable Certificate toggle button")
	public void i_enable_certificatio_toggle_button() throws Throwable 
	{
		
		 //click toggle

        driver.findElement(By.xpath("(//div[@class='mat-slide-toggle-thumb-container'])[2]")).click();

	}
	@When("I enable Live Class toggle button")
	public void i_enable_live_class_toggle_button() 
	{
        driver.findElement(By.xpath("(//div[@class='mat-slide-toggle-thumb-container'])[3]")).click();


	}
	@When("I select language says {string} and {string}")
	public void i_select_language_says_and(String Language1, String Language2) 
	{
		List<WebElement>checkboxes=driver.findElements(By.xpath("//*[@class='mat-checkbox-inner-container']"));
	    System.out.println("Total Number checkboxes : "+checkboxes.size());
	    
	    for(int i=1;i<checkboxes.size();i++)
	    {
	    	checkboxes.get(i).click();
	    }

	}
	

	@When("I enter Description as {string}")
	public void i_enter_description_as(String Description) 
	{
		 driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(Description);

	}


	@When("I upload an image file of type {string}")
	public void i_upload_an_image_file_of_type(String FileType) throws Throwable 
	{
	   
		 WebElement element= driver.findElement(By.xpath("//em[@class='material-icons upload']"));
		  element.click();
		   Thread.sleep(1000);
		    
		   // Switch to the popup window
	       String mainWindowHandle = driver.getWindowHandle();
	       Set<String> allWindowHandles = driver.getWindowHandles();
	       for (String handle : allWindowHandles) 
	       {
	           if (!handle.equals(mainWindowHandle)) 
	           {
	               driver.switchTo().window(handle);
	               break;
	           }
	       }

	       // Locate the file input element
	       WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

	       // Get the current working directory
	       String workingDir = System.getProperty("user.dir");

	       // Construct the absolute file path (using forward slashes for Linux)
	       String filePath = workingDir + FileType;
	       fileInput.sendKeys(filePath);
	       
	       //click crop button
//	       driver.switchTo().window(mainWindowHandle);
	       driver.findElement(By.xpath("(//*[normalize-space()='Crop and Continue'])[1]")).click();
	}
	@Then("I click the Save&List button.")
	public void i_click_the_save_list_button() throws Throwable 
	{
		//click save&list button
		Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Save & List']")).click();

	}

	@Then("the new course should be added successfully validation message should Appear")
	public void the_new_course_should_be_added_successfully_validation_message_should_appear()
	{
		// Validate confirmation message
		Eleutils.validationMessage();
	}



	@When("I search for the course by Course Name {string}")
	public void i_search_for_the_course_by_course_name(String CourseName) 
	{
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(CourseName);
		
	}
	
	@Then("the course {string} should be displayed in the search results")
	public void the_course_should_be_displayed_in_the_search_results(String CourseName) 
	{
	  WebElement displayedCourse =driver.findElement(By.xpath("(//table[starts-with(@id, 'DataTables_Table')])//tr[1]//td[1]"));
	  System.out.println("Search course name is : "+displayedCourse.getText());
		
		
	}

	//edit course section start here
	

	
	@When("I click on the edit icon for the course")
	public void i_click_on_the_edit_icon_for_the_course() 
	{
		driver.findElement(By.xpath("//mat-icon[normalize-space()='edit']")).click(); 
	}
	@Then("I should see the Edit Course page")
	public void i_should_see_the_edit_course_page() 
	{
	   
	}


	@When("I update Course Name as {string}")
	public void i_update_course_name_as(String CourseName) throws Throwable 
	{
		 driver.findElement(By.xpath("//input[@name='name']")).clear();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@name='name']")).sendKeys(CourseName);

	}



	@Then("Course Update successfully validation message should Appear")
	public void course_update_successfully_validation_message_should_appear() 
	{
		// Validate confirmation message
		Eleutils=new ElementUtils(driver);
		Eleutils.validationMessage();
	}

//Add data in course
	

	@When("I click Add Section icon then system display a Add course section Page")
	public void i_click_add_section_icon_then_system_display_a_add_course_section_page() 
	{
	    driver.findElement(By.xpath("//mat-icon[@mattooltip='Add Section']")).click();
	}


	@When("I click the section button, a popup appears to create English and Hindi section names")
	public void i_click_the_section_button_a_popup_appears_to_create_english_and_hindi_section_names() 
	{
	    driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

	}
	@When("I enter english section name and Hindi section name as {string} and {string}")
	public void i_enter_english_section_name_and_hindi_section_name_as_and(String english, String Hindi) 
	{
		driver.findElement(By.xpath("//input[@placeholder='English Section Name']")).sendKeys(english);
	    driver.findElement(By.xpath("//input[@placeholder='Hindi Section Name']")).sendKeys(Hindi);

	}
	@When("I click save button then section created successfully")
	public void i_click_save_button_then_section_created_successfully() 
	{
		 WebElement element= driver.findElement(By.xpath("//*[contains(@class, 'action-btn') and contains(@class, 'mat-focus-indicator') and contains(@class, 'mat-button') and contains(@class, 'mat-button-base') and contains(@class, 'mat-primary')]\n"+ ""));
	       element.click();
	    // user click section link
		    driver.findElement(By.xpath("//div[@class='group-section-heading-manage']")).click();

	}


	@When("I choose video and choose pdf and choose Quiz")
	public void i_choose_video_and_choose_pdf_and_choose_quiz() 
	{
		  // choose video

	   driver.findElement(By.xpath("//span[normalize-space()='Choose Video']")).click();
	   Eleutils=new ElementUtils(driver);
	   Eleutils.selectCheckbox();
       //click save button
       driver.findElement(By.xpath("//button[@type='button']//span[@class='mat-button-wrapper'][normalize-space()='Save']")).click();
       
       
       //click choose pdf
       driver.findElement(By.xpath("//span[normalize-space()='Choose PDF']")).click();
       Eleutils.selectCheckbox();
       driver.findElement(By.xpath("//button[@type='button']//span[@class='mat-button-wrapper'][normalize-space()='Save']")).click();

       //click choose Quiz
       driver.findElement(By.xpath("//span[normalize-space()='Choose Quiz']")).click();
       Eleutils.selectCheckbox();
       driver.findElement(By.xpath("//button[@type='button']//span[@class='mat-button-wrapper'][normalize-space()='Save']")).click();
       
	}
	@When("I Add Live class and and Evaluation Test")
	public void i_add_live_class_and_and_evaluation_test() 
	{
	   driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[7]")).click();
	   Eleutils.selectCheckbox();
       driver.findElement(By.xpath("//button[@type='button']//span[@class='mat-button-wrapper'][normalize-space()='Save']")).click();
       
       //choose evaluation test
       driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[8]")).click();
       Eleutils.selectCheckbox();
       driver.findElement(By.xpath("//button[@type='button']//span[@class='mat-button-wrapper'][normalize-space()='Save']")).click();
       
       
		
	}
	

	@Then("I should see validation message")
	public void i_should_see_validation_message() 
	{
//		Eleutils=new ElementUtils(driver);
//		Eleutils.validationMessage(); 
		
		WebElement validationmsg=driver.findElement(By.xpath("(//div[@class='ng-star-inserted'])[4]"));
		System.out.println(validationmsg.getText());
		
	}



	@When("I enable Course toggle and see validation message")
	public void i_enable_course_toggle_and_see_validation_message() 
	{
		driver.findElement(By.xpath("//*[@class='mat-slide-toggle-thumb']")).click();
		
		
		Eleutils=new ElementUtils(driver);
		Eleutils.validationMessage();
	}







	
}
