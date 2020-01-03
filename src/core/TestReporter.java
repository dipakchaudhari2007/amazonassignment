package core;

import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;


public class TestReporter {
	
	public static void log(String msg) {
		Reporter.log(msg);
		Config.getLogger().info(msg);
		Config.test.log(LogStatus.INFO, msg, "");
	}
	
	public static void logWithScreenShot(String msg) {
		Reporter.log(msg);
		Config.getLogger().info(msg);
		String image=Config.test.addScreenCapture(Support.getScreenshot(msg));
		Config.test.log(LogStatus.INFO, msg, image);
	}
	
	public static void AssertTrueWithScreenshot(boolean condition,String msg) {
		try {
			Assert.assertTrue(condition, msg + "Failed");
			Config.test.log(LogStatus.PASS, msg + "Passed", Support.getScreenshot(msg));
		} catch (Exception e) {
			String image=Config.test.addScreenCapture(Support.getScreenshot(msg));
			Config.test.log(LogStatus.FAIL, msg + "Failed", image);
		}	
	}
}