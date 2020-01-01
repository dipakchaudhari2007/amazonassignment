package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTestPage;
import core.TestReporter;
import io.appium.java_client.MobileElement;

public class LoginPage extends BaseTestPage{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	@FindBy(xpath = "")
    private MobileElement radioButtonLogin;

	@FindBy(xpath = "//*[@resource-id=\"ap_email_login\"]")
    private MobileElement textBoxMobileNumber;
	
	@FindBy(xpath = "//*[@resource-id=\"ap_password\"]")
    private MobileElement textBoxPassword;
	
	@FindBy(xpath = "//*[@resource-id=\"signInSubmit\"]")
    private MobileElement buttonLogin;
	
	@FindBy(xpath = "//*[@resource-id=\"continue\"]")
    private MobileElement buttonContinue;
	
	

	public MobileElement getRadioButtonLogin() {
		return radioButtonLogin;
	}

	public MobileElement getTextBoxMobileNumber() {
		return textBoxMobileNumber;
	}

	public MobileElement getTextBoxPassword() {
		return textBoxPassword;
	}

	public MobileElement getButtonLogin() {
		return buttonLogin;
	}

	public MobileElement getButtonContinue() {
		return buttonContinue;
	}



	@Override
	public void waitForPageToLoad() {
		wait.until(ExpectedConditions.visibilityOf(buttonContinue));
	}
	
	
	
	public void signIn(String mobile_no,String pass) {
		getTextBoxMobileNumber().sendKeys(mobile_no);
		getButtonContinue().click();
		
		wait.until(ExpectedConditions.visibilityOf(textBoxPassword));
		getTextBoxPassword().sendKeys(pass);
		
		TestReporter.logWithScreenShot("Before Login");
		getButtonLogin().click();
		
	}

}
