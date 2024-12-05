package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.users;
import POM.login;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;
import utils.ElementUtils;

public class AllUsers 
{
	WebDriver driver;
	private CommonUtils commonUtils;
	private ElementUtils elementutil;
	private login lp;
	private users search;
	private users user;



	@Given("User navigates to Admin Dashboard page and see The username is shown on the dashboard page.")
	public void user_navigates_to_admin_dashboard_page_and_see_the_username_is_shown_on_the_dashboard_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();
		//to open Admin dashboard
//		lp.AdminDashboard();
			
		
//		 Find the element with the text heading "Self Learning"
	      WebElement usernameElement = driver.findElement(By.xpath("//span[@class='name']"));
 
	      
	      // Verify if the username is displayed on the page
	        if (usernameElement.isDisplayed()) {
	            // Get the text of the username
	            String displayedUsername = usernameElement.getText();

	            // Print the username to the console
	            System.out.println("Test Passed Username displayed on the dashboard: " + displayedUsername);
	        } else 
	        {
	            System.out.println("Username is not displayed on the dashboard.");
	        }	      
	     
	}

	// user is ready to create new user	

	@When("Admin move to Users section and click All Users")
	public void admin_move_to_users_section_and_click_all_users() 
	{
		//to click user link
		user=new users(driver);
		user.clickUsers();
		//user click All user link
		driver.findElement(By.xpath("//span[normalize-space()='All Users']")).click();
				
	}
	@Then("Admin can see list of users that already created")
	public void admin_can_see_list_of_users_that_already_created() 
	{
		//find total number of row in webtable
		List<WebElement>rowlist=driver.findElements(By.xpath("//table[@class='table table-bordered order-column stripe hover dataTable no-footer']/tbody/tr"));
		
		System.out.println("Total Number rows are : " + rowlist.size());
		
		//find total number of coloumns
		List<WebElement>coloumnlist=driver.findElements(By.xpath("//table[@class='table table-bordered order-column stripe hover dataTable no-footer']/tbody/tr[1]/td"));
		System.out.println("Total numner of coloumns :" +coloumnlist.size());
		
//		//to print table data
//		for(int r=2;r<=rowlist.size();r++)
//		{
//			for(int c=1;c<=coloumnlist.size();c++)
//			{
//				String data=driver.findElement(By.xpath("//table[@class='table table-bordered order-column stripe hover dataTable no-footer']/tbody/tr[1]//td[1]")).getText();
//				System.out.print(data + "            ");
//			}
//		}
//		System.out.println( );
	}
	

	@When("Admin click Add user + icon and see Add user page to fill required details")
	public void admin_click_add_user_icon_and_see_add_user_page_to_fill_required_details() 
	{
		WebElement element=driver.findElement(By.xpath("(//mat-icon[normalize-space()='person_add'])[1]"));
		element.click();
		
	}

	@When("Admin enters the User Name, Email ID, Mobile Number, and City.")
	public void admin_enters_the_user_name_email_id_mobile_number_and_city() 
	{
		  commonUtils=new CommonUtils();
		  //Admin enter user name
		  driver.findElement(By.xpath("//input[@name='name']")).sendKeys(commonUtils.randomName);
		  //Admin enter email-id
		  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(commonUtils.getEmailWithTimeStamp());
          //user enter mobile number
		  driver.findElement(By.name("mobileNumber")).sendKeys(commonUtils.randomMobileNumber);
		  //user enter city name
		  driver.findElement(By.name("city")).sendKeys(commonUtils.randomCity);

	}

	@When("Admin enter text in about user textbox and select user role say {string} and enter password says {string}")
	public void Admin_enter_text_in_about_user_textbox_and_select_user_role_say_and_enter_password_says(String role, String pwd) throws Throwable 
	{
		//user enter text in textbox
		driver.findElement(By.name("description")).sendKeys("This is QA Testing");
		
		//user select role
		WebElement element= driver.findElement(By.xpath("//input[@role='combobox']"));
		element.sendKeys(role);
		element.sendKeys(Keys.ENTER);

		  
		
		  //user enter password
		  driver.findElement(By.name("password")).sendKeys(pwd);
		  driver.findElement(By.name("passwordConfirm")).sendKeys(pwd);
		  
		  elementutil=new ElementUtils(driver);
		  elementutil.scrolldown();

	}

	@When("Admin Active\\/inactive Visibility features as verified")
	public void admin_active_inactive_visibility_features_as_verified() 
	{
	    driver.findElement(By.xpath("(//div[@class='mat-slide-toggle-thumb'])[1]")).click();

		
	}
	@When("Admin Select courses like  {string}")
	public void Admin(String Course) throws Throwable 
	{
	    
		  WebElement element=driver.findElement(By.xpath("//input[@placeholder='Enter Course']"));
//		  element.click();
		  element.sendKeys(Course);
		  Thread.sleep(3000);
		  element.sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  element.sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  
		  
		  //user upload image
	        WebElement fileInput = driver.findElement(By.xpath("//em[@class='material-icons upload']"));
	        
	        fileInput.sendKeys(System.getProperty("user.dir")+".\\LMS_Admin\\images\\images.png");
	        

	        
	        
//	        fileInput.sendKeys("/home/hs/eclipse-workspace/LMS_Admin/images/images.png");
	        
	        
	        
	        // Get the current working directory
//	        String currentDir = System.getProperty("user.dir");
//
//	        // Construct the path to the image file
//	        String filePath = currentDir + "./LMS_Admin/images/images.png";
//
//	        // Use JavaScript to make the hidden input element visible
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("arguments[0].style.display='block';", fileInput);

	        // Enter the file path onto the file-selection input field
//	        fileInput.sendKeys(filePath);
		  
		  

	}

	@When("click Create user button")
	public void click_create_user_button() throws Throwable 
	{
//	   Thread.sleep(2000);
//	   driver.findElement(By.xpath("//span[normalize-space()='Create User']")).click();
      
	}

	  @Then("system should display a Successfully created user message")
      public void system_should_display_a_successfully_created_user_message() 
      {
		  // Find the message element
	        WebElement Message = driver.findElement(By.xpath("//div[@class='toast-title']"));

	        // Check if the error message is displayed
	        if (Message.isDisplayed()) 
	        {
	            // Error message is displayed
	            System.out.println("Message : " + Message.getText());
	        } 
	        else 
	        {
	            // Success message is displayed
	            System.out.println("System is not display any error or success message : Test Fail");
	        }
      }

	
		
          
          
          @Then("verify newly created user status toggle should be disable.")
          public void verify_newly_created_user_status_toggle_should_be_disable() 
          {
        	// Find the toggle button
              WebElement toggleButton = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

              
              String ariaCheckedValue = toggleButton.getAttribute("aria-checked");
              System.out.println("Aria Checked Value is : " +ariaCheckedValue);

              // Check if the aria-checked attribute value is "true"
              
              if ("false".equals(ariaCheckedValue)) 
              {
                  System.out.println("The toggle button is disable : Test Pass");
              } else 
              {
                  System.out.println("The toggle button is enable : Test Fail");
              }
          }

          @Then("clicks the status toggle button to enable it and sees the success message.")
          public void clicks_the_status_toggle_button_to_enable_it_and_sees_the_success_message() 
          {
        	  driver.findElement(By.xpath("(//div[@class='mat-slide-toggle-thumb'])[1]")).click();
        	  
        	  //success message verification
  	        WebElement Message = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));

  	        // Check if the  message is displayed
  	        if (Message.isDisplayed()) 
  	        {
  	            // message is displayed
  	            System.out.println("Message : " + Message.getText());
  	        } 
  	        else 
  	        {
  	            // Success message is not displayed
  	            System.out.println("System is not display any error or success message : Test Fail");
  	        }

        	  
          }







          
	  }
	 

	







