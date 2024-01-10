package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listeners extends Utils implements ITestListener{
	
	ExtentReports extent = Utils.getReporterObject();
	ExtentTest test;
	AppiumDriver driver;
	
	public void onTestStart(ITestResult result) {
		//Prints in the report for every started case and gives testcase name
		test = extent.createTest(result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "This is successful");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver= (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			if (driver != null) {
				test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getDescription(), driver), result.getMethod().getMethodName());
			}
			else {
	            test.log(Status.WARNING, "Driver instance is null. Unable to capture screenshot.");
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context){
		extent.flush();

	}
}
