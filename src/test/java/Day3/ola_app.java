package Day3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ola_app {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		Process process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!=null)
		{
			System.out.println("Appium Server is Started");
		}
		else
		{
			System.out.println("NOT able to Start the Server");
		}
		
		Thread.sleep(12000);
		
		//Launch app
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				//device details
				capabilities.setCapability("deviceName", "GT-I9300I");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "4.4.4");
				
				//app details
				capabilities.setCapability("appPackage", "com.olacabs.customer");
				capabilities.setCapability("appActivity", "com.olacabs.customer.ui.SplashActivity");
				
				//appium server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				Thread.sleep(8000);
				//Alert does not work in Android native app or page
//				Alert alert = driver.switchTo().alert();
//				alert.accept();
				
				driver.findElementById("android:id/button1").click();
				//wait
				WebDriverWait wait= new WebDriverWait(driver, 35);
				WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/button_ride_now")));
				System.out.println(until.isDisplayed());
				
				driver.findElementById("com.olacabs.customer:id/button_ride_now").click();
				Thread.sleep(4000);
				
				String text = driver.findElementById("com.olacabs.customer:id/button_ride_conform").getText();
				System.out.println(text);
				Thread.sleep(4000);
				
				driver.sendKeyEvent(AndroidKeyCode.BACK);
				
				if(process!=null)
				{
					Thread.sleep(4000);
					
					process.destroy();						
					System.out.println("Appium Server is Stopped");
					
					
				}
				
				
				
				
				
				
	}

}
