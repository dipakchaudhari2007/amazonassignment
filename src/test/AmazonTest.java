package test;

import org.testng.annotations.Test;
import core.BaseTestCase;
import core.FileInput;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;;

public class AmazonTest extends BaseTestCase {
	
	FileInput files= new FileInput();
	
	@Test
	public void testSearchAndCompare() throws Exception {
		
		SignInPage signInObj = new SignInPage();
		signInObj.verifySignInPageDisplayed();
		signInObj.clickSignInButton();
		
		LoginPage loginObj = new LoginPage();
		loginObj.verifyLogInPageDisplayed();
		loginObj.userLogIn(); //Calling login method

		HomePage homePageObj = new HomePage();
		homePageObj.verifyHomePageDisplayed();
		homePageObj.EnterKeywordAndSearchItem(); //Method to enter search keyword and search
		
		SearchResultPage searchResultObj = new SearchResultPage();
		searchResultObj.verifySearchResultPageDisplayed();
		String expectedItemName = searchResultObj.getItemName();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		productDetailsPage.verifyProductDetailsPageDisplayed();
		productDetailsPage.clickBuyNowButton();
		
		CheckoutPage checkoutObj = new CheckoutPage();
		checkoutObj.verifyCheckOutPaymentsPageDisplayed();
		checkoutObj.clickNetBankingRadioButton();
		checkoutObj.selectBankName();
		checkoutObj.clickContinueButton();
		
		String actualItemName = checkoutObj.getItemNameOnCheckOut();
		checkoutObj.compareItemNames(actualItemName, expectedItemName);	//Comparing the item name from product search and checkout page
	}
}
