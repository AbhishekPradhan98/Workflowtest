package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils 
{
	
	public WebDriver driver;
    WebDriverWait wait;

	public ElementUtils(WebDriver driver) 
	{		
		this.driver = driver;
		PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds wait

	}
	 // XPaths as constants

    private By CourseContent = By.xpath("(//div[@class='mat-list-item-content'])[20]");
    private static final String CONFIRM_MSG_XPATH = "//div[@class='ng-star-inserted']";
    private static final String SUBJECT_FIELD_XPATH = "//input[@placeholder='Enter Subject']";
    private static final String TOPIC_FIELD_XPATH = "//input[@placeholder='Enter Topic']";
    private static final String SAVE_AND_LIST_BTN_XPATH = "//span[normalize-space()='Save & List']";
	
    public void clickCourseContent()
	{
		driver.findElement(CourseContent).click();
	}
	
    // Method to validate confirmation message
    public void validationMessage() 
    {
        WebElement confirmMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRM_MSG_XPATH)));
        System.out.println("Validation Message is : " + confirmMsg.getText());
    }

    // Method to enter subject
    public void enterSubject(String subject) throws Throwable 
    {
        WebElement subjectField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SUBJECT_FIELD_XPATH)));
        subjectField.sendKeys(subject);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBJECT_FIELD_XPATH)));
        Thread.sleep(2000);
        subjectField.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        subjectField.sendKeys(Keys.ENTER);
    }

    // Method to enter topic
    public void enterTopic(String topic) throws Throwable 
    {
        WebElement topicField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TOPIC_FIELD_XPATH)));
        topicField.sendKeys(topic);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOPIC_FIELD_XPATH)));
        Thread.sleep(1000);
        topicField.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        topicField.sendKeys(Keys.ENTER);
    }

    // Method to click on the 'Save & List' button
    public void clickSaveAndListBtn() 
    {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAVE_AND_LIST_BTN_XPATH)));
        saveBtn.click();
    }
	
	
    public void selectCheckbox()
    {
    	   // Find all checkboxes matching the specified class
        List<WebElement> checkboxes = driver.findElements(By.xpath("//mat-checkbox[@class='mat-checkbox mat-accent']"));

        // Get the size of the checkbox list
        int checkboxCount = checkboxes.size();
        System.out.println("Total number of checkboxes: " + checkboxCount);

        // Select the first checkbox that meets a certain condition (e.g., it's not selected)
        for (WebElement checkbox : checkboxes) 
        {
            WebElement inputElement = checkbox.findElement(By.xpath("//mat-checkbox[@class='mat-checkbox mat-accent']"));  // Assuming the input element is inside mat-checkbox
            if (!inputElement.isSelected()) 
            {  // Condition: if the checkbox is not already selected
                inputElement.click();  // Click the checkbox
                System.out.println("First checkbox that meets the condition is selected.");
                break;  // Exit the loop after selecting the first checkbox
            }
        }
 	   
    }
	
	public void clickOnElement(WebElement element,long durationInSeconds) 
	{
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		
	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
	}
	
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
		
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
		
	}
	
	public void acceptAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
		
	}
	
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
		
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		
		Alert alert = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return alert;
		
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);	
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
		
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webElement);
		
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);
		
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		return webElement.getText();
		
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {
		
		try {
			WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
			return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
		
	}
	
	public void scrolldown() throws Throwable
	{
		
		// Create a JavascriptExecutor instance
		   JavascriptExecutor jse = (JavascriptExecutor)driver;
		// Scroll down by a specific pixel value (e.g., 500 pixels)
			jse.executeScript("window.scrollBy(0,350)");
			Thread.sleep(3000);
	}
	
	
}
