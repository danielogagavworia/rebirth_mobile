package stepDefinitions.Android;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.Login_pom;


public class Login_sd extends Login_pom{
	
	
	public void navigate_to_login_page() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_On_SignIN_Button();
	}
	
	@SuppressWarnings("deprecation")
	public void enter_email_details_and_login(String username, String password) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clear_emailField(email_TextField);
		enterUsername(username);
		clear_passwordField(password_TextField);
		enterPassword(password);
		click_on_Login_Button();
		}
	
	public void logout_successfull() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(15000);
		click_on_account_icon();
		click_on_logout();
	}
	
	
	@SuppressWarnings("deprecation")
	public void enter_phoneNumber_details_and_login(String phonenumber, String password) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clear_emailField(phoneNumb_TextField);
		enterphoneNumber(phonenumber);
		clear_passwordField(password_TextField2);
		enter_Password(password);
		click_on_phoneNumber_Login_Button();
		}
	
}
