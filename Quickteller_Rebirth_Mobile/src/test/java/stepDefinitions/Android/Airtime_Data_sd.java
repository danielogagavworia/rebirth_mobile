package stepDefinitions.Android;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.Airtime_Data_pom;
import PageObject.Login_pom;


public class Airtime_Data_sd extends Airtime_Data_pom{
	
	public void login_successfully() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_On_SignIN_Button();
		enterUsername();
		enterPassword();
		click_on_login_button();
		click_on_login_button();
	}
	
	public void navigate_to_airtime_and_data() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_on_recharge();
	}
	
	public void enter_number(String number){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_on_new_recipent();
		enterphoneNumber(number);
	}
	
	public void select_airtime_and_proceed_to_payment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_on_airtime();
		select_airtime_value();
		click_next();
		click_on_pay();
	}
	
	public void select_card_as_payment_choice_and_enter_verve_card_details() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_on_addCard();
		enter_verve_card_pan(verve_card_pan);
		enter_verve_expiry_and_cvv(verve_card_expiry,verve_card_cvv);
		enter_pin_and_proceed(verve_card_pin);
		select_account_type();
		click_next_on_payment_page();
	}
	
	public void select_data_plan_and_proceed_to_payment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click_on_data();
		click_on_data_plan_dropdown();
		select_a_data_plan();
		click_next();
		click_on_data();
		click_next();
		click_on_pay();
	}
	
	
	public void select_QT_account_payment_choice_and_proceed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		select_quickteller_account();
		enter_QTacc_pin();
	}
	
	
	
}
