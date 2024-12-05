package utils;

import java.util.Date;
import java.util.Random;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=20;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_BASIC_TIME=30;
	
	public String getEmailWithTimeStamp() 
	{
		
		
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		return "abhishek" + randomNumber + "@gmail.com";
		
		
//		Date date = new Date();
//		return "abhishek"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
		
	}
	
	

	public static  String QuizName() 
	{
		
		 Random random = new Random();
	     return "DemoQuiz" + (random.nextInt(900) + 100); // Generates "Course" followed by a random 3-digit number
		
	}
	public static  String videoName() 
	{
		
		 Random random = new Random();
	     return "DemoVideo" + (random.nextInt(900) + 100); // Generates "Course" followed by a random 3-digit number
		
	}
	
	
	public String pdf() 
	{
		
		Date date = new Date();
		return "DemoPdf"+date;
		
	}
	// Generate a random mobile number
    public String randomMobileNumber = generateMobileNumber();
    
    
    public static String generateMobileNumber() 
    {
        // The first digit should not be zero
//        int firstDigit = getRandomNumberInRange(1, 9);
    	// Ensure the first two digits are "95"
        int firstDigit = 7;
        int secondDigit = 3;

     // Generate the remaining 8 digits
        StringBuilder restOfDigits = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            restOfDigits.append(getRandomNumberInRange(0, 9));
        }

        // Combine all digits to form the mobile number
        return "" + firstDigit + secondDigit + restOfDigits.toString();
    }

    private static int getRandomNumberInRange(int min, int max) 
    {
    	Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    
    //to generate Random Name
    

    // Function to generate a random name
 // Generate a random name
    public String randomName = generateRandomName();
    
    private static String generateRandomName() 
    {
    	Random random = new Random();
	     return "DemoUser" + (random.nextInt(900) + 100); // Generates "Course" followed by a random 3-digit number
    }
    
 // Generate a random name
    public String randomCity = generateRandomCity();
    private static String generateRandomCity() 
    {
        String[] city = {"New York", "Tokyo", "London", "Paris", "Sydney", "Rio de Janeiro", "Mumbai", "Cape Town", "Vancouver", "Dubai"};

        // Generate a random index to select a name from the array
        int randomIndex = new Random().nextInt(city.length);

        return city[randomIndex];
    }
    //to generate random course
    // Method to generate a random course name
    public static String generateRandomCourseName() 
    {
        Random random = new Random();
        return "DemoCourse" + (random.nextInt(900) + 100); // Generates "Course" followed by a random 3-digit number
    }
    
    //generate random subject
    public  String RandomName() 
    {
    	Random random = new Random();
	     return "DemoSubject" + (random.nextInt(900) + 100); // Generates "Course" followed by a random 3-digit number
    }
    
}
