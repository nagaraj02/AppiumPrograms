package Day5;

import org.testng.annotations.Test;

public class Testng_depends {
	
	@Test
	public void login()
	{
		int Result=4/0;
		
		System.out.println("Login to app");
	}

	@Test(dependsOnMethods={"login"})
	public void sendmail()
	{
		System.out.println("sent the mail");
	}
	
	@Test(dependsOnMethods={"sendmail"})
	public void closeapp()
	{
		System.out.println("closed the app");
	}

}
