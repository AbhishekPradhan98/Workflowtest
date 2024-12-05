package testRunner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenlink 

 {

	public static void main(String[] args) throws Throwable 
	{
		   WebDriverManager.chromedriver().setup();
	       WebDriver driver=new ChromeDriver();
	       driver.manage().deleteAllCookies();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
	       driver.get("https://google.com");
	       //driver.get("https://flipkart.com/");

			List<WebElement>links=driver.findElements(By.tagName("a"));
			System.out.println("No of Links :"+ links.size());
		
			
			List<String>urllist=new ArrayList<String>();
			for(WebElement e:links)
			{
				String url=e.getAttribute("href");
				urllist.add(url);
//				checkbrokenlink(url);
			}
			long stTime=System.currentTimeMillis();
			urllist.parallelStream().forEach(e ->checkbrokenlink(e));
			long endTime=System.currentTimeMillis();
			
			System.out.println("Total time taken:"+(endTime-stTime));	
//			Thread.sleep(2000);
//			driver.quit();
			
	}
	public static void checkbrokenlink(String linkurl)
	{
		try 
		{
			URL url=new URL(linkurl);
			HttpURLConnection httpUrlconnection=(HttpURLConnection) url.openConnection();
			httpUrlconnection.setConnectTimeout(5000);
			httpUrlconnection.connect();
			
			if(httpUrlconnection.getResponseCode()>=400)
			{
				System.out.println(linkurl +"  ------>  " + httpUrlconnection.getResponseMessage() + " is a Broken link");
				
			}
			else 
			{
				System.out.println(linkurl +" ----->  " + httpUrlconnection.getResponseMessage());
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}			
	}
}
