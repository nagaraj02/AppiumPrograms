package Day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Start_Appium_Server {

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
				capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
				capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
				
				//appium server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait
				Thread.sleep(4000);
				
				//click on basic usage
				WebElement ele_Basic = driver.findElementById("com.mobeta.android.demodslv:id/activity_title");
				ele_Basic.click();
				
				
				//Drag and drop
				List<WebElement> ele_item = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
				System.out.println(ele_item.size());
				
				//Touch action class
				
				TouchAction action= new TouchAction(driver);
				action.longPress(ele_item.get(0)).moveTo(ele_item.get(5)).release().perform();
				
				Thread.sleep(8000);	
				
				//Stop the Server
				
				if(process!=null)
				{
					Thread.sleep(4000);
					
					process.destroy();						
					System.out.println("Appium Server is Stopped");
					
					
				}
				

	}

}
