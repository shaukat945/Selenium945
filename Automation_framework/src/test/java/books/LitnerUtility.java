package books;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;

public class LitnerUtility extends BaseClass implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		test=ereport.createTest(result.getName());
		
	}
	@Override//put Demo web shot.login as DEMO WEB SHOP.LOG    for test case fail
	public void onTestfailure(ITestResult result) {
		test.log(Status.FAIL,"Test script is failed");
		TakesScreenshot ts=(TakesScreenshot)driver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
	}

}