package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import core.BaseTestPage;

public class SignInPage extends BaseTestPage {

	@FindBy(id = "sso_splash_logo")
	private WebElement headerAmazon;

	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/sign_in_button\"]")
	private WebElement buttonSignIn;

	@FindBy(id = "new_user")
	private WebElement buttonCreateAccount;

	@FindBy(id = "skip_sign_in_button")
	private WebElement buttonSkipSingIn;
	
	@Override
	public void waitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(buttonSignIn));

	}
	
	/**
	 * Click Sign In button
	 */
	public SignInPage clickSignInButton() {
		try {
			buttonSignIn.click();
			Reporter.log("Sign in button is clickable");
		} catch (Exception e) {
			Assert.fail("Sign in button is not clickable");
		}
		return this;
	}
}
