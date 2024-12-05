package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class VideoPage 
{
	WebDriver driver;
	private ElementUtils elementUtils;
    WebDriverWait wait;
 // XPaths as constants
    private static final String VIDEO_LINK_XPATH = "//span[normalize-space()='Training Videos']";
    private static final String ADD_VIDEO_ICON_XPATH = "//mat-icon[normalize-space()='add']";
    private static final String VIDEO_TITLE_XPATH = "//input[@name='title']";
    private static final String VIDEO_DESCRIPTION_XPATH = "//textarea[@name='description']";
    private static final String VIDEO_URL_XPATH = "//input[@name='url']";
    private static final String VIDEO_TYPE_DROPDOWN_XPATH = "//mat-select[@name='type']";
    private static final String LIVE_VIDEO_OPTION_XPATH = "//span[@class='mat-option-text'][normalize-space()='Live']";

	public VideoPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds wait

	}
	
	// Method to click on the 'Videos' link
    public void clickVideoLink() 
    {
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_LINK_XPATH)));
        videoLink.click();
    }

    // Method to verify text on the video page
    public void videoPageTextVerification() 
    {
        if (driver.getPageSource().contains("videos")) 
        {
            System.out.println("Video Page Is Displayed: Test Pass");
        } else 
        {
            System.out.println("Video Page is not displayed: Test Fail");
        }
    }

    // Method to click on the 'Add Video' icon
    public void clickAddVideoIcon() 
    {
        WebElement addVideoIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_VIDEO_ICON_XPATH)));
        addVideoIcon.click();
        
        // Verify Add Video page
        if (driver.getPageSource().contains("Add Video")) 
        {
            System.out.println("Add Video Page Is Displayed: Test Pass");
        } else 
        {
            System.out.println("Add Video Page is not displayed: Test Fail");
        }
    }

    // Method to enter the video title
    public void enterVideoTitle(String vdoTitle) 
    {
        WebElement videoTitleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_TITLE_XPATH)));
        videoTitleField.sendKeys(vdoTitle);
    }

    // Method to enter the video description
    public void enterDescription(String description) 
    {
        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_DESCRIPTION_XPATH)));
        descriptionField.sendKeys(description);
    }

    // Method to enter the video URL
    public void enterUrl(String url) 
    {
        WebElement urlField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_URL_XPATH)));
        urlField.sendKeys(url);
    }

  // Method to select 'Live' from the dropdown
    public void selectLiveVideo() 
    {
        WebElement videoTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_TYPE_DROPDOWN_XPATH)));
        videoTypeDropdown.click();

        WebElement liveOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LIVE_VIDEO_OPTION_XPATH)));
        liveOption.click();
    }

}
