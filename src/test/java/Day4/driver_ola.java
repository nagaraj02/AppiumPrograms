package Day4;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driver_ola extends Base_Class_ola {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		Start_Server();
		Initialize_app();
		
		Ola_C c1= new Ola_C();
		String Actual_Result = c1.Confirm_booking(driver);
		System.out.println(Actual_Result);
		
		Stop_Server();
		
		
		
				
				
				
				
				
				
				

	}

}
