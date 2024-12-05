package stepdefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.DatePicker;
import POM.login;
import POM.users;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;
import utils.ElementUtils;

public class B_Users 
{
	WebDriver driver;
	private login lp;
	private users us;
    private Map<String, String> userDetails;
	private CommonUtils commonUtils;
	private DatePicker date;
    private ElementUtils utils;

	@Given("I am on the User page")
	public void i_am_on_the_user_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();

		//user click users link and click All users link
		us=new users(driver);
		us.clickUsers();
		WebElement clickAllUsers = driver.findElement(By.xpath("//span[normalize-space()='All Users']"));
		clickAllUsers.click();
		

	}

	@When("i Navigate to Add User Page")
	public void i_navigate_to_add_user_page() 
	{
//		user click + icon
//		driver.findElement(By.xpath("//mat-icon[normalize-space()='person_add']")).click();
		driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[5]")).click();		
//		
//		//verify page tittle
		String expectedtittle = "Add Users";
		String actualtittle= driver.findElement(By.xpath("//h1[normalize-space()='Add User']")).getText();
//		
//		//to print page tittle
		System.out.println("actual page tittle : "+actualtittle);
		
		if(actualtittle.equals(actualtittle))
		{
			System.out.println("Page tittle matches the expected tittle");
		}else 
		{
			System.out.println("Page tittle does not match the expected tittle");
		}
		
	}


	@When("I fill in the Name, Email, and Mobile No. fields with valid data")
	public void i_fill_in_the_name_email_and_mobile_no_fields_with_valid_data() 
	{
		commonUtils=new CommonUtils();
		  //Admin enter user name
		  driver.findElement(By.xpath("//input[@name='name']")).sendKeys(commonUtils.randomName);
		  //Admin enter email-id
		  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(commonUtils.getEmailWithTimeStamp());
          //user enter mobile number
		  driver.findElement(By.name("mobileNumber")).sendKeys(commonUtils.randomMobileNumber);
	}


	
	@When("I enter {string} in the department field and {string} in the Location field")
	public void i_enter_in_the_department_field_and_in_the_location_field(String Department, String Location) 
	{
	    driver.findElement(By.xpath("//*[@name='department']")).sendKeys(Department);
	    driver.findElement(By.xpath("//*[@name='location']")).sendKeys(Location);


	}
	@When("I select {string} from the User Role dropdown")
	public void i_select_from_the_user_role_dropdown(String UserRole) 
	{
		//user select role
				WebElement element= driver.findElement(By.xpath("//input[@role='combobox']"));
				element.sendKeys(UserRole);
				element.sendKeys(Keys.ENTER);

	}
	@When("I enter {string} in the Activation Date field")
	public void i_enter_in_the_activation_date_field(String ActivationDate) 
	{
	   date=new DatePicker(driver);
	   date.setStartDate(ActivationDate);

	}
//	@When("I enter {string} in the Expiry Date field")
//	public void i_enter_in_the_expiry_date_field(String ExpiryDate) 
//	{
//		date.setEndDate(ExpiryDate, endDay);
//
//	}


	@When("I enter {string} in the Expiry Date field and select the EndDay {string}")
	public void i_enter_in_the_expiry_date_field_and_select_the_end_day(String ExpiryDate, String EndDay) throws Throwable 
	{
	    date.setEndDate(ExpiryDate, EndDay);
	    Thread.sleep(2000);
	}

	@Then("I verify the Profile Expire \\(in days)")
	public void i_verify_the_profile_expire_in_days() 
	{

        // Wait for the elements to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement expireInDaysElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='expire-value']")));
        System.out.println("Profile Expire (in days) : "+expireInDaysElement.getText());

	}
	
	@When("I check the Visibility features toggle")
	public void i_check_the_visibility_features_toggle() 
	{
	  driver.findElement(By.xpath("(//div[@class='mat-slide-toggle-thumb'])[1]")).click();

	}

	@When("I attach {string} to the Upload Image field")
	public void i_attach_to_the_upload_image_field(String UploadImagePath) throws Throwable 
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
       String filePath = workingDir + UploadImagePath;
       fileInput.sendKeys(filePath);
       //click crop button
//       driver.switchTo().window(mainWindowHandle);
       driver.findElement(By.xpath("(//*[normalize-space()='Crop and Continue'])[1]")).click();
       

	}

	@When("I click the create user button")
	public void i_click_the_create_user_button() throws Throwable 
	{
		Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[normalize-space()='Create User']")).click();
//	  Thread.sleep(1000);

	}

	

	@Then("I should see a confirmation message.")
	public void i_should_see_a_confirmation_message() 
	{
		 WebElement confirmMsg = driver.findElement(By.xpath("//div[@class='toast-title']"));
	        System.out.println("Validation Message is : " + confirmMsg.getText());
	}





	
	
	
	
	
//	@Then("the user {string} should be listed in the Users table")
//	public void the_user_should_be_listed_in_the_users_table(String Name) 
//	{
//		// Validate the user is listed in the Users table
//        WebElement usersTable = driver.findElement(By.xpath("(//td[starts-with(@class, 'ng-tns')])[1]"));
//        System.out.println("created user is : " + usersTable.getText());
//        assertTrue(usersTable.getText().contains(Name));
//	}
//	@Then("i verify created user and Activate status toggle")
//	public void i_verify_created_user_and_activate_status_toggle() throws Throwable
//	{
//	    WebElement username= driver.findElement(By.xpath("(//td[starts-with(@class, 'ng-tns')])[1]"));
//	    WebElement searchUser= driver.findElement(By.xpath("//input[@type='search']"));
//	    searchUser.sendKeys(username.getText());
//	    
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("(//div[(@class='mat-slide-toggle-thumb')])[1]")).click();
//	}
// 
//	@Then("user status is activated confirmation mesaage appear")
//	public void user_status_is_activated_confirmation_mesaage_appear()
//	{
//		// Validate the user is listed in the Users table
//		String successMsg= "User status is activated";
//        WebElement usersTable = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
//        System.out.println("confirmation mesaage is : " + usersTable.getText());
//        assertTrue(usersTable.getText().contains(successMsg));
//	}

	
//bulk upload user

	@When("I uploads an Excel sheet to create users in bulk")
	public void i_uploads_an_excel_sheet_to_create_users_in_bulk() 
	{
		WebElement fileupload = driver.findElement(By.xpath("//input[@type='file']"));
         //uploading Excel file
        String workingDir = System.getProperty("user.dir");
        String filepaths="/BulkUser.xlsx";
        // Construct the absolute file path (using forward slashes for Linux)
        String filePath = workingDir + filepaths;
        fileupload.sendKeys(filePath);     
	}



	@Then("I should see Preview User List page should be displayed")
	public void i_should_see_preview_user_list_page_should_be_displayed() 
	{
		// Verify that the "Preview User List" page is displayed by checking for a unique element on the page
        WebElement previewUserListHeader = driver.findElement(By.xpath("//h2[normalize-space()='Preview User List']"));

        if (previewUserListHeader.isDisplayed()) 
        {
            System.out.println("Preview User List page is displayed : Test Pass");
        } else
        {
            System.out.println("Preview User List page is NOT displayed : Test Fail");
        }
	}
	@Then("I should see fields for {string} and {string}")
	public void i_should_see_fields_for_and(String string, String string2) 
	{
	  
	}
	@Then("the uploaded users should be previewed in a table with columns for:")
	public void the_uploaded_users_should_be_previewed_in_a_table_with_columns_for(io.cucumber.datatable.DataTable dataTable) 
	{
	     // Locate the table headers
        java.util.List<WebElement> tableHeaders = driver.findElements(By.xpath("//table/thead/tr/th"));

        // Define the expected column headers
        String[] expectedHeaders = {"Name", "Email", "Mobile No.", "Department", "Location", "Actions"};

        // Verify that the headers match the expected values
        for (int i = 0; i < expectedHeaders.length; i++) 
        {
            String actualHeader = tableHeaders.get(i).getText();
            if (actualHeader.equals(expectedHeaders[i])) 
            {
                System.out.println("Column " + actualHeader + " is present as expected.");
            } else 
            {
                System.out.println("Column mismatch: Expected " + expectedHeaders[i] + " but found " + actualHeader);
            }
        }
	}
	@Then("each user in the table should have an option to delete them with an Actions icon")
	public void each_user_in_the_table_should_have_an_option_to_delete_them_with_an_actions_icon() 
	{
		   // Locate the rows of the table (excluding header)
        WebElement tableRows = driver.findElement(By.xpath("//*[@class='delete-icon mat-icon notranslate material-icons mat-icon-no-color']"));
        
        if(tableRows.getAttribute("class") != null)
        {
        	System.out.println("Actions Delete icons are display as expected : Test Pass");
        }else 
        {
        	System.out.println("Actions Delete icons are not display as expected : Test Fail");
		}
	}
	@Then("there should be {string} and {string} buttons at the bottom of the page")
	public void there_should_be_and_buttons_at_the_bottom_of_the_page(String ActivationDate, String string2) 
	{
		 // Locate the "Save" button
        WebElement saveButton = driver.findElement(By.xpath("//span[normalize-space()='Save']"));

        // Locate the "Close" button
        WebElement closeButton = driver.findElement(By.xpath("//span[normalize-space()='Close']"));

        // Verify if the "Save" button is displayed
        if (saveButton.isDisplayed()) 
        {
            System.out.println("The 'Save' button is displayed.");
        } else 
        {
            System.out.println("The 'Save' button is NOT displayed.");
        }

        // Verify if the "Close" button is displayed
        if (closeButton.isDisplayed()) 
        {
            System.out.println("The 'Close' button is displayed.");
        } else 
        {
            System.out.println("The 'Close' button is NOT displayed.");
        }
		
	}
	@Then("I click Save Button")
	public void i_click_save_button() 
	{
	   driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
	}





	

}
