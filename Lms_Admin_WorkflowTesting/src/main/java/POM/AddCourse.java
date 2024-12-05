package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCourse 
{
	 private WebDriver driver;

	    // Locators for date fields
	    private By startDateField = By.xpath("//input[@name='startDate']");
	    private By endDateField = By.xpath("//input[@name='endDate']");

	    public AddCourse(WebDriver driver) 
	    {
	        this.driver = driver;
	    }

	    // Method to set the start date
	    public void setStartDate(String dateValue) 
	    {
	        WebElement startDate = driver.findElement(startDateField);
	        setDate(startDate, dateValue);
	    }

	    // Method to set the end date
	    public void setEndDate(String dateValue) 
	    {
	        WebElement endDate = driver.findElement(endDateField);
	        setDate(endDate, dateValue);
	    }

	    // Method to set the date value using JavaScript
	    private void setDate(WebElement dateField, String dateValue) 
	    {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].value='" + dateValue + "';", dateField);
	    }
	
}
