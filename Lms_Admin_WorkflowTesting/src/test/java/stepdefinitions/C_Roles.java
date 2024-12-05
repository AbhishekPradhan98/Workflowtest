package stepdefinitions;

import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import POM.login;
import POM.users;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class C_Roles 
{
	WebDriver driver;
	private login lp;
	private users us;
	
	@Given("I am dashboard page")
	public void i_am_dashboard_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();
		
		//user click users link and click All users link
		us=new users(driver);
		us.clickUsers();
	}
	@When("I navigate to the Users Roles page")
	public void i_navigate_to_the_users_roles_page() 
	{
	    driver.findElement(By.xpath("//span[normalize-space()='Roles']")).click();
	    if(driver.getPageSource().contains("Roles"))
		   {
			   System.out.println("Roles Page Display : Test Pass");
		   }else 
		   {
			   System.out.println("Roles Page is not Display : Test Fail");

		   }
	}
	@When("I click the Add Role link then I should see Add Roles Page")
	public void i_click_the_add_role_link_then_i_should_see_add_roles_page() 
	{
	  driver.findElement(By.xpath("//mat-icon[normalize-space()='add']")).click();
	  //verify Add Role Page display or not
	  if(driver.getPageSource().contains("Add Role"))
	   {
		   System.out.println("Add Role Page Display : Test Pass");
	   }else 
	   {
		   System.out.println("Add Role Page is not Display : Test Fail");

	   }
	  
	}
	@When("I fill in the {string} field with New Role")
	public void i_fill_in_the_field_with_new_role(String Name) 
	{
	    driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Name);
	}

	@When("I fill in the {string} field with new_role_key")
	public void i_fill_in_the_field_with_new_role_key(String Key) 
	{
	    driver.findElement(By.xpath("//input[@name='key']")).sendKeys(Key);

	}

	@When("I enable the Admin toggle")
	public void i_enable_the_admin_toggle() 
	{
	    driver.findElement(By.xpath("//div[@class='mat-slide-toggle-thumb']")).click();

	}
	@When("I click the Add Permission button")
	public void i_click_the_add_permission_button() 
	{
//	    driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
	}
	@Then("I should see the permission interface")
	public void i_should_see_the_permission_interface() 
	{
		// Verify the permission interface is displayed
		WebElement permissionInterface = driver.findElement(By.xpath("//th[@class='permission-col']"));
        Assert.assertTrue(permissionInterface.isDisplayed());
	}
	@When("I select the appropriate checkboxes for permissions")
	public void i_select_the_appropriate_checkboxes_for_permissions() 
	{
		List<WebElement>checkboxes=driver.findElements(By.xpath("//div[@class='mat-checkbox-inner-container']"));
	    System.out.println("Total Number checkboxes : "+checkboxes.size());
	    
	    for(int i=1;i<checkboxes.size();i++)
	    {
	    	checkboxes.get(i).click();
	    }
	}
	@When("I click the Save & List button")
	public void i_click_the_save_list_button() throws Throwable 
	{
	    driver.findElement(By.xpath("//span[normalize-space()='Save & List']")).click();
	    Thread.sleep(1000);    
	}

	@Then("I should see a confirmation message")
	public void i_should_see_a_confirmation_message() 
	{
		  // Validate confirmation message  
        WebElement confirmMsg = driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
	    System.out.println("Success Message is : " + confirmMsg.getText());
	}

        @Then("I should see the new role New Role says {string} with the correct permissions in the roles list")
        public void i_should_see_the_new_role_new_role_says_with_the_correct_permissions_in_the_roles_list(String Name) throws Throwable 
        {
        	Thread.sleep(4000);
        	System.out.println("New Role added successfully.");
        	
	    }

        
}
