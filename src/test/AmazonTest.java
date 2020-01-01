package test;

import java.time.Duration;

import javax.swing.JOptionPane;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTestCase;
import core.TestReporter;
import core.Utility;
import io.appium.java_client.TouchAction;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;

public class AmazonTest extends BaseTestCase {
	
	String expectedItemName="";
	
	@Test
	public void login_and_search() {
		
		SignInPage signInObj=new SignInPage();
		signInObj.waitForPageToLoad();
		TestReporter.logWithScreenShot("Welcome Page");
		
		signInObj.getButtonSignIn().click();
			
		LoginPage loginObj=new LoginPage();
		loginObj.waitForPageToLoad();
		TestReporter.log("Temp msg");
		TestReporter.logWithScreenShot("Login Page");
		loginObj.signIn("9033610313", "Test12345");
		Assert.assertTrue(true,"Login Successful");
		
		HomePage homePageObj=new HomePage();
		homePageObj.waitForPageToLoad();
		homePageObj.searchItem("65-inch TV");
		
		SearchResultPage searchResultObj=new SearchResultPage();
		searchResultObj.waitForPageToLoad();
		
		expectedItemName=searchResultObj.getResultItem().get(2).getText();
		searchResultObj.getResultItem().get(2).click();
		
		ProductDetailsPage productDetailsPage=new ProductDetailsPage();
		productDetailsPage.waitForPageToLoad();
		
		while(!(productDetailsPage.getButtonBuyNow().isDisplayed())){	
		//Scroll Down 	
		Utility.swipeVeritcal(driver, 0.9, 0.2, 2); 
		
		}
		productDetailsPage.getButtonBuyNow().click();
		CheckoutPage checkoutObj=new CheckoutPage();
		checkoutObj.waitForPageToLoad();
		
		// We don't have Test data for debit card: Fasiling test script here 
		TestReporter.AssertTrueWithScreenshot(false, "Debit Card details not provided in test data so marking Test Case as fail");
		
		// TODO -----------
		//	Pending Steps: -> Add card details 
						// -> COntinue on checkout 
						// -> Verify product name on checkout page 
		
		
	}

}
