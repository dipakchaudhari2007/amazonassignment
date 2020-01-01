package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTestPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class SignInPage extends BaseTestPage {

	@FindBy(id = "sso_splash_logo")
	private WebElement headerAmazon;

	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/sign_in_button\"]")
	private WebElement buttonSignIn;

	@FindBy(id = "new_user")
	private WebElement buttonCreateAccount;

	@FindBy(id = "skip_sign_in_button")
	private WebElement buttonSkipSingIn;

	public WebElement getHeaderAmazon() {
		return headerAmazon;
	}

	public WebElement getButtonSignIn() {
		return buttonSignIn;
	}

	public WebElement getButtonCreateAccount() {
		return buttonCreateAccount;
	}

	public WebElement getButtonSkipSingIn() {
		return buttonSkipSingIn;
	}

	@Override
	public void waitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(buttonSignIn));

	}

}
