package pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import core.BaseTestPage;
import core.FileInput;
import core.TestReporter;


public class CheckoutPage extends BaseTestPage{

	FileInput files= new FileInput();

	@FindBy(xpath = "//*[@text='Continue']")
	private WebElement buttonContinue;
	
	@FindBy(xpath = "//*[@resource-id='a-autoid-0-announce']")
	private WebElement buttonUseThisAddress;
	
	@FindBy(xpath = "//*[@resource-id='net-banking']")
	private WebElement radioButtonNetBanking;
	
	@FindBy(xpath = "//*[@resource-id='bank-options-combo']")
	private WebElement dropDownBankName;
	
	@FindBy(xpath = "//*[@resource-id='list-banks']")
	private List <WebElement> bankOptions;
	
	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/item_title\"]")
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
	 * Verify CheckOut Payments page loaded
	 */
	public CheckoutPage verifyCheckOutPaymentsPageDisplayed() {
		try {
			waitForPageToLoad();
			TestReporter.AssertTrueWithScreenshot(buttonContinue.isDisplayed(),"Verify CheckOut page payment is loaded");
		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load CheckOut payment page");
		}
		return this;
	}
		
	/**
	 * Select Bank Name
	 */
	public CheckoutPage selectBankName() {
		wait.until(ExpectedConditions.visibilityOf(dropDownBankName));
		try {
			String bankName = files.BankName(); //Fetching netbanking Bank name from TestData.xls
			dropDownBankName.click();
			for (WebElement webElement : bankOptions) {
				if (webElement.getText().equalsIgnoreCase(bankName)) {
					webElement.click();
					break;
					}
				}
		} catch (Exception e) {
			Assert.fail("Selecting Bank Name Failed");
		}
		return this;
	}
	
	/**
	 * Select Net Banking payment option
	 */
	public CheckoutPage clickNetBankingRadioButton() {
		try {
			
			radioButtonNetBanking.click();
			Reporter.log("NetBanking option is clicked");
		} catch (Exception e) {
			Assert.fail("Failed to click NetBanking button");
		}
		return this;
	}
	
	/**
	 * Click Continue button
	 */
	public CheckoutPage clickContinueButton() {
		try {
			
			buttonContinue.click();
			Reporter.log("Continue button is clicked");
		} catch (Exception e) {
			Assert.fail("Failed to click continue button");
		}
		return this;
	}
	
	/**
	 * Get selected item name from CheckOut page
	 */
	
	public String getItemNameOnCheckOut() {
		String actualDeviceName = "";
		wait.until(ExpectedConditions.visibilityOf(actualItemName));
		try {
			actualDeviceName = actualItemName.getText();
			Reporter.log("Got item name from check out page");
		} catch (Exception e) {
			Assert.fail("Failed to get item name from check out page");
		}
		return actualDeviceName;
	}
	
	/**
	 * Compare device names between search results and checkout
	 */
	public CheckoutPage compareItemNames(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue, "String Comparison failed");
			Reporter.log("Item names are matching");
			TestReporter.logWithScreenShot("CheckOut Page");
		} catch (Exception e) {
			Assert.fail("Failed to compare both values");
		}
		return this;
	}
}
