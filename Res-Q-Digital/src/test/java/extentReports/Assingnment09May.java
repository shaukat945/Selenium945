package extentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Assingnment09May {
	@Test
	public void AddLoginFailureScreenshot() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("Shaukat123123@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("S1234@ss");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/screenshotreport.html");
		ExtentReports eReport=new ExtentReports();
		eReport.attachReporter(spark);
		ExtentTest test = eReport.createTest("AddScreenshot");
		test.log(Status.INFO, "Adding screenshotinto report");
		test.addScreenCaptureFromBase64String(screenshot);
		eReport.flush();
	}

}
