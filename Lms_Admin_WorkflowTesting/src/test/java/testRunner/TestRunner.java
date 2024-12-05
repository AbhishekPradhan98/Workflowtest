
package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions 
(

		features = 
	            {
	            		
//				".//Featurefiles//",
//	    	    ".//Featurefiles/A_Login.feature"
	            ".//Featurefiles/B_AdminUsersModule.feature"
//	    	    ".//Featurefiles/C_Roles.feature"
//	   	    	".//Featurefiles/D_Course_Content_Qustions.feature"
//	  	   	    ".//Featurefiles/E_CoureContent_Video.feature"
//	            		".//Featurefiles/F_CourseContent_Quiz.feature"
//	    	    ".//Featurefiles/G_Pdf.feature"
//	    	     ".//Featurefiles/H_Courses.feature"

		         },
	    glue={"stepdefinitions","hooks"},
	    publish = true,       
		dryRun = false ,
//		monochrome = true,
		
		plugin = {"pretty",
				
				"html:reports/LMS_HTML-Reports.html",
				"json:reports/LMS_J SON_Reports.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",	
				"rerun:target/rerun.txt", //Mandatory to capture failures
		        
		        })

   public class TestRunner
   {
 
   }


 