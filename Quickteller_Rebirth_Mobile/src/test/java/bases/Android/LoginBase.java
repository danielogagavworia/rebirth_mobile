package bases.Android;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Utils;
import java.net.URL;


public class LoginBase extends Utils {
	
	public AndroidDriver driver;

	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Launch_App() throws InterruptedException, IOException {
		
		// Setup Chromedriver using WebDriverManager
        //WebDriverManager.chromedriver().setup();
        
		Properties prop= new Properties();
		FileReader readFile = new FileReader(
				System.getProperty("user.dir") + "//src//test//resources//ConfigFiles//Config.properties");
		prop.load(readFile);
		
		String IPAddress= System.getProperty("ipAddress") != null ? System.getProperty("ipAddress"): prop.getProperty("ipAddress");
		String Port = System.getProperty("port") != null ? System.getProperty("port") : prop.getProperty("port");
		String DeviceName= System.getProperty("deviceName") != null ? System.getProperty("deviceName") : prop.getProperty("deviceName");
		
		appiumService= start_appium_Server(IPAddress, Integer.parseInt(Port));
		UiAutomator2Options options= new UiAutomator2Options();
		
		//Emulator Name
		options.setDeviceName(DeviceName);
		//APK location
		options.setApp(System.getProperty("user.dir")+"//src//test//resources//APKS//login//rebirth.apk");
		
		options.setCapability("uiautomator2ServerLaunchTimeout", 1200000); // Set the timeout to 120 seconds
		options.setCapability("chromedriver_autodownload", true);
		options.setCapability("chromedriverExecutable","C:\\Users\\daniel.ogagavworia\\eclipse-workspace\\Quickteller_Rebirth_Mobile\\src\\test\\resources\\webdriver\\chromedriver.exe");

		
		//Accepts the appium server string and Capabilities
		driver = new AndroidDriver(appiumService.getUrl(), options);
	}
	
	
	@AfterTest
	public void Close_App() {
		driver.quit();
		close_Appium_server();
	}


}
