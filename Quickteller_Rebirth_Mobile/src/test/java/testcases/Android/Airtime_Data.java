package testcases.Android;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import stepDefinitions.Android.Airtime_Data_sd;


public class Airtime_Data extends Airtime_Data_sd {
	
	@Test(priority=1,description= "Validate that user can purchase airtime for mtn successfully using card as a payment method")
	public void Testcase_One() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		login_successfully();
		navigate_to_airtime_and_data();
		enter_number(mtn_number);
		select_airtime_and_proceed_to_payment();
		select_card_as_payment_choice_and_enter_verve_card_details();
		enter_otp();
		assert_reharge_is_successful();
	}
	
	
	@Test(enabled = false, priority=2,description= "Validate that user can purchase airtime for airtel successfully using card as a payment method")
	public void Testcase_Two() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		repurchase();
		enter_number(airtel_number);
		select_airtime_and_proceed_to_payment();
		select_card_as_payment_choice_and_enter_verve_card_details();
		enter_otp();
		assert_reharge_is_successful();
	}
	
	@Test(enabled = false, priority=3,description= "Validate that user can purchase airtime for glo successfully using card as a payment method")
	public void Testcase_Three() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		repurchase();
		enter_number(glo_number);
		select_airtime_and_proceed_to_payment();
		select_card_as_payment_choice_and_enter_verve_card_details();
		enter_otp();
		assert_reharge_is_successful();
	}
	
	@Test(enabled = false, priority=4,description= "Validate that user can purchase airtime for 9mobile successfully using card as a payment method")
	public void Testcase_Four() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		repurchase();
		enter_number(n9mobile_number);
		select_airtime_and_proceed_to_payment();
		select_card_as_payment_choice_and_enter_verve_card_details();
		enter_otp();
		assert_reharge_is_successful();
	}
	
	@Test(priority=5,description= "Validate that user can purchase data from Mtn successfully using QT Account as a payment method")
	public void Testcase_Five() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		repurchase();
		enter_number(mtn_number);
		select_data_plan_and_proceed_to_payment();
		select_QT_account_payment_choice_and_proceed();
		assert_reharge_is_successful();
	}
	
	@Test(enabled = false, priority=6,description= "Validate that user can purchase data from Airtel successfully using QT Account as a payment method")
	public void Testcase_Six() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		repurchase();
		enter_number(airtel_number);
		select_data_plan_and_proceed_to_payment();
		select_QT_account_payment_choice_and_proceed();
		assert_reharge_is_successful();
	}
	
	@Test(enabled = false, priority=7,description= "Validate that user can purchase data from Glo successfully using QT Account as a payment method")
	public void Testcase_Seven() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		repurchase();
		enter_number(glo_number);
		select_data_plan_and_proceed_to_payment();
		select_QT_account_payment_choice_and_proceed();
		assert_reharge_is_successful();
	}
	
	@Test(enabled = false, priority=8,description= "Validate that user can purchase data from 9mobile successfully using QT Account as a payment method")
	public void Testcase_Eight() throws Exception{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		repurchase();
		enter_number(n9mobile_number);
		select_data_plan_and_proceed_to_payment();
		select_QT_account_payment_choice_and_proceed();
		assert_reharge_is_successful();
	}
}
