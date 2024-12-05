package testRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bulkTest {

	public static void main(String[] args) throws Throwable 
	{
		 // Path for the file to be uploaded
        String workingDir = System.getProperty("user.dir");
        String filepaths = "/BulkUser.xlsx";
        String filePath = workingDir + filepaths;

        // Step 1: Create a new Excel file with random data
        createExcelWithRandomData(filePath);
		
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://d1hybkb3ihsdfi.cloudfront.net");
		//login
	    
	        driver.findElement(By.id("loginEmail")).sendKeys("morwal89@gmail.com");
			driver.findElement(By.id("loginPassword")).sendKeys("Exam@123");
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='mat-list-item-content'])[13]")).click();
			driver.findElement(By.xpath("//span[normalize-space()='All Users']")).click();
			
			  // Locate the file upload element
	        WebElement fileUpload = driver.findElement(By.xpath("//input[@type='file']"));

	        // Upload the generated Excel file
	        fileUpload.sendKeys(filePath);
			
			
    Thread.sleep(15000);
	driver.close();		
	}
	 // Method to generate random data and write it into the Excel file
    public static void createExcelWithRandomData(String filePath) throws IOException {
        // Create a new workbook and a sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = (Sheet) workbook.createSheet("UserData");

        // Create the header row
        Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
        headerRow.createCell(0).setCellValue("name");
        headerRow.createCell(1).setCellValue("email");
        headerRow.createCell(2).setCellValue("mobileNumber");
        headerRow.createCell(3).setCellValue("Department");
        headerRow.createCell(4).setCellValue("Location");

        // Generate and add random data for 10 users
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(i);

            // Generate random name, email, mobile number, department, and location
            String name = "User" + i;
            String email = "user" + i + "@example.com";
            String mobileNumber = "9" + String.format("%09d", random.nextInt(1000000000));
            String department = "IT"; // You can change this as needed
            String location = "Jaipur"; // You can change this as needed

            // Set the values in the row
            row.createCell(0).setCellValue(name);
            row.createCell(1).setCellValue(email);
            row.createCell(2).setCellValue(mobileNumber);
            row.createCell(3).setCellValue(department);
            row.createCell(4).setCellValue(location);
        }

        // Write the Excel file to disk
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) 
        {
            workbook.write(fileOut);
            System.out.println("Random data Excel file created successfully: " + filePath);
        }

        // Close the workbook
        workbook.close();
    }
}
