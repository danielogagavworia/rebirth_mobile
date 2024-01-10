package PageObject;

import org.openqa.selenium.By;

import bases.Android.LoginBase;

public class DisposableDomain_pom extends LoginBase  {
	
	// LOCATORS
	private By signup_with_email_btn = By.xpath("//android.widget.TextView[@text='Sign up with Email']");
	private By email_textfield= By.xpath("//android.view.ViewGroup[1]/android.widget.EditText[@index=0]");
	private By tnc_checkbox= By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[1][@index=0]");
	private By signup_btn= By.xpath("//android.widget.TextView[@text='Sign up']");
	private By err_msg= By.xpath("//android.widget.TextView[2][@index=1]");
	
	//INPUTS
	private String expected_domainErrMsg= "Email Domain not supported";
	
	
	
	//ACTIONS
	public void click_on_signup_with_email() {
		driver.findElement(signup_with_email_btn).click();
	}
	
	public void enter_email_address(String email) {
		driver.findElement(email_textfield).sendKeys(email);
	}
	
	public void clear_email_field() {
		driver.findElement(email_textfield).clear();
	}
	
	public void accept_terms_and_conditions() {
		driver.findElement(tnc_checkbox).click();
	}
	
	
	public void click_on_signup() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(signup_btn).click();
	}
	
	
	public void assert_user_is_notified_of_invalid_domain(){
		String actual_domainErrMsg= get_success_or_error_message(err_msg, driver);
		validate_success_or_error_message(actual_domainErrMsg,expected_domainErrMsg);
	}
	
}
