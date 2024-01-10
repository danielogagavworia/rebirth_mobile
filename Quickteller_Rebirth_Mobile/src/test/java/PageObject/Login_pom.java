package PageObject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import bases.Android.LoginBase;

public class Login_pom extends LoginBase {
	
	
	// LOCATORS
	private By signIn_Btn = By.xpath("//android.widget.TextView[@text='Sign in']");
	protected By email_TextField= By.xpath("//android.view.ViewGroup[1]/android.widget.EditText[@index=0]");
	protected By password_TextField= By.xpath("//android.view.ViewGroup[2]/android.widget.EditText[@index=0]");
	private By login_Btn= By.xpath("//android.view.ViewGroup[5]/android.widget.TextView[@text='Sign in']");
	private By err_msg= By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2][@index=1]");
	private By quickteller_login_successful= By.xpath("//android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1][@index=11]");
	private By account_n_Setting= By.xpath("//android.view.ViewGroup[2]/android.view.View/android.view.View[4]/android.widget.TextView[@text='Account']");
	private By logout= By.xpath("//android.view.ViewGroup[2]/android.widget.TextView[1][@text='Log Out']");
	private By signIn_with_PhoneNumb= By.xpath("//android.view.ViewGroup[8]/android.widget.TextView[@text='Sign in with Phone Number']");
	protected By phoneNumb_TextField= By.xpath("//android.view.ViewGroup[2]/android.widget.EditText[@index=0]");
	protected By password_TextField2= By.xpath("//android.view.ViewGroup[3]/android.widget.EditText[@index=0]");
	private By signin_here_hyperlink= By.xpath("//android.widget.TextView[@text='Sign in here']");
	private By phoneNumber_login_Btn= By.xpath("//android.view.ViewGroup[6]/android.widget.TextView[@text='Sign in']");
	
	
	
	//DATA
	protected String valid_Email_Address="dadubiaro@interswitch.com";
	protected String unknown_Email_Address="danielogavworia@gmail.com";
	protected String unknown_number= "08124888411";
	protected String valid_number= "08124888436";
	protected String valid_Password="password";
	protected String invalid_Password="inpassword";
	private String expected_unknown_email_msg= "We could not find an account associated with this email";
	private String expected_unknown_email_msg2 ="Error processing request, please try again.";
	private String expected_invalid_details_msg= "Incorrect password, 3 attempts remaining.";
	private String expected_unknown_phoneNumber_msg= "We could not find an account associated with this phone number";
	
	
	
	//ACTIONS
	public void click_On_SignIN_Button() {
		wait_until_element_shows(signIn_Btn, driver);
		driver.findElement(signIn_Btn).click();
	}
	
	public void enterUsername(String email) {
		driver.findElement(email_TextField).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(password_TextField).sendKeys(password);
	}
	
	public void click_on_Login_Button() {
		driver.findElement(login_Btn).click();
	}
	
	public void click_on_account_icon(){
		driver.findElement(account_n_Setting).click();
	}
	
	public void click_on_logout(){
		scroll_to_element("Log Out", driver);
		driver.findElement(logout).click();
	}
	
	public void click_on_signIn_with_phonenumber(){
		driver.findElement(signIn_with_PhoneNumb).click();
	}
	
	public void click_on_sign_in_here(){
		driver.findElement(signin_here_hyperlink).click();
	}
	
	
	public void enterphoneNumber(String phoneNumber) {
		driver.findElement(phoneNumb_TextField).sendKeys(phoneNumber);
	}
	
	public void enter_Password(String password) {
		driver.findElement(password_TextField2).sendKeys(password);
	}
	
	public void click_on_phoneNumber_Login_Button() {
		driver.findElement(phoneNumber_login_Btn).click();
	}
	
	
	public void assert_user_is_notified_email_is_unknown() {
		String actual_unknown_email_msg= get_success_or_error_message(err_msg, driver);
		assert_result_is_One_of(actual_unknown_email_msg, expected_unknown_email_msg, expected_unknown_email_msg2);
	}
	
	public void assert_user_is_notified_phonenumber_is_unknown() {
		String actual_unknown_phoneNumber_msg= get_success_or_error_message(err_msg, driver);
		assert_result_is_One_of(actual_unknown_phoneNumber_msg, expected_unknown_phoneNumber_msg, expected_unknown_email_msg2);
	}

	
	public void assert_user_is_logged_in_successfully() throws InterruptedException{
		wait_until_element_shows(quickteller_login_successful, driver);
		Boolean check_users_profile_is_displayed= check_element_visibility(quickteller_login_successful, driver);
		validate_actual_result_is_True(check_users_profile_is_displayed);
		Thread.sleep(9000);
	}
	
	public void assert_user_is_notified_of_invalid_details(){
		String actual_invalid_details_msg= get_success_or_error_message(err_msg, driver);
		validate_success_or_error_message(actual_invalid_details_msg,expected_invalid_details_msg);
	}
	
	
	
	public void clear_emailField(By element) {
		driver.findElement(element).clear();
	}
	
	
	public void clear_passwordField(By element) {
		driver.findElement(element).clear();
	}
	
	
	
}
