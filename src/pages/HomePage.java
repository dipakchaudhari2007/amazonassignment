package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTestPage;
import core.TestReporter;
import io.appium.java_client.TouchAction;

public class HomePage extends BaseTestPage{

	
	@FindBy(xpath = "//*[@resource-id='icp-btn-close-announce']")
    private WebElement buttonCancelLanguageSelection;

	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/action_bar_home_logo\"]")
    private WebElement logoAmazon;
	
	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/rs_search_src_text\"]")
    private WebElement txtBoxSearch;
	
	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_query_builder\"]")
    private WebElement buttonAppendSearch;
	
	@FindBy(xpath = "//android.widget.TextView[@text='65-inch tv'])[2]")
    private WebElement productSelected;
	
	WebDriverWait wait=new WebDriverWait(driver, 20);

	@Override
	public void waitForPageToLoad() {
		
		
		try {
		wait.until(ExpectedConditions.visibilityOf(buttonCancelLanguageSelection));
		buttonCancelLanguageSelection.click();
		System.out.print("Clicked on close language selection");
		} catch(Exception e) {
			
		}
		
	}
	
	public void searchItem(String keyword) {
		new TouchAction(driver).press(txtBoxSearch).release().perform();
		txtBoxSearch.sendKeys(keyword);
		TestReporter.logWithScreenShot("Searching... ");
		wait.until(ExpectedConditions.visibilityOf(productSelected));
		productSelected.click();
		TestReporter.logWithScreenShot("Search Result ");
		
	}

}
