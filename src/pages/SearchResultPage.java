package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTestPage;
import core.TestReporter;
import io.appium.java_client.MobileElement;

public class SearchResultPage extends BaseTestPage{

	
	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/item_title\"]")
    private List<WebElement> resultItem;

	@FindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_corrections_mixed_quartz']")
	private WebElement labelSearchResults;
	
	
	public List<WebElement> getResultItem() {
		return resultItem;
	}

	public WebElement getLabelSearchResults() {
		return labelSearchResults;
	}


	@Override
	public void waitForPageToLoad() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(labelSearchResults));
	}	
		

}
