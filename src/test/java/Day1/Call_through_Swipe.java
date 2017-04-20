package Day1;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Call_through_Swipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
			
				//Launch app
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				//device details
				capabilities.setCapability("deviceName", "ZY223FHHTV");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "6.0.1");
				
				//App details
				capabilities.setCapability("appPackage", "com.android.contacts");
				capabilities.setCapability("appActivity", "com.android.contacts.activities.DialtactsActivity");
				 
				//appium server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait for 4 seconds after app launched
				Thread.sleep(4000);
				
				driver.findElementByXPath("//*[@index='3'][@class='android.app.ActionBar$Tab']").click();
				Thread.sleep(3000);
				
				Dimension size = driver.manage().window().getSize();
				System.out.println("size is "+size);
				
				//Vertical swipe
				int Starty=(int)(size.height*0.90);
				int Endy=(int)(size.height*0.20);
				
				int Startx=(int)(size.width*0.50);
				
				WebElement ele_contact = driver.findElementByXPath("//*[@class='android.widget.TextView']");
				
				do
				{
					List<WebElement> ele_item1 = driver.findElementsByXPath("//*[@index='1'][@text='Office2'][@class='android.widget.TextView']");
					int size2 = ele_item1.size();
					System.out.println(size2);
					Thread.sleep(3000);
					
					//identify the text and stop
					if(size2>0)
					{
						//Horizontal swipe to calll
						
						int Startx1=(int)(size.width*0.10);
						int Endx1=(int)(size.width*0.90);
						Thread.sleep(3000);
						
						WebElement ele_item2 = driver.findElementByXPath("//*[@index='1'][@text='Office2'][@class='android.widget.TextView']");
						int Starty1 = ele_item2.getLocation().getY();
						Thread.sleep(3000);
						
						driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
						break;
						
						
					}
					
					
					//Vertical swipe
					driver.swipe(Startx, Starty, Startx, Endy, 1000);
					Thread.sleep(2000);
				}while(ele_contact.isDisplayed()==true);
				
				Thread.sleep(5000);
				String text = driver.findElementById("com.android.phone:id/callStateLabel").getText();
				
				if(text.contains("Dialling"))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
	}

}
