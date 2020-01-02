package core;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

public class Utility extends BaseTestCase{
	
	public static void swipeVeritcal(AppiumDriver<MobileElement> driver,double startPercentage,double finalPercentage,int duration){
		Dimension size=driver.manage().window().getSize();
		int width =(int) (size.width/2);
		int startPoint=(int) (size.getHeight() * startPercentage);
		int endPoint=(int) (size.getHeight() * finalPercentage);

		new TouchAction(driver).press(width,startPoint).waitAction(Duration.ofMillis(duration)).moveTo(width,endPoint).release().perform();
	
}
	public static void swipeHorizontal(AppiumDriver<MobileElement> driver,double startPercentage,double finalPercentage,int duration){
		Dimension size=driver.manage().window().getSize();
		int height =(int) (size.height/2);
		int startPoint=(int) (size.getWidth() * startPercentage);
		int endPoint=(int) (size.getWidth() * finalPercentage);
		new TouchAction(driver).press(startPoint,height).waitAction(Duration.ofMillis(duration)).moveTo(endPoint,height).release().perform();
	
}
	public static void zoomIn(AppiumDriver<MobileElement> driver) {
		int scrHeight = driver.manage().window().getSize().getHeight(); //To get the mobile screen height
		int scrWidth = driver.manage().window().getSize().getWidth();//To get the mobile screen width
		MultiTouchAction multiTouch = new MultiTouchAction(driver);
		TouchAction tAction0 = new TouchAction(driver);
		TouchAction tAction1 = new TouchAction(driver);
		System.out.println("scrWidth/2,scrHeight/2 ::::::  " + scrWidth/2 +","+ scrHeight/2);
		multiTouch.add(tAction0).add(tAction1);
		multiTouch.add(tAction0).add(tAction1).perform();// now perform both the actions simultaneously (tAction0 and tAction1)

	}
	
}
