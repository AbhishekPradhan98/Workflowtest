package hooks;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import QA.DriverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks extends BaseClass
{
	
	WebDriver driver;

	@Before
	public void setup() throws Throwable {
		
//		Properties prop = new ConfigReader().intializeProperties();
		
		configProp =new Properties();
		FileInputStream configProfile=new FileInputStream("config.properties");
		configProp.load(configProfile);
		
		
		driver = DriverFactory.initializeBrowser(configProp.getProperty("browser"));
		driver.get(configProp.getProperty("url"));
		
	}
	
	@After
	public void tearDown(Scenario scenario) throws Throwable {
		
		String scenarioName = scenario.getName().replaceAll(" ","_");
		
		if(scenario.isFailed()) {
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", scenarioName);
		}
		
//		Thread.sleep(3000);
//		driver.quit();
	
	
	}

}
