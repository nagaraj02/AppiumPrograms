package Day6;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class webbased_alert {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch app
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName", "SM-G350E");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		
		//app details
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		//appium server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(4000);
		
		driver.get("http://www.unionbankofindia.co.in/EMICal.aspx");
		Thread.sleep(3000);
		
		driver.findElementById("Button1").click();
		Thread.sleep(8000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		

	}

}
