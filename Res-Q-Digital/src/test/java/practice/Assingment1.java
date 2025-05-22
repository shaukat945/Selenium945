package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.RegisterPage;
import pom.WelcomePage;

public class Assingment1 {
	public static void main(String[] args) throws IOException {
		String time = LocalDateTime.now().toString().replace(":","_");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		System.out.println(url);
		
		driver.get(url);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+time+".png");
		org.openqa.selenium.io.FileHandler.copy(temp, dest);
		WelcomePage wp=new WelcomePage(driver);
		wp.getRegisterLink().click();
		RegisterPage rg=new RegisterPage(driver);
		rg.getMaleradioButton().click();
		rg.getFirstName().sendKeys("Shaukat");
		rg.getLastName().sendKeys("Ali");
		rg.getEmail().sendKeys("alishaukat945945@gmail.com");
		rg.getPassword().sendKeys("S12345@s");
		rg.getConfirmPassword().sendKeys("S12345@s");
		rg.getRegisterButton().click();
		
		
		
	}

}
