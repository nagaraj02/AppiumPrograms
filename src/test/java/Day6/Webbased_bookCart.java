package Day6;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Webbased_bookCart {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch app
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				//device details
				capabilities.setCapability("deviceName", "SM-G350E");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "4.4.2");
				
				//app details
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				
				//appium server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				Thread.sleep(4000);
				
				driver.get("http://books.rediff.com/");
				Thread.sleep(3000);
				
				driver.findElementById("srchword").sendKeys("Modi");
				driver.findElementByXPath("//input[@type='submit'][@class='srchbtn_n']").click();
				
				Thread.sleep(6000);
				
				List<WebElement> ele_book = driver.findElementsByTagName("a");
				
				for(WebElement element:ele_book)
				{
					System.out.println(element.getText());
					
					if((element.getText()).contains("Gamechanger"))
					{
						element.click();
						break;
						
					}
					
				}
				
				Thread.sleep(5000);
				
				driver.findElementByXPath("//input[@class='buynowbtn'][@type='button'][@value='Buy Now']").click();
				
				Thread.sleep(4000);
				
				String Actual_Result = driver.findElementByCssSelector("#currentcartdiv > div.cart_prd_row > div.prddetail > span:nth-child(1)").getText();
				System.out.println(Actual_Result);
				Thread.sleep(3000);
				
				if(Actual_Result.contains("Gamechanger"))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				

	}

}
