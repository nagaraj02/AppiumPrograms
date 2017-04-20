package Day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Drag_Drop_NBM {

		public static void main(String[] args) throws MalformedURLException, InterruptedException {
			
		//Launch the App
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName", "ZY223FHHTV");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		
		//App details
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		
		//Appium server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
		
		Thread.sleep(5000);
		
		//click on first option 
		WebElement ele_Basic = driver.findElementById("com.mobeta.android.demodslv:id/activity_title");
		ele_Basic.click();
		
		
		List<WebElement> ele_item = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
		
		TouchAction action = new TouchAction(driver);
		action.longPress(ele_item.get(0)).moveTo(ele_item.get(5)).release().perform();
		
		Thread.sleep(6000);
		
		action.longPress(ele_item.get(6)).moveTo(ele_item.get(1)).release().perform();
		
		System.out.println("END: Successfully Completed");
				
	}
}
		