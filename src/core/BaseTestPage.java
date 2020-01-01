package core;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BaseTestPage extends Config implements BasePage{
	
	public BaseTestPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //PageFactory.initElements(driver, this);
    }

	

}