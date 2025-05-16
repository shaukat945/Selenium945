package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public static ExtentReports ereport;
	public static WebDriver driver;
	public static ExtentTest test;
	
	public JavaUtility jutil=new JavaUtility();
	public static webDriverUtility util=new webDriverUtility();
	public FileUtility fs=new FileUtility();
	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+jutil.getSystemTime()+".html");
		ereport=new ExtentReports();
		ereport.attachReporter(spark);
	}
	@BeforeClass
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		util.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(fs.getDataFromProperty("url"));
		
	}
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fs.getDataFromProperty("Email"));
		lp.getPasswordTextField().sendKeys(fs.getDataFromProperty("Password"));
		lp.getLoginButton().click();
	}
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutLink().click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		ereport.flush();
	}
	public void onTestfailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
