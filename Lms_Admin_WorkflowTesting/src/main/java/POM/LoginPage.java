package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	By txt_Email=By.id("loginEmail");
	By txt_Password= By.id("loginPassword");
	By txt_loginBtn= By.xpath("//button[@id='login-button']");
	By txt_dashboard = By.xpath("//h1[normalize-space()='dashboard']");
	
public void loginEmail(String email)
{
	driver.findElement(txt_Email).sendKeys(email);
}

public void password(String pwd)
{
	driver.findElement(txt_Password).sendKeys(pwd);
}
	
public void clickLoginBtn()
{
	driver.findElement(txt_loginBtn).click();
}

public void dashboardPage()
{
	WebElement dashboardPage = driver.findElement(txt_dashboard);
	  
	  if(dashboardPage.isDisplayed())
	  {
		  System.out.println(dashboardPage.getText() + " Page is displayed : Test Pass" );
	  }else 
	  {
		System.out.println("dashboardPage is not display : Test Fail");
	  }	
}
	
//	public LoginPage(WebDriver driver) 
//	{
//		
//		this.driver = driver;
//		PageFactory.initElements(driver,this);
//		elementUtils = new ElementUtils(driver);
//		
//	}
//	
//	@FindBy(id="loginEmail")
//	private WebElement emailField;
//	
//	@FindBy(id="loginPassword")
//	private WebElement passwordField;
//	
//	@FindBy(xpath="//input[@value='Login']")
//	private WebElement loginButton;
//	
//	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
//	private WebElement warningMessage;
//	
//	public void enterEmailAddress(String emailText) 
//	{
//		
//		elementUtils.typeTextIntoElement(emailField, emailText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//		
//	}
//	
//	public void enterPassword(String passwordText) {
//		
//		elementUtils.typeTextIntoElement(passwordField, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//		
//	}
//	
//	
//	public String getWarningMessageText()  
//	{
//		
//		return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//		
//	}

}
