package Day4_Session2;

import io.appium.java_client.android.AndroidDriver;

public class Mortgage_C {
	
	
	public String Calculate_EMI(AndroidDriver driver,String Amount, String Tenure, String Interest)
	{
		driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys(Amount);
		driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys(Tenure);
		driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys(Interest);
		
		driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
		
		String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
		System.out.println("Output is "+Output);
		
		String Result = Output.replace("$", "");
		return Result;
		
	}

}
