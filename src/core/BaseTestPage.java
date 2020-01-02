package core;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BaseTestPage extends Config implements BasePage{
	
	public BaseTestPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	

}