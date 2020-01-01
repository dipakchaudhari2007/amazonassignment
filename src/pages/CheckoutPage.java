package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTestPage;
import core.TestReporter;


public class CheckoutPage extends BaseTestPage{


	@FindBy(xpath = "//*[@text='Continue']")
	private WebElement buttonContinue;
	
	@FindBy(xpath = "//*[@resource-id='a-autoid-0-announce']")
	private WebElement buttonUseThisAddress;
	
	
	

	@Override
	public void waitForPageToLoad() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(buttonUseThisAddress));
		TestReporter.logWithScreenShot("Address Details ");
		buttonUseThisAddress.click();
		wait.until(ExpectedConditions.visibilityOf(buttonContinue));
		TestReporter.logWithScreenShot("Delivery Date Details ");
	}	
		

}
