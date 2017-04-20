package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Screen_orientation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Launch app
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.DialtactsActivity");
		
		//appium server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(4000);
		
		driver.findElementByXPath("//*[@index='3'][@class='android.app.ActionBar$Tab']").click();
		Thread.sleep(3000);
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(8000);
		
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(8000);
		
	}

}
