package stepDefinitions.Android;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


import PageObject.DisposableDomain_pom;

public class DisposableDomain_sd extends DisposableDomain_pom{

	@SuppressWarnings("deprecation")
	
	public void enter_disposable_email_and_signup(String email) throws InterruptedException {
		clear_email_field();
		enter_email_address(email);
		click_on_signup();
	}	
	
	//Executes only once Before every class
		@BeforeClass()
		public void navigate_to_signUp_page() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			click_on_signup_with_email();
			accept_terms_and_conditions();
		}
	
	@DataProvider
	public Object [][] flaggedDomains(){
		return new Object [][] {{"abc.com"},
			{"klovenode.com"},{"drowblock.com"},{"gixenmixen.com"},{"gmai.com"},{"gmeil.com"},
			{"mail.com"},{"gmali.com"},{"gmain.com"},{"gnail.com"},{"gmall.com"},
			{"gmal.com"},{"yaoo.com"},{"gmil.com"},{"nicroric.com"},{"maildrop.cc"},{"omheightsy.com"},
			{"miucce.online"},{"sharklasers.com"}};
		}
	
}
