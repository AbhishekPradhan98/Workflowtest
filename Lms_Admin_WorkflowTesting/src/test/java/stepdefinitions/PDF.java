package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.DatePicker;
import POM.login;
import QA.DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;

public class PDF 
{
	WebDriver driver;
	private login lp;
    private DatePicker date;
    private ElementUtils utils;

	@Given("I am on the PDF's Page")
	public void i_am_on_the_pdf_s_page() throws Throwable, Throwable 
	{
		driver = DriverFactory.getDriver();
		lp=new login(driver);
		lp.AdminLogin();
		utils=new ElementUtils(driver);
		utils.clickCourseContent();
		//click Quiz link
		driver.findElement(By.xpath("//span[normalize-space()='PDF']")).click();
	}
	@When("I click Add pdf icon")
	public void i_click_add_pdf_icon() 
	{
	  driver.findElement(By.xpath("//mat-icon[normalize-space()='add']")).click();
		
	}
	@Then("I Naviagte to Add PDF page")
	public void i_naviagte_to_add_pdf_page() 
	{
	  String pgtitle=driver.getTitle();
	  System.out.println("Page Title is : "+pgtitle);
	}
	@When("I Enter title says {string} and Pdf Name")
	public void i_enter_title_says_and_pdf_name(String title) 
	{
	  driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		
	}
	
	@When("I Enter title says {string} and Pdf name{string}")
	public void i_enter_title_says_and_Pdf_name(String title, String PDFName) 
	{
		  driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		  driver.findElement(By.xpath("//input[@placeholder='PDF Name']")).sendKeys(PDFName);

	}


	@When("I Enter {string} in the Subject Field.")
	public void i_enter_in_the_subject_field(String subject) throws Throwable 
	{
		utils=new ElementUtils(driver);
		utils.enterSubject(subject);
	}



	@When("I Enter {string} in the Topic Field.")
	public void i_enter_in_the_topic_field(String Topic) throws Throwable 
	{
		utils.enterTopic(Topic);
	}
	
	@When("I Upload Pdf and click save&list Button")
	public void i_upload_pdf_and_click_save_list_button() 
	{
//	   driver.findElement(By.xpath("//input[@name='fileUrl']")).sendKeys("/Lms_Admin_WorkflowTesting/Python_E_Book.pdf");
	   
		WebElement fileupload = driver.findElement(By.xpath("//input[@name='fileUrl']"));
        //uploading Excel file
       String workingDir = System.getProperty("user.dir");
       String filepaths="/Python_E_Book.pdf";
       // Construct the absolute file path (using forward slashes for Linux)
       String filePath = workingDir + filepaths;
       fileupload.sendKeys(filePath);  
       
       //click save&list Button
		utils.clickSaveAndListBtn();
	}

}
