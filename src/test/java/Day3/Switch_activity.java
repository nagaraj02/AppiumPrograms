package Day3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_activity {

	public static void main(String[] args) throws IOException, InterruptedException {
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
				//******************************************************
				Thread.sleep(8000);
				//Message app
				
//				driver.startActivity("com.android.mms", "com.android.mms.ui.ConversationComposer");
//				
//				String Exp_Result= "8553124533";
//				System.out.println("Expeced Result is  "+Exp_Result);
//				Thread.sleep(3000);
//				
//				driver.findElementByXPath("//*[@index='0'][@class='android.widget.TextView'][@content-desc='Compose Button']").click();
//				Thread.sleep(7000);
//				
//				driver.findElementByXPath("//*[@class='android.widget.EditText'][@index='0'][@resource-id='com.android.mms:id/recipients_editor_to']").sendKeys("8553124533");
//				driver.findElementById("com.android.mms:id/edit_text_bottom").sendKeys(" Hi Dec Batch " +"\n"+ "Happy Christmas");
//				
//				driver.findElementById("com.android.mms:id/send_button").click();
//				Thread.sleep(5000);
//				
//				//click on the back button
//				driver.sendKeyEvent(AndroidKeyCode.BACK);
//				
//				Thread.sleep(3000);
//				
//				List<WebElement> ele_msgcont = driver.findElementsById("com.android.mms:id/from");
//				System.out.println(ele_msgcont.size());
//				
//				String Actual_Result = ele_msgcont.get(0).getText();
//				System.out.println("Actual Result is "+Actual_Result);
//				
//				if(Actual_Result.equals(Exp_Result))
//				{
//					System.out.println("Pass");
//				}
//				else
//				{
//					System.out.println("Fail");
//				}
//				
				//***********************************************
				Thread.sleep(8000);
				
				driver.startActivity("com.flipkart.android", "com.flipkart.android.activity.HomeFragmentHolderActivity");
				
				WebDriverWait wait3= new WebDriverWait(driver, 35);
				WebElement until3 = wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/search_widget_textbox")));
				System.out.println(until3.isDisplayed());
								
				driver.findElementById("com.flipkart.android:id/search_widget_textbox").click();
				Thread.sleep(4000);
						
				
				
				
				
				if(process!=null)
				{
					Thread.sleep(4000);
					
					process.destroy();						
					System.out.println("Appium Server is Stopped");
					
					
				}
				
				

	}

}
