package Day4;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ola_C {
	
	public String Confirm_booking(AndroidDriver driver) throws InterruptedException
	{
		driver.findElementById("android:id/button1").click();
		//wait
		WebDriverWait wait= new WebDriverWait(driver, 35);
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/button_ride_now")));
		System.out.println(until.isDisplayed());
		
		driver.findElementById("com.olacabs.customer:id/button_ride_now").click();
		Thread.sleep(4000);
		
		String text = driver.findElementById("com.olacabs.customer:id/button_ride_conform").getText();
		//System.out.println(text);
		Thread.sleep(4000);
		
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		return text;
		
	}

}
