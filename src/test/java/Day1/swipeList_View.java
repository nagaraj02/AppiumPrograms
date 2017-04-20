package Day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class swipeList_View {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
			
		//Launch App
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","ZY223FHHTV");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","6.0.1");
		
		//app details
		capabilities.setCapability("appPackage","com.fortysevendeg.android.swipelistview");
		capabilities.setCapability("appActivity","com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
		
		//Appium Server details
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(4000);
		
		//swipe Horizontally
		//get the size of the screen
		Dimension size = driver.manage().window().getSize();
		System.out.print("Screen Size = " + size + "\n");
		
		//find swipe start and swipe end point from screen width and height
		//find the startx point which is at the right side of the screen
		int startx = (int) (size.width*0.80);
		
		//find the endx point which at the left side of the screen
		int endx = (int) (size.width*0.20);
		
		//find the vertical point where you want to swipe.It is in the middle of the screen height
		int starty = (int) (size.height/2);
		
		
		System.out.println("startx = "+ startx + "\n" + "endx = "+ endx + "\n" + "starty = "+ starty);
		
		//swipe from right to left
		driver.swipe(startx, starty, endx, starty, 1000);
		Thread.sleep(3000);
		
	
		//swipe from left to right
		driver.swipe(endx, starty, startx, starty, 3000);
		Thread.sleep(3000);
		
		
		//Swiping Vertically
		//find starty point which at the bottom of the screen
		int starty1 = (int) (size.height*0.80);
		
		//find endy point which at the top of the screen
		int endy = (int) (size.height*0.20);
		
		//find the horizontal point where you want to swipt. It is in middle of the screen width
		int startx1 = size.width/2;
		
		//now swipe from botton to top
		driver.swipe(startx1, starty1, startx1, endy, 2000);
		Thread.sleep(2000);
				
		//now swipe from top to bottom
		driver.swipe(startx1, endy, startx1, starty1, 2000);
		Thread.sleep(2000);
		
		
		System.out.println("END: successfully Completed");
		
	}

}
