package Day1;

import io.appium.java_client.android.AndroidDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Local_Nagaraj
 * step 1: Launch phone contact app
 * step 2: click on contacts list icon on left side
 * step 3: click on search text box
 * step 4: enter text "name/phone no" 
 * step 5: click on the name or phone no in the list
 * step 6: check for "Dialing" text (if "Dialing" is present, the pass else fail) 
 * step 7: click on  the call disconnect icon
 */
public class Call_through_Swipe_NBM {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		//Launch the APP
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","ZY223FHHTV");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		
		//app details
		capabilities.setCapability("appPackage", "com.android.dialer");
		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		//Appium server deails
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(4000);
		
		//click on contact List icon on left side
		driver.findElementByXPath("//*[@index='2'][@class='android.view.View']").click();
		Thread.sleep(4000);
		
		
		//click on search bar
		driver.findElementById("com.android.dialer:id/search_box_start_search").click();
		
		//read name from keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter A Name:");
		String name = br.readLine();
			
		//click on searchfield and send name as "name1"
		driver.findElementById("com.android.dialer:id/search_view").sendKeys(name);
		Thread.sleep(4000);
		
		String text2 = driver.findElementByXPath("//*[@index='1'][@class='android.widget.TextView']").getText();
		System.out.println("STRING2 = "+text2);
		
		Thread.sleep(2000);
		
		if (text2.contains(name))
		{
			System.out.println("Contact present");
		} else {
			System.out.println("Contact Not present");
			
		}
		
		//click on the search Name listed below
		driver.findElementById("com.android.dialer:id/cliv_name_textview").click();
		Thread.sleep(4000);
		
		//on dial screen, capture the text "Dialing"
		String text = driver.findElementById("com.android.dialer:id/callStateLabel").getText();
		if(text.contains("Dialing"))
		{
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		//Thread.sleep(1000);
		
		//click on call disconnect button
		driver.findElementById("com.android.dialer:id/floating_end_call_action_button").click();
		Thread.sleep(2000);
		
		System.out.println("END: Completed Successfully");
			
	}

}
