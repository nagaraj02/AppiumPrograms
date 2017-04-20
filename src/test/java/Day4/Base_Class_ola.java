package Day4;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Base_Class_ola {

	public static Process process;
	public static AndroidDriver driver;
	
	//Start server
	public static void Start_Server() throws IOException, InterruptedException
	{
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		 process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!=null)
		{
			System.out.println("Appium Server is Started");
		}
		else
		{
			System.out.println("NOT able to Start the Server");
		}
		
		Thread.sleep(12000);
		
	}
	
	
	//Initiliaze app
	public static void Initialize_app() throws MalformedURLException, InterruptedException
	{
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
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(8000);
		
		
	}
	
	
	//Stop server
	
	public static void Stop_Server() throws InterruptedException
	{
		Thread.sleep(4000);
		if(process!=null)
		{
			Thread.sleep(4000);
			
			process.destroy();						
			System.out.println("Stopped Appium Server");
			
			
		}
		
	}
	
	
	
}
