package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Drag_drop_remove {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
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
				
				driver.findElementByXPath("//*[@text='CursorAdapter'][@index='0'][@class='android.widget.TextView']").click();
				Thread.sleep(2000);
				
				List<WebElement> ele_txtcont = driver.findElementsById("com.mobeta.android.demodslv:id/text");
				System.out.println(ele_txtcont.size());
				
				List<WebElement> ele_remcont = driver.findElementsById("com.mobeta.android.demodslv:id/click_remove");
				System.out.println(ele_remcont.size());
				
				for(int i=0;i<ele_txtcont.size();i++)
				{
					if((ele_txtcont.get(i).getText()).equals("Michael Brecker"))
						
					{
						ele_remcont.get(i).click();
						break;
						
					}
						
				}
				
				int flag=0;//Michael breaker should be available
				for(WebElement ele:ele_txtcont)
				{
					
					if(!(ele.getText()).equals("Michael Brecker"))
					{
						flag=1;//Michael Brecker not avilable
					}
					else
					{
						flag=0;//Avaiable
						break;
					}
					
				}
				
				
				//Validate
				if(flag==1)
				{
					System.out.println("Pass");
				}
				else if(flag==0)
				{
					System.out.println("Fail");
				}
				
	}

}
