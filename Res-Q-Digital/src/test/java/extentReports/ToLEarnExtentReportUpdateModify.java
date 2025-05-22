package extentReports;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLEarnExtentReportUpdateModify {
	@Test
	public void createReport() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+time+".html");
		
		ExtentReports eReport=new ExtentReports();
		eReport.attachReporter(spark);
		ExtentTest test = eReport.createTest("createReport");
		test.log(Status.PASS, "Modified extent report");
		eReport.flush();
	}
}
