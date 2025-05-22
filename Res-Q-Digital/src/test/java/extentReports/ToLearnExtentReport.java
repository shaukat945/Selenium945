package extentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
	@Test
	public void createReport() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport.html");
		
		ExtentReports eReport=new ExtentReports();
		eReport.attachReporter(spark);
		ExtentTest test = eReport.createTest("createReport");
		test.log(Status.PASS, "log Message added into report");
		eReport.flush();
	}

}
