package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties intializeProperties() throws IOException 
	{
		
		Properties prop = new Properties();
		File proFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		
		
		try 
		{
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
