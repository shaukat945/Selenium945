package popup;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationPopup {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String url = pro.getProperty("url1");
		driver.get(url);
		driver.findElement(By.name("submit")).click();
		Alert popup = driver.switchTo().alert();
		System.out.println(popup);
		popup.accept();
		//popup.accept();
		popup.dismiss();
	}

}
