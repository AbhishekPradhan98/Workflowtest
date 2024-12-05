package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.LoginPage;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class A_Login_Functionality 
{
	WebDriver driver;
	private LoginPage lp;



@Given("I am on the Login page")
public void i_am_on_the_login_page() 
{
	driver = DriverFactory.getDriver();
}
@When("I enter {string} in the Email\\/Mobile No. field")
public void i_enter_in_the_email_mobile_no_field(String email) 
{
    lp=new LoginPage(driver);
    lp.loginEmail(email);
}
@When("I enter {string} in the Password field")
public void i_enter_in_the_password_field(String pwd) 
{
   lp.password(pwd);
}

@When("I click the Login button")
public void i_click_the_login_button() 
{
    lp.clickLoginBtn();
}

@Then("I should see the dashboard page")
public void i_should_see_the_dashboard_page() 
{
	lp.dashboardPage();
  
}


@When("i verify my Profile Name and click Logout button")
public void i_verify_my_profile_name_and_click_logout_button() throws Throwable 
{
	// Verify the user profile
    WebElement profile = driver.findElement(By.xpath("//span[@class='name']"));
   

    if (profile.isDisplayed())
    {
        System.out.println(profile.getText() + " Profile verification successful.");
    } else 
    {
        System.out.println("Profile verification failed.");
    }

    // Click logout
    profile.click();
    Thread.sleep(2000);
    WebElement logoutButton = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));
    logoutButton.click();

    System.out.println("Logout successful.");

	
}

//verify error message when user enter valid password and enter invalid password

@Then("I should see an error message Invalid password. Please try again.")
public void i_should_see_an_error_message_invalid_password_please_try_again() 
{
	// error message
    WebElement errorMessageElement =driver.findElement(By.xpath("//div[@class='errortext']"));
    
	// Verify the error message text
    String expectedErrorMessage = "Invalid password. Please try again.";
    String actualErrorMessage = errorMessageElement.getText();
    Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    System.out.println("Test passed. The error message is displayed as expected.");
}


//verify error message Unregistered email

@Then("I should see an error message Unregistered email. Please check your email or sign up.")
public void i_should_see_an_error_message_unregistered_email_please_check_your_email_or_sign_up() 
{
    WebElement errorMessageElement =driver.findElement(By.xpath("//div[@class='errortext']"));

     // Verify the error message text
     String expectedErrorMessage = "Unregistered email. Please check your email or sign up.";
     String actualErrorMessage = errorMessageElement.getText();
     Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

     System.out.println("Test passed. The error message is displayed as expected.");
}


//verify error message when User ID and Password can be empty

@Then("I should see an error message User ID and Password cannot be empty. Please enter your User ID and Password.")
public void i_should_see_an_error_message_user_id_and_password_cannot_be_empty_please_enter_your_user_id_and_password() 
{
    WebElement errorMessageElement =driver.findElement(By.xpath("//div[@class='errortext']"));

	// Verify the error message text
    String expectedErrorMessage = "User ID and password must not be empty.";
    String actualErrorMessage = errorMessageElement.getText();
    Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    System.out.println("Test passed. The error message is displayed as expected.");
}













}
