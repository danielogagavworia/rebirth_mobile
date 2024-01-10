package testcases.Android;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import stepDefinitions.Android.DisposableDomain_sd;

public class DisposableDomain extends DisposableDomain_sd{

	@Test(dataProvider="flaggedDomains",description="Verify that user cannot sign up on quickteller using the flagged disposable email address")
	public void Testcase_One(String disposable_email) throws InterruptedException{ 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		enter_disposable_email_and_signup("dannnn@"+disposable_email);
		assert_user_is_notified_of_invalid_domain();
	}		
	
}
