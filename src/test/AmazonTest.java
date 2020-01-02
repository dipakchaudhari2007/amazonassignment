package test;

import static org.testng.Assert.assertEquals;

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
	String actualItemName="";
	
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
		TestReporter.logWithScreenShot("Payments Page");
		checkoutObj.getradioButtonNetBanking().click();
		String bankName = files.BankName(); //Fetching netbanking Bank name from TestData.xls
		checkoutObj.selectBankName(bankName);
		checkoutObj.getContinueButton().click();
		actualItemName=checkoutObj.getActualItemName().getText();
		TestReporter.logWithScreenShot("CheckOut Page");
		assertEquals(actualItemName, expectedItemName);	//Comparing the item name from product search and checkout page
		
	}

}
