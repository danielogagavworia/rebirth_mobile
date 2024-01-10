package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Utils {

	public AppiumDriverLocalService appiumService;

	// Starts the Appium Server
	public AppiumDriverLocalService start_appium_Server(String IPAddress, int Port) {

		try {
			appiumService = new AppiumServiceBuilder().withAppiumJS(new File(
					"C://Users//daniel.ogagavworia//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
					.withIPAddress(IPAddress).usingPort(Port).withTimeout(Duration.ofSeconds(600)).build();

			appiumService.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return appiumService;
	};

	// Stop the Appium Server
	public void close_Appium_server() {
		appiumService.stop();
	};

	public static ExtentReports getReporterObject() {
		String ReportPath = System.getProperty("user.dir") + "\\reporters\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(ReportPath);
		reporter.config().setReportName("QT Mobile Test Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

	public String getScreenshot(String testcaseName, AppiumDriver driver) throws IOException {
		File sourcee = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileDestination = System.getProperty("user.dir") + "\\reporters\\" + testcaseName + ".png";
		File Destination = new File(fileDestination);
		FileUtils.copyFile(sourcee, Destination);
		return fileDestination;
	}

	// Waits for an element to disappear
	public void wait_until_element_clears(String elementXpath, AppiumDriver driver) {
		FluentWait<AppiumDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofMillis(5000)).ignoring(org.openqa.selenium.NoSuchElementException.class);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));
	}

	// Asserts both expected and actual results are equal
	public void validate_success_or_error_message(String actual_result, String expected_result) {
		SoftAssert soft_assert = new SoftAssert();
		soft_assert.assertEquals(actual_result, expected_result);
		soft_assert.assertAll();
	}

	// Asserts that the result is true
	public void validate_actual_result_is_True(boolean actual_result) {
		SoftAssert soft_assert = new SoftAssert();
		soft_assert.assertTrue(actual_result);
		soft_assert.assertAll();
	}

	public void validate_actual_result_isFalse(boolean actual_result) {
		SoftAssert soft_assert = new SoftAssert();
		soft_assert.assertFalse(actual_result);
		soft_assert.assertAll();
	}

	public void wait_until_element_shows(By elementXpath, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		wait.until(ExpectedConditions.presenceOfElementLocated(elementXpath));

	}

	public void scroll_to_element(String text, AppiumDriver driver) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
	}

	public String get_success_or_error_message(By element, WebDriver driver) {
		String successfully_msg = driver.findElement(element).getText();
		return successfully_msg;
	}

	public Boolean check_element_visibility(By element, WebDriver driver) {
		Boolean element_visibility = driver.findElement(element).isDisplayed();
		return element_visibility;
	}
	
	
	public void assert_result_is_One_of(String actual_result, String expected_result1, String expected_result2) {
		SoftAssert softAssert= new SoftAssert();
		
		//Asserts passes if one of the error messages below is displayed
		softAssert.assertTrue(
				actual_result.equals(expected_result1) || actual_result.equals(expected_result2)        
        );
		softAssert.assertAll();	
	}

}
