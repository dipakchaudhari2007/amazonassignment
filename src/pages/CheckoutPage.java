package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import core.BaseTestPage;
import core.TestReporter;


public class CheckoutPage extends BaseTestPage{


	@FindBy(xpath = "//*[@text='Continue']")
	private WebElement buttonContinue;
	
	@FindBy(xpath = "//*[@resource-id='a-autoid-0-announce']")
	private WebElement buttonUseThisAddress;
	
	@FindBy(xpath = "")
	private WebElement radioButtonNetBanking;
	
	@FindBy(xpath = "")
	private WebElement dropDownBankName;
	
	@FindBy(xpath = "")
	private List <WebElement> bankOptions;
	
	@FindBy(xpath = "")
	private WebElement actualItemName;
	
	
	WebDriverWait wait=new WebDriverWait(driver, 20);

	@Override
	public void waitForPageToLoad() {
		
		wait.until(ExpectedConditions.visibilityOf(buttonUseThisAddress));
		TestReporter.logWithScreenShot("Address Details ");
		buttonUseThisAddress.click();
		wait.until(ExpectedConditions.visibilityOf(buttonContinue));
		TestReporter.logWithScreenShot("Delivery Date Details ");
	}	
		
	/**
	 * Select Carrier
	 * 
	 * @param option
	 */
	public CheckoutPage selectBankName(String option) {
		wait.until(ExpectedConditions.visibilityOf(dropDownBankName));
		try {
			dropDownBankName.click();
			for (WebElement webElement : bankOptions) {
				if (webElement.getText().equalsIgnoreCase(option)) {
					webElement.click();
					break;
					}
				}
		} catch (Exception e) {
			Assert.fail("Selecting Bank Name Failed");
		}
		return this;
	}
	
	public WebElement getradioButtonNetBanking() {
	
		return radioButtonNetBanking;
	}
	
	public WebElement getContinueButton() {
		return buttonContinue;
	}
	
	public WebElement getActualItemName() {
		return actualItemName;
	}

}
