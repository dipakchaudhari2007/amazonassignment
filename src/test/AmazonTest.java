package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTestCase;
import core.FileInput;
import core.TestReporter;
import core.Utility;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;;

public class AmazonTest extends BaseTestCase {
	
	String expectedItemName="";
	
	FileInput files= new FileInput();
	
	@Test
	public void login_and_search() throws Exception {
		
		SignInPage signInObj=new SignInPage();
		signInObj.waitForPageToLoad(); 
		TestReporter.logWithScreenShot("Welcome Page");
		
		signInObj.getButtonSignIn().click();
			
		LoginPage loginObj=new LoginPage();
		loginObj.waitForPageToLoad();
		TestReporter.logWithScreenShot("Login Page");
		String username = files.Username(); //Fetching login username from TestData.xls
		String password = files.Password(); //Fetching login password from TestData.xls
		
		loginObj.signIn(username, password); //Calling login method
		Assert.assertTrue(true,"Login Successful");
		
		HomePage homePageObj=new HomePage();
		homePageObj.waitForPageToLoad();
		
		String searchItem = files.SearchItem(); //Fetching search item name from TestData.xls
		
		homePageObj.searchItem(searchItem);
		
		SearchResultPage searchResultObj=new SearchResultPage();
		searchResultObj.waitForPageToLoad();
		
		expectedItemName=searchResultObj.getResultItem().get(2).getText();
		searchResultObj.getResultItem().get(2).click();
		
		ProductDetailsPage productDetailsPage=new ProductDetailsPage();
		productDetailsPage.waitForPageToLoad();
		
		while(!(productDetailsPage.getButtonBuyNow().isDisplayed())){ 	
		Utility.swipeVeritcal(driver, 0.9, 0.2, 2); //Scroll Down 
		
		}
		productDetailsPage.getButtonBuyNow().click();
		CheckoutPage checkoutObj=new CheckoutPage();
		checkoutObj.waitForPageToLoad();
		
		// We don't have Test data for debit card: Failing test script here 
		TestReporter.AssertTrueWithScreenshot(false, "Debit Card details not provided in test data so marking Test Case as fail");
		
		// TODO -----------
		//	Pending Steps: -> Add card details 
		// -> COntinue on checkout 
		// -> Verify product name on checkout page 
		
		
	}

}
