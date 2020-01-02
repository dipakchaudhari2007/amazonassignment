package test;

import org.testng.annotations.Test;
import core.BaseTestCase;
import core.FileInput;
import core.TestReporter;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;;

public class AmazonTest extends BaseTestCase {
	
	FileInput files= new FileInput();
	
	@Test
	public void SearchAndCompare() throws Exception {
		
		SignInPage signInObj=new SignInPage();
		signInObj.waitForPageToLoad(); 
		TestReporter.logWithScreenShot("Welcome Page");
		
		signInObj.clickSignInButton();
			
		LoginPage loginObj=new LoginPage();
		loginObj.waitForPageToLoad();
		TestReporter.logWithScreenShot("Login Page");
		loginObj.userLogIn(); //Calling login method

		HomePage homePageObj=new HomePage();
		homePageObj.waitForPageToLoad();
		TestReporter.logWithScreenShot("Home Page");
		homePageObj.EnterKeywordAndSearchItem(); //Method to enter search keyword and search
		
		SearchResultPage searchResultObj=new SearchResultPage();
		searchResultObj.waitForPageToLoad();
		TestReporter.logWithScreenShot("Search Results Page");
		String expectedItemName = searchResultObj.getItemName();

		ProductDetailsPage productDetailsPage=new ProductDetailsPage();
		productDetailsPage.waitForPageToLoad();
		TestReporter.logWithScreenShot("Product Details Page");
		productDetailsPage.clickBuyNowButton();
		
		CheckoutPage checkoutObj=new CheckoutPage();
		checkoutObj.waitForPageToLoad();
		TestReporter.logWithScreenShot("Payments Page");
		checkoutObj.clickNetBankingRadioButton();

		checkoutObj.selectBankName();
		checkoutObj.clickContinueButton();
		
		String actualItemName=checkoutObj.getItemNameOnCheckOut();
		TestReporter.logWithScreenShot("CheckOut Page");
		checkoutObj.compareItemNames(actualItemName, expectedItemName);	//Comparing the item name from product search and checkout page
	}
}
