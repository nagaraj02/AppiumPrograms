package Demo2;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Horizontal_swipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch filpboard app
		//class	            //reference variable= Object
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "flipboard.app");
		capabilities.setCapability("appActivity", "flipboard.activities.LaunchActivity");
		
		//Appium server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(5000);
		//wait-- explicit wait
		WebDriverWait wait= new WebDriverWait(driver, 35);
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flipboard.app:id/home_feed_cover_item_image")));
		System.out.println(until.isDisplayed());
		
		//swipe for 4 time
		
		Dimension size = driver.manage().window().getSize();
		System.out.println("Dimension is "+size);
		
		int Startx=(int)(size.width*0.90);
		System.out.println("Startx is "+Startx);
		
		int Endx=(int)(size.width*0.10);
		System.out.println("Endx is "+Endx);
		
		int Starty=(int)(size.height*0.50);
		System.out.println("Starty is "+Starty);
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		//get the output
		
		//tagname[@attribute name='attribute value]
		
		String Actual_Result = driver.findElementByXPath("//*[@index='0'][@resource-id='flipboard.app:id/title'][@class='android.widget.TextView']").getText();
		System.out.println("Actual Result is "+Actual_Result);
		
		//Validate
		if(Actual_Result.contains("Add an Account"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		System.out.println("Swipe is successfull fro Right to left");
		
		//**************************************************************
		Thread.sleep(8000);
		
		int Startx1=(int)(size.width*0.10);
		int Endx1=(int)(size.width*0.90);
		
		int Starty1=(int)(size.height*0.50);
		
		for(int i=1;i<=4;i++)
		{
		driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
		Thread.sleep(4000);
		}
		
		System.out.println("From Left to Right swipe is successfull");
		

	}

}
