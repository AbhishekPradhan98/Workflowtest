package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DatePicker 
{

    private WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private WebDriverWait wait;
 

    // Locators for date pickers and time inputs
    private By startDatePickerIcon = By.xpath("(//*[name()='svg'][@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[1]");
    private By endDatePickerIcon = By.xpath("(//*[name()='svg'][@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[2]");
    private By nextMonthArrow = By.xpath("//button[@aria-label='Next month']");
    private By monthYearButton = By.xpath("//button[@aria-label='Choose month and year']");
    private By startTimeInput = By.xpath("//input[@placeholder='Start Time']");
    private By endTimeInput = By.xpath("//input[@placeholder='End Time']");

    // Constructor to initialize the WebDriver, WebDriverWait, and JavascriptExecutor
    public DatePicker(WebDriver driver) 
    {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait for 10 seconds
        PageFactory.initElements(driver, this); // Initialize web elements
    }

    // Method to set the start date
    public void setStartDate(String startMonthYear) 
    {
        wait.until(ExpectedConditions.elementToBeClickable(startDatePickerIcon)).click(); // Open date picker

        // Navigate through months until the correct month and year is found
        while (!driver.findElement(monthYearButton).getText().contains(startMonthYear)) 
        {
            driver.findElement(nextMonthArrow).click();
        }

        // Select the day in the displayed month
           
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Format the date if necessary (assuming date is displayed as single digit day in the DOM)
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("d"));
        // Use the formatted date in the XPath to find the clickable element
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='" + formattedDate + "']")));
        // Click on the date
        dayElement.click();
        
    }

    // Method to set the end date
    public void setEndDate(String endMonthYear, String endDay) 
    {
        wait.until(ExpectedConditions.elementToBeClickable(endDatePickerIcon)).click(); // Open date picker

        // Navigate through months until the correct month and year is found
        while (!driver.findElement(monthYearButton).getText().contains(endMonthYear)) 
        {
            driver.findElement(nextMonthArrow).click();
        }

        // Select the day in the displayed month
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='" + endDay + "']")));
        dayElement.click();
    }
  //div[normalize-space()='31']
    // Method to set the start time using JavaScriptExecutor
    public void setStartTime() 
    {
    	    LocalTime currentTime = LocalTime.now();
    	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    	    String formattedTime = currentTime.format(formatter);
    	
        WebElement timeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(startTimeInput));
        jsExecutor.executeScript("arguments[0].value='" + formattedTime + "';", timeInput);

        // Trigger necessary events to update Angular's reactive form state
        triggerTimeChangeEvents(timeInput);
    }

    // Method to set the end time using JavaScriptExecutor
    public void setEndTime() 
    {
    	 // Get the current time and add 1 hour
        LocalTime currentTimePlusOneHour = LocalTime.now().plusHours(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedEndTime = currentTimePlusOneHour.format(formatter);
    	
        WebElement timeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(endTimeInput));
        jsExecutor.executeScript("arguments[0].value='" + formattedEndTime + "';", timeInput);

        // Trigger necessary events to update Angular's reactive form state
        triggerTimeChangeEvents(timeInput);
    }

    // Utility method to trigger change and blur events for Angular's reactive forms
    private void triggerTimeChangeEvents(WebElement timeInput) 
    {
        jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('input'));", timeInput);
        jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('change'));", timeInput);
        jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('blur'));", timeInput);
    }
}
