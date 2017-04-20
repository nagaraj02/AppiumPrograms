package Day5;

import org.testng.annotations.Test;

public class Testng_priority {
	
	@Test(priority=1)
	public void login()
	{
		System.out.println("Login to app");
	}

	@Test(priority=2)
	public void sendmail()
	{
		System.out.println("sent the mail");
	}
	
	@Test(priority=3)
	public void closeapp()
	{
		System.out.println("closed the app");
	}
	

}
