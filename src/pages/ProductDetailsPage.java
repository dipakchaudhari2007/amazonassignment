package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTestPage;
import core.TestReporter;
import io.appium.java_client.MobileElement;

public class ProductDetailsPage extends BaseTestPage{


	@FindBy(xpath = "//*[@resource-id='titleExpander']")
	private WebElement labelProductTitle;
	
	@FindBy(xpath = "//*[@resource-id='buyNowCheckout']")
	private WebElement buttonBuyNow;
	
	
	
	public WebElement getLabelProductTitle() {
		return labelProductTitle;
	}

	public WebElement getButtonBuyNow() {
		return buttonBuyNow;
	}
	
	

	@Override
	public void waitForPageToLoad() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(labelProductTitle));
	}	
		

}
