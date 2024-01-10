package testcases.Android;

import org.testng.annotations.Test;

import stepDefinitions.Android.Login_sd;

public class Login extends Login_sd {
	
	@Test(priority=1,description= "Validate that user cannot sign in using an unregistered email address")
	public void Testcase_One() throws InterruptedException{
		navigate_to_login_page();
		enter_email_details_and_login(unknown_Email_Address, invalid_Password);
		click_on_Login_Button();
		assert_user_is_notified_email_is_unknown();
	}
	
	@Test(priority=2,description= "Validate that user cannot sign in using an invalid password")
	public void Testcase_Two() throws InterruptedException{
		enter_email_details_and_login(valid_Email_Address, invalid_Password);
		assert_user_is_notified_of_invalid_details();
	}
	
	@Test(priority=3,description= "Validate that user can log in successfully")
	public void Testcase_Three() throws InterruptedException{
		enter_email_details_and_login(valid_Email_Address, valid_Password);
		assert_user_is_logged_in_successfully();
		logout_successfull();
	}
	
	@Test(priority=4,description= "Validate that user cannot sign in using an unregistered phonenumber")
	public void Testcase_Four() throws InterruptedException{
		navigate_to_login_page();
		click_on_signIn_with_phonenumber();
		enter_phoneNumber_details_and_login(unknown_number, invalid_Password);
		assert_user_is_notified_phonenumber_is_unknown();
	}
	
	@Test(priority=5,description= "Validate that user cannot sign in using an invalid password")
	public void Testcase_Five() throws InterruptedException{
		enter_phoneNumber_details_and_login(valid_number, invalid_Password);
		assert_user_is_notified_of_invalid_details();
	}
	
	@Test(priority=6,description= "Validate that user can log in successfully")
	public void Testcase_Six() throws InterruptedException{
		enter_phoneNumber_details_and_login(valid_number, valid_Password);
		assert_user_is_logged_in_successfully();
	}
	
}
