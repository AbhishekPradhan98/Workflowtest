 package QA.DriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonUtils;

public class DriverFactory {
	
	public static WebDriver driver=null;
	
	
	public static WebDriver initializeBrowser(String browserName) throws Throwable
	{
		
		if(browserName.equals("chrome")) 
		{
//			WebDriverManager.chromedriver().clearDriverCache().setup();

			
//			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			 // Create ChromeOptions to enable headless mode
//	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless");  // Enable headless mode
//	        options.addArguments("--disable-gpu");  // Disable GPU acceleration (optional but recommended)
//	        options.addArguments("--window-size=1920,1080");  // Set the window size (optional)
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();

			

			
//			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(300,TimeUnit.SECONDS);			

			
		}
		else if(browserName.equals("firefox")) 
		{
//			System.setProperty("Webdriver.firefox.driver","./Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		else if(browserName.equals("safari")) 
		{
			
			driver = new SafariDriver();
			
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		
		return driver;
		
	}
	
	public static WebDriver getDriver() 
	{
		
		return driver;
		
	}
	
	
	
}
