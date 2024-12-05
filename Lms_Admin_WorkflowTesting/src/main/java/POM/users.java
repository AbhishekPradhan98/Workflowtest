package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class users 
{
	public WebDriver driver;
	private ElementUtils elementUtils;
	
	public users(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
		
	}
	By txt_clickUsers = By.xpath("(//div[@class='mat-list-item-content'])[12]");
	public void clickUsers()
	{
		 WebElement element=driver.findElement(txt_clickUsers);
			Actions act=new Actions(driver);

			act.moveToElement(element).build().perform();
			element.click();
	}
	public void savelistButton()
	{
	    driver.findElement(By.xpath("//span[normalize-space()='Save & List']")).click();

	}
}
