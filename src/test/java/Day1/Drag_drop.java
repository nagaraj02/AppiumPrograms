package Day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Drag_drop {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//Launch app
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details ZY223FHHTV
		capabilities.setCapability("deviceName", "ZX1B32P4VL");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		
		//appium server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(4000);
		
		//click on first option "basic usage playground" 
		WebElement ele_Basic = driver.findElementById("com.mobeta.android.demodslv:id/activity_title");
		ele_Basic.click();
		
		
		//Drag and drop
		List<WebElement> ele_item = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
		//System.out.println(ele_item.size());
		
		//Touch action class
		TouchAction action= new TouchAction(driver);
		action.longPress(ele_item.get(0)).moveTo(ele_item.get(5)).release().perform();
		
		Thread.sleep(4000);	
		
		action.longPress(ele_item.get(6)).moveTo(ele_item.get(1)).release().perform();
//		action.moveTo(ele_item.get(1));
//		action.release();
//		action.perform();

		System.out.println("END:Successfully Executed");
		
	}

}
