/*Download and install appium-inspector
 * appium:app  C://Users//daniel.ogagavworia//Documents//Appium_Tutorial//src//test//resources//ILS-Visa.apk
 * appium:automationName  UIAutomator2
 * appium:deviceName  Daniels
 * platformName   android*/


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class Login {
	
	@SuppressWarnings("deprecation")
	@Test
	public void LoginToQuicteller() throws MalformedURLException, InterruptedException {
		AppiumDriverLocalService appiumService =new AppiumServiceBuilder().withAppiumJS(new File("C://Users//daniel.ogagavworia//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		//Starts the appium server automatically
		appiumService.start();
		
		
		UiAutomator2Options options= new UiAutomator2Options();
		//Emulator Name
		options.setDeviceName("Daniels");
		//APK location
		//options.setApp("C://Users//daniel.ogagavworia//Documents//Quickteller_Mobile_Automation//src//test//resources//APKS//app-release.apk");
		options.setApp(System.getProperty("user.dir")+"//src//test//resources//APKS//app-release.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
		
		//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView")).click();
		
		
		
		//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")).sendKeys("chiamaka@sharklasers.com");
		
		//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]")).sendKeys("Password@123");
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@index=3]")).sendKeys("chiamaka@sharklasers.com");
		
		driver.findElement(By.xpath("//android.widget.EditText[@index=6]")).sendKeys("Password@123");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='LOGIN']")).click();
		
		Thread.sleep(35000);

		driver.quit();
		
		appiumService.stop();
	}

}
