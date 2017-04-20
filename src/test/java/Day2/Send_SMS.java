package Day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Send_SMS {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//launch app
		DesiredCapabilities capabilities= new DesiredCapabilities();

		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		capabilities.setCapability("appPackage", "com.android.mms");
		capabilities.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(5000);
		
		String Exp_Result= "8553124533";
		System.out.println("Expeced Result is  "+Exp_Result);
		
		driver.findElementByXPath("//*[@index='0'][@class='android.widget.TextView'][@content-desc='Compose Button']").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.android.mms:id/recipients_editor_to").sendKeys("8553124533");
		driver.findElementById("com.android.mms:id/edit_text_bottom").sendKeys(" Hi Dec Batch " +"\n"+ "Happy Christmas");
		
		driver.findElementById("com.android.mms:id/send_button").click();
		Thread.sleep(5000);
		
		//click on the back button
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		Thread.sleep(3000);
		
		List<WebElement> ele_msgcont = driver.findElementsById("com.android.mms:id/from");
		System.out.println(ele_msgcont.size());
		
		String Actual_Result = ele_msgcont.get(0).getText();
		System.out.println("Actual Result is "+Actual_Result);
		
		if(Actual_Result.equals(Exp_Result))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		
		
	
	
	}

}
