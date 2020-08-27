package webapptesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Cricbuzz {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Aditi");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\AditiArora\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		//connect to android device, which connects to the appium and check the capabilities in phone
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://m.cricbuzz.com");
	    
	    Thread.sleep(3000);
	    
	   // driver.findElement(MobileBy.AndroidUIAutomator("text(\"Menu\")")).click();
	    
	  driver.findElement(By.xpath("//span[contains(text(),'Menu')]")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	  WebElement element = driver.findElement(By.xpath("//span[contains(text(),'England, Australia players may not have to miss start of IPL')]"));
	
        JavascriptExecutor js = (JavascriptExecutor) driver;	
        
        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(4000);
	    element.click();
	
	}

}
