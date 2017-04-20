package Day2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SMS_secondway {

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
				System.out.println("Expected Result is  "+Exp_Result);
				
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
				
				//for each loop
				//for(datatype ref_var:array)
				
				int flag=0;//mismatch
				
				for(WebElement ele:ele_msgcont)
				{
					//System.out.println(ele.getText());
					if((ele.getText()).equals(Exp_Result))
					{
						flag=1;//matching
						break;
					}
					else
					{
						flag=0;//mismatch
					}
					
				}
				
				
				//validation
				if(flag==1)
				{
					System.out.println("Pass");
				}
				else 
				{
					System.out.println("Fail");
				}
				

	}

}
