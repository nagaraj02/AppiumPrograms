package Day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/** Test comments  used for testing */
public class sample_test {

	//** Android Driver initialization */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","ZX1B32P4VL");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");
		
		//app details
		capabilities.setCapability("appPackage","com.android.mms");
		capabilities.setCapability("appActivity","com.android.mms.ui.ConversationList");
		
		//Appium Server details
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(4000);
		
		System.out.println("App Launched Successfully");

	}

}
