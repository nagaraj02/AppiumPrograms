package Day6;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hybrid_App_Maps_learning {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch app
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				//device details
				capabilities.setCapability("deviceName", "GT-I9300I");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "4.4.4");
				
				//app details
				capabilities.setCapability("appPackage", "com.emn8.mobilem8.nativeapp.bk");
				capabilities.setCapability("appActivity", "com.emn8.mobilem8.nativeapp.bk.BKNativeMobileApp");
				
				//appium server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				Thread.sleep(4000);
				//*******************************************************************
				
				Set<String> contextHandles = driver.getContextHandles();
				//***************************************************************
				
				Map<String,String> hashMap= new HashMap<String,String>();
				
				//*********************************************************
				for(String contextname:contextHandles)
				{
														
					if(contextname.contains("NATIVE"))
					{
						hashMap.put("native", contextname);
						
					}
					else
					{
						hashMap.put("webview", contextname);
					}
				}
				
				
				//*******************************************************
				//first page
				
				System.out.println("---first page--- ");
				driver.context(hashMap.get("native"));
				
				WebDriverWait wait= new WebDriverWait(driver, 50);
				WebElement ele_voucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.View'][@index='9'][@content-desc='VOUCHERS']")));
				
				System.out.println(ele_voucher.isDisplayed());
				
				Thread.sleep(6000);
				ele_voucher.click();
				
				//********************************************************************
				Thread.sleep(9000);
				System.out.println("----Second page----"+" Redeem element");
				driver.context(hashMap.get("native"));
				
				
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@class='android.view.View'][@index='17'][@content-desc='REDEEM']").click();
				
				Thread.sleep(8000);
				
				//******************************************************************
				System.out.println("----Third page----"+" uname,pwd element");
				driver.context(hashMap.get("webview"));
				
				
				Thread.sleep(6000);
				
				driver.findElementByXPath("//input[@class='x-input-email'][@type='email'][@name='email']").sendKeys("descbatch@gmail.com");
				WebElement ele_pwd = driver.findElementByXPath("//input[@class='x-input-password'][@type='password'][@name='password']");

				ele_pwd.click();
				Thread.sleep(4000);
				ele_pwd.sendKeys("12345");
				
				Thread.sleep(6000);
				
				//******************************************************************
				System.out.println("----Third page----"+" Sign in element");
				driver.context(hashMap.get("native"));
				
				Thread.sleep(6000);
				driver.findElementByXPath("//*[@class='android.view.View'][@index='69'][@content-desc='SIGN IN']").click();
				Thread.sleep(6000);
				
				driver.sendKeyEvent(AndroidKeyCode.BACK);

	}

}
