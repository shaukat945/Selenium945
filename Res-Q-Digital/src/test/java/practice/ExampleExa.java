package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleExa {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/radio?sublist=0");
		
		//driver.findElement(By.id("name")).sendKeys("Shaukat Ali Ansari");
		//driver.findElement(By.id("email")).sendKeys("shaukat.bala945@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("S12345@r");
		//driver.findElement(By.xpath("//button[text()='Register']")).click();
		driver.findElement(By.xpath("//span[text()='Office delivery']/..//input[@type='radio']")).click();
		
	}
	

}
