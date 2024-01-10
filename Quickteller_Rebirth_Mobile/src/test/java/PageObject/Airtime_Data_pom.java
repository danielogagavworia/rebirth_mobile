package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import bases.Android.LoginBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class Airtime_Data_pom extends LoginBase {
	
	
	// LOCATORS
	private By signIn_Btn = By.xpath("//android.widget.TextView[@text='Sign in']");
	protected By email_TextField= By.xpath("//android.view.ViewGroup[1]/android.widget.EditText[@index=0]");
	protected By password_TextField= By.xpath("//android.view.ViewGroup[2]/android.widget.EditText[@index=0]");
	private By login_Btn= By.xpath("//android.view.ViewGroup[5]/android.widget.TextView[@text='Sign in']");
	private By recharge= By.xpath("//android.widget.TextView[@text='Airtime/Data']");
	private By new_recipent = By.xpath("//android.widget.TextView[@text='New Recipient']");
	private By phonenumber_textfield = By.xpath("//android.view.ViewGroup[5]/android.widget.EditText[@index=0]");
	private By airtime = By.xpath("//android.widget.TextView[@text='Airtime']");
	private By airtime_value = By.xpath("//android.view.ViewGroup[7]/android.widget.TextView[@index=0]");
	private By next_btn = By.xpath("//android.widget.TextView[@text='Next']");
	private By pay_btn = By.xpath("//android.widget.TextView[contains(@text, 'Pay')]");
	private By add_card = By.xpath("//android.widget.TextView[contains(@text, 'New Card')]");
	private By card_pan = By.xpath("//android.widget.EditText[@text='0000 0000 0000 0000']");
	private By account_type_dropdown = By.xpath("//android.widget.TextView[@text='Default']");
	private By savings = By.xpath("//android.widget.TextView[@text='Savings']");
	private By expiration_date = By.xpath("//android.widget.EditText[@text='MM/YY']");
	private By cvv = By.xpath("//android.widget.EditText[@text='CVV']");
	private By card_pin = By.xpath("//android.widget.EditText[@text='4 digit PIN']");
	private By payment_btn= By.xpath("//android.widget.TextView[contains(@text, 'xt')]");
	private By otp= By.xpath("//android.widget.TextView[@text='OTP']");
	private By successful_recharge_msg = By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1][@index=1]");
	private By new_purchase = By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[@index=0]");
	private By data_btn= By.xpath("//android.widget.TextView[@text='Data']");
	private By data_plan_dropdown= By.xpath("//android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.TextView[@text='Select plan']");
	private By select_data_plan= By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[@index=0]");
	private By QTacc_btn= By.xpath("//android.widget.TextView[contains(@text, 'Quickteller Account')]");
	
	
	//DATA
	protected String valid_Email_Address="dadubiaro@interswitch.com";
	protected String valid_Password="password";
	protected String mtn_number= "08104514277";
	protected String airtel_number= "09049281333";
	protected String n9mobile_number= "08094919045";
	protected String glo_number="09053345833";
	protected String verve_card_pan= "5060990580000217499";
	protected String verve_card_expiry= "0350";
	protected String verve_card_cvv= "111";
	protected String verve_card_pin= "1111";
	private String expected_airtime_success_msg = "Top-up Successful!";
	private String expected_airtime_success_msg2= "It's on the Way!";
	private String QTacc_pin="2468";
	
	
	//ACTIONS
	public void click_On_SignIN_Button() {
		wait_until_element_shows(signIn_Btn, driver);
		driver.findElement(signIn_Btn).click();
	}
	
	public void enterUsername() {
		driver.findElement(email_TextField).sendKeys(valid_Email_Address);
	}
	
	public void enterPassword() {
		driver.findElement(password_TextField).sendKeys(valid_Password);
	}
	
	public void click_on_login_button() {
		driver.findElement(login_Btn).click();
	}
	
	public void click_on_recharge() throws InterruptedException{
		wait_until_element_shows(recharge, driver);
		Thread.sleep(14000);
		driver.findElement(recharge).click();
	}
	
	public void click_on_new_recipent() {
		driver.findElement(new_recipent).click();
	}
	
	public void enterphoneNumber(String phonenumber) {
		driver.findElement(phonenumber_textfield).sendKeys(phonenumber);
	}
	
	public void click_on_airtime() {
		driver.findElement(airtime).click();
	}
	
	public void select_airtime_value() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(airtime_value).click();
	}
	
	public void click_next() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(next_btn).click();
	}
	
	@SuppressWarnings("deprecation")
	public void click_next_on_payment_page() throws InterruptedException {
		Thread.sleep(6000);
		 // Find the element
        WebElement element = driver.findElement(payment_btn);

        // Get the size of the element
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        // Calculate the coordinates for the right side
        int rightX = element.getLocation().getX() + width;
        int centerY = element.getLocation().getY() + height / 2;

        // Perform a tap on the right side of the element
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(rightX, centerY)).perform();
	}
	
	public void click_on_pay() {
		driver.findElement(pay_btn).click();
	}
	
	public void click_on_addCard() {
		driver.findElement(add_card).click();
	}
	
	public void enter_verve_card_pan(String pan) {
		driver.findElement(card_pan).sendKeys(pan);
	}
	
	public void select_account_type() {
		driver.findElement(account_type_dropdown).click();
		driver.findElement(savings).click();
	}
	
	public void enter_verve_expiry_and_cvv(String expiry, String Cvv) {
		driver.findElement(expiration_date).sendKeys(expiry);
		driver.findElement(cvv).sendKeys(Cvv);
	}
	
	public void enter_pin_and_proceed(String pin) {
		driver.findElement(card_pin).sendKeys(pin);
	}
	
	public void enter_otp() throws InterruptedException {

		wait_until_element_shows(otp, driver);
		for (int i = 1; i < 7; i++) {
			KeyEvent keyevent = new KeyEvent(AndroidKey.valueOf("DIGIT_" + i));
			driver.pressKey(keyevent);
		}
	}

	public void assert_reharge_is_successful() throws InterruptedException {
		wait_until_element_shows(successful_recharge_msg, driver);
		String actual_airtime_success_msg= get_success_or_error_message(successful_recharge_msg, driver);
		assert_result_is_One_of(actual_airtime_success_msg, expected_airtime_success_msg, expected_airtime_success_msg2);
	}
	
	public void repurchase() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(new_purchase).click();
	}
	
	public void click_on_data() throws InterruptedException {
		driver.findElement(data_btn).click();
		Thread.sleep(7000);
	}
	
	public void click_on_data_plan_dropdown() {
		driver.findElement(data_plan_dropdown).click();
	}
	
	public void select_a_data_plan() {
		driver.findElement(select_data_plan).click();
	}
	
	public void select_quickteller_account() {
		 // Find the element
        WebElement element = driver.findElement(QTacc_btn);

        // Get the size of the element
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        // Calculate the coordinates for the right side
        int rightX = element.getLocation().getX() + width;
        int centerY = element.getLocation().getY() + height / 2;

        // Perform a tap on the right side of the element
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(rightX, centerY)).perform();
	}
	
	public void enter_QTacc_pin(){
	    //wait_until_element_shows(otp, driver);

	    // Enter each digit of the PIN
	    for (int i = 0; i < QTacc_pin.length(); i++) {
	        char digit = QTacc_pin.charAt(i);
	        KeyEvent keyevent = new KeyEvent(AndroidKey.valueOf("DIGIT_" + digit));
	        driver.pressKey(keyevent);
	       
	    }
	}
	
}
